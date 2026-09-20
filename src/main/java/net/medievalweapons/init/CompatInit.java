package net.medievalweapons.init;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;

public class CompatInit {

    public static final boolean isBetterCombatLoaded = FabricLoader.getInstance().isModLoaded("bettercombat");
    public static final Boolean isLevelZLoaded = FabricLoader.getInstance().isModLoaded("levelz");

    public static void init() {
        if (CompatItems.isAdditionalAdditionsLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("additionaladditions_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
        if (CompatItems.isBetterEndLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("betterend_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
        if (CompatItems.isBetterNetherLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("betternether_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
        if (CompatItems.isBYGLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("byg_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
        if (CompatItems.isDeeperDarkerLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("deeperdarker_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
        if (CompatItems.isDragonLootLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("dragonloot_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
        if (CompatItems.isEarlyStageLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("earlystage_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
        if (CompatItems.isMythicMetalsLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("mythicmetals_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
        if (CompatItems.isMythicUpgradesLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("mythicupgrades_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
        if (CompatItems.isOblivionLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("oblivion_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
        if (CompatItems.isParadiseLostLoaded) {
            ResourceManagerHelper.registerBuiltinResourcePack(MedievalMain.identifierOf("paradise_lost_medievalweapons_compat"), FabricLoader.getInstance().getModContainer("medievalweapons").orElseThrow(),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
    }

}
