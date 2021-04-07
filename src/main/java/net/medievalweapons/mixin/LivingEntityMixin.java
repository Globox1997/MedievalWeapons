package net.medievalweapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.Lance_Item;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "Lnet/minecraft/entity/LivingEntity;getHandSwingDuration()I", at = @At("HEAD"), cancellable = true)
    private void getHandSwingDuration(CallbackInfoReturnable<Integer> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Item item = livingEntity.getMainHandStack().getItem();
        if (item.isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS) || item.isIn(TagInit.DOUBLE_HANDED_ITEMS)
                || item instanceof Lance_Item) {
            info.setReturnValue(10);
        }
    }

    @Inject(method = "blockedByShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/PersistentProjectileEntity;getPierceLevel()B"), cancellable = true)
    private void blockedByShieldMixin(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Item item = livingEntity.getMainHandStack().getItem();
        if (item.isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS) || item.isIn(TagInit.DOUBLE_HANDED_ITEMS)) {
            info.setReturnValue(false);
        }
    }

    @Inject(method = "blockedByShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;dotProduct(Lnet/minecraft/util/math/Vec3d;)D", shift = Shift.AFTER), cancellable = true)
    private void blockedByShieldDamageWeaponMixin(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Item item = livingEntity.getMainHandStack().getItem();
        if (item.isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS) || item.isIn(TagInit.DOUBLE_HANDED_ITEMS)) {
            if (livingEntity instanceof PlayerEntity) {
                ((PlayerEntity) livingEntity).getItemCooldownManager().set(item, 80);
            }
            if (!world.isClient) {
                livingEntity.getMainHandStack().damage(1, livingEntity,
                        (p) -> p.sendToolBreakStatus(p.getActiveHand()));
            }
        }
    }

}