package net.medievalweapons.entity.model;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class Francisca_LT_Entity_Model extends Model {
  private final ModelPart base = new ModelPart(32, 32, 0, 0);

  public Francisca_LT_Entity_Model() {
    super(RenderLayer::getEntitySolid);
    base.setPivot(0.0F, 16.0F, 0.0F);
    base.setTextureOffset(0, 16).addCuboid(-6.0F, 7.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(14, 14).addCuboid(-6.0F, 6.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 14).addCuboid(-5.0F, 5.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(13, 5).addCuboid(-4.0F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(7, 13).addCuboid(-3.0F, 3.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 12).addCuboid(-2.0F, 2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(7, 11).addCuboid(-1.0F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 10).addCuboid(0.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(9, 7).addCuboid(1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(9, 9).addCuboid(2.0F, -2.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 8).addCuboid(2.0F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 0).addCuboid(-2.0F, -4.0F, -0.5F, 9.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(7, 15).addCuboid(-2.0F, -3.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 2).addCuboid(-2.0F, -5.0F, -0.5F, 8.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 4).addCuboid(-1.0F, -6.0F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 6).addCuboid(0.0F, -7.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(14, 12).addCuboid(1.0F, -8.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);

  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
      float green, float blue, float alpha) {
    this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }
}