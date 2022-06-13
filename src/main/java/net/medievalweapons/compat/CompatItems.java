package net.medievalweapons.compat;

import org.betterx.betterend.item.material.EndToolMaterial;
import org.betterx.betternether.items.materials.BNToolMaterial;

import net.dragonloot.item.DragonToolMaterial;
import net.fabricmc.loader.api.FabricLoader;
import net.id.aether.items.tools.AetherToolMaterials;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.ItemInit;
import net.medievalweapons.item.*;
import net.minecraft.item.Item;
import nourl.mythicmetals.tools.ToolMaterials;
import potionstudios.byg.common.item.BYGTier;

@SuppressWarnings("unused")
public class CompatItems {
    private static final FabricLoader fabricLoader = FabricLoader.getInstance();
    public static Boolean isDragonLootLoaded = fabricLoader.isModLoaded("dragonloot");
    public static Boolean isBetterEndLoaded = fabricLoader.isModLoaded("betterend");
    public static Boolean isBetterNetherLoaded = fabricLoader.isModLoaded("betternether");
    public static Boolean isMythicMetalsLoaded = fabricLoader.isModLoaded("mythicmetals");
    public static Boolean isAetherLoaded = fabricLoader.isModLoaded("the_aether");
    public static Boolean isBYGLoaded = fabricLoader.isModLoaded("byg");

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

    // Mythic Metals
    // public static Francisca_HT_Item ADAMANTITE_FRANCISCA_HT_ITEM;
    // public static Javelin_Item ADAMANTITE_JAVELIN_ITEM;

    // BYG
    public static Francisca_HT_Item PENDORITE_FRANCISCA_HT_ITEM;
    public static Javelin_Item PENDORITE_JAVELIN_ITEM;

