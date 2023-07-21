package net.medievalweapons.init;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundInit {

    public static final Identifier MAGIC_HEAL_AURA = new Identifier("medievalweapons:magic_heal_aura");
    public static final Identifier MAGIC_SHOT = new Identifier("medievalweapons:magic_shot");
    public static final Identifier PARRYING = new Identifier("medievalweapons:parrying");
    public static final Identifier SWORD_PARRYING = new Identifier("medievalweapons:sword_parrying");
    public static SoundEvent SWORD_PARRYING_EVENT = SoundEvent.of(SWORD_PARRYING);
    public static SoundEvent MAGIC_HEAL_AURA_EVENT = SoundEvent.of(MAGIC_HEAL_AURA);
    public static SoundEvent MAGIC_SHOT_EVENT = SoundEvent.of(MAGIC_SHOT);
    public static SoundEvent PARRYING_EVENT = SoundEvent.of(PARRYING);

    public static void init() {
        Registry.register(Registries.SOUND_EVENT, SoundInit.MAGIC_HEAL_AURA, MAGIC_HEAL_AURA_EVENT);
        Registry.register(Registries.SOUND_EVENT, SoundInit.MAGIC_SHOT, MAGIC_SHOT_EVENT);
        Registry.register(Registries.SOUND_EVENT, SoundInit.PARRYING, PARRYING_EVENT);
        Registry.register(Registries.SOUND_EVENT, SoundInit.SWORD_PARRYING, SWORD_PARRYING_EVENT);
    }

}
