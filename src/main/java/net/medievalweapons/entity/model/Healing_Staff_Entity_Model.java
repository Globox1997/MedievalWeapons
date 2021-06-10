package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Healing_Staff_Entity_Model extends Model {
    private final ModelPart base;

    public Healing_Staff_Entity_Model(ModelPart base) {
        super(RenderLayer::getEntitySolid);
        this.base = base.getChild("base");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("base", ModelPartBuilder.create().uv(25, 16)
                .cuboid(-20.0F, 20.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(24, 18)
                .cuboid(-21.0F, 19.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 12).cuboid(-21.0F, 18.0F, -0.5F, 6.0F, 1.0F, 1.0F)
                .uv(25, 13).cuboid(-17.0F, 19.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(24, 8)
                .cuboid(-19.0F, 17.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(13, 9).cuboid(-20.0F, 16.0F, -0.5F, 5.0F, 1.0F, 1.0F)
                .uv(14, 25).cuboid(-20.0F, 15.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(24, 6)
                .cuboid(-17.0F, 15.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(24, 0).cuboid(-16.0F, 14.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(21, 24).cuboid(-15.0F, 13.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 24)
                .cuboid(-14.0F, 12.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 23)
                .cuboid(-13.0F, 11.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 23).cuboid(-12.0F, 10.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(21, 22).cuboid(-11.0F, 9.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 22)
                .cuboid(-10.0F, 8.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(21, 20).cuboid(-9.0F, 7.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(21, 11).cuboid(-8.0F, 6.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 21)
                .cuboid(-7.0F, 5.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 21).cuboid(-6.0F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(20, 2).cuboid(-5.0F, 3.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 20)
                .cuboid(-4.0F, 2.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 19).cuboid(-3.0F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(0, 19).cuboid(-2.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(18, 15)
                .cuboid(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(18, 4).cuboid(0.0F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(7, 18).cuboid(1.0F, -3.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(17, 17)
                .cuboid(2.0F, -4.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(13, 13).cuboid(3.0F, -5.0F, -0.5F, 5.0F, 1.0F, 1.0F)
                .uv(0, 27).cuboid(6.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F).uv(0, 17)
                .cuboid(4.0F, -6.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 4).cuboid(3.0F, -7.0F, -0.5F, 8.0F, 1.0F, 1.0F)
                .uv(26, 4).cuboid(4.0F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F).uv(0, 14)
                .cuboid(6.0F, -9.0F, -0.5F, 4.0F, 2.0F, 1.0F).uv(23, 26).cuboid(9.0F, -6.0F, -0.5F, 1.0F, 1.0F, 1.0F)
                .uv(0, 0).cuboid(5.0F, -10.0F, -0.5F, 11.0F, 1.0F, 1.0F).uv(19, 26)
                .cuboid(6.0F, -11.0F, -0.5F, 1.0F, 1.0F, 1.0F).uv(0, 10).cuboid(9.0F, -11.0F, -0.5F, 6.0F, 1.0F, 1.0F)
                .uv(0, 25).cuboid(11.0F, -9.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(9, 26)
                .cuboid(14.0F, -9.0F, -0.5F, 1.0F, 1.0F, 1.0F).uv(16, 6).cuboid(8.0F, -13.0F, -0.5F, 3.0F, 2.0F, 1.0F)
                .uv(10, 15).cuboid(13.0F, -13.0F, -0.5F, 3.0F, 2.0F, 1.0F).uv(0, 6)
                .cuboid(9.0F, -14.0F, -0.5F, 7.0F, 1.0F, 1.0F).uv(0, 2).cuboid(8.0F, -15.0F, -0.5F, 9.0F, 1.0F, 1.0F)
                .uv(5, 26).cuboid(9.0F, -16.0F, -0.5F, 1.0F, 1.0F, 1.0F).uv(0, 8)
                .cuboid(11.0F, -16.0F, -0.5F, 6.0F, 1.0F, 1.0F).uv(13, 11)
                .cuboid(14.0F, -17.0F, -0.5F, 3.0F, 1.0F, 1.0F), ModelTransform.pivot(13.0F, 3.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
            float green, float blue, float alpha) {
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}