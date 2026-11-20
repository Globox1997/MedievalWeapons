package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Item;

public class TagInit {

    public static final TagKey<Item> DOUBLE_HANDED_ITEMS = TagKey.create(Registries.ITEM, MedievalMain.identifierOf("double_handed_items"));
    public static final TagKey<Item> ACROSS_DOUBLE_HANDED_ITEMS = TagKey.create(Registries.ITEM, MedievalMain.identifierOf("across_double_handed_items"));
    public static final TagKey<DamageType> BYPASSES_WEAPON_BLOCK = TagKey.create(Registries.DAMAGE_TYPE, MedievalMain.identifierOf("bypasses_weapon_block"));

    public static void init() {
    }

}
