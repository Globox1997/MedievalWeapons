package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.effect.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class EffectInit {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create( ForgeRegistries.MOB_EFFECTS, MedievalMain.MOD_ID);

    public static final RegistryObject<MobEffect> STUN_EFFECT = MOB_EFFECTS.register("stunned",
            () -> new StunEffect(MobEffectCategory.HARMFUL, 12221440));

    public static final RegistryObject<MobEffect> BLEED_EFFECT = MOB_EFFECTS.register("bleed",
            () -> new BleedEffect( MobEffectCategory.HARMFUL, 10303293));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }


}
