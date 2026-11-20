package net.medievalweapons.mixin;

import java.util.List;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.mojang.authlib.GameProfile;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.access.PlayerAccess;
import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.LongSwordItem;
import net.medievalweapons.item.RapierItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity implements PlayerAccess {

    @Unique
    private int lastAttackedOffhandTicks;

    public PlayerEntityMixin(Level world, BlockPos pos, float yaw, GameProfile profile) {
        super(EntityType.PLAYER, world);
    }

    @Inject(method = "tick()V", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/player/Player;attackStrengthTicker:I", ordinal = 0))
    private void tickMixin(CallbackInfo info) {
        this.lastAttackedOffhandTicks++;
    }

    @Unique
    private void offhandAttack(Entity target) {
        if (!target.isAttackable()) {
            return;
        }
        if (target.skipAttackInteraction(this)) {
            return;
        }
        target.invulnerableTime = 0;

        ItemStack itemStack = this.getItemInHand(InteractionHand.OFF_HAND);
        float f = (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) - getWeaponAttackDamage(this.getMainHandItem()) + getWeaponAttackDamage(itemStack));
        DamageSource damageSource = this.damageSources().playerAttack((Player) (Object) this);
        float g = 0.0f;
        float i = (float) this.getAttributeValue(Attributes.ATTACK_KNOCKBACK);
        if (this.level() instanceof ServerLevel serverWorld) {
            g = EnchantmentHelper.modifyDamage(serverWorld, itemStack, target, damageSource, f) - f;
            i = EnchantmentHelper.modifyKnockback(serverWorld, itemStack, target, damageSource, i);
        }
        float h = this.getAttackCooldownProgressOffhand(0.5f);
        g *= h;
        this.resetLastAttackedOffhandTicks();
        if ((f *= 0.2f + h * h * 0.8f) > 0.0f || g > 0.0f) {
            boolean bl = h > 0.9f;
            boolean bl2 = false;
            if (this.isSprinting() && bl) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, this.getSoundSource(), 1.0f, 1.0f);
                i += 1.0f;
                bl2 = true;
            }
            boolean bl3 = bl && this.fallDistance > 0.0f && !this.onGround() && !this.onClimbable() && !this.isInWater() && !this.hasEffect(MobEffects.BLINDNESS) && !this.isPassenger()
                    && target instanceof LivingEntity;
            bl3 = bl3 && !this.isSprinting();
            if (bl3) {
                f *= 1.5f;
            }
            f += g;
            boolean bl42 = false;
            double d = this.walkDist - this.walkDistO;
            if (bl && !bl3 && !bl2 && this.onGround() && d < (double) this.getSpeed() && itemStack.getItem() instanceof SwordItem) {
                bl42 = true;
            }
            float j = 0.0f;
            if (target instanceof LivingEntity livingEntity) {
                j = livingEntity.getHealth();
            }
            Vec3 vec3d = target.getDeltaMovement();
            boolean bl6 = target.hurt(target.damageSources().playerAttack((Player) (Object) this), f);
            if (bl6) {
                if (i > 0) {
                    if (target instanceof LivingEntity livingEntity) {
                        livingEntity.knockback((float) i * 0.5f, Mth.sin(this.getYRot() * ((float) Math.PI / 180)), -Mth.cos(this.getYRot() * ((float) Math.PI / 180)));
                    } else {
                        target.push(-Mth.sin(this.getYRot() * ((float) Math.PI / 180)) * (float) i * 0.5f, 0.1,
                                Mth.cos(this.getYRot() * ((float) Math.PI / 180)) * (float) i * 0.5f);
                    }
                    this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 1.0, 0.6));
                    this.setSprinting(false);
                }
                if (bl42) {
                    float l = 1.0f + (float) this.getAttributeValue(Attributes.SWEEPING_DAMAGE_RATIO) * f;
                    List<LivingEntity> list = this.level().getEntitiesOfClass(LivingEntity.class, target.getBoundingBox().inflate(1.0, 0.25, 1.0));
                    for (LivingEntity livingEntity : list) {
                        if (livingEntity == this || livingEntity == target || this.isAlliedTo(livingEntity) || livingEntity instanceof ArmorStand && ((ArmorStand) livingEntity).isMarker()
                                || !(this.distanceToSqr(livingEntity) < 9.0))
                            continue;
                        livingEntity.knockback(0.4f, Mth.sin(this.getYRot() * ((float) Math.PI / 180)), -Mth.cos(this.getYRot() * ((float) Math.PI / 180)));
                        livingEntity.hurt(livingEntity.damageSources().playerAttack((Player) (Object) this), l);
                    }
                    this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, this.getSoundSource(), 1.0f, 1.0f);
                    ((Player) (Object) this).sweepAttack();
                }
                if (target instanceof ServerPlayer serverPlayerEntity && target.hurtMarked) {
                    serverPlayerEntity.connection.send(new ClientboundSetEntityMotionPacket(target));
                    target.hurtMarked = false;
                    target.setDeltaMovement(vec3d);
                }
                if (bl3) {
                    this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_CRIT, this.getSoundSource(), 1.0f, 1.0f);
                    ((Player) (Object) this).crit(target);
                }
                if (!bl3 && !bl42) {
                    if (bl) {
                        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_STRONG, this.getSoundSource(), 1.0f, 1.0f);
                    } else {
                        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_WEAK, this.getSoundSource(), 1.0f, 1.0f);
                    }
                }
                if (g > 0.0f) {
                    ((Player) (Object) this).magicCrit(target);
                }
                this.setLastHurtMob(target);
                if (target instanceof LivingEntity livingEntity) {
                    itemStack.postHurtEnemy(livingEntity, (Player) (Object) this);
                }
                if (target.level() instanceof ServerLevel serverWorld) {
                    EnchantmentHelper.doPostAttackEffectsWithItemSource(serverWorld, target, damageSource, itemStack);
                }
                ItemStack itemStack2 = this.getOffhandItem();
                Entity entity = target;
                if (target instanceof EnderDragonPart enderDragonPart) {
                    entity = enderDragonPart.parentMob;
                }
                if (!this.level().isClientSide() && !itemStack2.isEmpty() && entity instanceof LivingEntity livingEntity) {
                    itemStack2.hurtEnemy(livingEntity, (Player) (Object) this);
                    if (itemStack2.isEmpty()) {
                        this.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
                    }
                }
                if (target instanceof LivingEntity livingEntity) {
                    float m = j - livingEntity.getHealth();
                    ((Player) (Object) this).awardStat(Stats.DAMAGE_DEALT, Math.round(m * 10.0f));
                    if (this.level() instanceof ServerLevel serverWorld && m > 2.0f) {
                        int n = (int) ((double) m * 0.5);
                        serverWorld.sendParticles(ParticleTypes.DAMAGE_INDICATOR, target.getX(), target.getY(0.5), target.getZ(), n, 0.1, 0.0, 0.1, 0.2);
                    }
                    target.invulnerableTime = 0;
                }
                ((Player) (Object) this).causeFoodExhaustion(0.1f);
            } else {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_NODAMAGE, this.getSoundSource(), 1.0f, 1.0f);
            }
        }
    }

    @Unique
    private static double getWeaponAttackDamage(ItemStack stack) {
        double[] damage = {0.0D};
        stack.forEachModifier(EquipmentSlot.MAINHAND, (attribute, modifier) -> {
            if (attribute.is(Attributes.ATTACK_DAMAGE) && modifier.operation() == AttributeModifier.Operation.ADD_VALUE) {
                damage[0] += modifier.amount();
            }
        });
        return damage[0];
    }

    @WrapWithCondition(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;knockback(DDD)V"))
    private boolean attackKnockbackMixin(LivingEntity target, double strength, double x, double z) {
        return !(this.getMainHandItem().getItem() instanceof RapierItem);
    }

    @Override
    public boolean canDisableShield() {
        ItemStack itemStack = this.getMainHandItem();
        return super.canDisableShield() || itemStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.is(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                || itemStack.getItem() instanceof BigAxeItem;
    }

    @Shadow
    public float getCurrentItemAttackStrengthDelay() {
        return 0.0F;
    }

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

    @Override
    public int getLastAttackedOffhandTicks() {
        return this.lastAttackedOffhandTicks;
    }

}