package net.medievalweapons.compat;

import net.medievalweapons.init.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class CompatEntities {

    public static void loadEntities() {
        for (Item item : CompatItems.THROWABLE_ITEMS) {
            ItemInit.registerWeaponEntity(BuiltInRegistries.ITEM.getKey(item), item);
        }
    }

}
