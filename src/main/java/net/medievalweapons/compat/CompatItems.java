package net.medievalweapons.compat;

import org.betterx.betterend.item.material.EndToolMaterial;
import org.betterx.betternether.items.materials.BNToolMaterial;

import dqu.additionaladditions.material.GildedNetheriteToolMaterial;
import dqu.additionaladditions.material.RoseGoldToolMaterial;
import net.dragonloot.item.DragonToolMaterial;
import net.fabricmc.loader.api.FabricLoader;
import net.id.aether.items.tools.AetherToolMaterials;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.ItemInit;
import net.medievalweapons.item.*;
import net.minecraft.item.Item;
import net.trique.mythicupgrades.item.ModToolMaterials;
import nourl.mythicmetals.tools.MythicToolMaterials;
import potionstudios.byg.common.item.BYGTier;

public class CompatItems {
    private static final FabricLoader fabricLoader = FabricLoader.getInstance();
    public static Boolean isDragonLootLoaded = fabricLoader.isModLoaded("dragonloot");
    public static Boolean isBetterEndLoaded = fabricLoader.isModLoaded("betterend");
    public static Boolean isBetterNetherLoaded = fabricLoader.isModLoaded("betternether");
    public static Boolean isMythicMetalsLoaded = fabricLoader.isModLoaded("mythicmetals");
    public static Boolean isAetherLoaded = fabricLoader.isModLoaded("the_aether");
    public static Boolean isBYGLoaded = fabricLoader.isModLoaded("byg");
    public static Boolean isAdditionalAdditionsLoaded = fabricLoader.isModLoaded("additionaladditions");
    public static Boolean isMythicUpgradesLoaded = fabricLoader.isModLoaded("mythicupgrades");

    // DragonLoot
    public static Francisca_Item DRAGON_FRANCISCA_ITEM;
    public static Javelin_Item DRAGON_JAVELIN_ITEM;

    // Better Nether
    public static Francisca_Item NETHER_RUBY_FRANCISCA_ITEM;
    public static Javelin_Item NETHER_RUBY_JAVELIN_ITEM;
    public static Francisca_Item CINCINNASITE_FRANCISCA_ITEM;
    public static Javelin_Item CINCINNASITE_JAVELIN_ITEM;
    public static Francisca_Item CINCINNASITE_DIAMOND_FRANCISCA_ITEM;
    public static Javelin_Item CINCINNASITE_DIAMOND_JAVELIN_ITEM;

    // Better End
    public static Francisca_Item TERMINITE_FRANCISCA_ITEM;
    public static Javelin_Item TERMINITE_JAVELIN_ITEM;
    public static Francisca_Item AETERNIUM_FRANCISCA_ITEM;
    public static Javelin_Item AETERNIUM_JAVELIN_ITEM;
    public static Francisca_Item THALLASIUM_FRANCISCA_ITEM;
    public static Javelin_Item THALLASIUM_JAVELIN_ITEM;

    // Mythic Metals
    public static Francisca_Item ADAMANTITE_FRANCISCA_ITEM;
    public static Javelin_Item ADAMANTITE_JAVELIN_ITEM;

    // BYG
    public static Francisca_Item PENDORITE_FRANCISCA_ITEM;
    public static Javelin_Item PENDORITE_JAVELIN_ITEM;

    // Additional Additions
    public static Francisca_Item ROSE_GOLD_FRANCISCA_ITEM;
    public static Javelin_Item ROSE_GOLD_JAVELIN_ITEM;
    public static Francisca_Item GILDED_NETHERITE_FRANCISCA_ITEM;
    public static Javelin_Item GILDED_NETHERITE_JAVELIN_ITEM;

    // Aether
    public static Francisca_Item GRAVITITE_FRANCISCA_ITEM;
    public static Javelin_Item GRAVITITE_JAVELIN_ITEM;
    public static Francisca_Item ZANITE_FRANCISCA_ITEM;
    public static Javelin_Item ZANITE_JAVELIN_ITEM;

