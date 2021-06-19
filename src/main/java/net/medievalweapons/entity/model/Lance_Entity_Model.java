package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Lance_Entity_Model extends Model {
    private final ModelPart base;

    public Lance_Entity_Model(ModelPart base) {
        super(RenderLayer::getEntitySolid);
        this.base = base.getChild("base");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("base",
                ModelPartBuilder.create().uv(21, 18).cuboid(-20.0F, 19.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(21, 14).cuboid(-20.0F, 18.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(21, 1)
                        .cuboid(-19.0F, 17.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 21).cuboid(-18.0F, 16.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 21).cuboid(-17.0F, 15.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 20)
                        .cuboid(-16.0F, 14.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(19, 3).cuboid(-15.0F, 13.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 19).cuboid(-14.0F, 12.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 19)
                        .cuboid(-13.0F, 11.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(18, 9).cuboid(-12.0F, 10.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(18, 7).cuboid(-11.0F, 9.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(18, 5)
                        .cuboid(-10.0F, 8.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 18).cuboid(-9.0F, 7.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 17).cuboid(-8.0F, 6.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 17)
                        .cuboid(-7.0F, 5.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(16, 11).cuboid(-6.0F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 16).cuboid(-5.0F, 3.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 15)
                        .cuboid(-4.0F, 2.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 15).cuboid(-3.0F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 13).cuboid(-2.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 0)
                        .cuboid(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 14).cuboid(0.0F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 13).cuboid(1.0F, -3.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(12, 2)
                        .cuboid(2.0F, -4.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 12).cuboid(3.0F, -5.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(11, 6).cuboid(4.0F, -6.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(11, 4)
                        .cuboid(5.0F, -7.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(9, 8).cuboid(6.0F, -8.0F, -0.5F, 4.0F, 1.0F, 1.0F).uv(0, 2).cuboid(7.0F, -10.0F, -0.5F, 5.0F, 2.0F, 1.0F).uv(0, 5)
                        .cuboid(8.0F, -11.0F, -0.5F, 5.0F, 1.0F, 1.0F).uv(0, 0).cuboid(8.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F).uv(0, 9).cuboid(10.0F, -13.0F, -0.5F, 4.0F, 1.0F, 1.0F).uv(0, 7)
                        .cuboid(11.0F, -14.0F, -0.5F, 4.0F, 1.0F, 1.0F).uv(0, 11).cuboid(13.0F, -15.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(9, 10).cuboid(14.0F, -16.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(21, 16)
                        .cuboid(15.0F, -17.0F, -0.5F, 2.0F, 1.0F, 1.0F),
                ModelTransform.pivot(12.0F, 4.0F, 0.5F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}