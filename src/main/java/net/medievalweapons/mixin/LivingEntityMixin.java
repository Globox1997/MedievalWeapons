package net.medievalweapons.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.ConfigInit;
import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.LanceItem;
import net.medievalweapons.item.LongSwordItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "Lnet/minecraft/entity/LivingEntity;getHandSwingDuration()I", at = @At("HEAD"), cancellable = true)
    private void getHandSwingDuration(CallbackInfoReturnable<Integer> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getMainHandStack();
        if (!CompatInit.isBetterCombatLoaded && itemStack.isIn(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.isIn(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                || itemStack.getItem() instanceof BigAxeItem || itemStack.getItem() instanceof LanceItem) {
            info.setReturnValue(10);
        }
    }

    // Items can not block projectiles
    @Inject(method = "blockedByShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/PersistentProjectileEntity;getPierceLevel()B"), cancellable = true)
    private void blockedByShieldMixin(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getMainHandStack();
        if (itemStack.isIn(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.isIn(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                || itemStack.getItem() instanceof BigAxeItem) {
            info.setReturnValue(false);
        }
    }

    @WrapOperation(method = "damage",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/LivingEntity;damageShield(F)V"))
    private void damageMixin(LivingEntity instance, float amount, Operation<Void> original){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getActiveItem();
        if (itemStack.isIn(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.isIn(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                || itemStack.getItem() instanceof BigAxeItem) {
            if (livingEntity instanceof PlayerEntity) {
                ((PlayerEntity) livingEntity).getItemCooldownManager().set(itemStack.getItem(), ConfigInit.CONFIG.weapon_blocking_cooldown);
            }
            livingEntity.clearActiveItem();
            if (!this.getWorld().isClient()) {
                livingEntity.getMainHandStack().damage(1, livingEntity, LivingEntity.getSlotForHand(livingEntity.getActiveHand()));
            }
        }else{
            original.call(instance,amount);
        }
    }

}
