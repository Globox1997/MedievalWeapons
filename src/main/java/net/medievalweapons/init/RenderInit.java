package net.medievalweapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.entity.renderer.FranciscaEntityRenderer;
import net.medievalweapons.entity.renderer.JavelinEntityRenderer;
import net.medievalweapons.init.ParticleInit.HealingAuraParticle;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class RenderInit {

    public static final Map<DyeColor, RenderType> CUSTOM_GLINT = customGlints();

    public static void init() {
        for (Map.Entry<ResourceLocation, EntityType> entry : EntityInit.ENTITY_TYPES.entrySet()) {
            if (entry.getKey().getPath().contains("javelin")) {
                EntityRendererRegistry.register(entry.getValue(), JavelinEntityRenderer::new);
            } else if (entry.getKey().getPath().contains("francisca")) {
                EntityRendererRegistry.register(entry.getValue(), FranciscaEntityRenderer::new);
            }
        }
        // Particle
        ParticleFactoryRegistry.getInstance().register(ParticleInit.HEALING_AURA_PARTICLE, HealingAuraParticle.Factory::new);
    }

    private static Map<DyeColor, RenderType> customGlints() {
        Map<DyeColor, RenderType> map = new HashMap<>();

        for (DyeColor color : List.of(DyeColor.BLUE, DyeColor.RED, DyeColor.YELLOW)) {
            final ResourceLocation glintId = MedievalMain.identifierOf("textures/glint/" + color.getName() + "_item_glint.png");
            map.put(color, RenderType.create(color.getName() + "_glint", DefaultVertexFormat.POSITION_TEX,
                    VertexFormat.Mode.QUADS, 256, RenderType.CompositeState.builder().setShaderState(RenderStateShard.RENDERTYPE_GLINT_SHADER)
                            .setTextureState(new RenderStateShard.TextureStateShard(glintId, true, false))
                            .setWriteMaskState(RenderStateShard.COLOR_WRITE).setCullState(RenderStateShard.NO_CULL).setDepthTestState(RenderStateShard.EQUAL_DEPTH_TEST)
                            .setTransparencyState(RenderStateShard.GLINT_TRANSPARENCY).setTexturingState(RenderStateShard.GLINT_TEXTURING).createCompositeState(false)));
        }

        return map;
    }

}