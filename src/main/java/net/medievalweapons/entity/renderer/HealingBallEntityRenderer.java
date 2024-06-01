package net.medievalweapons.entity.renderer;

import org.joml.Matrix4f;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.entity.HealingBallEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class HealingBallEntityRenderer extends EntityRenderer<HealingBallEntity> {
    private static final Identifier TEXTURE = new Identifier("medievalweapons:textures/entity/healing_ball.png");
    private static final RenderLayer LAYER;

    public HealingBallEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    protected int getBlockLight(HealingBallEntity healing_Ball_Entity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public void render(HealingBallEntity healing_Ball_Entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.scale(0.4F, 0.4F, 0.4F);
        matrixStack.multiply(this.dispatcher.getRotation());
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
        MatrixStack.Entry entry = matrixStack.peek();
        Matrix4f matrix4f = entry.getPositionMatrix();
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(LAYER);
        produceVertex(vertexConsumer, matrix4f, entry, i, 0.0F, 0, 0, 1);
        produceVertex(vertexConsumer, matrix4f, entry, i, 1.0F, 0, 1, 1);
        produceVertex(vertexConsumer, matrix4f, entry, i, 1.0F, 1, 1, 0);
        produceVertex(vertexConsumer, matrix4f, entry, i, 0.0F, 1, 0, 0);
        matrixStack.pop();
        super.render(healing_Ball_Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    private static void produceVertex(VertexConsumer vertexConsumer, Matrix4f modelMatrix, MatrixStack.Entry entry, int light, float x, int y, int textureU, int textureV) {
        vertexConsumer.vertex(modelMatrix, x - 0.5F, (float) y - 0.25F, 0.0F).color(255, 255, 255, 255).texture((float) textureU, (float) textureV).overlay(OverlayTexture.DEFAULT_UV).light(light)
                .normal(entry, 0.0F, 1.0F, 0.0F).next();
    }

    @Override
    public Identifier getTexture(HealingBallEntity healing_Ball_Entity) {
        return TEXTURE;
    }

    static {
        LAYER = RenderLayer.getEntityCutoutNoCull(TEXTURE);
    }
}
