package net.medievalweapons.item.renderer;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.medievalweapons.entity.model.Thalleous_Sword_Entity_Model;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public enum Thalleous_Sword_Item_Renderer {
    INSTANCE;

    private final Thalleous_Sword_Entity_Model thalleous_Sword_Entity_Model = new Thalleous_Sword_Entity_Model(Thalleous_Sword_Entity_Model.getTexturedModelData().createModel());

    public boolean render(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
            int overlay, BakedModel model) {
        if (renderMode == ModelTransformation.Mode.GUI || renderMode == ModelTransformation.Mode.GROUND || renderMode == ModelTransformation.Mode.FIXED) {
            return false;
        }

        matrices.push();
        model.getTransformation().getTransformation(renderMode).apply(leftHanded, matrices);
        if (entity != null) {
            if ((renderMode == ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND || renderMode == ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND) && entity.isBlocking()) {
                matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(30.0F));
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(leftHanded ? 20.0F : -20.0F));
            }
        }
        matrices.translate(-0.05D, 0.84D, 0.0D);
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumers,
                this.thalleous_Sword_Entity_Model.getLayer(new Identifier("medievalweapons", "textures/entity/thalleous_sword.png")), false, stack.hasGlint());
        this.thalleous_Sword_Entity_Model.render(matrices, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
        return true;
    }
}