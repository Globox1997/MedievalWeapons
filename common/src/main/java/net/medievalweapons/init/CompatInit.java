package net.medievalweapons.init;

import net.medievalweapons.platform.Services;

import java.util.ArrayList;
import java.util.List;

public class CompatInit {

    public static final boolean isBetterCombatLoaded = Services.PLATFORM.isModLoaded("bettercombat");
    public static final Boolean isLevelZLoaded = Services.PLATFORM.isModLoaded("levelz");

    private static final List<String> COMPAT_PACK_MODS = List.of("additionaladditions", "betterend", "betternether", "byg", "deeperdarker", "dragonloot", "earlystage", "mythicmetals",
            "mythicupgrades", "oblivion", "paradise_lost");

    public static List<String> builtinPacks() {
        List<String> packs = new ArrayList<>();
        for (String modId : COMPAT_PACK_MODS) {
            if (Services.PLATFORM.isModLoaded(modId)) {
                packs.add(modId + "_medievalweapons_compat");
            }
        }
        return packs;
    }

}
