package net.medievalweapons.compat;

import net.medievalweapons.entity.*;
import net.medievalweapons.init.EntityInit;
import net.medievalweapons.item.FranciscaItem;
import net.medievalweapons.item.JavelinItem;
import net.minecraft.world.entity.EntityType;

public class CompatEntities {
    // DragonLoot
    public static EntityType<JavelinEntity> DRAGON_JAVELIN;
    public static EntityType<FranciscaEntity> DRAGON_FRANCISCA;

    // Better Nether
    public static EntityType<FranciscaEntity> NETHER_RUBY_FRANCISCA;
    public static EntityType<JavelinEntity> NETHER_RUBY_JAVELIN;
    public static EntityType<FranciscaEntity> CINCINNASITE_FRANCISCA;
    public static EntityType<JavelinEntity> CINCINNASITE_JAVELIN;
    public static EntityType<FranciscaEntity> CINCINNASITE_DIAMOND_FRANCISCA;
    public static EntityType<JavelinEntity> CINCINNASITE_DIAMOND_JAVELIN;

    // Better End
    public static EntityType<FranciscaEntity> TERMINITE_FRANCISCA;
    public static EntityType<JavelinEntity> TERMINITE_JAVELIN;
    public static EntityType<FranciscaEntity> AETERNIUM_FRANCISCA;
    public static EntityType<JavelinEntity> AETERNIUM_JAVELIN;
    public static EntityType<FranciscaEntity> THALLASIUM_FRANCISCA;
    public static EntityType<JavelinEntity> THALLASIUM_JAVELIN;

    // Mythic Metals
    public static EntityType<JavelinEntity> ADAMANTITE_JAVELIN;
    public static EntityType<FranciscaEntity> ADAMANTITE_FRANCISCA;

    // BYG
    public static EntityType<JavelinEntity> PENDORITE_JAVELIN;
    public static EntityType<FranciscaEntity> PENDORITE_FRANCISCA;

    // Additional Additions
    public static EntityType<JavelinEntity> ROSE_GOLD_JAVELIN;
    public static EntityType<FranciscaEntity> ROSE_GOLD_FRANCISCA;
    public static EntityType<JavelinEntity> GILDED_NETHERITE_JAVELIN;
    public static EntityType<FranciscaEntity> GILDED_NETHERITE_FRANCISCA;

    // Paradise Lost
    public static EntityType<JavelinEntity> OLVITE_JAVELIN;
    public static EntityType<FranciscaEntity> OLVITE_FRANCISCA;

    // Mythic Upgrades
    public static EntityType<JavelinEntity> RUBY_NETHERITE_JAVELIN;
    public static EntityType<FranciscaEntity> RUBY_NETHERITE_FRANCISCA;
    public static EntityType<JavelinEntity> SAPPHIRE_NETHERITE_JAVELIN;
    public static EntityType<FranciscaEntity> SAPPHIRE_NETHERITE_FRANCISCA;

    // Deeper and Darker
    public static EntityType<JavelinEntity> WARDEN_JAVELIN;
    public static EntityType<FranciscaEntity> WARDEN_FRANCISCA;

    // EarlyStage
    public static EntityType<JavelinEntity> STEEL_JAVELIN;
    public static EntityType<FranciscaEntity> STEEL_FRANCISCA;
    public static EntityType<JavelinEntity> DAMASCUS_STEEL_JAVELIN;
    public static EntityType<FranciscaEntity> DAMASCUS_STEEL_FRANCISCA;

    // Oblivion
    public static EntityType<JavelinEntity> FIERY_NETHERITE_JAVELIN;
    public static EntityType<FranciscaEntity> FIERY_NETHERITE_FRANCISCA;
    public static EntityType<JavelinEntity> SCARLET_JAVELIN;
    public static EntityType<FranciscaEntity> SCARLET_FRANCISCA;
    public static EntityType<JavelinEntity> SOLARITE_JAVELIN;
    public static EntityType<FranciscaEntity> SOLARITE_FRANCISCA;

