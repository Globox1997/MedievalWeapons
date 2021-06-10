package net.medievalweapons.compat;

import net.dragonloot.item.DragonToolMaterial;
import net.fabricmc.loader.api.FabricLoader;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.ItemInit;
import net.medievalweapons.item.*;
import net.minecraft.item.Item;
import ru.betterend.item.material.EndToolMaterial;
import paulevs.betternether.items.materials.BNItemMaterials;

public class CompatItems {
        private static FabricLoader fabricLoader = FabricLoader.getInstance();
        public static Boolean isDragonLootLoaded = fabricLoader.isModLoaded("dragonloot");
        public static Boolean isBetterEndLoaded = fabricLoader.isModLoaded("betterend");
        public static Boolean isBetterNetherLoaded = fabricLoader.isModLoaded("betternether");
        // DragonLoot
        public static Francisca_HT_Item DRAGON_FRANCISCA_HT_ITEM;
        public static Javelin_Item DRAGON_JAVELIN_ITEM;

        // Better Nether
        public static Francisca_HT_Item NETHER_RUBY_FRANCISCA_HT_ITEM;
        public static Javelin_Item NETHER_RUBY_JAVELIN_ITEM;
        public static Francisca_HT_Item CINCINNASITE_FRANCISCA_HT_ITEM;
        public static Javelin_Item CINCINNASITE_JAVELIN_ITEM;
        public static Francisca_HT_Item CINCINNASITE_DIAMOND_FRANCISCA_HT_ITEM;
        public static Javelin_Item CINCINNASITE_DIAMOND_JAVELIN_ITEM;

        // Better End
        public static Francisca_HT_Item TERMINITE_FRANCISCA_HT_ITEM;
        public static Javelin_Item TERMINITE_JAVELIN_ITEM;
        public static Francisca_HT_Item AETERNIUM_FRANCISCA_HT_ITEM;
        public static Javelin_Item AETERNIUM_JAVELIN_ITEM;
        public static Francisca_HT_Item THALLASIUM_FRANCISCA_HT_ITEM;
        public static Javelin_Item THALLASIUM_JAVELIN_ITEM;

