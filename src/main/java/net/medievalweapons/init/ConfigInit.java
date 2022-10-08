package net.medievalweapons.init;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class ConfigInit {
    public static MedievalConfig CONFIG = new MedievalConfig();

    public static void init() {
        AutoConfig.register(MedievalConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(MedievalConfig.class).getConfig();
    }

}
