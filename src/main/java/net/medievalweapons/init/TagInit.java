package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class TagInit {

    public static final TagKey<Item> DOUBLE_HANDED_ITEMS = TagKey.of(RegistryKeys.ITEM, MedievalMain.identifierOf("double_handed_items"));
    public static final TagKey<Item> ACROSS_DOUBLE_HANDED_ITEMS = TagKey.of(RegistryKeys.ITEM, MedievalMain.identifierOf("across_double_handed_items"));

    public static void init() {
    }

}