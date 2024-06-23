package net.medievalweapons.init;

import net.fabricmc.loader.api.FabricLoader;

public class CompatInit {

    public static final boolean isBetterCombatLoaded = FabricLoader.getInstance().isModLoaded("bettercombat");
    public static final Boolean isLevelZLoaded = FabricLoader.getInstance().isModLoaded("levelz");
    public static final Boolean isARRPLoaded = FabricLoader.getInstance().isModLoaded("advanced_runtime_resource_pack");
    public static final Boolean isBRRPLoaded = FabricLoader.getInstance().isModLoaded("brrp_v1");

    public static void init() {
    }

}
