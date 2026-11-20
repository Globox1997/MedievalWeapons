package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.effect.BleedEffect;
import net.medievalweapons.effect.StunEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.util.function.BiConsumer;

public class EffectInit {

    public static Holder<MobEffect> STUN_EFFECT;
    public static Holder<MobEffect> BLEED_EFFECT;

    public static void register(BiConsumer<Identifier, MobEffect> registrar) {
        MobEffect stun = new StunEffect(MobEffectCategory.HARMFUL, 12221440);
        MobEffect bleed = new BleedEffect(MobEffectCategory.HARMFUL, 10303293);
        registrar.accept(MedievalMain.identifierOf("stun"), stun);
        registrar.accept(MedievalMain.identifierOf("bleed"), bleed);
        STUN_EFFECT = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(stun);
        BLEED_EFFECT = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(bleed);
    }
}
