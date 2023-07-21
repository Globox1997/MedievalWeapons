package net.medievalweapons;

import net.fabricmc.api.ModInitializer;
import net.medievalweapons.init.*;
import net.medievalweapons.network.PlayerPacket;
import net.minecraft.util.Identifier;

public class MedievalMain implements ModInitializer {

    // All credits go to Plasma Studios: https://youtu.be/Uc7YMW3AKpg?t=1152
    // Thanks for the awesome series
    // Check it out here: https://youtu.be/yCNUP2NAt-A

    public static final Identifier ID(String path) {
        return new Identifier("medievalweapons", path);
    }

    @Override
    public void onInitialize() {
        CompatInit.init();
        ConfigInit.init();
        ItemInit.init();
        EffectInit.init();
        EntityInit.init();
        ParticleInit.init();
        PlayerPacket.init();
        SoundInit.init();
        TagInit.init();
    }

}

// You are LOVED!!!
// Jesus loves you unconditionally!