package net.medievalweapons.mixin;

import java.util.List;

import com.mojang.authlib.GameProfile;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.access.PlayerAccess;
import net.medievalweapons.init.ConfigInit;
import net.medievalweapons.init.EffectInit;
import net.medievalweapons.item.Big_Axe_Item;
import net.medievalweapons.item.Mace_Item;
import net.medievalweapons.item.Small_Axe_Item;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.SweepingEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.dragon.EnderDragonPart;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements PlayerAccess {

    @Unique
    private int lastAttackedOffhandTicks;

    public PlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
        super(EntityType.PLAYER, world);
    }

    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getSweepingMultiplier(Lnet/minecraft/entity/LivingEntity;)F"))
    private void attackMixin(Entity target, CallbackInfo info) {
        ItemStack itemStack = this.getStackInHand(Hand.MAIN_HAND);
        if (!this.world.isClient && itemStack.getItem() instanceof Mace_Item && target instanceof LivingEntity) {
            Mace_Item mace_Item = (Mace_Item) itemStack.getItem();
            if (this.world.random.nextFloat() <= 0.01F + ((float) mace_Item.getAddition() / 10F))
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(EffectInit.STUN_EFFECT, 60 + mace_Item.getAddition() * 20, 0, false, false, true));
        }
    }

    @Inject(method = "attack", at = @At(value = "HEAD"), cancellable = true)
    private void attackStunMixin(Entity target, CallbackInfo info) {
        if (this.hasStatusEffect(EffectInit.STUN_EFFECT))
            info.cancel();
    }

    @Inject(method = "takeShieldHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;takeShieldHit(Lnet/minecraft/entity/LivingEntity;)V", shift = Shift.AFTER))
    public void takeShieldHitMixin(LivingEntity attacker, CallbackInfo info) {
        Item item = attacker.getMainHandStack().getItem();
        if (attacker instanceof PlayerEntity && !(item instanceof AxeItem) && item instanceof ToolItem) {
            if (ConfigInit.CONFIG.extra_weapon_shield_blocking_cooldown != 0 && (item instanceof Small_Axe_Item || item instanceof Big_Axe_Item)) {
                PlayerEntity playerEntity = (PlayerEntity) (Object) this;
                playerEntity.getItemCooldownManager().set(playerEntity.getActiveItem().getItem(), ConfigInit.CONFIG.extra_weapon_shield_blocking_cooldown);
                playerEntity.clearActiveItem();
            } else if (ConfigInit.CONFIG.shield_blocking_cooldown != 0) {
                PlayerEntity playerEntity = (PlayerEntity) (Object) this;
                playerEntity.getItemCooldownManager().set(playerEntity.getActiveItem().getItem(), ConfigInit.CONFIG.shield_blocking_cooldown);
                playerEntity.clearActiveItem();
            }
        }

    }

    @Inject(method = "Lnet/minecraft/entity/player/PlayerEntity;tick()V", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerEntity;lastAttackedTicks:I", ordinal = 0))
    private void tickMixin(CallbackInfo info) {
        this.lastAttackedOffhandTicks++;
    }

    private void offhandAttack(Entity target) {
        if (!target.isAttackable()) {
            return;
        }
        if (target.handleAttack(this)) {
            return;
        }
        target.timeUntilRegen = 0;

        float f = (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        float g = target instanceof LivingEntity ? EnchantmentHelper.getAttackDamage(this.getOffHandStack(), ((LivingEntity) target).getGroup())
                : EnchantmentHelper.getAttackDamage(this.getOffHandStack(), EntityGroup.DEFAULT);
        float h = this.getAttackCooldownProgressOffhand(0.5f);
        g *= h;
        this.resetLastAttackedOffhandTicks();
        if ((f *= 0.2f + h * h * 0.8f) > 0.0f || g > 0.0f) {
            ItemStack itemStack = this.getStackInHand(Hand.OFF_HAND);
            boolean bl = h > 0.9f;
            boolean bl2 = false;
            int i = 0;
            i += EnchantmentHelper.getLevel(Enchantments.KNOCKBACK, itemStack);
            if (this.isSprinting() && bl) {
                this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, this.getSoundCategory(), 1.0f, 1.0f);
                ++i;
                bl2 = true;
            }
            boolean bl3 = bl && this.fallDistance > 0.0f && !this.onGround && !this.isClimbing() && !this.isTouchingWater() && !this.hasStatusEffect(StatusEffects.BLINDNESS) && !this.hasVehicle()
                    && target instanceof LivingEntity;
            bl3 = bl3 && !this.isSprinting();
            if (bl3) {
                f *= 1.5f;
            }
            f += g;
            boolean bl42 = false;
            double d = this.horizontalSpeed - this.prevHorizontalSpeed;
            if (bl && !bl3 && !bl2 && this.onGround && d < (double) this.getMovementSpeed() && itemStack.getItem() instanceof SwordItem) {
                bl42 = true;
            }
            float j = 0.0f;
            boolean bl5 = false;
            int k = EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, itemStack);

            if (target instanceof LivingEntity) {
                j = ((LivingEntity) target).getHealth();
                if (k > 0 && !target.isOnFire()) {
                    bl5 = true;
                    target.setOnFireFor(1);
                }
            }
            Vec3d vec3d = target.getVelocity();
            boolean bl6 = target.damage(DamageSource.player((PlayerEntity) (Object) this), f);
            if (bl6) {
                if (i > 0) {
                    if (target instanceof LivingEntity) {
                        ((LivingEntity) target).takeKnockback((float) i * 0.5f, MathHelper.sin(this.getYaw() * ((float) Math.PI / 180)), -MathHelper.cos(this.getYaw() * ((float) Math.PI / 180)));
                    } else {
                        target.addVelocity(-MathHelper.sin(this.getYaw() * ((float) Math.PI / 180)) * (float) i * 0.5f, 0.1,
                                MathHelper.cos(this.getYaw() * ((float) Math.PI / 180)) * (float) i * 0.5f);
                    }
                    this.setVelocity(this.getVelocity().multiply(0.6, 1.0, 0.6));
                    this.setSprinting(false);
                }
                if (bl42) {
                    float l = 1.0f + SweepingEnchantment.getMultiplier(EnchantmentHelper.getLevel(Enchantments.SWEEPING, itemStack)) * f;
                    List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class, target.getBoundingBox().expand(1.0, 0.25, 1.0));
                    for (LivingEntity livingEntity : list) {
                        if (livingEntity == this || livingEntity == target || this.isTeammate(livingEntity) || livingEntity instanceof ArmorStandEntity && ((ArmorStandEntity) livingEntity).isMarker()
                                || !(this.squaredDistanceTo(livingEntity) < 9.0))
                            continue;
                        livingEntity.takeKnockback(0.4f, MathHelper.sin(this.getYaw() * ((float) Math.PI / 180)), -MathHelper.cos(this.getYaw() * ((float) Math.PI / 180)));
                        livingEntity.damage(DamageSource.player((PlayerEntity) (Object) this), l);
                    }
                    this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, this.getSoundCategory(), 1.0f, 1.0f);
                    ((PlayerEntity) (Object) this).spawnSweepAttackParticles();
                }
                if (target instanceof ServerPlayerEntity && target.velocityModified) {
                    ((ServerPlayerEntity) target).networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(target));
                    target.velocityModified = false;
                    target.setVelocity(vec3d);
                }
                if (bl3) {
                    this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, this.getSoundCategory(), 1.0f, 1.0f);
                    ((PlayerEntity) (Object) this).addCritParticles(target);
                }
                if (!bl3 && !bl42) {
                    if (bl) {
                        this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, this.getSoundCategory(), 1.0f, 1.0f);
                    } else {
                        this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_WEAK, this.getSoundCategory(), 1.0f, 1.0f);
                    }
                }
                if (g > 0.0f) {
                    ((PlayerEntity) (Object) this).addEnchantedHitParticles(target);
                }
                this.onAttacking(target);
                if (target instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged((LivingEntity) target, this);
                }
                EnchantmentHelper.onTargetDamaged(this, target);
                ItemStack itemStack2 = this.getOffHandStack();
                Entity entity = target;
                if (target instanceof EnderDragonPart) {
                    entity = ((EnderDragonPart) target).owner;
                }
                if (!this.world.isClient && !itemStack2.isEmpty() && entity instanceof LivingEntity) {
                    itemStack2.postHit((LivingEntity) entity, (PlayerEntity) (Object) this);
                    if (itemStack2.isEmpty()) {
                        this.setStackInHand(Hand.OFF_HAND, ItemStack.EMPTY);
                    }
                }
                if (target instanceof LivingEntity) {
                    float m = j - ((LivingEntity) target).getHealth();
                    ((PlayerEntity) (Object) this).increaseStat(Stats.DAMAGE_DEALT, Math.round(m * 10.0f));
                    if (k > 0) {
                        target.setOnFireFor(k * 4);
                    }
                    if (this.world instanceof ServerWorld && m > 2.0f) {
                        int n = (int) ((double) m * 0.5);
                        ((ServerWorld) this.world).spawnParticles(ParticleTypes.DAMAGE_INDICATOR, target.getX(), target.getBodyY(0.5), target.getZ(), n, 0.1, 0.0, 0.1, 0.2);
                    }
                    target.timeUntilRegen = 0;
                }
                ((PlayerEntity) (Object) this).addExhaustion(0.1f);
            } else {
                this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, this.getSoundCategory(), 1.0f, 1.0f);
                if (bl5) {
                    target.extinguish();
                }
            }
        }
    }

    @Shadow
    public float getAttackCooldownProgressPerTick() {
        return 0.0F;
    }

    @Override
    public void doOffhandAttack(Entity entity) {
        offhandAttack(entity);
    }

    @Override
    public float getAttackCooldownProgressOffhand(float baseTime) {
        return MathHelper.clamp(((float) this.lastAttackedOffhandTicks + baseTime) / this.getAttackCooldownProgressPerTick(), 0.0f, 1.0f);
    }

    @Override
    public void resetLastAttackedOffhandTicks() {
        this.lastAttackedOffhandTicks = 0;
    }

}