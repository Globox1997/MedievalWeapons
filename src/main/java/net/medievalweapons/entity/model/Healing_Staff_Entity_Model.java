package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Healing_Staff_Entity_Model extends Model {
    private final ModelPart base = new ModelPart(32, 32, 0, 0);

    public Healing_Staff_Entity_Model() {
        super(RenderLayer::getEntitySolid);
        base.setPivot(13.0F, 3.0F, 0.0F);
        base.setTextureOffset(25, 16).addCuboid(-20.0F, 20.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(24, 18).addCuboid(-21.0F, 19.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 12).addCuboid(-21.0F, 18.0F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(25, 13).addCuboid(-17.0F, 19.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(24, 8).addCuboid(-19.0F, 17.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(13, 9).addCuboid(-20.0F, 16.0F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(14, 25).addCuboid(-20.0F, 15.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(24, 6).addCuboid(-17.0F, 15.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(24, 0).addCuboid(-16.0F, 14.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(21, 24).addCuboid(-15.0F, 13.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(7, 24).addCuboid(-14.0F, 12.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(14, 23).addCuboid(-13.0F, 11.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 23).addCuboid(-12.0F, 10.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(21, 22).addCuboid(-11.0F, 9.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(7, 22).addCuboid(-10.0F, 8.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(21, 20).addCuboid(-9.0F, 7.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(21, 11).addCuboid(-8.0F, 6.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(14, 21).addCuboid(-7.0F, 5.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 21).addCuboid(-6.0F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(20, 2).addCuboid(-5.0F, 3.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(7, 20).addCuboid(-4.0F, 2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(14, 19).addCuboid(-3.0F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 19).addCuboid(-2.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(18, 15).addCuboid(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(18, 4).addCuboid(0.0F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(7, 18).addCuboid(1.0F, -3.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(17, 17).addCuboid(2.0F, -4.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(13, 13).addCuboid(3.0F, -5.0F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 27).addCuboid(6.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 17).addCuboid(4.0F, -6.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 4).addCuboid(3.0F, -7.0F, -0.5F, 8.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(26, 4).addCuboid(4.0F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 14).addCuboid(6.0F, -9.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F);
        base.setTextureOffset(23, 26).addCuboid(9.0F, -6.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 0).addCuboid(5.0F, -10.0F, -0.5F, 11.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(19, 26).addCuboid(6.0F, -11.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 10).addCuboid(9.0F, -11.0F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 25).addCuboid(11.0F, -9.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(9, 26).addCuboid(14.0F, -9.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(16, 6).addCuboid(8.0F, -13.0F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F);
        base.setTextureOffset(10, 15).addCuboid(13.0F, -13.0F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 6).addCuboid(9.0F, -14.0F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 2).addCuboid(8.0F, -15.0F, -0.5F, 9.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(5, 26).addCuboid(9.0F, -16.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(0, 8).addCuboid(11.0F, -16.0F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F);
        base.setTextureOffset(13, 11).addCuboid(14.0F, -17.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
            float green, float blue, float alpha) {
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}