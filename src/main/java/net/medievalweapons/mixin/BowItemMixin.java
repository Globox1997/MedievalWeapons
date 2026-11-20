package net.medievalweapons.mixin;

import net.medievalweapons.init.ConfigInit;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.ItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;

@Mixin(BowItem.class)
public abstract class BowItemMixin extends ProjectileWeaponItem {

    public BowItemMixin(Properties settings) {
        super(settings);
    }

    @Inject(method = "shootProjectile", at = @At("TAIL"))
    private void onStoppedUsingMixin(LivingEntity shooter, Projectile projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target, CallbackInfo info) {
        if (this == ItemInit.LONG_BOW_ITEM) {
            projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, speed * ConfigInit.CONFIG.long_bow_speed, divergence);
        } else if (this == ItemInit.RECURVE_BOW_ITEM) {
            projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, speed * ConfigInit.CONFIG.recurve_bow_speed, divergence);
        }
    }

    @ModifyVariable(method = "releaseUsing", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/item/BowItem;getPowerForTime(I)F"), ordinal = 0)
    private float onStoppedUsingPullProgressMixin(float original, ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        if (this == ItemInit.LONG_BOW_ITEM) {
            float f = (float) (this.getUseDuration(stack, user) - remainingUseTicks) / 60.0F;
            f = (f * f + f * 2.0F) / 3.0F;
            if (f > 1.0F) {
                f = 1.0F;
            }
            return f;
        } else if (this == ItemInit.RECURVE_BOW_ITEM) {
            float f = (float) (this.getUseDuration(stack, user) - remainingUseTicks) / 12.0F;
            f = (f * f + f * 2.0F) / 3.0F;
            if (f > 1.0F) {
                f = 1.0F;
            }
            return f;
        }
        return original;
    }

}
