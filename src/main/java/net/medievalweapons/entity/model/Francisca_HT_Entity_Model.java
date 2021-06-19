package net.medievalweapons.entity.model;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class Francisca_HT_Entity_Model extends Model {
    private final ModelPart base;

    public Francisca_HT_Entity_Model(ModelPart base) {
        super(RenderLayer::getEntitySolid);
        this.base = base.getChild("base");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("base",
                ModelPartBuilder.create().uv(16, 0).cuboid(0.0F, -1.0F, 4.0F, 1.0F, 1.0F, 3.0F).uv(0, 9).cuboid(0.0F, 7.0F, -8.0F, 1.0F, 1.0F, 2.0F).uv(0, 21)
                        .cuboid(0.0F, 6.0F, -8.0F, 1.0F, 1.0F, 3.0F).uv(10, 20).cuboid(0.0F, 5.0F, -7.0F, 1.0F, 1.0F, 3.0F).uv(19, 19).cuboid(0.0F, 4.0F, -6.0F, 1.0F, 1.0F, 3.0F).uv(18, 14)
                        .cuboid(0.0F, 3.0F, -5.0F, 1.0F, 1.0F, 3.0F).uv(5, 18).cuboid(0.0F, 2.0F, -4.0F, 1.0F, 1.0F, 3.0F).uv(0, 17).cuboid(0.0F, 1.0F, -3.0F, 1.0F, 1.0F, 3.0F).uv(16, 10)
                        .cuboid(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F).uv(16, 6).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F).uv(0, 9).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 7.0F).uv(9, 0)
                        .cuboid(0.0F, -3.0F, 1.0F, 1.0F, 1.0F, 5.0F).uv(0, 0).cuboid(0.0F, -5.0F, -2.0F, 1.0F, 2.0F, 7.0F).uv(9, 9).cuboid(0.0F, -6.0F, -1.0F, 1.0F, 1.0F, 5.0F).uv(12, 15)
                        .cuboid(0.0F, -7.0F, -1.0F, 1.0F, 1.0F, 4.0F).uv(0, 3).cuboid(0.0F, -8.0F, 1.0F, 1.0F, 1.0F, 2.0F).uv(0, 0).cuboid(0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 2.0F),
                ModelTransform.pivot(0.5F, 16.0F, 1.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.base.yaw = 1.5708F;
        this.base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}