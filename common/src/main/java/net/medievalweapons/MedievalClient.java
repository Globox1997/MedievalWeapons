package net.medievalweapons;

import net.medievalweapons.effect.StunEffect;
import net.medievalweapons.init.EffectInit;
import net.minecraft.client.Minecraft;

public class MedievalClient {

    public static void onClientTick(Minecraft client) {
        if (client.player != null && client.player.hasEffect(EffectInit.STUN_EFFECT)) {
            client.player.makeStuckInBlock(client.player.getInBlockState(), StunEffect.STUCK_MULTIPLIER);
        }
    }

}
