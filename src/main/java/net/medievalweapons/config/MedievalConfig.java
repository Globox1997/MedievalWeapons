package net.medievalweapons.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "medievalweapons")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public class MedievalConfig implements ConfigData {
  @Comment("Only for double handed weapons")
  public boolean auto_switch = false;

}