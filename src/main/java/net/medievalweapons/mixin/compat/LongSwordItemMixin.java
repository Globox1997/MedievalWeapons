package net.medievalweapons.mixin.compat;

import java.util.Map;

import org.betterx.betternether.interfaces.InitialStackStateProvider;
import org.betterx.betternether.items.materials.BNToolMaterial;
import org.betterx.betternether.registry.NetherEnchantments;
import org.spongepowered.asm.mixin.Mixin;

import net.medievalweapons.item.LongSwordItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

@Mixin(LongSwordItem.class)
public abstract class LongSwordItemMixin extends SwordItem implements InitialStackStateProvider {

    public LongSwordItemMixin(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    // @Override
    // public void putEnchantments(ItemStack itemStack, Map<Enchantment, Integer> defaultEnchants) {
    // if (getMaterial() == BNToolMaterial.FLAMING_RUBY) {
    // defaultEnchants.put(NetherEnchantments.RUBY_FIRE, 1);
    // EnchantmentHelper.set(defaultEnchants, itemStack);
    // }
    // }

}
