package net.medievalweapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.medievalweapons.compat.CompatRender;
import net.medievalweapons.entity.renderer.Francisca_Entity_Renderer;
import net.medievalweapons.entity.renderer.Healing_Ball_Entity_Renderer;
import net.medievalweapons.entity.renderer.Javelin_Entity_Renderer;
import net.medievalweapons.init.ParticleInit.HealingAuraParticle;

@Environment(EnvType.CLIENT)
public class RenderInit {

    public static void init() {
        // Francisca
        EntityRendererRegistry.register(EntityInit.WOODEN_FRANCISCA, Francisca_Entity_Renderer::new);
        EntityRendererRegistry.register(EntityInit.STONE_FRANCISCA, Francisca_Entity_Renderer::new);
        EntityRendererRegistry.register(EntityInit.IRON_FRANCISCA, Francisca_Entity_Renderer::new);
        EntityRendererRegistry.register(EntityInit.GOLDEN_FRANCISCA, Francisca_Entity_Renderer::new);
        EntityRendererRegistry.register(EntityInit.DIAMOND_FRANCISCA, Francisca_Entity_Renderer::new);
        EntityRendererRegistry.register(EntityInit.NETHERITE_FRANCISCA, Francisca_Entity_Renderer::new);
        // Javelin
        EntityRendererRegistry.register(EntityInit.WOODEN_JAVELIN, Javelin_Entity_Renderer::new);
        EntityRendererRegistry.register(EntityInit.STONE_JAVELIN, Javelin_Entity_Renderer::new);
        EntityRendererRegistry.register(EntityInit.IRON_JAVELIN, Javelin_Entity_Renderer::new);
        EntityRendererRegistry.register(EntityInit.GOLDEN_JAVELIN, Javelin_Entity_Renderer::new);
        EntityRendererRegistry.register(EntityInit.DIAMOND_JAVELIN, Javelin_Entity_Renderer::new);
        EntityRendererRegistry.register(EntityInit.NETHERITE_JAVELIN, Javelin_Entity_Renderer::new);
        // Healing Ball
        EntityRendererRegistry.register(EntityInit.HEALING_BALL_ENTITY, Healing_Ball_Entity_Renderer::new);
        // Particle
        ParticleFactoryRegistry.getInstance().register(ParticleInit.HEALING_AURA_PARTICLE, HealingAuraParticle.Factory::new);
        // Compat
        CompatRender.loadRenderer();
    }

}