package net.medievalweapons.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "medievalweapons")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public class MedievalConfig implements ConfigData {
    @Comment("Only for double handed weapons")
    public boolean auto_switch = false;
    public int weapon_blocking_cooldown = 60;
    @Comment("20 ticks = 1 second")
    public int shield_blocking_cooldown = 40;

}