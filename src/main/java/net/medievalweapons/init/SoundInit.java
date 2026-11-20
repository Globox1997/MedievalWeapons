package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class SoundInit {

    public static final ResourceLocation MAGIC_HEAL_AURA = MedievalMain.identifierOf("magic_heal_aura");
    public static final ResourceLocation MAGIC_SHOT = MedievalMain.identifierOf("magic_shot");
    public static final ResourceLocation PARRYING = MedievalMain.identifierOf("parrying");
    public static final ResourceLocation SWORD_PARRYING = MedievalMain.identifierOf("sword_parrying");
    public static SoundEvent SWORD_PARRYING_EVENT = SoundEvent.createVariableRangeEvent(SWORD_PARRYING);
    public static SoundEvent MAGIC_HEAL_AURA_EVENT = SoundEvent.createVariableRangeEvent(MAGIC_HEAL_AURA);
    public static SoundEvent MAGIC_SHOT_EVENT = SoundEvent.createVariableRangeEvent(MAGIC_SHOT);
    public static SoundEvent PARRYING_EVENT = SoundEvent.createVariableRangeEvent(PARRYING);

    public static void init() {
        Registry.register(BuiltInRegistries.SOUND_EVENT, SoundInit.MAGIC_HEAL_AURA, MAGIC_HEAL_AURA_EVENT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, SoundInit.MAGIC_SHOT, MAGIC_SHOT_EVENT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, SoundInit.PARRYING, PARRYING_EVENT);
        Registry.register(BuiltInRegistries.SOUND_EVENT, SoundInit.SWORD_PARRYING, SWORD_PARRYING_EVENT);
    }

}
