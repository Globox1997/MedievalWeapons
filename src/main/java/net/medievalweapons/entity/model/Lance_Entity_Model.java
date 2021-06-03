package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Lance_Entity_Model extends Model {
    private final ModelPart base = new ModelPart(32, 32, 0, 0);

    public Lance_Entity_Model() {
        super(RenderLayer::getEntitySolid);

        base.setPivot(12.0F, 4.0F, 0.5F);
        base.setTextureOffset(21, 18).addCuboid(-20.0F, 19.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(21, 14).addCuboid(-20.0F, 18.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(21, 1).addCuboid(-19.0F, 17.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(14, 21).addCuboid(-18.0F, 16.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 21).addCuboid(-17.0F, 15.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(7, 20).addCuboid(-16.0F, 14.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(19, 3).addCuboid(-15.0F, 13.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(14, 19).addCuboid(-14.0F, 12.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 19).addCuboid(-13.0F, 11.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(18, 9).addCuboid(-12.0F, 10.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(18, 7).addCuboid(-11.0F, 9.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(18, 5).addCuboid(-10.0F, 8.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(7, 18).addCuboid(-9.0F, 7.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(14, 17).addCuboid(-8.0F, 6.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 17).addCuboid(-7.0F, 5.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(16, 11).addCuboid(-6.0F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(7, 16).addCuboid(-5.0F, 3.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(14, 15).addCuboid(-4.0F, 2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 15).addCuboid(-3.0F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(14, 13).addCuboid(-2.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(14, 0).addCuboid(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(7, 14).addCuboid(0.0F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 13).addCuboid(1.0F, -3.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(12, 2).addCuboid(2.0F, -4.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(7, 12).addCuboid(3.0F, -5.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(11, 6).addCuboid(4.0F, -6.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(11, 4).addCuboid(5.0F, -7.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(9, 8).addCuboid(6.0F, -8.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 2).addCuboid(7.0F, -10.0F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 5).addCuboid(8.0F, -11.0F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 0).addCuboid(8.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 9).addCuboid(10.0F, -13.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 7).addCuboid(11.0F, -14.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 11).addCuboid(13.0F, -15.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(9, 10).addCuboid(14.0F, -16.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(21, 16).addCuboid(15.0F, -17.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
            float green, float blue, float alpha) {
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}