        public static void loadItems() {
                if (isBetterEndLoaded) {
                        ItemInit.ITEMS.put(MedievalMain.ID("terminite_small_axe"),
                                        new Small_Axe_Item(EndToolMaterial.TERMINITE, 5, -2.9F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("terminite_long_sword"),
                                        new Long_Sword_Item(EndToolMaterial.TERMINITE, 5, -3.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("terminite_dagger"),
                                        new Dagger_Item(EndToolMaterial.TERMINITE, 2, -2.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("terminite_big_axe"),
                                        new Big_Axe_Item(EndToolMaterial.TERMINITE, 6, -3.4F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("terminite_lance"), new Lance_Item(EndToolMaterial.TERMINITE,
                                        3, -3.2F, new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("terminite_healing_staff"),
                                        new Healing_Staff_Item(EndToolMaterial.TERMINITE, 1, -3.3F, 4,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("terminite_mace"), new Mace_Item(EndToolMaterial.TERMINITE,
                                        4, -3.0F, 2, new Item.Settings().group(MedievalMain.GROUP)));
                        TERMINITE_FRANCISCA_HT_ITEM = ItemInit.register("terminite_francisca",
                                        new Francisca_HT_Item(EndToolMaterial.TERMINITE, 2.0F, -2.6F,
                                                        () -> CompatEntities.TERMINITE_FRANCISCA_HT,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        TERMINITE_JAVELIN_ITEM = ItemInit.register("terminite_javelin",
                                        new Javelin_Item(EndToolMaterial.TERMINITE, 2.2F, -2.7F,
                                                        () -> CompatEntities.TERMINITE_JAVELIN,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("terminite_francisca"), TERMINITE_FRANCISCA_HT_ITEM);
                        ItemInit.ITEMS.put(MedievalMain.ID("terminite_javelin"), TERMINITE_JAVELIN_ITEM);

                        ItemInit.ITEMS.put(MedievalMain.ID("aeternium_small_axe"),
                                        new Small_Axe_Item(EndToolMaterial.AETERNIUM, 5, -2.9F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("aeternium_long_sword"),
                                        new Long_Sword_Item(EndToolMaterial.AETERNIUM, 5, -3.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("aeternium_dagger"),
                                        new Dagger_Item(EndToolMaterial.AETERNIUM, 2, -2.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("aeternium_big_axe"),
                                        new Big_Axe_Item(EndToolMaterial.AETERNIUM, 6, -3.4F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("aeternium_lance"), new Lance_Item(EndToolMaterial.AETERNIUM,
                                        3, -3.2F, new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("aeternium_healing_staff"),
                                        new Healing_Staff_Item(EndToolMaterial.AETERNIUM, 1, -3.3F, 4,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("aeternium_mace"), new Mace_Item(EndToolMaterial.AETERNIUM,
                                        4, -3.0F, 2, new Item.Settings().group(MedievalMain.GROUP)));
                        AETERNIUM_FRANCISCA_HT_ITEM = ItemInit.register("aeternium_francisca",
                                        new Francisca_HT_Item(EndToolMaterial.AETERNIUM, 2.0F, -2.6F,
                                                        () -> CompatEntities.AETERNIUM_FRANCISCA_HT,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        AETERNIUM_JAVELIN_ITEM = ItemInit.register("aeternium_javelin",
                                        new Javelin_Item(EndToolMaterial.AETERNIUM, 2.2F, -2.7F,
                                                        () -> CompatEntities.AETERNIUM_JAVELIN,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("aeternium_francisca"), AETERNIUM_FRANCISCA_HT_ITEM);
                        ItemInit.ITEMS.put(MedievalMain.ID("aeternium_javelin"), AETERNIUM_JAVELIN_ITEM);

                        ItemInit.ITEMS.put(MedievalMain.ID("thallasium_small_axe"),
                                        new Small_Axe_Item(EndToolMaterial.THALLASIUM, 5, -2.9F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("thallasium_long_sword"),
                                        new Long_Sword_Item(EndToolMaterial.THALLASIUM, 5, -3.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("thallasium_dagger"),
                                        new Dagger_Item(EndToolMaterial.THALLASIUM, 2, -2.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("thallasium_big_axe"),
                                        new Big_Axe_Item(EndToolMaterial.THALLASIUM, 6, -3.4F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("thallasium_lance"),
                                        new Lance_Item(EndToolMaterial.THALLASIUM, 3, -3.2F,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("thallasium_healing_staff"),
                                        new Healing_Staff_Item(EndToolMaterial.THALLASIUM, 1, -3.3F, 4,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("thallasium_mace"), new Mace_Item(EndToolMaterial.THALLASIUM,
                                        4, -3.0F, 2, new Item.Settings().group(MedievalMain.GROUP)));
                        THALLASIUM_FRANCISCA_HT_ITEM = ItemInit.register("thallasium_francisca",
                                        new Francisca_HT_Item(EndToolMaterial.THALLASIUM, 2.0F, -2.6F,
                                                        () -> CompatEntities.THALLASIUM_FRANCISCA_HT,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        THALLASIUM_JAVELIN_ITEM = ItemInit.register("thallasium_javelin",
                                        new Javelin_Item(EndToolMaterial.THALLASIUM, 2.2F, -2.7F,
                                                        () -> CompatEntities.THALLASIUM_JAVELIN,
                                                        new Item.Settings().group(MedievalMain.GROUP)));
                        ItemInit.ITEMS.put(MedievalMain.ID("thallasium_francisca"), THALLASIUM_FRANCISCA_HT_ITEM);
                        ItemInit.ITEMS.put(MedievalMain.ID("thallasium_javelin"), THALLASIUM_JAVELIN_ITEM);
                }
                if (isBetterNetherLoaded) {
                        ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_small_axe"),
                                        new Small_Axe_Item(BNItemMaterials.NETHER_RUBY_TOOLS, 5, -2.9F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_long_sword"),
                                        new Long_Sword_Item(BNItemMaterials.NETHER_RUBY_TOOLS, 5, -3.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_dagger"),
                                        new Dagger_Item(BNItemMaterials.NETHER_RUBY_TOOLS, 2, -2.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_big_axe"),
                                        new Big_Axe_Item(BNItemMaterials.NETHER_RUBY_TOOLS, 6, -3.4F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_lance"),
                                        new Lance_Item(BNItemMaterials.NETHER_RUBY_TOOLS, 3, -3.2F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_healing_staff"),
                                        new Healing_Staff_Item(BNItemMaterials.NETHER_RUBY_TOOLS, 1, -3.3F, 4,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_mace"),
                                        new Mace_Item(BNItemMaterials.NETHER_RUBY_TOOLS, 4, -3.0F, 2,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        NETHER_RUBY_FRANCISCA_HT_ITEM = ItemInit.register("nether_ruby_francisca",
                                        new Francisca_HT_Item(BNItemMaterials.NETHER_RUBY_TOOLS, 2.0F, -2.6F,
                                                        () -> CompatEntities.NETHER_RUBY_FRANCISCA_HT,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        NETHER_RUBY_JAVELIN_ITEM = ItemInit.register("nether_ruby_javelin",
                                        new Javelin_Item(BNItemMaterials.NETHER_RUBY_TOOLS, 2.2F, -2.7F,
                                                        () -> CompatEntities.NETHER_RUBY_JAVELIN,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_francisca"), NETHER_RUBY_FRANCISCA_HT_ITEM);
                        ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_javelin"), NETHER_RUBY_JAVELIN_ITEM);

                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_small_axe"),
                                        new Small_Axe_Item(BNItemMaterials.CINCINNASITE_TOOLS, 5, -2.9F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_long_sword"),
                                        new Long_Sword_Item(BNItemMaterials.CINCINNASITE_TOOLS, 5, -3.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_dagger"),
                                        new Dagger_Item(BNItemMaterials.CINCINNASITE_TOOLS, 2, -2.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_big_axe"),
                                        new Big_Axe_Item(BNItemMaterials.CINCINNASITE_TOOLS, 6, -3.4F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_lance"),
                                        new Lance_Item(BNItemMaterials.CINCINNASITE_TOOLS, 3, -3.2F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_healing_staff"),
                                        new Healing_Staff_Item(BNItemMaterials.CINCINNASITE_TOOLS, 1, -3.3F, 4,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_mace"),
                                        new Mace_Item(BNItemMaterials.CINCINNASITE_TOOLS, 4, -3.0F, 2,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        CINCINNASITE_FRANCISCA_HT_ITEM = ItemInit.register("cincinnasite_francisca",
                                        new Francisca_HT_Item(BNItemMaterials.CINCINNASITE_TOOLS, 2.0F, -2.6F,
                                                        () -> CompatEntities.CINCINNASITE_FRANCISCA_HT,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        CINCINNASITE_JAVELIN_ITEM = ItemInit.register("cincinnasite_javelin",
                                        new Javelin_Item(BNItemMaterials.CINCINNASITE_TOOLS, 2.2F, -2.7F,
                                                        () -> CompatEntities.CINCINNASITE_JAVELIN,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_francisca"), CINCINNASITE_FRANCISCA_HT_ITEM);
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_javelin"), CINCINNASITE_JAVELIN_ITEM);

                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_small_axe"),
                                        new Small_Axe_Item(BNItemMaterials.CINCINNASITE_DIAMOND_TOOLS, 5, -2.9F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_long_sword"),
                                        new Long_Sword_Item(BNItemMaterials.CINCINNASITE_DIAMOND_TOOLS, 5, -3.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_dagger"),
                                        new Dagger_Item(BNItemMaterials.CINCINNASITE_DIAMOND_TOOLS, 2, -2.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_big_axe"),
                                        new Big_Axe_Item(BNItemMaterials.CINCINNASITE_DIAMOND_TOOLS, 6, -3.4F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_lance"),
                                        new Lance_Item(BNItemMaterials.CINCINNASITE_DIAMOND_TOOLS, 3, -3.2F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_healing_staff"),
                                        new Healing_Staff_Item(BNItemMaterials.CINCINNASITE_DIAMOND_TOOLS, 1, -3.3F, 5,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_mace"),
                                        new Mace_Item(BNItemMaterials.CINCINNASITE_DIAMOND_TOOLS, 4, -3.0F, 3,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        CINCINNASITE_DIAMOND_FRANCISCA_HT_ITEM = ItemInit.register("cincinnasite_diamond_francisca",
                                        new Francisca_HT_Item(BNItemMaterials.CINCINNASITE_DIAMOND_TOOLS, 2.0F, -2.6F,
                                                        () -> CompatEntities.CINCINNASITE_DIAMOND_FRANCISCA_HT,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        CINCINNASITE_DIAMOND_JAVELIN_ITEM = ItemInit.register("cincinnasite_diamond_javelin",
                                        new Javelin_Item(BNItemMaterials.CINCINNASITE_DIAMOND_TOOLS, 2.2F, -2.7F,
                                                        () -> CompatEntities.CINCINNASITE_DIAMOND_JAVELIN,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_francisca"),
                                        CINCINNASITE_DIAMOND_FRANCISCA_HT_ITEM);
                        ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_javelin"),
                                        CINCINNASITE_DIAMOND_JAVELIN_ITEM);
                }
                if (isDragonLootLoaded) {
                        ItemInit.ITEMS.put(MedievalMain.ID("dragon_small_axe"),
                                        new Small_Axe_Item(DragonToolMaterial.getInstance(), 5, -2.9F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("dragon_long_sword"),
                                        new Long_Sword_Item(DragonToolMaterial.getInstance(), 5, -3.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("dragon_dagger"),
                                        new Dagger_Item(DragonToolMaterial.getInstance(), 2, -2.0F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("dragon_big_axe"),
                                        new Big_Axe_Item(DragonToolMaterial.getInstance(), 6, -3.4F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("dragon_lance"),
                                        new Lance_Item(DragonToolMaterial.getInstance(), 3, -3.2F,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("dragon_healing_staff"),
                                        new Healing_Staff_Item(DragonToolMaterial.getInstance(), 1, -3.3F, 4,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("dragon_mace"),
                                        new Mace_Item(DragonToolMaterial.getInstance(), 4, -3.0F, 2,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        DRAGON_FRANCISCA_HT_ITEM = ItemInit.register("dragon_francisca",
                                        new Francisca_HT_Item(DragonToolMaterial.getInstance(), 2.0F, -2.6F,
                                                        () -> CompatEntities.DRAGON_FRANCISCA_HT,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        DRAGON_JAVELIN_ITEM = ItemInit.register("dragon_javelin",
                                        new Javelin_Item(DragonToolMaterial.getInstance(), 2.2F, -2.7F,
                                                        () -> CompatEntities.DRAGON_JAVELIN,
                                                        new Item.Settings().group(MedievalMain.GROUP).fireproof()));
                        ItemInit.ITEMS.put(MedievalMain.ID("dragon_francisca"), DRAGON_FRANCISCA_HT_ITEM);
                        ItemInit.ITEMS.put(MedievalMain.ID("dragon_javelin"), DRAGON_JAVELIN_ITEM);
                }
        }
}