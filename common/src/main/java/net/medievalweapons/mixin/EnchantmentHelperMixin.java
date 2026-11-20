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
import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

    @Inject(method = "getAvailableEnchantmentResults", at = @At("TAIL"), cancellable = true)
    private static void getPossibleEntriesMixin(int level, ItemStack stack, Stream<Holder<Enchantment>> possibleEnchantments, CallbackInfoReturnable<List<EnchantmentInstance>> info) {
        List<EnchantmentInstance> currentEnchantments = info.getReturnValue();
        if (currentEnchantments != null) {
            if (stack.getItem() instanceof JavelinItem) {
                List<EnchantmentInstance> enchantments = new ArrayList<>();
                currentEnchantments.forEach(enchantment -> {
                    if ((enchantment.enchantment().value().canEnchant(stack) && enchantment.enchantment().value().isPrimaryItem(stack)) || enchantment.enchantment().is(Enchantments.IMPALING)
                            || enchantment.enchantment().is(Enchantments.PIERCING) || enchantment.enchantment().is(Enchantments.LOYALTY)) {
                        enchantments.add(enchantment);
                    }
                });

                info.setReturnValue(enchantments);
            } else if (stack.getItem() instanceof LanceItem) {
                List<EnchantmentInstance> enchantments = new ArrayList<>();
                currentEnchantments.forEach(enchantment -> {
                    if (enchantment.enchantment().value().canEnchant(stack) && enchantment.enchantment().value().isPrimaryItem(stack) && !enchantment.enchantment().is(Enchantments.SWEEPING_EDGE)) {
                        enchantments.add(enchantment);
                    }
                });
                info.setReturnValue(enchantments);
            }
        }
    }

}
