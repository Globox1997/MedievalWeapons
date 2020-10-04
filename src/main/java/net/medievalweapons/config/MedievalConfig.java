package net.medievalweapons.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "medievalweapons")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public class MedievalConfig implements ConfigData {

  // public float test1 = 1.0F;
  // public float test2 = 1.0F;
  // public float test3 = 1.0F;

  // public double tansla_1 = 0.0D;
  // public double tansla_2 = 0.85D;
  // public double tansla_3 = 0.0D;

  public float r1 = 20.0F;
  public float r2 = 3.0F;
  // public float r1 = 0.0F;
  // public float r2 = 0.0F;
  // public float r3 = 0.0F;

  @ConfigEntry.Gui.PrefixText
  public boolean auto_switch = false;
  // public int cold_damage_effect_time = 2400;
  // public int cold_tick_interval = 400;
  // public int heating_up_interval = 100;
  // public int heating_up_cold_tick_decrease = 400;
  // @ConfigEntry.Gui.PrefixText
  // public int freeze_icon_x = 7;
  // public int freeze_icon_y = 52;
}
