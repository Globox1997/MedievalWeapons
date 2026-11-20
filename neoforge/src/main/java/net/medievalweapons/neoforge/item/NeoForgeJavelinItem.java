package net.medievalweapons.neoforge.item;

import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.item.JavelinItem;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.function.Supplier;

public class NeoForgeJavelinItem extends JavelinItem {

    public NeoForgeJavelinItem(ToolMaterial toolMaterial, Supplier<EntityType<JavelinEntity>> typeSupplier, Properties settings) {
        super(toolMaterial, typeSupplier, settings);
    }

    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return JavelinItem.allowsExtraEnchantment(enchantment) || super.supportsEnchantment(stack, enchantment);
    }

    @Override
    public boolean isPrimaryItemFor(ItemStack stack, Holder<Enchantment> enchantment) {
        return JavelinItem.allowsExtraEnchantment(enchantment) || super.isPrimaryItemFor(stack, enchantment);
    }

}
