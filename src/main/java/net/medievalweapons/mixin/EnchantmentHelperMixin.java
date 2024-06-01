package net.medievalweapons.mixin;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.JavelinItem;
import net.medievalweapons.item.LanceItem;
import net.medievalweapons.item.SmallAxeItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Hand;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

    @Inject(method = "Lnet/minecraft/enchantment/EnchantmentHelper;getSweepingMultiplier(Lnet/minecraft/entity/LivingEntity;)F", at = @At("TAIL"), cancellable = true)
    private static void getSweepingMultiplierMixin(LivingEntity entity, CallbackInfoReturnable<Float> info) {
        ItemStack itemStack = entity.getMainHandStack();

        if (itemStack.isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof BigAxeItem) {
            info.setReturnValue(EnchantmentHelper.getSweepingMultiplier(EnchantmentHelper.getEquipmentLevel(Enchantments.SWEEPING_EDGE, entity) + 1));
        }
    }

    @Inject(method = "getPossibleEntries", at = @At("TAIL"), cancellable = true)
    private static void getPossibleEntriesMixin(FeatureSet enabledFeatures, int level, ItemStack stack, boolean treasureAllowed, CallbackInfoReturnable<List<EnchantmentLevelEntry>> info) {
        List<EnchantmentLevelEntry> currentEnchantments = info.getReturnValue();
        if (currentEnchantments != null) {
            if (stack.getItem() instanceof JavelinItem) {
                List<EnchantmentLevelEntry> enchantments = new ArrayList<>();
                currentEnchantments.forEach(enchantment -> {
                    if ((enchantment.enchantment.isAcceptableItem(stack) && enchantment.enchantment.isPrimaryItem(stack)) || enchantment.enchantment == Enchantments.IMPALING
                            || enchantment.enchantment == Enchantments.PIERCING || enchantment.enchantment == Enchantments.LOYALTY) {
                        enchantments.add(enchantment);
                    }
                });

                info.setReturnValue(enchantments);
            } else if (stack.getItem() instanceof LanceItem) {
                List<EnchantmentLevelEntry> enchantments = new ArrayList<>();
                currentEnchantments.forEach(enchantment -> {
                    if (enchantment.enchantment.isAcceptableItem(stack) && enchantment.enchantment.isPrimaryItem(stack) && enchantment.enchantment != Enchantments.SWEEPING_EDGE) {
                        enchantments.add(enchantment);
                    }
                });
                info.setReturnValue(enchantments);
            }
        }
    }

    @Inject(method = "getKnockback", at = @At("HEAD"), cancellable = true)
    private static void getKnockbackMixin(LivingEntity entity, CallbackInfoReturnable<Integer> info) {
        ItemStack itemStack = entity.getStackInHand(Hand.MAIN_HAND);
        if (itemStack.getItem() instanceof SmallAxeItem) {
            info.setReturnValue(1 + getEquipmentLevel(Enchantments.KNOCKBACK, entity));
        }
    }

    @Shadow
    public static int getEquipmentLevel(Enchantment enchantment, LivingEntity entity) {
        return 1;
    }

}
