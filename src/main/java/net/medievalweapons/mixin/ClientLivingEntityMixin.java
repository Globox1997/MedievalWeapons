package net.medievalweapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.SoundInit;
import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.Big_Axe_Item;
import net.medievalweapons.item.Long_Sword_Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;

@Environment(EnvType.CLIENT)
@Mixin(LivingEntity.class)
public class ClientLivingEntityMixin {

    @Inject(method = "handleStatus", at = @At(value = "FIELD", target = "Lnet/minecraft/sound/SoundEvents;ITEM_SHIELD_BLOCK:Lnet/minecraft/sound/SoundEvent;"), cancellable = true)
    public void handleStatusMixin(byte status, CallbackInfo info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Item item = livingEntity.getMainHandStack().getItem();
        if (item.isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS) || item instanceof Big_Axe_Item) {
            livingEntity.playSound(SoundInit.PARRYING_EVENT, 1.0F, 0.9F + livingEntity.world.random.nextFloat() * 0.2F);
            info.cancel();
        } else if (item.isIn(TagInit.DOUBLE_HANDED_ITEMS) || item instanceof Long_Sword_Item) {
            livingEntity.playSound(SoundInit.SWORD_PARRYING_EVENT, 1.0F,
                    0.9F + livingEntity.world.random.nextFloat() * 0.2F);
            info.cancel();
        }
    }
}
