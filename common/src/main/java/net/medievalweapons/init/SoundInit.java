package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;

import java.util.function.BiConsumer;

public class SoundInit {

    public static final Identifier MAGIC_HEAL_AURA = MedievalMain.identifierOf("magic_heal_aura");
    public static final Identifier MAGIC_SHOT = MedievalMain.identifierOf("magic_shot");
    public static final Identifier PARRYING = MedievalMain.identifierOf("parrying");
    public static final Identifier SWORD_PARRYING = MedievalMain.identifierOf("sword_parrying");
    public static final SoundEvent SWORD_PARRYING_EVENT = SoundEvent.createVariableRangeEvent(SWORD_PARRYING);
    public static final SoundEvent MAGIC_HEAL_AURA_EVENT = SoundEvent.createVariableRangeEvent(MAGIC_HEAL_AURA);
    public static final SoundEvent MAGIC_SHOT_EVENT = SoundEvent.createVariableRangeEvent(MAGIC_SHOT);
    public static final SoundEvent PARRYING_EVENT = SoundEvent.createVariableRangeEvent(PARRYING);
    public static final ResourceKey<SoundEvent> SWORD_PARRYING_KEY = ResourceKey.create(Registries.SOUND_EVENT, SWORD_PARRYING);
    public static final ResourceKey<SoundEvent> PARRYING_KEY = ResourceKey.create(Registries.SOUND_EVENT, PARRYING);

    public static void register(BiConsumer<Identifier, SoundEvent> registrar) {
        registrar.accept(SWORD_PARRYING, SWORD_PARRYING_EVENT);
        registrar.accept(MAGIC_HEAL_AURA, MAGIC_HEAL_AURA_EVENT);
        registrar.accept(MAGIC_SHOT, MAGIC_SHOT_EVENT);
        registrar.accept(PARRYING, PARRYING_EVENT);
    }

}
