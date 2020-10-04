package net.medievalweapons.entity.model;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class Big_Axe_Entity_Model extends Model {
  private final ModelPart base = new ModelPart(32, 32, 0, 0);

  public Big_Axe_Entity_Model() {
    super(RenderLayer::getEntitySolid);
    base.setPivot(4.0F, 12.0F, 0.0F);
    base.setTextureOffset(22, 18).addCuboid(-12.0F, 11.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(22, 11).addCuboid(-12.0F, 10.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(22, 9).addCuboid(-11.0F, 9.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(22, 7).addCuboid(-10.0F, 8.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(22, 22).addCuboid(-9.0F, 7.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 22).addCuboid(-8.0F, 6.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(15, 21).addCuboid(-7.0F, 5.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(7, 21).addCuboid(-6.0F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(20, 2).addCuboid(-5.0F, 3.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 20).addCuboid(-4.0F, 2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(19, 4).addCuboid(-3.0F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(15, 19).addCuboid(-2.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(7, 19).addCuboid(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(18, 14).addCuboid(0.0F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 18).addCuboid(1.0F, -3.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 0).addCuboid(2.0F, -4.0F, -0.5F, 11.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(13, 10).addCuboid(3.0F, -5.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(15, 17).addCuboid(4.0F, -6.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(7, 17).addCuboid(5.0F, -7.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 16).addCuboid(6.0F, -8.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 2).addCuboid(7.0F, -10.0F, -0.5F, 9.0F, 2.0F, 1.0F, 0.0F);
    base.setTextureOffset(11, 12).addCuboid(6.0F, -11.0F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 9).addCuboid(6.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(15, 6).addCuboid(6.0F, -13.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(22, 16).addCuboid(10.0F, -13.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(10, 14).addCuboid(13.0F, -12.0F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F);
    base.setTextureOffset(22, 20).addCuboid(14.0F, -13.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 7).addCuboid(10.0F, -8.0F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 13).addCuboid(11.0F, -7.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 11).addCuboid(9.0F, -5.0F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(0, 5).addCuboid(5.0F, -3.0F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F);
    base.setTextureOffset(13, 8).addCuboid(6.0F, -2.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
      float green, float blue, float alpha) {
    this.base.yaw = 1.5708F;
    this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }
}