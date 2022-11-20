package net.medievalweapons.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.ItemInit;

@Mixin(BowItem.class)
public abstract class BowItemMixin extends ProjectileWeaponItem {

    @Shadow public abstract int getUseDuration(ItemStack p_40680_);

    public BowItemMixin(Properties settings) {
        super(settings);
    }

    @Inject(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/AbstractArrow;shootFromRotation(Lnet/minecraft/world/entity/Entity;FFFFF)V", shift = Shift.AFTER), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void onStoppedUsingMixin(ItemStack p_40667_, Level p_40668_, LivingEntity p_40669_, int p_40670_, CallbackInfo ci, Player player, boolean flag, ItemStack itemstack, int i, float f, boolean flag1, ArrowItem arrowitem, AbstractArrow abstractarrow, Player playerEntity, boolean bl, ItemStack itemStack, int ii, float fo, boolean bl2, ArrowItem arrowItem, AbstractArrow persistentProjectileEntity) {
        ItemInit.LONG_BOW_ITEM.get();
        ItemInit.RECURVE_BOW_ITEM.get();

    }

    @ModifyVariable(method = "releaseUsing", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/item/BowItem;getPowerForTime(I)F"), ordinal = 0)
    private BowItem onStoppedUsingPullProgressMixin(BowItem value) {
        ItemInit.LONG_BOW_ITEM.get();
        ItemInit.RECURVE_BOW_ITEM.get();
        return value;
    }

}
