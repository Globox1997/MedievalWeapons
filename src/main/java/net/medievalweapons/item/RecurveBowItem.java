package net.medievalweapons.item;

import net.minecraft.item.BowItem;

public class RecurveBowItem extends BowItem {

    public RecurveBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getRange() {
        return 12;
    }

}
