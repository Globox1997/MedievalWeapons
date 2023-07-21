package net.medievalweapons.init;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagInit {

    public static final TagKey<Item> DOUBLE_HANDED_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("medievalweapons", "double_handed_items"));
    public static final TagKey<Item> ACCROSS_DOUBLE_HANDED_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("medievalweapons", "accross_double_handed_items"));

    public static void init() {
    }

}