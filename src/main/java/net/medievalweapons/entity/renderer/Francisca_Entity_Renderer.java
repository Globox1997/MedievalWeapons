package net.medievalweapons.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.entity.Francisca_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@SuppressWarnings("deprecation")
@Environment(EnvType.CLIENT)
public class Francisca_Entity_Renderer extends EntityRenderer<Francisca_Entity> {

    private final ItemRenderer itemRenderer;

    public Francisca_Entity_Renderer(EntityRendererFactory.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(Francisca_Entity francisca_Entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        float age = getAge(francisca_Entity, g);

        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, francisca_Entity.prevYaw, francisca_Entity.getYaw()) - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, francisca_Entity.prevPitch, francisca_Entity.getPitch()) + 90.0F * age));
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0F));

        matrixStack.translate(0.0D, -0.2D, 0.0D);

        this.itemRenderer.renderItem(francisca_Entity.getStack(), ModelTransformationMode.GROUND, i, OverlayTexture.DEFAULT_UV, matrixStack, vertexConsumerProvider, francisca_Entity.getWorld(),
                francisca_Entity.getId());
        matrixStack.pop();
        super.render(francisca_Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    private float getAge(Francisca_Entity francisca_Entity, float g) {
        if (!francisca_Entity.inGround()) {
            return francisca_Entity.age;
        }
        return 1.0f;
    }

    @Override
    public Identifier getTexture(Francisca_Entity francisca_Entity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }

}