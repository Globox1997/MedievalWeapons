package net.medievalweapons.mixin.compat;

import org.betterx.betternether.interfaces.InitialStackStateProvider;
import org.betterx.betternether.items.materials.BNToolMaterial;
import org.spongepowered.asm.mixin.Mixin;

import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.item.Javelin_Item;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

@Mixin(Javelin_Item.class)
public class Javelin_ItemMixin implements InitialStackStateProvider {

    @Override
    public void initializeState(ItemStack stack) {
        if (((SwordItem) stack.getItem()).getMaterial() == BNToolMaterial.NETHER_RUBY) {
            EnchantmentHelper.set(CompatItems.DEFAULT_RUBY_ENCHANTS, stack);
        }
    }

}