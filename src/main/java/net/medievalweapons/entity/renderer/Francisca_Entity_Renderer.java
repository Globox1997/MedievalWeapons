package net.medievalweapons.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.medievalweapons.entity.Francisca_Entity;
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

public class Francisca_Entity_Renderer extends EntityRenderer<Francisca_Entity> {

    private final ItemRenderer itemRenderer;

    public Francisca_Entity_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(Francisca_Entity francisca_Entity, float f, float g, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i) {
        matrixStack.pushPose();

        matrixStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(g, francisca_Entity.yRotO, francisca_Entity.getYRot()) - 90.0F));
        matrixStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(g, francisca_Entity.xRotO, francisca_Entity.getXRot()) + 90.0F));
        matrixStack.mulPose(Vector3f.XP.rotationDegrees(180.0F));

        matrixStack.translate(0.0D, -0.2D, 0.0D);

        this.itemRenderer.renderStatic(((ItemSupplier) francisca_Entity).getItem(), ItemTransforms.TransformType.GUI, i, OverlayTexture.NO_OVERLAY, matrixStack, vertexConsumerProvider,
                francisca_Entity.getId());
        matrixStack.popPose();
        super.render(francisca_Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public ResourceLocation getTextureLocation(Francisca_Entity francisca_Entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }

}