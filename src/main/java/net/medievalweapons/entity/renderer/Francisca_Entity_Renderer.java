package net.medievalweapons.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.entity.Francisca_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

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

        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, francisca_Entity.prevYaw, francisca_Entity.getYaw()) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, francisca_Entity.prevPitch, francisca_Entity.getPitch()) + 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180.0F));

        matrixStack.translate(0.0D, -0.2D, 0.0D);

        this.itemRenderer.renderItem(((FlyingItemEntity) francisca_Entity).getStack(), ModelTransformation.Mode.GUI, i, OverlayTexture.DEFAULT_UV, matrixStack, vertexConsumerProvider,
                ((Francisca_Entity) francisca_Entity).getId());
        matrixStack.pop();
        super.render(francisca_Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(Francisca_Entity francisca_Entity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }

}