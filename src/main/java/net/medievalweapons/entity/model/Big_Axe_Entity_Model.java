package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Big_Axe_Entity_Model extends Model {
    private final ModelPart base;

    public Big_Axe_Entity_Model(ModelPart base) {
        super(RenderLayer::getEntitySolid);
        this.base = base.getChild("base");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("base", ModelPartBuilder.create().uv(22, 18)
                .cuboid(-12.0F, 11.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(22, 11)
                .cuboid(-12.0F, 10.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(22, 9).cuboid(-11.0F, 9.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(22, 7).cuboid(-10.0F, 8.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(22, 22)
                .cuboid(-9.0F, 7.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 22).cuboid(-8.0F, 6.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(15, 21).cuboid(-7.0F, 5.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 21)
                .cuboid(-6.0F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(20, 2).cuboid(-5.0F, 3.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(0, 20).cuboid(-4.0F, 2.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(19, 4)
                .cuboid(-3.0F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(15, 19).cuboid(-2.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(7, 19).cuboid(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(18, 14)
                .cuboid(0.0F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 18).cuboid(1.0F, -3.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(0, 0).cuboid(2.0F, -4.0F, -0.5F, 11.0F, 1.0F, 1.0F).uv(13, 10)
                .cuboid(3.0F, -5.0F, -0.5F, 4.0F, 1.0F, 1.0F).uv(15, 17).cuboid(4.0F, -6.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(7, 17).cuboid(5.0F, -7.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 16)
                .cuboid(6.0F, -8.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 2).cuboid(7.0F, -10.0F, -0.5F, 9.0F, 2.0F, 1.0F)
                .uv(11, 12).cuboid(6.0F, -11.0F, -0.5F, 5.0F, 1.0F, 1.0F).uv(0, 9)
                .cuboid(6.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F).uv(15, 6).cuboid(6.0F, -13.0F, -0.5F, 3.0F, 1.0F, 1.0F)
                .uv(22, 16).cuboid(10.0F, -13.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(10, 14)
                .cuboid(13.0F, -12.0F, -0.5F, 3.0F, 2.0F, 1.0F).uv(22, 20)
                .cuboid(14.0F, -13.0F, -0.5F, 1.0F, 1.0F, 1.0F).uv(0, 7).cuboid(10.0F, -8.0F, -0.5F, 6.0F, 1.0F, 1.0F)
                .uv(0, 13).cuboid(11.0F, -7.0F, -0.5F, 4.0F, 2.0F, 1.0F).uv(0, 11)
                .cuboid(9.0F, -5.0F, -0.5F, 5.0F, 1.0F, 1.0F).uv(0, 5).cuboid(5.0F, -3.0F, -0.5F, 7.0F, 1.0F, 1.0F)
                .uv(13, 8).cuboid(6.0F, -2.0F, -0.5F, 4.0F, 1.0F, 1.0F), ModelTransform.pivot(4.0F, 12.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
            float green, float blue, float alpha) {
        this.base.yaw = 1.5708F;
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}