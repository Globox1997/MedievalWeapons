package net.medievalweapons.init;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoundInit {

    public static final Identifier MAGIC_HEAL_AURA = new Identifier("medievalweapons:magic_heal_aura");
    public static final Identifier MAGIC_SHOT = new Identifier("medievalweapons:magic_shot");
    public static SoundEvent MAGIC_HEAL_AURA_EVENT = new SoundEvent(MAGIC_HEAL_AURA);
    public static SoundEvent MAGIC_SHOT_EVENT = new SoundEvent(MAGIC_SHOT);

    public static void init() {
        Registry.register(Registry.SOUND_EVENT, SoundInit.MAGIC_HEAL_AURA, MAGIC_HEAL_AURA_EVENT);
        Registry.register(Registry.SOUND_EVENT, SoundInit.MAGIC_SHOT, MAGIC_SHOT_EVENT);
    }

}
