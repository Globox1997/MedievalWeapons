package net.medievalweapons.init;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.medievalweapons.entity.renderer.Big_Axe_Entity_Renderer;
import net.medievalweapons.entity.renderer.Francisca_HT_Entity_Renderer;
import net.medievalweapons.entity.renderer.Francisca_LT_Entity_Renderer;
import net.medievalweapons.entity.renderer.Healing_Ball_Entity_Renderer;
import net.medievalweapons.entity.renderer.Healing_Staff_Entity_Renderer;
import net.medievalweapons.entity.renderer.Javelin_Entity_Renderer;
import net.medievalweapons.entity.renderer.Lance_Entity_Renderer;
import net.medievalweapons.entity.renderer.Mace_Entity_Renderer;
import net.medievalweapons.entity.renderer.Thalleous_Sword_Entity_Renderer;
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
                // Big Axe
                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                // Lance
                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_LANCE,
                                (dispatcher, context) -> new Lance_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_LANCE,
                                (dispatcher, context) -> new Lance_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_LANCE,
                                (dispatcher, context) -> new Lance_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_LANCE,
                                (dispatcher, context) -> new Lance_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_LANCE,
                                (dispatcher, context) -> new Lance_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_LANCE,
                                (dispatcher, context) -> new Lance_Entity_Renderer(dispatcher));
                // Healing Staff
                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_HEALING_STAFF,
                                (dispatcher, context) -> new Healing_Staff_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_HEALING_STAFF,
                                (dispatcher, context) -> new Healing_Staff_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_HEALING_STAFF,
                                (dispatcher, context) -> new Healing_Staff_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_HEALING_STAFF,
                                (dispatcher, context) -> new Healing_Staff_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_HEALING_STAFF,
                                (dispatcher, context) -> new Healing_Staff_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_HEALING_STAFF,
                                (dispatcher, context) -> new Healing_Staff_Entity_Renderer(dispatcher));
                // Mace
                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_MACE,
                                (dispatcher, context) -> new Mace_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_MACE,
                                (dispatcher, context) -> new Mace_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_MACE,
                                (dispatcher, context) -> new Mace_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_MACE,
                                (dispatcher, context) -> new Mace_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_MACE,
                                (dispatcher, context) -> new Mace_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_MACE,
                                (dispatcher, context) -> new Mace_Entity_Renderer(dispatcher));
                // Healing Ball
                EntityRendererRegistry.INSTANCE.register(EntityInit.HEALING_BALL_ENTITY,
                                (dispatcher, context) -> new Healing_Ball_Entity_Renderer(dispatcher));
                // Particle
                ParticleFactoryRegistry.getInstance().register(ParticleInit.HEALING_AURA_PARTICLE,
                                HealingAuraParticle.Factory::new);
                // Thalleous Sword
                EntityRendererRegistry.INSTANCE.register(EntityInit.THALLEOUS_SWORD,
                                (dispatcher, context) -> new Thalleous_Sword_Entity_Renderer(dispatcher));

        }

}