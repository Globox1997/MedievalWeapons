package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Thalleous_Sword_Entity_Model extends Model {
    private final ModelPart base = new ModelPart(64, 64, 0, 0);

    public Thalleous_Sword_Entity_Model() {
        super(RenderLayer::getEntitySolid);
        base.setPivot(0.0F, 16.0F, 0.0F);
        base.setTextureOffset(13, 27).addCuboid(-6.0F, 7.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 26).addCuboid(-7.0F, 6.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(19, 23).addCuboid(-8.0F, 5.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(21, 5).addCuboid(-8.0F, 4.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(25, 21).addCuboid(-5.0F, 3.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(23, 25).addCuboid(-4.0F, 2.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(15, 25).addCuboid(-3.0F, 1.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 20).addCuboid(-2.0F, 0.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(13, 19).addCuboid(-1.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(7, 25).addCuboid(2.0F, 1.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(9, 23).addCuboid(2.0F, 2.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 24).addCuboid(2.0F, 3.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(27, 27).addCuboid(3.0F, 4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 14).addCuboid(-1.0F, -2.0F, 0.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 2).addCuboid(-4.0F, -3.0F, 0.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 0).addCuboid(-5.0F, -4.0F, 0.0F, 15.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 6).addCuboid(0.0F, -5.0F, 0.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(23, 27).addCuboid(-3.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(23, 3).addCuboid(-4.0F, -5.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(19, 27).addCuboid(8.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 12).addCuboid(1.0F, -6.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 10).addCuboid(2.0F, -7.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 8).addCuboid(3.0F, -8.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 4).addCuboid(2.0F, -9.0F, 0.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(7, 27).addCuboid(3.0F, -10.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 18).addCuboid(6.0F, -10.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(17, 13).addCuboid(7.0F, -11.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(17, 11).addCuboid(8.0F, -12.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(17, 9).addCuboid(10.0F, -13.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(13, 17).addCuboid(11.0F, -14.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(13, 21).addCuboid(12.0F, -15.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 16).addCuboid(12.0F, -16.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(15, 15).addCuboid(13.0F, -17.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(0, 22).addCuboid(15.0F, -18.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(21, 7).addCuboid(16.0F, -19.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        base.setTextureOffset(26, 18).addCuboid(18.0F, -20.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
            float green, float blue, float alpha) {
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}