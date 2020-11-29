package net.medievalweapons.mixin;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.Javelin_Item;
import net.medievalweapons.item.Lance_Item;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
  @Inject(method = "Lnet/minecraft/enchantment/EnchantmentHelper;getSweepingMultiplier(Lnet/minecraft/entity/LivingEntity;)F", at = @At(value = "HEAD"), cancellable = true)
  private static void getSweepingMultiplierMixin(LivingEntity entity, CallbackInfoReturnable<Float> info) {
    if (entity.getMainHandStack().getItem().isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS)) {
      int lvl = getEquipmentLevel(Enchantments.SWEEPING, entity);
      info.setReturnValue(lvl + 1.0F);
    }
    if (entity.getMainHandStack().getItem() instanceof Lance_Item) {
      int lvl = getEquipmentLevel(Enchantments.SWEEPING, entity);
      info.setReturnValue(lvl - 1.0F);
    }
  }

  @Shadow
  public static int getEquipmentLevel(Enchantment enchantment, LivingEntity entity) {
    return 1;
  }

  @Inject(method = "getPossibleEntries(ILnet/minecraft/item/ItemStack;Z)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
  private static void getPossibleEntriesMixin(int i, ItemStack stack, boolean treasureAllowed,
      CallbackInfoReturnable<List<EnchantmentLevelEntry>> info) {
    if (stack.getItem() instanceof Javelin_Item) {
      List<EnchantmentLevelEntry> currentEnchantments = info.getReturnValue();
      List<EnchantmentLevelEntry> enchantments = new ArrayList<>();
      currentEnchantments.forEach(enchantment -> {
        if (!(enchantment.enchantment.type == EnchantmentTarget.TRIDENT)
            || enchantment.enchantment == Enchantments.IMPALING) {
          enchantments.add(enchantment);
        }
      });
      Enchantment piercing = Enchantments.PIERCING;
      for (int level = piercing.getMaxLevel(); level > piercing.getMinLevel() - 1; --level) {
        if (i >= piercing.getMinPower(level) && i <= piercing.getMaxPower(level)) {
          enchantments.add(new EnchantmentLevelEntry(piercing, level));
          break;
        }
      }
      info.setReturnValue(enchantments);
    }
  }

}
