package net.medievalweapons.item;

import net.minecraft.world.item.BowItem;

public class RecurveBowItem extends BowItem {

    public RecurveBowItem(Properties settings) {
        super(settings);
    }

    @Override
    public int getDefaultProjectileRange() {
        return 12;
    }

}
