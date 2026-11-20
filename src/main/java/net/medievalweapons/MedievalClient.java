package net.medievalweapons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.medievalweapons.effect.StunEffect;
import net.medievalweapons.init.EffectInit;
import net.medievalweapons.init.ModelInit;
import net.medievalweapons.init.RenderInit;
import net.medievalweapons.network.MedievalClientPacket;

public class MedievalClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModelInit.init();
        RenderInit.init();
        MedievalClientPacket.init();
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if (client.player != null && client.player.hasEffect(EffectInit.STUN_EFFECT)) {
                client.player.makeStuckInBlock(client.player.getInBlockState(), StunEffect.STUCK_MULTIPLIER);
            }
        });
    }

}