    public static void loadEntities() {
        if (CompatItems.isBetterEndLoaded) {
            TERMINITE_FRANCISCA = EntityInit.register("terminite_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.TERMINITE_FRANCISCA_ITEM));
            TERMINITE_JAVELIN = EntityInit.register("terminite_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.TERMINITE_JAVELIN_ITEM));
            AETERNIUM_FRANCISCA = EntityInit.register("aeternium_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.AETERNIUM_FRANCISCA_ITEM));
            AETERNIUM_JAVELIN = EntityInit.register("aeternium_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.AETERNIUM_JAVELIN_ITEM));
            THALLASIUM_FRANCISCA = EntityInit.register("thallasium_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.THALLASIUM_FRANCISCA_ITEM));
            THALLASIUM_JAVELIN = EntityInit.register("thallasium_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.THALLASIUM_JAVELIN_ITEM));
        }
        if (CompatItems.isBetterNetherLoaded) {
            NETHER_RUBY_FRANCISCA = EntityInit.register("nether_ruby_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.NETHER_RUBY_FRANCISCA_ITEM));
            NETHER_RUBY_JAVELIN = EntityInit.register("nether_ruby_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.NETHER_RUBY_JAVELIN_ITEM));
            CINCINNASITE_FRANCISCA = EntityInit.register("cincinnasite_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.CINCINNASITE_FRANCISCA_ITEM));
            CINCINNASITE_JAVELIN = EntityInit.register("cincinnasite_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.CINCINNASITE_JAVELIN_ITEM));
            CINCINNASITE_DIAMOND_FRANCISCA = EntityInit.register("cincinnasite_diamond_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.CINCINNASITE_DIAMOND_FRANCISCA_ITEM));
            CINCINNASITE_DIAMOND_JAVELIN = EntityInit.register("cincinnasite_diamond_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.CINCINNASITE_DIAMOND_JAVELIN_ITEM));
        }
        if (CompatItems.isDragonLootLoaded) {
            DRAGON_JAVELIN = EntityInit.register("dragon_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.DRAGON_JAVELIN_ITEM));
            DRAGON_FRANCISCA = EntityInit.register("dragon_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.DRAGON_FRANCISCA_ITEM));
        }
        if (CompatItems.isMythicMetalsLoaded) {
            ADAMANTITE_JAVELIN = EntityInit.register("adamantite_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.ADAMANTITE_JAVELIN_ITEM));
            ADAMANTITE_FRANCISCA = EntityInit.register("adamantite_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.ADAMANTITE_FRANCISCA_ITEM));
        }
        if (CompatItems.isParadiseLostLoaded) {
            OLVITE_JAVELIN = EntityInit.register("olvite_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.OLVITE_JAVELIN_ITEM));
            OLVITE_FRANCISCA = EntityInit.register("olvite_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.OLVITE_FRANCISCA_ITEM));
        }
        if (CompatItems.isBYGLoaded) {
            PENDORITE_JAVELIN = EntityInit.register("pendorite_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.PENDORITE_JAVELIN_ITEM));
            PENDORITE_FRANCISCA = EntityInit.register("pendorite_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.PENDORITE_FRANCISCA_ITEM));
        }
        if (CompatItems.isAdditionalAdditionsLoaded) {
            ROSE_GOLD_JAVELIN = EntityInit.register("rose_gold_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.ROSE_GOLD_JAVELIN_ITEM));
            ROSE_GOLD_FRANCISCA = EntityInit.register("rose_gold_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.ROSE_GOLD_FRANCISCA_ITEM));
            GILDED_NETHERITE_JAVELIN = EntityInit.register("gilded_netherite_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.GILDED_NETHERITE_JAVELIN_ITEM));
            GILDED_NETHERITE_FRANCISCA = EntityInit.register("gilded_netherite_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.GILDED_NETHERITE_FRANCISCA_ITEM));
        }
        if (CompatItems.isMythicUpgradesLoaded) {
            RUBY_NETHERITE_JAVELIN = EntityInit.register("ruby_netherite_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.RUBY_NETHERITE_JAVELIN_ITEM));
            RUBY_NETHERITE_FRANCISCA = EntityInit.register("ruby_netherite_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.RUBY_NETHERITE_FRANCISCA_ITEM));
            SAPPHIRE_NETHERITE_JAVELIN = EntityInit.register("sapphire_netherite_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.SAPPHIRE_NETHERITE_JAVELIN_ITEM));
            SAPPHIRE_NETHERITE_FRANCISCA = EntityInit.register("sapphire_netherite_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.SAPPHIRE_NETHERITE_FRANCISCA_ITEM));
        }
        if (CompatItems.isDeeperDarkerLoaded) {
            WARDEN_JAVELIN = EntityInit.register("warden_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.WARDEN_JAVELIN_ITEM));
            WARDEN_FRANCISCA = EntityInit.register("warden_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.WARDEN_FRANCISCA_ITEM));
        }
        if (CompatItems.isEarlyStageLoaded) {
            STEEL_JAVELIN = EntityInit.register("steel_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.STEEL_JAVELIN_ITEM));
            STEEL_FRANCISCA = EntityInit.register("steel_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.STEEL_FRANCISCA_ITEM));
            DAMASCUS_STEEL_JAVELIN = EntityInit.register("damascus_steel_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.DAMASCUS_STEEL_JAVELIN_ITEM));
            DAMASCUS_STEEL_FRANCISCA = EntityInit.register("damascus_steel_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.DAMASCUS_STEEL_FRANCISCA_ITEM));
        }
        if (CompatItems.isOblivionLoaded) {
            FIERY_NETHERITE_JAVELIN = EntityInit.register("fiery_netherite_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.FIERY_NETHERITE_JAVELIN_ITEM));
            FIERY_NETHERITE_FRANCISCA = EntityInit.register("fiery_netherite_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.FIERY_NETHERITE_FRANCISCA_ITEM));
            SCARLET_JAVELIN = EntityInit.register("scarlet_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.SCARLET_JAVELIN_ITEM));
            SCARLET_FRANCISCA = EntityInit.register("scarlet_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.SCARLET_FRANCISCA_ITEM));
            SOLARITE_JAVELIN = EntityInit.register("solarite_javelin", EntityInit.createJavelin((JavelinItem) CompatItems.SOLARITE_JAVELIN_ITEM));
            SOLARITE_FRANCISCA = EntityInit.register("solarite_francisca", EntityInit.createFrancisca((FranciscaItem) CompatItems.SOLARITE_FRANCISCA_ITEM));
        }
    }
}
