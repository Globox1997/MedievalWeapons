package net.medievalweapons.item;


import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class Small_Axe_Item extends SwordItem {

    public Small_Axe_Item(Tiers toolMaterial, int attackDamage, float attackSpeed, Properties settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    // Built in knockback is done by mixin

}