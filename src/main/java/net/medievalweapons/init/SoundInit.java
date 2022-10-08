package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MedievalMain.MOD_ID);


    public static final ResourceLocation MAGIC_HEAL_AURA = new ResourceLocation("medievalweapons:magic_heal_aura");
    public static final ResourceLocation MAGIC_SHOT = new ResourceLocation("medievalweapons:magic_shot");
    public static final ResourceLocation PARRYING = new ResourceLocation("medievalweapons:parrying");
    public static final ResourceLocation SWORD_PARRYING = new ResourceLocation("medievalweapons:sword_parrying");

    public static SoundEvent SWORD_PARRYING_EVENT = new SoundEvent(SWORD_PARRYING);
    public static SoundEvent MAGIC_HEAL_AURA_EVENT = new SoundEvent(MAGIC_HEAL_AURA);
    public static SoundEvent MAGIC_SHOT_EVENT = new SoundEvent(MAGIC_SHOT);
    public static SoundEvent PARRYING_EVENT = new SoundEvent(PARRYING);


    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }


}
