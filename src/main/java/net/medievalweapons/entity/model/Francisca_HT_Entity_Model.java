package net.medievalweapons.entity.model;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class Francisca_HT_Entity_Model extends Model {
  private final ModelPart base = new ModelPart(32, 32, 0, 0);

  public Francisca_HT_Entity_Model() {
    super(RenderLayer::getEntitySolid);
    base.setPivot(0.5F, 16.0F, 1.0F);
    base.setTextureOffset(16, 0).addCuboid(0.0F, -1.0F, 4.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(0, 9).addCuboid(0.0F, 7.0F, -8.0F, 1.0F, 1.0F, 2.0F, 0.0F);
    base.setTextureOffset(0, 21).addCuboid(0.0F, 6.0F, -8.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(10, 20).addCuboid(0.0F, 5.0F, -7.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(19, 19).addCuboid(0.0F, 4.0F, -6.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(18, 14).addCuboid(0.0F, 3.0F, -5.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(5, 18).addCuboid(0.0F, 2.0F, -4.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(0, 17).addCuboid(0.0F, 1.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(16, 10).addCuboid(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(16, 6).addCuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(0, 9).addCuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 7.0F, 0.0F);
    base.setTextureOffset(9, 0).addCuboid(0.0F, -3.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F);
    base.setTextureOffset(0, 0).addCuboid(0.0F, -5.0F, -2.0F, 1.0F, 2.0F, 7.0F, 0.0F);
    base.setTextureOffset(9, 9).addCuboid(0.0F, -6.0F, -1.0F, 1.0F, 1.0F, 5.0F, 0.0F);
    base.setTextureOffset(12, 15).addCuboid(0.0F, -7.0F, -1.0F, 1.0F, 1.0F, 4.0F, 0.0F);
    base.setTextureOffset(0, 3).addCuboid(0.0F, -8.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F);
    base.setTextureOffset(0, 0).addCuboid(0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 2.0F, 0.0F);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
      float green, float blue, float alpha) {
    this.base.yaw = 1.5708F;
    this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }
}