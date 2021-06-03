package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Mace_Entity_Model extends Model {
    private final ModelPart base = new ModelPart(32, 32, 0, 0);

    public Mace_Entity_Model() {
        super(RenderLayer::getEntitySolid);
        base.setPivot(2.0F, 14.0F, 0.0F);
        base.setTextureOffset(14, 18).addCuboid(-10.0F, 9.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(7, 17).addCuboid(-10.0F, 8.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(17, 3).addCuboid(-9.0F, 7.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(14, 16).addCuboid(-8.0F, 6.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 16).addCuboid(-7.0F, 5.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(7, 15).addCuboid(-6.0F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(15, 5).addCuboid(-5.0F, 3.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(14, 14).addCuboid(-4.0F, 2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 14).addCuboid(-3.0F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(7, 13).addCuboid(-2.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 10).addCuboid(-1.0F, -1.0F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(18, 12).addCuboid(2.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 20).addCuboid(4.0F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 12).addCuboid(0.0F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 8).addCuboid(-1.0F, -3.0F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(18, 10).addCuboid(-1.0F, -4.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(19, 19).addCuboid(-2.0F, -5.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 6).addCuboid(2.0F, -4.0F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 18).addCuboid(5.0F, -3.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(9, 19).addCuboid(7.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 4).addCuboid(3.0F, -5.0F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(2.0F, -6.0F, -0.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 2).addCuboid(2.0F, -7.0F, -0.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(5, 19).addCuboid(1.0F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(11, 7).addCuboid(4.0F, -8.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(11, 11).addCuboid(4.0F, -9.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(11, 9).addCuboid(4.0F, -10.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(19, 1).addCuboid(5.0F, -11.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
            float green, float blue, float alpha) {
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}