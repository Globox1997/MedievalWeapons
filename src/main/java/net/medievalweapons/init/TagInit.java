package net.medievalweapons.init;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagInit {

    public static final TagKey<Item> DOUBLE_HANDED_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of("medievalweapons", "double_handed_items"));
    public static final TagKey<Item> ACROSS_DOUBLE_HANDED_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of("medievalweapons", "across_double_handed_items"));

    public static void init() {
    }

}