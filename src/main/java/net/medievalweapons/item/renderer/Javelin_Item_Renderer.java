package net.medievalweapons.item.renderer;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.medievalweapons.entity.model.Javelin_Entity_Model;
import net.medievalweapons.entity.renderer.Javelin_Entity_Renderer;
import net.medievalweapons.item.Javelin_Item;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public enum Javelin_Item_Renderer {
  INSTANCE;

  private final Javelin_Entity_Model javelinEntityModel = new Javelin_Entity_Model(
      Javelin_Entity_Model.getTexturedModelData().createModel());

  public boolean render(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded,
      MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model) {
    if (renderMode == ModelTransformation.Mode.GUI || renderMode == ModelTransformation.Mode.GROUND
        || renderMode == ModelTransformation.Mode.FIXED) {
      return false;
    }

    matrices.push();

    model.getTransformation().getTransformation(renderMode).apply(leftHanded, matrices);

    if (entity != null && entity.isUsingItem() && entity.getActiveItem() == stack
        && (renderMode == ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND
            || renderMode == ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND)) {
      matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(120F));
      matrices.translate(0.0D, 0.7D, 0.0D);
    } else if (renderMode != ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND
        && renderMode != ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND) {
      matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(-60F));
      matrices.translate(0.0D, 0.85D, 0.0D);
    } else {
      matrices.translate(0.0D, 0.85D, 0.0D);
    }

    matrices.scale(1.0F, -1.0F, -1.0F);
    VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumers, this.javelinEntityModel.getLayer(
        Javelin_Entity_Renderer.getTexture(((Javelin_Item) stack.getItem()).getType())), false, stack.hasGlint());
    this.javelinEntityModel.render(matrices, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
    matrices.pop();
    return true;
  }
}