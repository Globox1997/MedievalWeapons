package net.medievalweapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.medievalweapons.compat.CompatRender;
import net.medievalweapons.entity.renderer.FranciscaEntityRenderer;
import net.medievalweapons.entity.renderer.HealingBallEntityRenderer;
import net.medievalweapons.entity.renderer.JavelinEntityRenderer;
import net.medievalweapons.init.ParticleInit.HealingAuraParticle;

@Environment(EnvType.CLIENT)
public class RenderInit {

    public static void init() {
        // Francisca
        EntityRendererRegistry.register(EntityInit.WOODEN_FRANCISCA, FranciscaEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.STONE_FRANCISCA, FranciscaEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.IRON_FRANCISCA, FranciscaEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.GOLDEN_FRANCISCA, FranciscaEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.DIAMOND_FRANCISCA, FranciscaEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.NETHERITE_FRANCISCA, FranciscaEntityRenderer::new);
        // Javelin
        EntityRendererRegistry.register(EntityInit.WOODEN_JAVELIN, JavelinEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.STONE_JAVELIN, JavelinEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.IRON_JAVELIN, JavelinEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.GOLDEN_JAVELIN, JavelinEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.DIAMOND_JAVELIN, JavelinEntityRenderer::new);
        EntityRendererRegistry.register(EntityInit.NETHERITE_JAVELIN, JavelinEntityRenderer::new);
        // Healing Ball
        EntityRendererRegistry.register(EntityInit.HEALING_BALL_ENTITY, HealingBallEntityRenderer::new);
        // Particle
        ParticleFactoryRegistry.getInstance().register(ParticleInit.HEALING_AURA_PARTICLE, HealingAuraParticle.Factory::new);
        // Compat
        CompatRender.loadRenderer();
    }

}