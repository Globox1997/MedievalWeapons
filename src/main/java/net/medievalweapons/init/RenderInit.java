package net.medievalweapons.init;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.medievalweapons.entity.renderer.Francisca_HT_Entity_Renderer;
import net.medievalweapons.entity.renderer.Francisca_LT_Entity_Renderer;
import net.medievalweapons.entity.renderer.Healing_Ball_Entity_Renderer;
import net.medievalweapons.entity.renderer.Javelin_Entity_Renderer;
import net.medievalweapons.init.ParticleInit.HealingAuraParticle;
import net.medievalweapons.network.EntitySpawnPacket;

public class RenderInit {

        public static void init() {
                // Packet
                ClientPlayNetworking.registerGlobalReceiver(EntitySpawnPacket.ID, EntitySpawnPacket::onPacket);
                // Francisca
                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_FRANCISCA_LT,
                                (dispatcher, context) -> new Francisca_LT_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_FRANCISCA_LT,
                                (dispatcher, context) -> new Francisca_LT_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_FRANCISCA_HT,
                                (dispatcher, context) -> new Francisca_HT_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_FRANCISCA_HT,
                                (dispatcher, context) -> new Francisca_HT_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_FRANCISCA_HT,
                                (dispatcher, context) -> new Francisca_HT_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_FRANCISCA_HT,
                                (dispatcher, context) -> new Francisca_HT_Entity_Renderer(dispatcher));
                // Javelin
                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                // Healing Ball
                EntityRendererRegistry.INSTANCE.register(EntityInit.HEALING_BALL_ENTITY,
                                (dispatcher, context) -> new Healing_Ball_Entity_Renderer(dispatcher));
                // Particle
                ParticleFactoryRegistry.getInstance().register(ParticleInit.HEALING_AURA_PARTICLE,
                                HealingAuraParticle.Factory::new);

        }

}