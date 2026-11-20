package net.medievalweapons;

import net.fabricmc.api.ModInitializer;
import net.medievalweapons.init.*;
import net.medievalweapons.network.MedievalServerPacket;
import net.minecraft.resources.ResourceLocation;

public class MedievalMain implements ModInitializer {

    // All credits go to Plasma Studios: https://youtu.be/Uc7YMW3AKpg?t=1152
    // Thanks for the awesome series
    // Check it out here: https://youtu.be/yCNUP2NAt-A

    @Override
    public void onInitialize() {
        ConfigInit.init();
        CompatInit.init();
        ItemInit.init();
        EffectInit.init();
        EntityInit.init();
        ParticleInit.init();
        MedievalServerPacket.init();
        SoundInit.init();
        TagInit.init();
    }

    public static ResourceLocation identifierOf(String path) {
        return ResourceLocation.fromNamespaceAndPath("medievalweapons", path);
    }

}

// You are LOVED!!!
// Jesus loves you unconditionally!