package net.medievalweapons.item;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SmallAxeItem extends SwordItem {

    public SmallAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    // Built in knockback is done by mixin

}