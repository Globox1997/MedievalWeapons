package net.medievalweapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.TagInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
  @Inject(method = "Lnet/minecraft/enchantment/EnchantmentHelper;getSweepingMultiplier(Lnet/minecraft/entity/LivingEntity;)F", at = @At(value = "HEAD"), cancellable = true)
  private static void getSweepingMultiplier(LivingEntity entity, CallbackInfoReturnable<Float> info) {
    if (entity.getMainHandStack().getItem().isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS)) {
      int lvl = getEquipmentLevel(Enchantments.SWEEPING, entity);
      info.setReturnValue(lvl + 1.0F);

    }
  }

  @Shadow
  public static int getEquipmentLevel(Enchantment enchantment, LivingEntity entity) {
    return 1;
  }

}
