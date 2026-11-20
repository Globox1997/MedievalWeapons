package net.medievalweapons.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.SoundInit;
import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.LongSwordItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
@Mixin(LivingEntity.class)
public class ClientLivingEntityMixin {

    @Inject(method = "handleEntityEvent", at = @At(value = "FIELD", target = "Lnet/minecraft/sounds/SoundEvents;SHIELD_BLOCK:Lnet/minecraft/sounds/SoundEvent;"), cancellable = true)
    private void handleStatusMixin(byte status, CallbackInfo info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getMainHandItem();
        if (itemStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof BigAxeItem) {
            livingEntity.playSound(SoundInit.PARRYING_EVENT, 1.0F, 0.9F + livingEntity.level().getRandom().nextFloat() * 0.2F);
            info.cancel();
        } else if (itemStack.is(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem) {
            livingEntity.playSound(SoundInit.SWORD_PARRYING_EVENT, 1.0F, 0.9F + livingEntity.level().getRandom().nextFloat() * 0.2F);
            info.cancel();
        }
    }
}
