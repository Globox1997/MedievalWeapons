package net.medievalweapons.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "medievalweapons")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public class MedievalConfig implements ConfigData {

    @Comment("20 ticks = 1 second")
    public int weapon_blocking_cooldown = 60;
    @Comment("0.03 = 3% chance")
    public float sickle_head_drop_chance = 0.03f;
    public boolean healing_staff_owner_healing = false;

    public int battle_axe_attack_damage = 5;
    public float battle_axe_attack_speed = -2.9f;
    public float battle_axe_knockback = 1.0f;

    public int long_sword_attack_damage = 6;
    public float long_sword_attack_speed = -3.0f;
    public float long_sword_range = 0.8f;

    public int dagger_attack_damage = 2;
    public float dagger_attack_speed = -2.0f;
    public float dagger_range = -1.0f;

    public int francisca_attack_damage = 1;
    public float francisca_attack_speed = -2.6f;

    public int war_axe_attack_damage = 6;
    public float war_axe_attack_speed = -3.4f;
    public float war_axe_sweeping_ratio = 1.0f;

    public int javelin_attack_damage = 2;
    public float javelin_attack_speed = -2.7f;
    public float javelin_range = 1.0f;

    public int lance_attack_damage = 3;
    public float lance_attack_speed = -3.2f;
    public float lance_range = 1.5f;

    public int healing_staff_attack_damage = 1;
    public float healing_staff_attack_speed = -3.3f;
    public float healing_staff_range = 0.5f;

    public int mace_attack_damage = 4;
    public float mace_attack_speed = -2.8f;
    public float mace_range = -0.5f;

    public int ninjato_attack_damage = 2;
    public float ninjato_attack_speed = -2.1f;

    public int sickle_attack_damage = 2;
    public float sickle_attack_speed = -2.2f;

    public int rapier_attack_damage = 2;
    public float rapier_attack_speed = -2.0f;

    public float long_bow_speed = 1.3f;
    public float recurve_bow_speed = 0.9f;

    public int thalleous_sword_attack_damage = 10;
    public float thalleous_sword_attack_speed = -3.0f;
    public float thalleous_sword_range = 1.0f;
    public float thalleous_sword_sweeping_ratio = 1.0f;

    public int deathsinger_sword_attack_damage = 10;
    public float deathsinger_sword_attack_speed = -3.0f;
    public float deathsinger_sword_range = 1.0f;
    public float deathsinger_sword_sweeping_ratio = 1.0f;

    public int tidesinger_staff_attack_damage = 10;
    public float tidesinger_staff_attack_speed = -3.0f;
    public float tidesinger_staff_range = 1.0f;
    public float tidesinger_staff_sweeping_ratio = 1.0f;
}