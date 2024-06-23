package net.medievalweapons.init;

import net.medievalweapons.effect.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class EffectInit {

    public static final RegistryEntry<StatusEffect> STUN_EFFECT = register("medievalweapons:stun", new StunEffect(StatusEffectCategory.HARMFUL, 12221440));
    public static final RegistryEntry<StatusEffect> BLEED_EFFECT = register("medievalweapons:bleed", new BleedEffect(StatusEffectCategory.HARMFUL, 10303293));

    public static void init() {
    }

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(id), statusEffect);
    }
}
