package net.medievalweapons.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.ConfigInit;
import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.LanceItem;
import net.medievalweapons.item.LongSwordItem;
import net.medievalweapons.item.RapierItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(method = "getCurrentSwingDuration()I", at = @At("HEAD"), cancellable = true)
    private void getHandSwingDuration(CallbackInfoReturnable<Integer> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getMainHandItem();
        if (!CompatInit.isBetterCombatLoaded && itemStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.is(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                || itemStack.getItem() instanceof BigAxeItem || itemStack.getItem() instanceof LanceItem) {
            info.setReturnValue(10);
        }
    }

    // Items can not block projectiles
    @Inject(method = "isDamageSourceBlocked", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/AbstractArrow;getPierceLevel()B"), cancellable = true)
    private void blockedByShieldMixin(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getMainHandItem();
        if (itemStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.is(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                || itemStack.getItem() instanceof BigAxeItem) {
            info.setReturnValue(false);
        }
    }

    @WrapWithCondition(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;knockback(DDD)V"))
    private boolean damageKnockbackMixin(LivingEntity instance, double strength, double x, double z, DamageSource source) {
        return !(source.getEntity() instanceof LivingEntity attacker && source.getDirectEntity() == attacker && attacker.getMainHandItem().getItem() instanceof RapierItem);
    }

    @WrapOperation(method = "hurt",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/entity/LivingEntity;hurtCurrentlyUsedShield(F)V"))
    private void damageMixin(LivingEntity instance, float amount, Operation<Void> original){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getUseItem();
        if (itemStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.is(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                || itemStack.getItem() instanceof BigAxeItem) {
            if (livingEntity instanceof Player) {
                ((Player) livingEntity).getCooldowns().addCooldown(itemStack.getItem(), ConfigInit.CONFIG.weapon_blocking_cooldown);
            }
            livingEntity.stopUsingItem();
            if (!this.level().isClientSide()) {
                livingEntity.getMainHandItem().hurtAndBreak(1, livingEntity, LivingEntity.getSlotForHand(livingEntity.getUsedItemHand()));
            }
        }else{
            original.call(instance,amount);
        }
    }

}
