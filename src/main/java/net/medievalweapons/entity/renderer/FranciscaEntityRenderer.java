package net.medievalweapons.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.entity.FranciscaEntity;
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
public class FranciscaEntityRenderer extends EntityRenderer<FranciscaEntity> {

    private final ItemRenderer itemRenderer;

    public FranciscaEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(FranciscaEntity francisca_Entity, float f, float g, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i) {
        matrixStack.pushPose();
        float age = getAge(francisca_Entity, g);

        matrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(g, francisca_Entity.yRotO, francisca_Entity.getYRot()) - 90.0F));
        matrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(g, francisca_Entity.xRotO, francisca_Entity.getXRot()) + 90.0F * age));
        matrixStack.mulPose(Axis.XP.rotationDegrees(180.0F));

        matrixStack.translate(0.0D, -0.2D, 0.0D);

        this.itemRenderer.renderStatic(francisca_Entity.getItem(), ItemDisplayContext.GROUND, i, OverlayTexture.NO_OVERLAY, matrixStack, vertexConsumerProvider, francisca_Entity.level(),
                francisca_Entity.getId());
        matrixStack.popPose();
        super.render(francisca_Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    private float getAge(FranciscaEntity francisca_Entity, float g) {
        if (!francisca_Entity.inGround()) {
            return francisca_Entity.tickCount + g;
        }
        return 1.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(FranciscaEntity francisca_Entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }

}