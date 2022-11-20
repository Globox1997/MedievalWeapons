package net.medievalweapons.mixin;

import java.util.List;

import com.mojang.authlib.GameProfile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.SweepingEdgeEnchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.access.PlayerAccess;

@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity implements PlayerAccess {

    @Unique
    private int lastAttackedOffhandTicks;

    public PlayerEntityMixin(Level world, BlockPos pos, float yaw, GameProfile profile) {
        super(EntityType.PLAYER, world);
    }

    @Inject(method = "blockUsingShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;blockUsingShield(Lnet/minecraft/world/entity/LivingEntity;)V", shift = Shift.AFTER))
    public void takeShieldHitMixin(LivingEntity attacker, CallbackInfo info) {
        Item item = attacker.getMainHandItem().getItem();
        if (attacker instanceof Player && !(item instanceof AxeItem) && item instanceof TieredItem) {

        }

    }

    @Inject(method = "tick()V", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/player/Player;noPhysics:Z", ordinal = 0))
    private void tickMixin(CallbackInfo info) {
        this.lastAttackedOffhandTicks++;
    }

    private void offhandAttack(Entity target) {
        if (!target.isAttackable()) {
            return;
        }
        if (target.skipAttackInteraction(this)) {
            return;
        }
        target.invulnerableTime = 0;

        float f = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
        float g = target instanceof LivingEntity ? EnchantmentHelper.getDamageBonus(this.getOffhandItem(), ((LivingEntity) target).getMobType())
                : EnchantmentHelper.getDamageBonus(this.getOffhandItem(), MobType.UNDEFINED);
        float h = this.getAttackCooldownProgressOffhand(0.5f);
        g *= h;
        this.resetLastAttackedOffhandTicks();
        if ((f *= 0.2f + h * h * 0.8f) > 0.0f || g > 0.0f) {
            ItemStack itemStack = this.getItemInHand(InteractionHand.OFF_HAND);
            boolean bl = h > 0.9f;
            boolean bl2 = false;
            int i = 0;
            i += EnchantmentHelper.getItemEnchantmentLevel(Enchantments.KNOCKBACK, itemStack);
            if (this.isSprinting() && bl) {
                this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, this.getSoundSource(), 1.0f, 1.0f);
                ++i;
                bl2 = true;
            }
            boolean bl3 = bl && this.fallDistance > 0.0f && !this.onGround && !this.onClimbable() && !this.isInWater() && !this.hasEffect(MobEffects.BLINDNESS) && !this.isPassenger()
                    && target instanceof LivingEntity;
            bl3 = bl3 && !this.isSprinting();
            if (bl3) {
                f *= 1.5f;
            }
            f += g;
            boolean bl42 = false;
            double d = this.walkDist - this.walkDistO;
            if (bl && !bl3 && !bl2 && this.onGround && d < (double) this.getSpeed() && itemStack.getItem() instanceof SwordItem) {
                bl42 = true;
            }
            float j = 0.0f;
            boolean bl5 = false;
            int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_ASPECT, this);

            if (target instanceof LivingEntity) {
                j = ((LivingEntity) target).getHealth();
                if (k > 0 && !target.isOnFire()) {
                    bl5 = true;
                    target.setSecondsOnFire(1);
                }
            }
            Vec3 vec3d = target.getDeltaMovement();
            boolean bl6 = target.hurt(DamageSource.playerAttack((Player) (Object) this), f);
            if (bl6) {
                if (i > 0) {
                    if (target instanceof LivingEntity) {
                        ((LivingEntity) target).knockback((float) i * 0.5f, Mth.sin(this.getYRot() * ((float) Math.PI / 180)), -Mth.cos(this.getYRot() * ((float) Math.PI / 180)));
                    } else {
                        target.push(-Mth.sin(this.getYRot() * ((float) Math.PI / 180)) * (float) i * 0.5f, 0.1,
                                Mth.cos(this.getYRot() * ((float) Math.PI / 180)) * (float) i * 0.5f);
                    }
                    this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 1.0, 0.6));
                    this.setSprinting(false);
                }
                if (bl42) {
                    float l = 1.0f + SweepingEdgeEnchantment.getSweepingDamageRatio(EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING_EDGE, this)) * f;
                    List<LivingEntity> list = this.level.getEntitiesOfClass(LivingEntity.class, target.getBoundingBox().inflate(1.0, 0.25, 1.0));
                    for (LivingEntity livingEntity : list) {
                        if (livingEntity == this || livingEntity == target || this.isAlliedTo(livingEntity) || livingEntity instanceof ArmorStand && ((ArmorStand) livingEntity).isMarker()
                                || !(this.distanceToSqr(livingEntity) < 9.0))
                            continue;
                        livingEntity.knockback(0.4f, Mth.sin(this.getYRot() * ((float) Math.PI / 180)), -Mth.cos(this.getYRot() * ((float) Math.PI / 180)));
                        livingEntity.hurt(DamageSource.playerAttack((Player) (Object) this), l);
                    }
                    this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, this.getSoundSource(), 1.0f, 1.0f);
                    ((Player) (Object) this).sweepAttack();
                }
                if (target instanceof ServerPlayer && target.hurtMarked) {
                    ((ServerPlayer) target).connection.send(new ClientboundSetEntityMotionPacket(target));
                    target.hurtMarked = false;
                    target.setDeltaMovement(vec3d);
                }
                if (bl3) {
                    this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_CRIT, this.getSoundSource(), 1.0f, 1.0f);
                    ((Player) (Object) this).crit(target);
                }
                if (!bl3 && !bl42) {
                    if (bl) {
                        this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_STRONG, this.getSoundSource(), 1.0f, 1.0f);
                    } else {
                        this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_WEAK, this.getSoundSource(), 1.0f, 1.0f);
                    }
                }
                if (g > 0.0f) {
                    ((Player) (Object) this).magicCrit(target);
                }
                this.setLastHurtMob(target);
                if (target instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects((LivingEntity) target, this);
                }
                EnchantmentHelper.doPostDamageEffects(this, target);
                ItemStack itemStack2 = this.getOffhandItem();
                Entity entity = target;
                if (target instanceof EnderDragonPart) {
                    entity = ((EnderDragonPart) target).parentMob;
                }
                if (!this.level.isClientSide && !itemStack2.isEmpty() && entity instanceof LivingEntity) {
                    itemStack2.hurtEnemy((LivingEntity) entity, (Player) (Object) this);
                    if (itemStack2.isEmpty()) {
                        this.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
                    }
                }
                if (target instanceof LivingEntity) {
                    float m = j - ((LivingEntity) target).getHealth();
                    ((Player) (Object) this).awardStat(Stats.DAMAGE_DEALT, Math.round(m * 10.0f));
                    if (k > 0) {
                        target.setSecondsOnFire(k * 4);
                    }
                    if (this.level instanceof ServerLevel && m > 2.0f) {
                        int n = (int) ((double) m * 0.5);
                        ((ServerLevel) this.level).sendParticles(ParticleTypes.DAMAGE_INDICATOR, target.getX(), target.getY(0.5), target.getZ(), n, 0.1, 0.0, 0.1, 0.2);
                    }
                    target.invulnerableTime = 0;
                }
                ((Player) (Object) this).causeFoodExhaustion(0.1f);
            } else {
                this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_NODAMAGE, this.getSoundSource(), 1.0f, 1.0f);
                if (bl5) {
                    target.clearFire();
                }
            }
        }
    }

    @Shadow
    public float getCurrentItemAttackStrengthDelay() {
        return 0.0F;
    }

    @Shadow public abstract SoundSource getSoundSource();

    @Shadow public abstract float getSpeed();

    @Override
    public void doOffhandAttack(Entity entity) {
        offhandAttack(entity);
    }

    @Override
    public float getAttackCooldownProgressOffhand(float baseTime) {
        return Mth.clamp(((float) this.lastAttackedOffhandTicks + baseTime) / this.getCurrentItemAttackStrengthDelay(), 0.0f, 1.0f);
    }

    @Override
    public void resetLastAttackedOffhandTicks() {
        this.lastAttackedOffhandTicks = 0;
    }

}

