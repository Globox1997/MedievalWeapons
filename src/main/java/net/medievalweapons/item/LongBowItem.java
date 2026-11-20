package net.medievalweapons.item;

import net.minecraft.world.item.BowItem;

public class LongBowItem extends BowItem {

    public LongBowItem(Properties settings) {
        super(settings);
    }

    @Override
    public int getDefaultProjectileRange() {
        return 20;
    }

}
