package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MedievalMain.MOD_ID);


    public static final RegistryObject<SoundEvent> MAGIC_HEAL_AURA = SOUNDS.register("magic_heal_aura",
            ()-> new SoundEvent(new SoundEvent()));
    public static final Identifier MAGIC_SHOT = new Identifier("medievalweapons:magic_shot");
    public static final Identifier PARRYING = new Identifier("medievalweapons:parrying");
    public static final Identifier SWORD_PARRYING = new Identifier("medievalweapons:sword_parrying");
    public static SoundEvent SWORD_PARRYING_EVENT = new SoundEvent(SWORD_PARRYING);
    public static SoundEvent MAGIC_HEAL_AURA_EVENT = new SoundEvent(MAGIC_HEAL_AURA.getId());
    public static SoundEvent MAGIC_SHOT_EVENT = new SoundEvent(MAGIC_SHOT);
    public static SoundEvent PARRYING_EVENT = new SoundEvent(PARRYING);


    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }


}
