package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.effect.BleedEffect;
import net.medievalweapons.effect.StunEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class EffectInit {

    public static final RegistryEntry<StatusEffect> STUN_EFFECT = register(MedievalMain.identifierOf("stun"), new StunEffect(StatusEffectCategory.HARMFUL, 12221440));
    public static final RegistryEntry<StatusEffect> BLEED_EFFECT = register(MedievalMain.identifierOf("bleed"), new BleedEffect(StatusEffectCategory.HARMFUL, 10303293));

    public static void init() {
    }

    private static RegistryEntry<StatusEffect> register(Identifier id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, id, statusEffect);
    }
}
