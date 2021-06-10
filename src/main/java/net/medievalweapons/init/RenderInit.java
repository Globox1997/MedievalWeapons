package net.medievalweapons.init;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.medievalweapons.compat.CompatRender;
import net.medievalweapons.entity.model.*;
import net.medievalweapons.entity.renderer.Francisca_HT_Entity_Renderer;
import net.medievalweapons.entity.renderer.Francisca_LT_Entity_Renderer;
import net.medievalweapons.entity.renderer.Healing_Ball_Entity_Renderer;
import net.medievalweapons.entity.renderer.Javelin_Entity_Renderer;
import net.medievalweapons.init.ParticleInit.HealingAuraParticle;
import net.medievalweapons.network.EntitySpawnPacket;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class RenderInit {

        public static final EntityModelLayer BIG_AXE_LAYER = new EntityModelLayer(new Identifier("medievalweapons:big_axe_render_layer"), "big_axe_render_layer");
        public static final EntityModelLayer FRANCISCA_HT_LAYER = new EntityModelLayer(new Identifier("medievalweapons:francisca_ht_render_layer"), "francisca_ht_render_layer");
        public static final EntityModelLayer FRANCISCA_LT_LAYER = new EntityModelLayer(new Identifier("medievalweapons:francisca_lt_render_layer"), "francisca_lt_render_layer");
        public static final EntityModelLayer HEALING_STAFF_LAYER = new EntityModelLayer(new Identifier("medievalweapons:healing_staff_render_layer"), "healing_staff_render_layer");
        public static final EntityModelLayer JAVELIN_LAYER = new EntityModelLayer(new Identifier("medievalweapons:javelin_render_layer"), "javelin_render_layer");
        public static final EntityModelLayer LANCE_LAYER = new EntityModelLayer(new Identifier("medievalweapons:lance_render_layer"), "lance_render_layer");
        public static final EntityModelLayer MACE_LAYER = new EntityModelLayer(new Identifier("medievalweapons:mace_render_layer"), "mace_render_layer");
        public static final EntityModelLayer THALLEOUS_SWORD_LAYER = new EntityModelLayer(new Identifier("medievalweapons:thalleous_sword_render_layer"), "thalleous_sword_render_layer");

        public static void init() {
                // Packet
                ClientPlayNetworking.registerGlobalReceiver(EntitySpawnPacket.ID, EntitySpawnPacket::onPacket);
                // Francisca
                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_FRANCISCA_LT, Francisca_LT_Entity_Renderer::new);
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_FRANCISCA_LT, Francisca_LT_Entity_Renderer::new);
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
                // Javelin
                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_JAVELIN, Javelin_Entity_Renderer::new);
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_JAVELIN, Javelin_Entity_Renderer::new);
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_JAVELIN, Javelin_Entity_Renderer::new);
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_JAVELIN, Javelin_Entity_Renderer::new);
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_JAVELIN, Javelin_Entity_Renderer::new);
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_JAVELIN, Javelin_Entity_Renderer::new);
                // Healing Ball
                EntityRendererRegistry.INSTANCE.register(EntityInit.HEALING_BALL_ENTITY, Healing_Ball_Entity_Renderer::new);
                // Particle
                ParticleFactoryRegistry.getInstance().register(ParticleInit.HEALING_AURA_PARTICLE,
                                HealingAuraParticle.Factory::new);
                // Compat
                CompatRender.loadRenderer();

                EntityModelLayerRegistry.registerModelLayer(BIG_AXE_LAYER, Big_Axe_Entity_Model::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(FRANCISCA_HT_LAYER, Francisca_HT_Entity_Model::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(FRANCISCA_LT_LAYER, Francisca_LT_Entity_Model::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(HEALING_STAFF_LAYER, Healing_Staff_Entity_Model::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(JAVELIN_LAYER, Javelin_Entity_Model::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(LANCE_LAYER, Lance_Entity_Model::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(MACE_LAYER, Mace_Entity_Model::getTexturedModelData);
                EntityModelLayerRegistry.registerModelLayer(THALLEOUS_SWORD_LAYER, Thalleous_Sword_Entity_Model::getTexturedModelData);

        }

}