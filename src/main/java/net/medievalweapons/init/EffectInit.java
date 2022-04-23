package net.medievalweapons.init;

import net.medievalweapons.effect.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.registry.Registry;

public class EffectInit {

    public static final StatusEffect STUN_EFFECT = new StunEffect(StatusEffectCategory.HARMFUL, 12221440);

    public static void init() {
        Registry.register(Registry.STATUS_EFFECT, "medievalweapons:stun", STUN_EFFECT);
    }

}
