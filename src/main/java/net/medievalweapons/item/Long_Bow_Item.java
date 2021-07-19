package net.medievalweapons.item;

import net.minecraft.item.BowItem;

public class Long_Bow_Item extends BowItem {

    public Long_Bow_Item(Settings settings) {
        super(settings);
    }

    @Override
    public int getRange() {
        return 20;
    }

}
