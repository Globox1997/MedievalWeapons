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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.SwingAnimation;
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

    @Inject(method = "getModifiedSwingDuration", at = @At("HEAD"), cancellable = true)
    private void getHandSwingDuration(SwingAnimation animation, CallbackInfoReturnable<Integer> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getMainHandItem();
        if (!CompatInit.isBetterCombatLoaded && itemStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.is(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                || itemStack.getItem() instanceof BigAxeItem || itemStack.getItem() instanceof LanceItem) {
            info.setReturnValue(10);
        }
    }

    @WrapWithCondition(method = "dealDefaultKnockback", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;knockback(DDDLnet/minecraft/world/damagesource/DamageSource;F)V"))
    private boolean damageKnockbackMixin(LivingEntity instance, double strength, double x, double z, DamageSource source, float damage) {
        return !(source.getEntity() instanceof LivingEntity attacker && source.getDirectEntity() == attacker && attacker.getMainHandItem().getItem() instanceof RapierItem);
    }

    @WrapOperation(method = "applyItemBlocking", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/component/BlocksAttacks;hurtBlockingItem(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;F)V"))
    private void applyItemBlockingMixin(BlocksAttacks blocksAttacks, Level level, ItemStack itemStack, LivingEntity user, InteractionHand hand, float damage, Operation<Void> original) {
        original.call(blocksAttacks, level, itemStack, user, hand, damage);
        if (damage > 0.0F && (itemStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.is(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                || itemStack.getItem() instanceof BigAxeItem)) {
            if (user instanceof Player player) {
                player.getCooldowns().addCooldown(itemStack, ConfigInit.CONFIG.weapon_blocking_cooldown);
            }
            user.stopUsingItem();
        }
    }

}
