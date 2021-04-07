package net.medievalweapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.SoundInit;
import net.medievalweapons.init.TagInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;

@Mixin(LivingEntity.class)
public class ClientLivingEntityMixin {

    @Environment(EnvType.CLIENT)
    @Inject(method = "handleStatus", at = @At(value = "FIELD", target = "Lnet/minecraft/sound/SoundEvents;ITEM_SHIELD_BLOCK:Lnet/minecraft/sound/SoundEvent;"), cancellable = true)
    public void handleStatusMixin(byte status, CallbackInfo info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Item item = livingEntity.getMainHandStack().getItem();
        if (item.isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS)) {
            livingEntity.playSound(SoundInit.PARRYING_EVENT, 1.0F, 0.9F + livingEntity.world.random.nextFloat() * 0.2F);
            info.cancel();
        } else if (item.isIn(TagInit.DOUBLE_HANDED_ITEMS)) {
            livingEntity.playSound(SoundInit.SWORD_PARRYING_EVENT, 1.0F,
                    0.9F + livingEntity.world.random.nextFloat() * 0.2F);
            info.cancel();
        }
    }
}
