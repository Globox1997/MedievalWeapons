package net.medievalweapons.mixin;
/*
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.ItemInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.world.World;

@Mixin(BowItem.class)
public abstract class BowItemMixin extends RangedWeaponItem {

    public BowItemMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/PersistentProjectileEntity;setVelocity(Lnet/minecraft/entity/Entity;FFFFF)V", shift = Shift.AFTER), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void onStoppedUsingMixin(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo info, PlayerEntity playerEntity, boolean bl, ItemStack itemStack, int i,
            float f, boolean bl2, ArrowItem arrowItem, PersistentProjectileEntity persistentProjectileEntity) {
        if (((BowItem) (Object) this) == ItemInit.LONG_BOW_ITEM)
            persistentProjectileEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, f * 4.5F, 1.0F);
        else if (((BowItem) (Object) this) == ItemInit.RECURVE_BOW_ITEM)
            persistentProjectileEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, f * 2.0F, 1.0F);

    }

    @ModifyVariable(method = "onStoppedUsing", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/item/BowItem;getPullProgress(I)F"), ordinal = 0)
    private float onStoppedUsingPullProgressMixin(float original, ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (((BowItem) (Object) this) == ItemInit.LONG_BOW_ITEM) {
            float f = (float) (this.getMaxUseTime(stack) - remainingUseTicks) / 60.0F;
            f = (f * f + f * 2.0F) / 3.0F;
            if (f > 1.0F) {
                f = 1.0F;
            }
            return f;
        } else if (((BowItem) (Object) this) == ItemInit.RECURVE_BOW_ITEM) {
            float f = (float) (this.getMaxUseTime(stack) - remainingUseTicks) / 12.0F;
            f = (f * f + f * 2.0F / 3.0F);
            if (f > 1.0F) {
                f = 1.0F;
            }
            return f;
        }
        return original;
    }

}

 */
