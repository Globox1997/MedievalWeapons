package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Thalleous_Sword_Entity_Model extends Model {
    private final ModelPart base;

    public Thalleous_Sword_Entity_Model(ModelPart base) {
        super(RenderLayer::getEntitySolid);
        this.base = base.getChild("base");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("base",
                ModelPartBuilder.create().uv(13, 27).cuboid(-6.0F, 7.0F, 0.0F, 2.0F, 1.0F, 1.0F).uv(0, 26).cuboid(-7.0F, 6.0F, 0.0F, 3.0F, 1.0F, 1.0F).uv(19, 23)
                        .cuboid(-8.0F, 5.0F, 0.0F, 4.0F, 1.0F, 1.0F).uv(21, 5).cuboid(-8.0F, 4.0F, 0.0F, 5.0F, 1.0F, 1.0F).uv(25, 21).cuboid(-5.0F, 3.0F, 0.0F, 3.0F, 1.0F, 1.0F).uv(23, 25)
                        .cuboid(-4.0F, 2.0F, 0.0F, 3.0F, 1.0F, 1.0F).uv(15, 25).cuboid(-3.0F, 1.0F, 0.0F, 3.0F, 1.0F, 1.0F).uv(0, 20).cuboid(-2.0F, 0.0F, 0.0F, 6.0F, 1.0F, 1.0F).uv(13, 19)
                        .cuboid(-1.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F).uv(7, 25).cuboid(2.0F, 1.0F, 0.0F, 3.0F, 1.0F, 1.0F).uv(9, 23).cuboid(2.0F, 2.0F, 0.0F, 4.0F, 1.0F, 1.0F).uv(0, 24)
                        .cuboid(2.0F, 3.0F, 0.0F, 3.0F, 1.0F, 1.0F).uv(27, 27).cuboid(3.0F, 4.0F, 0.0F, 1.0F, 1.0F, 1.0F).uv(0, 14).cuboid(-1.0F, -2.0F, 0.0F, 7.0F, 1.0F, 1.0F).uv(0, 2)
                        .cuboid(-4.0F, -3.0F, 0.0F, 11.0F, 1.0F, 1.0F).uv(0, 0).cuboid(-5.0F, -4.0F, 0.0F, 15.0F, 1.0F, 1.0F).uv(0, 6).cuboid(0.0F, -5.0F, 0.0F, 10.0F, 1.0F, 1.0F).uv(23, 27)
                        .cuboid(-3.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F).uv(23, 3).cuboid(-4.0F, -5.0F, 0.0F, 3.0F, 1.0F, 1.0F).uv(19, 27).cuboid(8.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F).uv(0, 12)
                        .cuboid(1.0F, -6.0F, 0.0F, 8.0F, 1.0F, 1.0F).uv(0, 10).cuboid(2.0F, -7.0F, 0.0F, 8.0F, 1.0F, 1.0F).uv(0, 8).cuboid(3.0F, -8.0F, 0.0F, 8.0F, 1.0F, 1.0F).uv(0, 4)
                        .cuboid(2.0F, -9.0F, 0.0F, 10.0F, 1.0F, 1.0F).uv(7, 27).cuboid(3.0F, -10.0F, 0.0F, 2.0F, 1.0F, 1.0F).uv(0, 18).cuboid(6.0F, -10.0F, 0.0F, 6.0F, 1.0F, 1.0F).uv(17, 13)
                        .cuboid(7.0F, -11.0F, 0.0F, 6.0F, 1.0F, 1.0F).uv(17, 11).cuboid(8.0F, -12.0F, 0.0F, 6.0F, 1.0F, 1.0F).uv(17, 9).cuboid(10.0F, -13.0F, 0.0F, 6.0F, 1.0F, 1.0F).uv(13, 17)
                        .cuboid(11.0F, -14.0F, 0.0F, 6.0F, 1.0F, 1.0F).uv(13, 21).cuboid(12.0F, -15.0F, 0.0F, 5.0F, 1.0F, 1.0F).uv(0, 16).cuboid(12.0F, -16.0F, 0.0F, 6.0F, 1.0F, 1.0F).uv(15, 15)
                        .cuboid(13.0F, -17.0F, 0.0F, 6.0F, 1.0F, 1.0F).uv(0, 22).cuboid(15.0F, -18.0F, 0.0F, 4.0F, 1.0F, 1.0F).uv(21, 7).cuboid(16.0F, -19.0F, 0.0F, 4.0F, 1.0F, 1.0F).uv(26, 18)
                        .cuboid(18.0F, -20.0F, 0.0F, 2.0F, 1.0F, 1.0F),
                ModelTransform.pivot(0.0F, 16.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}