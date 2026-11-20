package net.medievalweapons.fabric.platform;

import net.fabricmc.loader.api.FabricLoader;
import net.medievalweapons.platform.services.IPlatformHelper;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

}
