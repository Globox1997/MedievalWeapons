package net.medievalweapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatRender;
import net.medievalweapons.entity.renderer.FranciscaEntityRenderer;
import net.medievalweapons.entity.renderer.JavelinEntityRenderer;
import net.medievalweapons.init.ParticleInit.HealingAuraParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.entity.EntityType;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class RenderInit {

    public static final Map<DyeColor, RenderLayer> CUSTOM_GLINT = customGlints();

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

    private static Map<DyeColor, RenderLayer> customGlints() {
        Map<DyeColor, RenderLayer> map = new HashMap<>();

        for (DyeColor color : DyeColor.values()) {
            final Identifier glintId = MedievalMain.identifierOf("textures/glint/" + color.getName() + "_item_glint.png");
            map.put(color, RenderLayer.of(color.getName() + "_glint", VertexFormats.POSITION_TEXTURE,
                    VertexFormat.DrawMode.QUADS, 256, RenderLayer.MultiPhaseParameters.builder().program(RenderPhase.GLINT_PROGRAM)
                            .texture(new RenderPhase.Texture(glintId, true, false))
                            .writeMaskState(RenderPhase.COLOR_MASK).cull(RenderPhase.DISABLE_CULLING).depthTest(RenderPhase.EQUAL_DEPTH_TEST)
                            .transparency(RenderPhase.GLINT_TRANSPARENCY).texturing(RenderPhase.GLINT_TEXTURING).build(false)));
        }

        return map;
    }

}