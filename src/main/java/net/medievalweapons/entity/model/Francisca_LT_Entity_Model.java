package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Francisca_LT_Entity_Model extends Model {
  private final ModelPart base;

  public Francisca_LT_Entity_Model(ModelPart base) {
    super(RenderLayer::getEntitySolid);
    this.base = base.getChild("base");
  }

  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    modelPartData.addChild("base", ModelPartBuilder.create().uv(0, 16).cuboid(-6.0F, 7.0F, -0.5F, 2.0F, 1.0F, 1.0F)
        .uv(14, 14).cuboid(-6.0F, 6.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 14).cuboid(-5.0F, 5.0F, -0.5F, 3.0F, 1.0F, 1.0F)
        .uv(13, 5).cuboid(-4.0F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 13).cuboid(-3.0F, 3.0F, -0.5F, 3.0F, 1.0F, 1.0F)
        .uv(0, 12).cuboid(-2.0F, 2.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 11).cuboid(-1.0F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F)
        .uv(0, 10).cuboid(0.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(9, 7).cuboid(1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F)
        .uv(9, 9).cuboid(2.0F, -2.0F, -0.5F, 4.0F, 1.0F, 1.0F).uv(0, 8).cuboid(2.0F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F)
        .uv(0, 0).cuboid(-2.0F, -4.0F, -0.5F, 9.0F, 1.0F, 1.0F).uv(7, 15).cuboid(-2.0F, -3.0F, -0.5F, 2.0F, 1.0F, 1.0F)
        .uv(0, 2).cuboid(-2.0F, -5.0F, -0.5F, 8.0F, 1.0F, 1.0F).uv(0, 4).cuboid(-1.0F, -6.0F, -0.5F, 6.0F, 1.0F, 1.0F)
        .uv(0, 6).cuboid(0.0F, -7.0F, -0.5F, 4.0F, 1.0F, 1.0F).uv(14, 12).cuboid(1.0F, -8.0F, -0.5F, 2.0F, 1.0F, 1.0F),
        ModelTransform.pivot(0.0F, 16.0F, 0.0F));
    return TexturedModelData.of(modelData, 32, 32);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
      float green, float blue, float alpha) {
    this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }
}