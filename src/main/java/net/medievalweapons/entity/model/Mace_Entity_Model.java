package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Mace_Entity_Model extends Model {
    private final ModelPart base;

    public Mace_Entity_Model(ModelPart base) {
        super(RenderLayer::getEntitySolid);
        this.base = base.getChild("base");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("base",
                ModelPartBuilder.create().uv(14, 18).cuboid(-10.0F, 9.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(7, 17).cuboid(-10.0F, 8.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(17, 3)
                        .cuboid(-9.0F, 7.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 16).cuboid(-8.0F, 6.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 16).cuboid(-7.0F, 5.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 15)
                        .cuboid(-6.0F, 4.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(15, 5).cuboid(-5.0F, 3.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(14, 14).cuboid(-4.0F, 2.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 14)
                        .cuboid(-3.0F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(7, 13).cuboid(-2.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 10).cuboid(-1.0F, -1.0F, -0.5F, 5.0F, 1.0F, 1.0F).uv(18, 12)
                        .cuboid(2.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(0, 20).cuboid(4.0F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F).uv(0, 12).cuboid(0.0F, -2.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(0, 8)
                        .cuboid(-1.0F, -3.0F, -0.5F, 5.0F, 1.0F, 1.0F).uv(18, 10).cuboid(-1.0F, -4.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(19, 19).cuboid(-2.0F, -5.0F, -0.5F, 1.0F, 1.0F, 1.0F).uv(0, 6)
                        .cuboid(2.0F, -4.0F, -0.5F, 5.0F, 1.0F, 1.0F).uv(0, 18).cuboid(5.0F, -3.0F, -0.5F, 2.0F, 1.0F, 1.0F).uv(9, 19).cuboid(7.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F).uv(0, 4)
                        .cuboid(3.0F, -5.0F, -0.5F, 7.0F, 1.0F, 1.0F).uv(0, 0).cuboid(2.0F, -6.0F, -0.5F, 9.0F, 1.0F, 1.0F).uv(0, 2).cuboid(2.0F, -7.0F, -0.5F, 8.0F, 1.0F, 1.0F).uv(5, 19)
                        .cuboid(1.0F, -8.0F, -0.5F, 1.0F, 1.0F, 1.0F).uv(11, 7).cuboid(4.0F, -8.0F, -0.5F, 4.0F, 1.0F, 1.0F).uv(11, 11).cuboid(4.0F, -9.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(11, 9)
                        .cuboid(4.0F, -10.0F, -0.5F, 3.0F, 1.0F, 1.0F).uv(19, 1).cuboid(5.0F, -11.0F, -0.5F, 1.0F, 1.0F, 1.0F),
                ModelTransform.pivot(2.0F, 14.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}