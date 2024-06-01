package net.medievalweapons.item;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SmallAxeItem extends SwordItem {

    public SmallAxeItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    // Built in knockback is done by mixin
}
