package net.medievalweapons.init;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TagInit {

    public static final TagKey<Item> DOUBLE_HANDED_ITEMS = TagKey.of(Registry.ITEM_KEY, new Identifier("medievalweapons", "double_handed_items"));
    public static final TagKey<Item> ACCROSS_DOUBLE_HANDED_ITEMS = TagKey.of(Registry.ITEM_KEY, new Identifier("medievalweapons", "accross_double_handed_items"));

    public static void init() {
    }

}