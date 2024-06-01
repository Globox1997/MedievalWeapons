package net.medievalweapons.item;

import net.minecraft.item.BowItem;

public class LongBowItem extends BowItem {

    public LongBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getRange() {
        return 20;
    }

}
