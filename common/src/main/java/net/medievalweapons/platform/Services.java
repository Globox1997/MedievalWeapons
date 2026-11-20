package net.medievalweapons.platform;

import net.medievalweapons.platform.services.IItemHelper;
import net.medievalweapons.platform.services.INetworkHelper;
import net.medievalweapons.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static INetworkHelper network() {
        return NetworkHolder.NETWORK;
    }

    public static IItemHelper items() {
        return ItemHolder.ITEMS;
    }

    public static <T> T load(Class<T> clazz) {
        return ServiceLoader.load(clazz, Services.class.getClassLoader()).findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
    }

    private static final class ItemHolder {
        private static final IItemHelper ITEMS = load(IItemHelper.class);
    }

    private static final class NetworkHolder {
        private static final INetworkHelper NETWORK = load(INetworkHelper.class);
    }
}
