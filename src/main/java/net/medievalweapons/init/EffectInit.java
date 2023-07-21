package net.medievalweapons.init;

import net.medievalweapons.effect.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EffectInit {

    public static final StatusEffect STUN_EFFECT = new StunEffect(StatusEffectCategory.HARMFUL, 12221440);
    public static final StatusEffect BLEED_EFFECT = new BleedEffect(StatusEffectCategory.HARMFUL, 10303293);

    public static void init() {
        Registry.register(Registries.STATUS_EFFECT, "medievalweapons:stun", STUN_EFFECT);
        Registry.register(Registries.STATUS_EFFECT, "medievalweapons:bleed", BLEED_EFFECT);
    }

}
