package net.medievalweapons.entity.model;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class Javelin_Entity_Model extends Model {
  private final ModelPart base = new ModelPart(32, 32, 0, 0);

  public Javelin_Entity_Model() {
    super(RenderLayer::getEntitySolid);
    base.setPivot(0.0F, 9.0F, 0.0F);
    base.setTextureOffset(18, 0).addCuboid(-0.5F, 14.0F, -15.0F, 1.0F, 1.0F, 2.0F, 0.0F);
    base.setTextureOffset(15, 23).addCuboid(-0.5F, 13.0F, -15.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(0, 23).addCuboid(-0.5F, 12.0F, -14.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(21, 0).addCuboid(-0.5F, 11.0F, -13.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(10, 21).addCuboid(-0.5F, 10.0F, -12.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(20, 16).addCuboid(-0.5F, 9.0F, -11.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(20, 12).addCuboid(-0.5F, 8.0F, -10.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(20, 20).addCuboid(-0.5F, 7.0F, -9.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(5, 20).addCuboid(-0.5F, 6.0F, -8.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(15, 19).addCuboid(-0.5F, 5.0F, -7.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(0, 19).addCuboid(-0.5F, 4.0F, -6.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(18, 8).addCuboid(-0.5F, 3.0F, -5.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(17, 4).addCuboid(-0.5F, 2.0F, -4.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(10, 17).addCuboid(-0.5F, 1.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(5, 16).addCuboid(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(15, 15).addCuboid(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(0, 15).addCuboid(-0.5F, -2.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(13, 9).addCuboid(-0.5F, -3.0F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(13, 0).addCuboid(-0.5F, -4.0F, 2.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(10, 13).addCuboid(-0.5F, -5.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(12, 5).addCuboid(-0.5F, -6.0F, 4.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(5, 12).addCuboid(-0.5F, -7.0F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F);
    base.setTextureOffset(7, 0).addCuboid(-0.5F, -8.0F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F);
    base.setTextureOffset(6, 7).addCuboid(-0.5F, -9.0F, 7.0F, 1.0F, 1.0F, 4.0F, 0.0F);
    base.setTextureOffset(0, 0).addCuboid(-0.5F, -10.0F, 7.0F, 1.0F, 1.0F, 5.0F, 0.0F);
    base.setTextureOffset(0, 6).addCuboid(-0.5F, -11.0F, 8.0F, 1.0F, 1.0F, 4.0F, 0.0F);
    base.setTextureOffset(0, 11).addCuboid(-0.5F, -12.0F, 9.0F, 1.0F, 1.0F, 3.0F, 0.0F);

  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
      float green, float blue, float alpha) {
    this.base.pitch = 0.7854F;
    this.base.yaw = -1.5708F;
    this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }
}