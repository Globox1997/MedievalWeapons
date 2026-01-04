package net.medievalweapons.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.ItemInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.world.World;

@Mixin(BowItem.class)
public abstract class BowItemMixin extends RangedWeaponItem {

    public BowItemMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "shoot", at = @At("TAIL"))
    private void onStoppedUsingMixin(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target, CallbackInfo info) {
        if (this == ItemInit.LONG_BOW_ITEM) {
            projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw(), 0.0F, speed * 1.3F, divergence);
        } else if (this == ItemInit.RECURVE_BOW_ITEM) {
            projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw(), 0.0F, speed * 0.9F, divergence);
        }
    }

    @ModifyVariable(method = "onStoppedUsing", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/item/BowItem;getPullProgress(I)F"), ordinal = 0)
    private float onStoppedUsingPullProgressMixin(float original, ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (this == ItemInit.LONG_BOW_ITEM) {
            float f = (float) (this.getMaxUseTime(stack, user) - remainingUseTicks) / 60.0F;
            f = (f * f + f * 2.0F) / 3.0F;
            if (f > 1.0F) {
                f = 1.0F;
            }
            return f;
        } else if (this == ItemInit.RECURVE_BOW_ITEM) {
            float f = (float) (this.getMaxUseTime(stack, user) - remainingUseTicks) / 12.0F;
            f = (f * f + f * 2.0F / 3.0F);
            if (f > 1.0F) {
                f = 1.0F;
            }
            return f;
        }
        return original;
    }

}
