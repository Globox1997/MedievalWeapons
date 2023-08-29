package net.medievalweapons.compat;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.entity.*;
import net.medievalweapons.init.EntityInit;
import net.minecraft.entity.EntityType;

public class CompatEntities {
    // DragonLoot
    public static EntityType<Javelin_Entity> DRAGON_JAVELIN;
    public static EntityType<Francisca_Entity> DRAGON_FRANCISCA;

    // Better Nether
    public static EntityType<Francisca_Entity> NETHER_RUBY_FRANCISCA;
    public static EntityType<Javelin_Entity> NETHER_RUBY_JAVELIN;
    public static EntityType<Francisca_Entity> CINCINNASITE_FRANCISCA;
    public static EntityType<Javelin_Entity> CINCINNASITE_JAVELIN;
    public static EntityType<Francisca_Entity> CINCINNASITE_DIAMOND_FRANCISCA;
    public static EntityType<Javelin_Entity> CINCINNASITE_DIAMOND_JAVELIN;

    // Better End
    public static EntityType<Francisca_Entity> TERMINITE_FRANCISCA;
    public static EntityType<Javelin_Entity> TERMINITE_JAVELIN;
    public static EntityType<Francisca_Entity> AETERNIUM_FRANCISCA;
    public static EntityType<Javelin_Entity> AETERNIUM_JAVELIN;
    public static EntityType<Francisca_Entity> THALLASIUM_FRANCISCA;
    public static EntityType<Javelin_Entity> THALLASIUM_JAVELIN;

    // Mythic Metals
    public static EntityType<Javelin_Entity> ADAMANTITE_JAVELIN;
    public static EntityType<Francisca_Entity> ADAMANTITE_FRANCISCA;

    // BYG
    public static EntityType<Javelin_Entity> PENDORITE_JAVELIN;
    public static EntityType<Francisca_Entity> PENDORITE_FRANCISCA;

    // Additional Additions
    public static EntityType<Javelin_Entity> ROSE_GOLD_JAVELIN;
    public static EntityType<Francisca_Entity> ROSE_GOLD_FRANCISCA;
    public static EntityType<Javelin_Entity> GILDED_NETHERITE_JAVELIN;
    public static EntityType<Francisca_Entity> GILDED_NETHERITE_FRANCISCA;

    // Paradise Lost
    public static EntityType<Javelin_Entity> OLVITE_JAVELIN;
    public static EntityType<Francisca_Entity> OLVITE_FRANCISCA;

    // Mythic Upgrades
    public static EntityType<Javelin_Entity> RUBY_NETHERITE_JAVELIN;
    public static EntityType<Francisca_Entity> RUBY_NETHERITE_FRANCISCA;
    public static EntityType<Javelin_Entity> SAPPHIRE_NETHERITE_JAVELIN;
    public static EntityType<Francisca_Entity> SAPPHIRE_NETHERITE_FRANCISCA;

    // Deeper and Darker
    public static EntityType<Javelin_Entity> WARDEN_JAVELIN;
    public static EntityType<Francisca_Entity> WARDEN_FRANCISCA;

