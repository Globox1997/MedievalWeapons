package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class SoundInit {

    public static final Identifier MAGIC_HEAL_AURA = MedievalMain.identifierOf("magic_heal_aura");
    public static final Identifier MAGIC_SHOT = MedievalMain.identifierOf("magic_shot");
    public static final Identifier PARRYING = MedievalMain.identifierOf("parrying");
    public static final Identifier SWORD_PARRYING = MedievalMain.identifierOf("sword_parrying");
    public static final Holder<SoundEvent> SWORD_PARRYING_EVENT = register(SWORD_PARRYING);
    public static final Holder<SoundEvent> MAGIC_HEAL_AURA_EVENT = register(MAGIC_HEAL_AURA);
    public static final Holder<SoundEvent> MAGIC_SHOT_EVENT = register(MAGIC_SHOT);
    public static final Holder<SoundEvent> PARRYING_EVENT = register(PARRYING);

    public static void init() {
    }

    private static Holder<SoundEvent> register(Identifier id) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

}
