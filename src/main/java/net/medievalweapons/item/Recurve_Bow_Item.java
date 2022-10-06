package net.medievalweapons.item;


import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;

public class Recurve_Bow_Item extends BowItem {

    public Recurve_Bow_Item(Item.Properties settings) {
        super(settings);
    }

    @Override
    public int getDefaultProjectileRange() {
        return 12;
    }

}
