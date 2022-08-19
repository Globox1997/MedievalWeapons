package net.medievalweapons.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "medievalweapons")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public class MedievalConfig implements ConfigData {

    @Comment("20 ticks = 1 second")
    public int weapon_blocking_cooldown = 60;
    @Comment("20 ticks = 1 second")
    public int shield_blocking_cooldown = 40;
    @Comment("Includes war axe and battle axe")
    public int extra_weapon_shield_blocking_cooldown = 60;
    public boolean old_healing_staff_behavior = false;
    public boolean healing_staff_owner_healing = false;
}