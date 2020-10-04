package net.medievalweapons.init;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class TagInit {

  public static final Tag<Item> DOUBLE_HANDED_ITEMS = TagRegistry
      .item(new Identifier("medievalweapons", "double_handed_items"));
  public static final Tag<Item> ACCROSS_DOUBLE_HANDED_ITEMS = TagRegistry
      .item(new Identifier("medievalweapons", "accross_double_handed_items"));

  public static void init() {
  }

}
