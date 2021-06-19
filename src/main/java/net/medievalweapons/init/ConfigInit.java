package net.medievalweapons.init;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.medievalweapons.config.MedievalConfig;

public class ConfigInit {
    public static MedievalConfig CONFIG = new MedievalConfig();

    public static void init() {
        AutoConfig.register(MedievalConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(MedievalConfig.class).getConfig();
    }

}
