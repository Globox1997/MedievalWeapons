package net.medievalweapons.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.medievalweapons.MedievalClient;
import net.medievalweapons.init.ModelInit;
import net.medievalweapons.init.ParticleInit;
import net.medievalweapons.init.RenderInit;
import net.medievalweapons.network.MedievalClientPacket;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperties;

@Environment(EnvType.CLIENT)
public class MedievalWeaponsFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModelInit.register((id, codec) -> ConditionalItemModelProperties.ID_MAPPER.put(id, codec));
        RenderInit.registerEntityRenderers(EntityRendererRegistry::register);
        ParticleProviderRegistry.getInstance().register(ParticleInit.HEALING_AURA_PARTICLE, ParticleInit.HealingAuraParticle.Factory::new);
        MedievalClientPacket.init();
        ClientTickEvents.START_CLIENT_TICK.register(MedievalClient::onClientTick);
    }

}
