package net.medievalweapons.item;

import net.minecraft.item.BowItem;

public class Recurve_Bow_Item extends BowItem {

    public Recurve_Bow_Item(Settings settings) {
        super(settings);
    }

    @Override
    public int getRange() {
        return 12;
    }

}