    // Mythic Upgrades
    public static Francisca_Item RUBY_NETHERITE_FRANCISCA_ITEM;
    public static Javelin_Item RUBY_NETHERITE_JAVELIN_ITEM;
    public static Francisca_Item SAPPHIRE_NETHERITE_FRANCISCA_ITEM;
    public static Javelin_Item SAPPHIRE_NETHERITE_JAVELIN_ITEM;

    public static void loadItems() {
        if (isBetterEndLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_small_axe"), new Small_Axe_Item(EndToolMaterial.TERMINITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_long_sword"), new Long_Sword_Item(EndToolMaterial.TERMINITE, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_dagger"), new Dagger_Item(EndToolMaterial.TERMINITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_big_axe"), new Big_Axe_Item(EndToolMaterial.TERMINITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_lance"), new Lance_Item(EndToolMaterial.TERMINITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_healing_staff"), new Healing_Staff_Item(EndToolMaterial.TERMINITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_mace"), new Mace_Item(EndToolMaterial.TERMINITE, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP)));
            TERMINITE_FRANCISCA_ITEM = ItemInit.register("terminite_francisca",
                    new Francisca_Item(EndToolMaterial.TERMINITE, 1.0F, -2.6F, () -> CompatEntities.TERMINITE_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP)));
            TERMINITE_JAVELIN_ITEM = ItemInit.register("terminite_javelin",
                    new Javelin_Item(EndToolMaterial.TERMINITE, 2.2F, -2.7F, () -> CompatEntities.TERMINITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_francisca"), TERMINITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_javelin"), TERMINITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_ninjato"), new Ninjato_Item(EndToolMaterial.TERMINITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_sickle"), new Sickle_Item(EndToolMaterial.TERMINITE, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("terminite_rapier"), new Rapier_Item(EndToolMaterial.TERMINITE, 3, -2.0F, 2, new Item.Settings().group(MedievalMain.GROUP)));

            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_small_axe"), new Small_Axe_Item(EndToolMaterial.AETERNIUM, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_long_sword"), new Long_Sword_Item(EndToolMaterial.AETERNIUM, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_dagger"), new Dagger_Item(EndToolMaterial.AETERNIUM, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_big_axe"), new Big_Axe_Item(EndToolMaterial.AETERNIUM, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_lance"), new Lance_Item(EndToolMaterial.AETERNIUM, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_healing_staff"), new Healing_Staff_Item(EndToolMaterial.AETERNIUM, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_mace"), new Mace_Item(EndToolMaterial.AETERNIUM, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP)));
            AETERNIUM_FRANCISCA_ITEM = ItemInit.register("aeternium_francisca",
                    new Francisca_Item(EndToolMaterial.AETERNIUM, 1.0F, -2.6F, () -> CompatEntities.AETERNIUM_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP)));
            AETERNIUM_JAVELIN_ITEM = ItemInit.register("aeternium_javelin",
                    new Javelin_Item(EndToolMaterial.AETERNIUM, 2.2F, -2.7F, () -> CompatEntities.AETERNIUM_JAVELIN, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_francisca"), AETERNIUM_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_javelin"), AETERNIUM_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_ninjato"), new Ninjato_Item(EndToolMaterial.AETERNIUM, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_sickle"), new Sickle_Item(EndToolMaterial.AETERNIUM, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("aeternium_rapier"), new Rapier_Item(EndToolMaterial.AETERNIUM, 3, -2.0F, 2, new Item.Settings().group(MedievalMain.GROUP)));

            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_small_axe"), new Small_Axe_Item(EndToolMaterial.THALLASIUM, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_long_sword"), new Long_Sword_Item(EndToolMaterial.THALLASIUM, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_dagger"), new Dagger_Item(EndToolMaterial.THALLASIUM, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_big_axe"), new Big_Axe_Item(EndToolMaterial.THALLASIUM, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_lance"), new Lance_Item(EndToolMaterial.THALLASIUM, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_healing_staff"), new Healing_Staff_Item(EndToolMaterial.THALLASIUM, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_mace"), new Mace_Item(EndToolMaterial.THALLASIUM, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP)));
            THALLASIUM_FRANCISCA_ITEM = ItemInit.register("thallasium_francisca",
                    new Francisca_Item(EndToolMaterial.THALLASIUM, 1.0F, -2.6F, () -> CompatEntities.THALLASIUM_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP)));
            THALLASIUM_JAVELIN_ITEM = ItemInit.register("thallasium_javelin",
                    new Javelin_Item(EndToolMaterial.THALLASIUM, 2.2F, -2.7F, () -> CompatEntities.THALLASIUM_JAVELIN, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_francisca"), THALLASIUM_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_javelin"), THALLASIUM_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_ninjato"), new Ninjato_Item(EndToolMaterial.THALLASIUM, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_sickle"), new Sickle_Item(EndToolMaterial.THALLASIUM, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP)));
            ItemInit.ITEMS.put(MedievalMain.ID("thallasium_rapier"), new Rapier_Item(EndToolMaterial.THALLASIUM, 3, -2.0F, 2, new Item.Settings().group(MedievalMain.GROUP)));

            ItemInit.MATERIAL_STRINGS.add("terminite");
            ItemInit.MATERIAL_STRINGS.add("aeternium");
            ItemInit.MATERIAL_STRINGS.add("thallasium");
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
            NETHER_RUBY_FRANCISCA_ITEM = ItemInit.register("nether_ruby_francisca",
                    new Francisca_Item(BNToolMaterial.NETHER_RUBY, 1.0F, -2.6F, () -> CompatEntities.NETHER_RUBY_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            NETHER_RUBY_JAVELIN_ITEM = ItemInit.register("nether_ruby_javelin",
                    new Javelin_Item(BNToolMaterial.NETHER_RUBY, 2.2F, -2.7F, () -> CompatEntities.NETHER_RUBY_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_francisca"), NETHER_RUBY_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_javelin"), NETHER_RUBY_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_ninjato"), new Ninjato_Item(BNToolMaterial.NETHER_RUBY, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_sickle"), new Sickle_Item(BNToolMaterial.NETHER_RUBY, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("nether_ruby_rapier"), new Rapier_Item(BNToolMaterial.NETHER_RUBY, 3, -2.0F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_small_axe"), new Small_Axe_Item(BNToolMaterial.CINCINNASITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_long_sword"), new Long_Sword_Item(BNToolMaterial.CINCINNASITE, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_dagger"), new Dagger_Item(BNToolMaterial.CINCINNASITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_big_axe"), new Big_Axe_Item(BNToolMaterial.CINCINNASITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_lance"), new Lance_Item(BNToolMaterial.CINCINNASITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_healing_staff"),
                    new Healing_Staff_Item(BNToolMaterial.CINCINNASITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_mace"), new Mace_Item(BNToolMaterial.CINCINNASITE, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            CINCINNASITE_FRANCISCA_ITEM = ItemInit.register("cincinnasite_francisca",
                    new Francisca_Item(BNToolMaterial.CINCINNASITE, 1.0F, -2.6F, () -> CompatEntities.CINCINNASITE_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            CINCINNASITE_JAVELIN_ITEM = ItemInit.register("cincinnasite_javelin",
                    new Javelin_Item(BNToolMaterial.CINCINNASITE, 2.2F, -2.7F, () -> CompatEntities.CINCINNASITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_francisca"), CINCINNASITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_javelin"), CINCINNASITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_ninjato"), new Ninjato_Item(BNToolMaterial.CINCINNASITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_sickle"), new Sickle_Item(BNToolMaterial.CINCINNASITE, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_rapier"), new Rapier_Item(BNToolMaterial.CINCINNASITE, 3, -2.0F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

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
            CINCINNASITE_DIAMOND_FRANCISCA_ITEM = ItemInit.register("cincinnasite_diamond_francisca", new Francisca_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 1.0F, -2.6F,
                    () -> CompatEntities.CINCINNASITE_DIAMOND_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            CINCINNASITE_DIAMOND_JAVELIN_ITEM = ItemInit.register("cincinnasite_diamond_javelin",
                    new Javelin_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 2.2F, -2.7F, () -> CompatEntities.CINCINNASITE_DIAMOND_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_francisca"), CINCINNASITE_DIAMOND_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_javelin"), CINCINNASITE_DIAMOND_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_ninjato"),
                    new Ninjato_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_sickle"),
                    new Sickle_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("cincinnasite_diamond_rapier"),
                    new Rapier_Item(BNToolMaterial.CINCINNASITE_DIAMOND, 3, -2.0F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("nether_ruby");
            ItemInit.MATERIAL_STRINGS.add("cincinnasite");
            ItemInit.MATERIAL_STRINGS.add("cincinnasite_diamond");
        }
        if (isDragonLootLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_small_axe"), new Small_Axe_Item(DragonToolMaterial.getInstance(), 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_long_sword"), new Long_Sword_Item(DragonToolMaterial.getInstance(), 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_dagger"), new Dagger_Item(DragonToolMaterial.getInstance(), 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_big_axe"), new Big_Axe_Item(DragonToolMaterial.getInstance(), 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_lance"), new Lance_Item(DragonToolMaterial.getInstance(), 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_healing_staff"),
                    new Healing_Staff_Item(DragonToolMaterial.getInstance(), 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_mace"), new Mace_Item(DragonToolMaterial.getInstance(), 4, -2.8F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            DRAGON_FRANCISCA_ITEM = ItemInit.register("dragon_francisca",
                    new Francisca_Item(DragonToolMaterial.getInstance(), 1.0F, -2.6F, () -> CompatEntities.DRAGON_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            DRAGON_JAVELIN_ITEM = ItemInit.register("dragon_javelin",
                    new Javelin_Item(DragonToolMaterial.getInstance(), 2.2F, -2.7F, () -> CompatEntities.DRAGON_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_francisca"), DRAGON_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_javelin"), DRAGON_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_ninjato"), new Ninjato_Item(DragonToolMaterial.getInstance(), 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_sickle"), new Sickle_Item(DragonToolMaterial.getInstance(), 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("dragon_rapier"), new Rapier_Item(DragonToolMaterial.getInstance(), 3, -2.0F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("dragon");
        }
        if (isMythicMetalsLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_small_axe"), new Small_Axe_Item(MythicToolMaterials.ADAMANTITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_long_sword"), new Long_Sword_Item(MythicToolMaterials.ADAMANTITE, 5, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_dagger"), new Dagger_Item(MythicToolMaterials.ADAMANTITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_big_axe"), new Big_Axe_Item(MythicToolMaterials.ADAMANTITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_lance"), new Lance_Item(MythicToolMaterials.ADAMANTITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_healing_staff"),
                    new Healing_Staff_Item(MythicToolMaterials.ADAMANTITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_mace"), new Mace_Item(MythicToolMaterials.ADAMANTITE, 4, -3.0F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ADAMANTITE_FRANCISCA_ITEM = ItemInit.register("adamantite_francisca",
                    new Francisca_Item(MythicToolMaterials.ADAMANTITE, 2.0F, -2.6F, () -> CompatEntities.ADAMANTITE_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ADAMANTITE_JAVELIN_ITEM = ItemInit.register("adamantite_javelin",
                    new Javelin_Item(MythicToolMaterials.ADAMANTITE, 2.2F, -2.7F, () -> CompatEntities.ADAMANTITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_francisca"), ADAMANTITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_javelin"), ADAMANTITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_ninjato"), new Ninjato_Item(MythicToolMaterials.ADAMANTITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_sickle"), new Sickle_Item(MythicToolMaterials.ADAMANTITE, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("adamantite_rapier"), new Rapier_Item(MythicToolMaterials.ADAMANTITE, 3, -2.0F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("adamantite");
        }
        if (isAetherLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_small_axe"), new Small_Axe_Item(AetherToolMaterials.GRAVITITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_long_sword"), new Long_Sword_Item(AetherToolMaterials.GRAVITITE, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_dagger"), new Dagger_Item(AetherToolMaterials.GRAVITITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_big_axe"), new Big_Axe_Item(AetherToolMaterials.GRAVITITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_lance"), new Lance_Item(AetherToolMaterials.GRAVITITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_healing_staff"),
                    new Healing_Staff_Item(AetherToolMaterials.GRAVITITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_mace"), new Mace_Item(AetherToolMaterials.GRAVITITE, 4, -2.8F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            GRAVITITE_FRANCISCA_ITEM = ItemInit.register("gravitite_francisca",
                    new Francisca_Item(AetherToolMaterials.GRAVITITE, 1.0F, -2.6F, () -> CompatEntities.GRAVITITE_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            GRAVITITE_JAVELIN_ITEM = ItemInit.register("gravitite_javelin",
                    new Javelin_Item(AetherToolMaterials.GRAVITITE, 2.2F, -2.7F, () -> CompatEntities.GRAVITITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_francisca"), GRAVITITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_javelin"), GRAVITITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_ninjato"), new Ninjato_Item(AetherToolMaterials.GRAVITITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_sickle"), new Sickle_Item(AetherToolMaterials.GRAVITITE, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gravitite_rapier"), new Rapier_Item(AetherToolMaterials.GRAVITITE, 3, -2.0F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.ITEMS.put(MedievalMain.ID("zanite_small_axe"), new Small_Axe_Item(AetherToolMaterials.ZANITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_long_sword"), new Long_Sword_Item(AetherToolMaterials.ZANITE, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_dagger"), new Dagger_Item(AetherToolMaterials.ZANITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_big_axe"), new Big_Axe_Item(AetherToolMaterials.ZANITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_lance"), new Lance_Item(AetherToolMaterials.ZANITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_healing_staff"), new Healing_Staff_Item(AetherToolMaterials.ZANITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_mace"), new Mace_Item(AetherToolMaterials.ZANITE, 4, -2.8F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ZANITE_FRANCISCA_ITEM = ItemInit.register("zanite_francisca",
                    new Francisca_Item(AetherToolMaterials.ZANITE, 1.0F, -2.6F, () -> CompatEntities.ZANITE_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ZANITE_JAVELIN_ITEM = ItemInit.register("zanite_javelin",
                    new Javelin_Item(AetherToolMaterials.ZANITE, 2.2F, -2.7F, () -> CompatEntities.ZANITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_francisca"), ZANITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_javelin"), ZANITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_ninjato"), new Ninjato_Item(AetherToolMaterials.ZANITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_sickle"), new Sickle_Item(AetherToolMaterials.ZANITE, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("zanite_rapier"), new Rapier_Item(AetherToolMaterials.ZANITE, 3, -2.0F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("gravitite");
            ItemInit.MATERIAL_STRINGS.add("zanite");
        }
        if (isBYGLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_small_axe"), new Small_Axe_Item(BYGTier.PENDORITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_long_sword"), new Long_Sword_Item(BYGTier.PENDORITE, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_dagger"), new Dagger_Item(BYGTier.PENDORITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_big_axe"), new Big_Axe_Item(BYGTier.PENDORITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_lance"), new Lance_Item(BYGTier.PENDORITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_healing_staff"), new Healing_Staff_Item(BYGTier.PENDORITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_mace"), new Mace_Item(BYGTier.PENDORITE, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            PENDORITE_FRANCISCA_ITEM = ItemInit.register("pendorite_francisca",
                    new Francisca_Item(BYGTier.PENDORITE, 1.0F, -2.6F, () -> CompatEntities.PENDORITE_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            PENDORITE_JAVELIN_ITEM = ItemInit.register("pendorite_javelin",
                    new Javelin_Item(BYGTier.PENDORITE, 2.2F, -2.7F, () -> CompatEntities.PENDORITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_francisca"), PENDORITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_javelin"), PENDORITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_ninjato"), new Ninjato_Item(BYGTier.PENDORITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_sickle"), new Sickle_Item(BYGTier.PENDORITE, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("pendorite_rapier"), new Rapier_Item(BYGTier.PENDORITE, 3, -2.0F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("pendorite");
        }
        if (isAdditionalAdditionsLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_small_axe"),
                    new Small_Axe_Item(GildedNetheriteToolMaterial.MATERIAL, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_long_sword"),
                    new Long_Sword_Item(GildedNetheriteToolMaterial.MATERIAL, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_dagger"), new Dagger_Item(GildedNetheriteToolMaterial.MATERIAL, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_big_axe"),
                    new Big_Axe_Item(GildedNetheriteToolMaterial.MATERIAL, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_lance"), new Lance_Item(GildedNetheriteToolMaterial.MATERIAL, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_healing_staff"),
                    new Healing_Staff_Item(GildedNetheriteToolMaterial.MATERIAL, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_mace"), new Mace_Item(GildedNetheriteToolMaterial.MATERIAL, 4, -2.8F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            GILDED_NETHERITE_FRANCISCA_ITEM = ItemInit.register("gilded_netherite_francisca",
                    new Francisca_Item(GildedNetheriteToolMaterial.MATERIAL, 1.0F, -2.6F, () -> CompatEntities.GILDED_NETHERITE_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            GILDED_NETHERITE_JAVELIN_ITEM = ItemInit.register("gilded_netherite_javelin",
                    new Javelin_Item(GildedNetheriteToolMaterial.MATERIAL, 2.2F, -2.7F, () -> CompatEntities.GILDED_NETHERITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_francisca"), GILDED_NETHERITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_javelin"), GILDED_NETHERITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_ninjato"),
                    new Ninjato_Item(GildedNetheriteToolMaterial.MATERIAL, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_sickle"), new Sickle_Item(GildedNetheriteToolMaterial.MATERIAL, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("gilded_netherite_rapier"),
                    new Rapier_Item(GildedNetheriteToolMaterial.MATERIAL, 3, -2.0F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_small_axe"), new Small_Axe_Item(RoseGoldToolMaterial.MATERIAL, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_long_sword"), new Long_Sword_Item(RoseGoldToolMaterial.MATERIAL, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_dagger"), new Dagger_Item(RoseGoldToolMaterial.MATERIAL, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_big_axe"), new Big_Axe_Item(RoseGoldToolMaterial.MATERIAL, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_lance"), new Lance_Item(RoseGoldToolMaterial.MATERIAL, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_healing_staff"),
                    new Healing_Staff_Item(RoseGoldToolMaterial.MATERIAL, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_mace"), new Mace_Item(RoseGoldToolMaterial.MATERIAL, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ROSE_GOLD_FRANCISCA_ITEM = ItemInit.register("rose_gold_francisca",
                    new Francisca_Item(RoseGoldToolMaterial.MATERIAL, 1.0F, -2.6F, () -> CompatEntities.ROSE_GOLD_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ROSE_GOLD_JAVELIN_ITEM = ItemInit.register("rose_gold_javelin",
                    new Javelin_Item(RoseGoldToolMaterial.MATERIAL, 2.2F, -2.7F, () -> CompatEntities.ROSE_GOLD_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_francisca"), ROSE_GOLD_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_javelin"), ROSE_GOLD_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_ninjato"), new Ninjato_Item(RoseGoldToolMaterial.MATERIAL, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_sickle"), new Sickle_Item(RoseGoldToolMaterial.MATERIAL, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("rose_gold_rapier"), new Rapier_Item(RoseGoldToolMaterial.MATERIAL, 3, -2.0F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("gilded_netherite");
            ItemInit.MATERIAL_STRINGS.add("rose_gold");
        }
        if (isMythicUpgradesLoaded) {
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_small_axe"), new Small_Axe_Item(ModToolMaterials.RUBY_NETHERITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_long_sword"),
                    new Long_Sword_Item(ModToolMaterials.RUBY_NETHERITE, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_dagger"), new Dagger_Item(ModToolMaterials.RUBY_NETHERITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_big_axe"), new Big_Axe_Item(ModToolMaterials.RUBY_NETHERITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_lance"), new Lance_Item(ModToolMaterials.RUBY_NETHERITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_healing_staff"),
                    new Healing_Staff_Item(ModToolMaterials.RUBY_NETHERITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_mace"), new Mace_Item(ModToolMaterials.RUBY_NETHERITE, 4, -2.8F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            RUBY_NETHERITE_FRANCISCA_ITEM = ItemInit.register("ruby_netherite_francisca",
                    new Francisca_Item(ModToolMaterials.RUBY_NETHERITE, 1.0F, -2.6F, () -> CompatEntities.RUBY_NETHERITE_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            RUBY_NETHERITE_JAVELIN_ITEM = ItemInit.register("ruby_netherite_javelin",
                    new Javelin_Item(ModToolMaterials.RUBY_NETHERITE, 2.2F, -2.7F, () -> CompatEntities.RUBY_NETHERITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_francisca"), RUBY_NETHERITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_javelin"), RUBY_NETHERITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_ninjato"), new Ninjato_Item(ModToolMaterials.RUBY_NETHERITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_sickle"), new Sickle_Item(ModToolMaterials.RUBY_NETHERITE, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("ruby_netherite_rapier"), new Rapier_Item(ModToolMaterials.RUBY_NETHERITE, 3, -2.0F, 3, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_small_axe"),
                    new Small_Axe_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 5, -2.9F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_long_sword"),
                    new Long_Sword_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 6, -3.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_dagger"),
                    new Dagger_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 2, -2.0F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_big_axe"),
                    new Big_Axe_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 6, -3.4F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_lance"), new Lance_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 3, -3.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_healing_staff"),
                    new Healing_Staff_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 1, -3.3F, 4, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_mace"), new Mace_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 4, -2.8F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            SAPPHIRE_NETHERITE_FRANCISCA_ITEM = ItemInit.register("sapphire_netherite_francisca", new Francisca_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 1.0F, -2.6F,
                    () -> CompatEntities.SAPPHIRE_NETHERITE_FRANCISCA, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            SAPPHIRE_NETHERITE_JAVELIN_ITEM = ItemInit.register("sapphire_netherite_javelin",
                    new Javelin_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 2.2F, -2.7F, () -> CompatEntities.SAPPHIRE_NETHERITE_JAVELIN, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_francisca"), SAPPHIRE_NETHERITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_javelin"), SAPPHIRE_NETHERITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_ninjato"),
                    new Ninjato_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 2, -2.1F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_sickle"),
                    new Sickle_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 2, -2.2F, new Item.Settings().group(MedievalMain.GROUP).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.ID("sapphire_netherite_rapier"),
                    new Rapier_Item(ModToolMaterials.SAPPHIRE_NETHERITE, 3, -2.0F, 2, new Item.Settings().group(MedievalMain.GROUP).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("ruby_netherite");
            ItemInit.MATERIAL_STRINGS.add("sapphire_netherite");
        }
    }
}