    public static void loadItems() {
        if (isBetterEndLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_small_axe"), new Small_Axe_Item(EndToolMaterial.TERMINITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_long_sword"), new Long_Sword_Item(EndToolMaterial.TERMINITE, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_dagger"), new Dagger_Item(EndToolMaterial.TERMINITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_big_axe"), new Big_Axe_Item(EndToolMaterial.TERMINITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_lance"), new Lance_Item(EndToolMaterial.TERMINITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_healing_staff"), new Healing_Staff_Item(EndToolMaterial.TERMINITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_mace"), new Mace_Item(EndToolMaterial.TERMINITE, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP)));
            TERMINITE_FRANCISCA_HT_ITEM = ItemInit.register("terminite_francisca",
                    new Francisca_HT_Item(EndToolMaterial.TERMINITE, 1.0F, -2.6F, () -> CompatEntities.TERMINITE_FRANCISCA_HT, new Item.Settings().group(MedievalMain.GROUP)));
            TERMINITE_JAVELIN_ITEM = ItemInit.register("terminite_javelin",
                    new Javelin_Item(EndToolMaterial.TERMINITE, 2.2F, -2.7F, () -> CompatEntities.TERMINITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_francisca"), TERMINITE_FRANCISCA_HT_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_javelin"), TERMINITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_ninjato"), new Ninjato_Item(EndToolMaterial.TERMINITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP)));

            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_small_axe"), new Small_Axe_Item(EndToolMaterial.AETERNIUM, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_long_sword"), new Long_Sword_Item(EndToolMaterial.AETERNIUM, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_dagger"), new Dagger_Item(EndToolMaterial.AETERNIUM, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_big_axe"), new Big_Axe_Item(EndToolMaterial.AETERNIUM, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_lance"), new Lance_Item(EndToolMaterial.AETERNIUM, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_healing_staff"), new Healing_Staff_Item(EndToolMaterial.AETERNIUM, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_mace"), new Mace_Item(EndToolMaterial.AETERNIUM, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP)));
            AETERNIUM_FRANCISCA_HT_ITEM = ItemInit.register("aeternium_francisca",
                    new Francisca_HT_Item(EndToolMaterial.AETERNIUM, 1.0F, -2.6F, () -> CompatEntities.AETERNIUM_FRANCISCA_HT, new Item.Settings().group(MedievalMain.GROUP)));
            AETERNIUM_JAVELIN_ITEM = ItemInit.register("aeternium_javelin",
                    new Javelin_Item(EndToolMaterial.AETERNIUM, 2.2F, -2.7F, () -> CompatEntities.AETERNIUM_JAVELIN, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_francisca"), AETERNIUM_FRANCISCA_HT_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_javelin"), AETERNIUM_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_ninjato"), new Ninjato_Item(EndToolMaterial.AETERNIUM, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP)));

            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_small_axe"), new Small_Axe_Item(EndToolMaterial.THALLASIUM, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_long_sword"), new Long_Sword_Item(EndToolMaterial.THALLASIUM, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_dagger"), new Dagger_Item(EndToolMaterial.THALLASIUM, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_big_axe"), new Big_Axe_Item(EndToolMaterial.THALLASIUM, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_lance"), new Lance_Item(EndToolMaterial.THALLASIUM, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_healing_staff"), new Healing_Staff_Item(EndToolMaterial.THALLASIUM, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_mace"), new Mace_Item(EndToolMaterial.THALLASIUM, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP)));
            THALLASIUM_FRANCISCA_HT_ITEM = ItemInit.register("thallasium_francisca",
                    new Francisca_HT_Item(EndToolMaterial.THALLASIUM, 1.0F, -2.6F, () -> CompatEntities.THALLASIUM_FRANCISCA_HT, new Item.Settings().group(MedievalMain.GROUP)));
            THALLASIUM_JAVELIN_ITEM = ItemInit.register("thallasium_javelin",
                    new Javelin_Item(EndToolMaterial.THALLASIUM, 2.2F, -2.7F, () -> CompatEntities.THALLASIUM_JAVELIN, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_francisca"), THALLASIUM_FRANCISCA_HT_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_javelin"), THALLASIUM_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_ninjato"), new Ninjato_Item(EndToolMaterial.THALLASIUM, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP)));
        }
        if (isBetterNetherLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_small_axe"), new Small_Axe_Item(BNToolMaterial.NETHER_RUBY, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_long_sword"), new Long_Sword_Item(BNToolMaterial.NETHER_RUBY, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_dagger"), new Dagger_Item(BNToolMaterial.NETHER_RUBY, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_big_axe"), new Big_Axe_Item(BNToolMaterial.NETHER_RUBY, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_lance"), new Lance_Item(BNToolMaterial.NETHER_RUBY, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_healing_staff"),
                    new Healing_Staff_Item(BNToolMaterial.NETHER_RUBY, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_mace"), new Mace_Item(BNToolMaterial.NETHER_RUBY, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            NETHER_RUBY_FRANCISCA_HT_ITEM = ItemInit.register("nether_ruby_francisca",
                    new Francisca_HT_Item(BNToolMaterial.NETHER_RUBY, 1.0F, -2.6F, () -> CompatEntities.NETHER_RUBY_FRANCISCA_HT, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            NETHER_RUBY_JAVELIN_ITEM = ItemInit.register("nether_ruby_javelin",
                    new Javelin_Item(BNToolMaterial.NETHER_RUBY, 2.2F, -2.7F, () -> CompatEntities.NETHER_RUBY_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_francisca"), NETHER_RUBY_FRANCISCA_HT_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_javelin"), NETHER_RUBY_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_ninjato"), new Ninjato_Item(BNToolMaterial.NETHER_RUBY, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_small_axe"), new Small_Axe_Item(BNToolMaterial.CINCINNASITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_long_sword"), new Long_Sword_Item(BNToolMaterial.CINCINNASITE, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_dagger"), new Dagger_Item(BNToolMaterial.CINCINNASITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_big_axe"), new Big_Axe_Item(BNToolMaterial.CINCINNASITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_lance"), new Lance_Item(BNToolMaterial.CINCINNASITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_healing_staff"),
                    new Healing_Staff_Item(BNToolMaterial.CINCINNASITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_mace"), new Mace_Item(BNToolMaterial.CINCINNASITE, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            CINCINNASITE_FRANCISCA_HT_ITEM = ItemInit.register("cincinnasite_francisca",
                    new Francisca_HT_Item(BNToolMaterial.CINCINNASITE, 1.0F, -2.6F, () -> CompatEntities.CINCINNASITE_FRANCISCA_HT, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            CINCINNASITE_JAVELIN_ITEM = ItemInit.register("cincinnasite_javelin",
                    new Javelin_Item(BNToolMaterial.CINCINNASITE, 2.2F, -2.7F, () -> CompatEntities.CINCINNASITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_francisca"), CINCINNASITE_FRANCISCA_HT_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_javelin"), CINCINNASITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_ninjato"), new Ninjato_Item(BNToolMaterial.CINCINNASITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_small_axe"),
                    new Small_Axe_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_long_sword"),
                    new Long_Sword_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_dagger"),
                    new Dagger_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_big_axe"),
                    new Big_Axe_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_lance"),
                    new Lance_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_healing_staff"),
                    new Healing_Staff_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 1, -3.3F, 5, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_mace"),
                    new Mace_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 4, -2.8F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            CINCINNASITE_DIAMOND_FRANCISCA_HT_ITEM = ItemInit.register("cincinnasite_diamond_francisca", new Francisca_HT_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 1.0F, -2.6F,
                    () -> CompatEntities.CINCINNASITE_DIAMOND_FRANCISCA_HT, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            CINCINNASITE_DIAMOND_JAVELIN_ITEM = ItemInit.register("cincinnasite_diamond_javelin",
                    new Javelin_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 2.2F, -2.7F, () -> CompatEntities.CINCINNASITE_DIAMOND_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_francisca"), CINCINNASITE_DIAMOND_FRANCISCA_HT_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_javelin"), CINCINNASITE_DIAMOND_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_ninjato"),
                    new Ninjato_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
        }
        if (isDragonLootLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_small_axe"), new Small_Axe_Item(DragonToolMaterial.getInstance(), 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_long_sword"), new Long_Sword_Item(DragonToolMaterial.getInstance(), 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_dagger"), new Dagger_Item(DragonToolMaterial.getInstance(), 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_big_axe"), new Big_Axe_Item(DragonToolMaterial.getInstance(), 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_lance"), new Lance_Item(DragonToolMaterial.getInstance(), 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_healing_staff"),
                    new Healing_Staff_Item(DragonToolMaterial.getInstance(), 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_mace"), new Mace_Item(DragonToolMaterial.getInstance(), 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            DRAGON_FRANCISCA_HT_ITEM = ItemInit.register("dragon_francisca",
                    new Francisca_HT_Item(DragonToolMaterial.getInstance(), 1.0F, -2.6F, () -> CompatEntities.DRAGON_FRANCISCA_HT, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            DRAGON_JAVELIN_ITEM = ItemInit.register("dragon_javelin",
                    new Javelin_Item(DragonToolMaterial.getInstance(), 2.2F, -2.7F, () -> CompatEntities.DRAGON_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_francisca"), DRAGON_FRANCISCA_HT_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_javelin"), DRAGON_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_ninjato"), new Ninjato_Item(DragonToolMaterial.getInstance(), 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
        }
        if (isMythicMetalsLoaded) {
            // ItemInit.ITEMS.put(MedievalMain.ID("adamantite_small_axe"), new Small_Axe_Item(ToolMaterials.ADAMANTITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            // ItemInit.ITEMS.put(MedievalMain.ID("adamantite_long_sword"), new Long_Sword_Item(ToolMaterials.ADAMANTITE, 5, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            // ItemInit.ITEMS.put(MedievalMain.ID("adamantite_dagger"), new Dagger_Item(ToolMaterials.ADAMANTITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            // ItemInit.ITEMS.put(MedievalMain.ID("adamantite_big_axe"), new Big_Axe_Item(ToolMaterials.ADAMANTITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            // ItemInit.ITEMS.put(MedievalMain.ID("adamantite_lance"), new Lance_Item(ToolMaterials.ADAMANTITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            // ItemInit.ITEMS.put(MedievalMain.ID("adamantite_healing_staff"), new Healing_Staff_Item(ToolMaterials.ADAMANTITE, 1, -3.3F, 4, new
            // Item.Settings().group(MedievalMain.GROUP).fireproof()));
            // ItemInit.ITEMS.put(MedievalMain.ID("adamantite_mace"), new Mace_Item(ToolMaterials.ADAMANTITE, 4, -3.0F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            // ADAMANTITE_FRANCISCA_HT_ITEM = ItemInit.register("adamantite_francisca",
            // new Francisca_HT_Item(ToolMaterials.ADAMANTITE, 2.0F, -2.6F, () -> CompatEntities.DRAGON_FRANCISCA_HT, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            // ADAMANTITE_JAVELIN_ITEM = ItemInit.register("adamantite_javelin",
            // new Javelin_Item(ToolMaterials.ADAMANTITE, 2.2F, -2.7F, () -> CompatEntities.DRAGON_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            // ItemInit.ITEMS.put(MedievalMain.ID("adamantite_francisca"), ADAMANTITE_FRANCISCA_HT_ITEM);
            // ItemInit.ITEMS.put(MedievalMain.ID("adamantite_javelin"), ADAMANTITE_JAVELIN_ITEM);
        }
        if (isAetherLoaded) {

            // AetherToolMaterials
        }
        if (isBYGLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_small_axe"), new Small_Axe_Item(BYGTier.PENDORITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_long_sword"), new Long_Sword_Item(BYGTier.PENDORITE, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_dagger"), new Dagger_Item(BYGTier.PENDORITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_big_axe"), new Big_Axe_Item(BYGTier.PENDORITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_lance"), new Lance_Item(BYGTier.PENDORITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_healing_staff"), new Healing_Staff_Item(BYGTier.PENDORITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_mace"), new Mace_Item(BYGTier.PENDORITE, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            PENDORITE_FRANCISCA_HT_ITEM = ItemInit.register("pendorite_francisca",
                    new Francisca_HT_Item(BYGTier.PENDORITE, 1.0F, -2.6F, () -> CompatEntities.PENDORITE_FRANCISCA_HT, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            PENDORITE_JAVELIN_ITEM = ItemInit.register("pendorite_javelin",
                    new Javelin_Item(BYGTier.PENDORITE, 2.2F, -2.7F, () -> CompatEntities.PENDORITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_francisca"), PENDORITE_FRANCISCA_HT_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_javelin"), PENDORITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_ninjato"), new Ninjato_Item(BYGTier.PENDORITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
        }
    }
}