    public static void loadEntities() {
        if (CompatItems.isBetterEndLoaded) {
            TERMINITE_FRANCISCA = EntityInit.register("terminite_francisca", EntityInit.create_Francisca(CompatItems.TERMINITE_FRANCISCA_ITEM));
            TERMINITE_JAVELIN = EntityInit.register("terminite_javelin", EntityInit.create_Javelin(CompatItems.TERMINITE_JAVELIN_ITEM));
            AETERNIUM_FRANCISCA = EntityInit.register("aeternium_francisca", EntityInit.create_Francisca(CompatItems.AETERNIUM_FRANCISCA_ITEM));
            AETERNIUM_JAVELIN = EntityInit.register("aeternium_javelin", EntityInit.create_Javelin(CompatItems.AETERNIUM_JAVELIN_ITEM));
            THALLASIUM_FRANCISCA = EntityInit.register("thallasium_francisca", EntityInit.create_Francisca(CompatItems.THALLASIUM_FRANCISCA_ITEM));
            THALLASIUM_JAVELIN = EntityInit.register("thallasium_javelin", EntityInit.create_Javelin(CompatItems.THALLASIUM_JAVELIN_ITEM));

            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("terminite_francisca"), TERMINITE_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("terminite_javelin"), TERMINITE_JAVELIN);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("aeternium_francisca"), AETERNIUM_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("aeternium_javelin"), AETERNIUM_JAVELIN);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("thallasium_francisca"), THALLASIUM_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("thallasium_javelin"), THALLASIUM_JAVELIN);
        }
        if (CompatItems.isBetterNetherLoaded) {
            NETHER_RUBY_FRANCISCA = EntityInit.register("nether_ruby_francisca", EntityInit.create_Francisca(CompatItems.NETHER_RUBY_FRANCISCA_ITEM));
            NETHER_RUBY_JAVELIN = EntityInit.register("nether_ruby_javelin", EntityInit.create_Javelin(CompatItems.NETHER_RUBY_JAVELIN_ITEM));
            CINCINNASITE_FRANCISCA = EntityInit.register("cincinnasite_francisca", EntityInit.create_Francisca(CompatItems.CINCINNASITE_FRANCISCA_ITEM));
            CINCINNASITE_JAVELIN = EntityInit.register("cincinnasite_javelin", EntityInit.create_Javelin(CompatItems.CINCINNASITE_JAVELIN_ITEM));
            CINCINNASITE_DIAMOND_FRANCISCA = EntityInit.register("cincinnasite_diamond_francisca", EntityInit.create_Francisca(CompatItems.CINCINNASITE_DIAMOND_FRANCISCA_ITEM));
            CINCINNASITE_DIAMOND_JAVELIN = EntityInit.register("cincinnasite_diamond_javelin", EntityInit.create_Javelin(CompatItems.CINCINNASITE_DIAMOND_JAVELIN_ITEM));

            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("nether_ruby_francisca"), NETHER_RUBY_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("nether_ruby_javelin"), NETHER_RUBY_JAVELIN);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("cincinnasite_francisca"), CINCINNASITE_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("cincinnasite_javelin"), CINCINNASITE_JAVELIN);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("cincinnasite_diamond_javelin"), CINCINNASITE_DIAMOND_JAVELIN);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("cincinnasite_diamond_francisca"), CINCINNASITE_DIAMOND_FRANCISCA);
        }
        if (CompatItems.isDragonLootLoaded) {
            DRAGON_JAVELIN = EntityInit.register("dragon_javelin", EntityInit.create_Javelin(CompatItems.DRAGON_JAVELIN_ITEM));
            DRAGON_FRANCISCA = EntityInit.register("dragon_francisca", EntityInit.create_Francisca(CompatItems.DRAGON_FRANCISCA_ITEM));

            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("dragon_francisca"), DRAGON_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("dragon_javelin"), DRAGON_JAVELIN);
        }
        if (CompatItems.isMythicMetalsLoaded) {
            ADAMANTITE_JAVELIN = EntityInit.register("adamantite_javelin", EntityInit.create_Javelin(CompatItems.ADAMANTITE_JAVELIN_ITEM));
            ADAMANTITE_FRANCISCA = EntityInit.register("adamantite_francisca", EntityInit.create_Francisca(CompatItems.ADAMANTITE_FRANCISCA_ITEM));

            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("adamantite_francisca"), ADAMANTITE_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("adamantite_javelin"), ADAMANTITE_JAVELIN);
        }
        if (CompatItems.isParadiseLostLoaded) {
            OLVITE_JAVELIN = EntityInit.register("olvite_javelin", EntityInit.create_Javelin(CompatItems.OLVITE_JAVELIN_ITEM));
            OLVITE_FRANCISCA = EntityInit.register("olvite_francisca", EntityInit.create_Francisca(CompatItems.OLVITE_FRANCISCA_ITEM));

            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("olvite_francisca"), OLVITE_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("olvite_javelin"), OLVITE_JAVELIN);
        }
        if (CompatItems.isBYGLoaded) {
            PENDORITE_JAVELIN = EntityInit.register("pendorite_javelin", EntityInit.create_Javelin(CompatItems.PENDORITE_JAVELIN_ITEM));
            PENDORITE_FRANCISCA = EntityInit.register("pendorite_francisca", EntityInit.create_Francisca(CompatItems.PENDORITE_FRANCISCA_ITEM));

            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("pendorite_francisca"), PENDORITE_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("pendorite_javelin"), PENDORITE_JAVELIN);
        }
        if (CompatItems.isAdditionalAdditionsLoaded) {
            ROSE_GOLD_JAVELIN = EntityInit.register("rose_gold_javelin", EntityInit.create_Javelin(CompatItems.ROSE_GOLD_JAVELIN_ITEM));
            ROSE_GOLD_FRANCISCA = EntityInit.register("rose_gold_francisca", EntityInit.create_Francisca(CompatItems.ROSE_GOLD_FRANCISCA_ITEM));
            GILDED_NETHERITE_JAVELIN = EntityInit.register("gilded_netherite_javelin", EntityInit.create_Javelin(CompatItems.GILDED_NETHERITE_JAVELIN_ITEM));
            GILDED_NETHERITE_FRANCISCA = EntityInit.register("gilded_netherite_francisca", EntityInit.create_Francisca(CompatItems.GILDED_NETHERITE_FRANCISCA_ITEM));

            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("rose_gold_francisca"), ROSE_GOLD_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("rose_gold_javelin"), ROSE_GOLD_JAVELIN);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("gilded_netherite_francisca"), GILDED_NETHERITE_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("gilded_netherite_javelin"), GILDED_NETHERITE_JAVELIN);
        }
        if (CompatItems.isMythicUpgradesLoaded) {
            RUBY_NETHERITE_JAVELIN = EntityInit.register("ruby_netherite_javelin", EntityInit.create_Javelin(CompatItems.RUBY_NETHERITE_JAVELIN_ITEM));
            RUBY_NETHERITE_FRANCISCA = EntityInit.register("ruby_netherite_francisca", EntityInit.create_Francisca(CompatItems.RUBY_NETHERITE_FRANCISCA_ITEM));
            SAPPHIRE_NETHERITE_JAVELIN = EntityInit.register("sapphire_netherite_javelin", EntityInit.create_Javelin(CompatItems.SAPPHIRE_NETHERITE_JAVELIN_ITEM));
            SAPPHIRE_NETHERITE_FRANCISCA = EntityInit.register("sapphire_netherite_francisca", EntityInit.create_Francisca(CompatItems.SAPPHIRE_NETHERITE_FRANCISCA_ITEM));

            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("ruby_netherite_francisca"), RUBY_NETHERITE_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("ruby_netherite_javelin"), RUBY_NETHERITE_JAVELIN);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("sapphire_netherite_francisca"), SAPPHIRE_NETHERITE_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("sapphire_netherite_javelin"), SAPPHIRE_NETHERITE_JAVELIN);
        }
        if (CompatItems.isDeeperDarkerLoaded) {
            WARDEN_JAVELIN = EntityInit.register("warden_javelin", EntityInit.create_Javelin(CompatItems.WARDEN_JAVELIN_ITEM));
            WARDEN_FRANCISCA = EntityInit.register("warden_francisca", EntityInit.create_Francisca(CompatItems.WARDEN_FRANCISCA_ITEM));

            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("warden_francisca"), WARDEN_FRANCISCA);
            EntityInit.ENTITY_TYPES.put(MedievalMain.ID("warden_javelin"), WARDEN_JAVELIN);
        }
    }
}