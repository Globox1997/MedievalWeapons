package net.medievalweapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.entity.FranciscaEntity;
import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.entity.renderer.FranciscaEntityRenderer;
import net.medievalweapons.entity.renderer.JavelinEntityRenderer;
import net.medievalweapons.init.ParticleInit.HealingAuraParticle;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.TextureTransform;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class RenderInit {

    public static final Map<DyeColor, RenderType> CUSTOM_GLINT = new HashMap<>();
    public static final Map<DyeColor, RenderType> CUSTOM_TRANSLUCENT_GLINT = new HashMap<>();
    private static final Map<Identifier, DyeColor> GLINT_SPRITES = new HashMap<>();

    static {
        for (DyeColor color : List.of(DyeColor.BLUE, DyeColor.RED, DyeColor.YELLOW)) {
            Identifier glintId = MedievalMain.identifierOf("textures/glint/" + color.getName() + "_item_glint.png");
            CUSTOM_GLINT.put(color, RenderType.create(color.getName() + "_item_cutout_glint",
                    RenderSetup.builder(RenderPipelines.ITEM_CUTOUT_GLINT).withTexture("Sampler0", TextureAtlas.LOCATION_ITEMS).withTexture("GlintSampler", glintId)
                            .setTextureTransform(TextureTransform.GLINT_TEXTURING).useLightmap().useOverlay().affectsCrumbling().setOutline(RenderSetup.OutlineProperty.AFFECTS_OUTLINE)
                            .createRenderSetup()));
            CUSTOM_TRANSLUCENT_GLINT.put(color, RenderType.create(color.getName() + "_item_translucent_glint",
                    RenderSetup.builder(RenderPipelines.ITEM_TRANSLUCENT_GLINT).setOitPipelines(RenderPipelines.OIT_ITEM_GLINT).withTexture("Sampler0", TextureAtlas.LOCATION_ITEMS)
                            .withTexture("GlintSampler", glintId).setTextureTransform(TextureTransform.GLINT_TEXTURING).useLightmap().useOverlay().affectsCrumbling().sortOnUpload()
                            .setOutline(RenderSetup.OutlineProperty.AFFECTS_OUTLINE).createRenderSetup()));
        }
        for (String path : List.of("item/thalleous_sword", "item/extra/thalleous_sword")) {
            GLINT_SPRITES.put(MedievalMain.identifierOf(path), DyeColor.BLUE);
        }
        for (String path : List.of("item/deathsinger_sword", "item/extra/deathsinger_sword")) {
            GLINT_SPRITES.put(MedievalMain.identifierOf(path), DyeColor.RED);
        }
        for (String path : List.of("item/tidesinger_staff", "item/extra/tidesinger_staff")) {
            GLINT_SPRITES.put(MedievalMain.identifierOf(path), DyeColor.YELLOW);
        }
    }

    @SuppressWarnings("unchecked")
    public static void init() {
        for (Map.Entry<Identifier, EntityType> entry : EntityInit.ENTITY_TYPES.entrySet()) {
            if (entry.getKey().getPath().contains("javelin")) {
                EntityRendererRegistry.register((EntityType<JavelinEntity>) entry.getValue(), JavelinEntityRenderer::new);
            } else if (entry.getKey().getPath().contains("francisca")) {
                EntityRendererRegistry.register((EntityType<FranciscaEntity>) entry.getValue(), FranciscaEntityRenderer::new);
            }
        }
        ParticleProviderRegistry.getInstance().register(ParticleInit.HEALING_AURA_PARTICLE, HealingAuraParticle.Factory::new);
    }

    public static @Nullable RenderType getCustomGlint(Identifier sprite, boolean translucent) {
        DyeColor color = GLINT_SPRITES.get(sprite);
        if (color == null) {
            return null;
        }
        return translucent ? CUSTOM_TRANSLUCENT_GLINT.get(color) : CUSTOM_GLINT.get(color);
    }

}
