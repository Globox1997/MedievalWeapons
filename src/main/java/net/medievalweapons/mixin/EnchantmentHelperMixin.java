package net.medievalweapons.mixin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.item.JavelinItem;
import net.medievalweapons.item.LanceItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

    @Inject(method = "getPossibleEntries", at = @At("TAIL"), cancellable = true)
    private static void getPossibleEntriesMixin(int level, ItemStack stack, Stream<RegistryEntry<Enchantment>> possibleEnchantments, CallbackInfoReturnable<List<EnchantmentLevelEntry>> info) {
        List<EnchantmentLevelEntry> currentEnchantments = info.getReturnValue();
        if (currentEnchantments != null) {
            if (stack.getItem() instanceof JavelinItem) {
                List<EnchantmentLevelEntry> enchantments = new ArrayList<>();
                currentEnchantments.forEach(enchantment -> {
                    if ((enchantment.enchantment.value().isAcceptableItem(stack) && enchantment.enchantment.value().isPrimaryItem(stack)) || enchantment.enchantment == Enchantments.IMPALING
                            || enchantment.enchantment == Enchantments.PIERCING || enchantment.enchantment == Enchantments.LOYALTY) {
                        enchantments.add(enchantment);
                    }
                });

                info.setReturnValue(enchantments);
            } else if (stack.getItem() instanceof LanceItem) {
                List<EnchantmentLevelEntry> enchantments = new ArrayList<>();
                currentEnchantments.forEach(enchantment -> {
                    if (enchantment.enchantment.value().isAcceptableItem(stack) && enchantment.enchantment.value().isPrimaryItem(stack) && enchantment.enchantment != Enchantments.SWEEPING_EDGE) {
                        enchantments.add(enchantment);
                    }
                });
                info.setReturnValue(enchantments);
            }
        }
    }

}
