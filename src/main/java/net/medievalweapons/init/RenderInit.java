package net.medievalweapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.medievalweapons.compat.CompatRender;
import net.medievalweapons.entity.renderer.FranciscaEntityRenderer;
import net.medievalweapons.entity.renderer.JavelinEntityRenderer;
import net.medievalweapons.init.ParticleInit.HealingAuraParticle;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class RenderInit {

    public static void init() {
        for (Map.Entry<Identifier, EntityType> entry : EntityInit.ENTITY_TYPES.entrySet()) {
            if (entry.getKey().getPath().contains("javelin")) {
                EntityRendererRegistry.register(entry.getValue(), JavelinEntityRenderer::new);
            } else if (entry.getKey().getPath().contains("francisca")) {
                EntityRendererRegistry.register(entry.getValue(), FranciscaEntityRenderer::new);
            }
        }
        // Particle
        ParticleFactoryRegistry.getInstance().register(ParticleInit.HEALING_AURA_PARTICLE, HealingAuraParticle.Factory::new);
        // Compat
        CompatRender.loadRenderer();
    }

}