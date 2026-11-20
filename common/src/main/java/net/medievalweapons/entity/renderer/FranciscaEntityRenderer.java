package net.medievalweapons.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.medievalweapons.entity.FranciscaEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;

public class FranciscaEntityRenderer extends EntityRenderer<FranciscaEntity, FranciscaEntityRenderer.FranciscaRenderState> {

    private final ItemModelResolver itemModelResolver;

    public FranciscaEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemModelResolver = context.getItemModelResolver();
    }

    @Override
    public FranciscaRenderState createRenderState() {
        return new FranciscaRenderState();
    }

    @Override
    public void extractRenderState(FranciscaEntity entity, FranciscaRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.yRot = Mth.lerp(partialTicks, entity.yRotO, entity.getYRot());
        state.xRot = Mth.lerp(partialTicks, entity.xRotO, entity.getXRot());
        state.spin = entity.inGround() ? 1.0F : entity.tickCount + partialTicks;
        this.itemModelResolver.updateForNonLiving(state.item, entity.getItem(), ItemDisplayContext.GROUND, entity);
    }

    @Override
    public void submit(FranciscaRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.rotateDegrees(Axis.YP, state.yRot - 90.0F);
        poseStack.rotateDegrees(Axis.ZP, state.xRot + 90.0F * state.spin);
        poseStack.rotateDegrees(Axis.XP, 180.0F);
        poseStack.translate(0.0D, -0.2D, 0.0D);
        state.item.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);
        poseStack.popPose();
        super.submit(state, poseStack, submitNodeCollector, camera);
    }

    public static class FranciscaRenderState extends EntityRenderState {
        public final ItemStackRenderState item = new ItemStackRenderState();
        public float yRot;
        public float xRot;
        public float spin;
    }

}
