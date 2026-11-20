package net.medievalweapons.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.entity.JavelinEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;

@SuppressWarnings("deprecation")
@Environment(EnvType.CLIENT)
public class JavelinEntityRenderer extends EntityRenderer<JavelinEntity> {

    private final ItemRenderer itemRenderer;

    public JavelinEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(JavelinEntity javelin_Entity, float f, float g, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i) {
        matrixStack.pushPose();

        matrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(g, javelin_Entity.yRotO, javelin_Entity.getYRot()) - 90.0F));
        matrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(g, javelin_Entity.xRotO, javelin_Entity.getXRot()) + -45.0F));

        matrixStack.translate(-0.3D, -0.15D, 0.0D);
        // Use GUI type cause it isn't used for this type
        this.itemRenderer.renderStatic(javelin_Entity.getItem(), ItemDisplayContext.GUI, i, OverlayTexture.NO_OVERLAY, matrixStack, vertexConsumerProvider, javelin_Entity.level(),
                javelin_Entity.getId());
        matrixStack.popPose();
        super.render(javelin_Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public ResourceLocation getTextureLocation(JavelinEntity javelin_Entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }

}