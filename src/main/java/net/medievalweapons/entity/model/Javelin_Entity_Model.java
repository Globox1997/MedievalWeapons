package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Javelin_Entity_Model extends Model {
  private final ModelPart base;

  public Javelin_Entity_Model(ModelPart base) {
    super(RenderLayer::getEntitySolid);
    this.base = base.getChild("base");
  }

  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    modelPartData.addChild("base", ModelPartBuilder.create().uv(18, 0).cuboid(-0.5F, 14.0F, -15.0F, 1.0F, 1.0F, 2.0F)
        .uv(15, 23).cuboid(-0.5F, 13.0F, -15.0F, 1.0F, 1.0F, 3.0F).uv(0, 23)
        .cuboid(-0.5F, 12.0F, -14.0F, 1.0F, 1.0F, 3.0F).uv(21, 0).cuboid(-0.5F, 11.0F, -13.0F, 1.0F, 1.0F, 3.0F)
        .uv(10, 21).cuboid(-0.5F, 10.0F, -12.0F, 1.0F, 1.0F, 3.0F).uv(20, 16)
        .cuboid(-0.5F, 9.0F, -11.0F, 1.0F, 1.0F, 3.0F).uv(20, 12).cuboid(-0.5F, 8.0F, -10.0F, 1.0F, 1.0F, 3.0F)
        .uv(20, 20).cuboid(-0.5F, 7.0F, -9.0F, 1.0F, 1.0F, 3.0F).uv(5, 20).cuboid(-0.5F, 6.0F, -8.0F, 1.0F, 1.0F, 3.0F)
        .uv(15, 19).cuboid(-0.5F, 5.0F, -7.0F, 1.0F, 1.0F, 3.0F).uv(0, 19).cuboid(-0.5F, 4.0F, -6.0F, 1.0F, 1.0F, 3.0F)
        .uv(18, 8).cuboid(-0.5F, 3.0F, -5.0F, 1.0F, 1.0F, 3.0F).uv(17, 4).cuboid(-0.5F, 2.0F, -4.0F, 1.0F, 1.0F, 3.0F)
        .uv(10, 17).cuboid(-0.5F, 1.0F, -3.0F, 1.0F, 1.0F, 3.0F).uv(5, 16).cuboid(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F)
        .uv(15, 15).cuboid(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F).uv(0, 15).cuboid(-0.5F, -2.0F, 0.0F, 1.0F, 1.0F, 3.0F)
        .uv(13, 9).cuboid(-0.5F, -3.0F, 1.0F, 1.0F, 1.0F, 3.0F).uv(13, 0).cuboid(-0.5F, -4.0F, 2.0F, 1.0F, 1.0F, 3.0F)
        .uv(10, 13).cuboid(-0.5F, -5.0F, 3.0F, 1.0F, 1.0F, 3.0F).uv(12, 5).cuboid(-0.5F, -6.0F, 4.0F, 1.0F, 1.0F, 3.0F)
        .uv(5, 12).cuboid(-0.5F, -7.0F, 5.0F, 1.0F, 1.0F, 3.0F).uv(7, 0).cuboid(-0.5F, -8.0F, 6.0F, 1.0F, 1.0F, 4.0F)
        .uv(6, 7).cuboid(-0.5F, -9.0F, 7.0F, 1.0F, 1.0F, 4.0F).uv(0, 0).cuboid(-0.5F, -10.0F, 7.0F, 1.0F, 1.0F, 5.0F)
        .uv(0, 6).cuboid(-0.5F, -11.0F, 8.0F, 1.0F, 1.0F, 4.0F).uv(0, 11).cuboid(-0.5F, -12.0F, 9.0F, 1.0F, 1.0F, 3.0F),
        ModelTransform.pivot(0.0F, 9.0F, 0.0F));
    return TexturedModelData.of(modelData, 32, 32);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
      float green, float blue, float alpha) {
    this.base.pitch = 0.7854F;
    this.base.yaw = -1.5708F;
    this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }
}