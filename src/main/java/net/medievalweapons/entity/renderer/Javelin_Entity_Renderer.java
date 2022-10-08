package net.medievalweapons.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.medievalweapons.entity.Javelin_Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.ItemSupplier;

public class Javelin_Entity_Renderer extends EntityRenderer<Javelin_Entity> {

    private final ItemRenderer itemRenderer;

    public Javelin_Entity_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(Javelin_Entity javelin_Entity, float f, float g, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i) {
        matrixStack.pushPose();

        matrixStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(g, javelin_Entity.yRotO, javelin_Entity.getYRot()) - 90.0F));
        matrixStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(g, javelin_Entity.xRotO, javelin_Entity.getXRot()) + -45.0F));

        matrixStack.translate(-0.3D, -0.15D, 0.0D);
        // Use GUI type because it isn't used for this type
        this.itemRenderer.renderStatic(((ItemSupplier) javelin_Entity).getItem(), ItemTransforms.TransformType.GUI, i, OverlayTexture.NO_OVERLAY, matrixStack, vertexConsumerProvider,
                ((Javelin_Entity) javelin_Entity).getId());
        matrixStack.popPose();
        super.render(javelin_Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public ResourceLocation getTextureLocation(Javelin_Entity javelin_Entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }

}