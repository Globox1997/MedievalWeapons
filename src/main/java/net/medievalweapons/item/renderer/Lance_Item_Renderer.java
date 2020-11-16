package net.medievalweapons.item.renderer;

import net.medievalweapons.entity.model.Lance_Entity_Model;
import net.medievalweapons.entity.renderer.Lance_Entity_Renderer;
import net.medievalweapons.item.Lance_Item;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public enum Lance_Item_Renderer {
    INSTANCE;

    private final Lance_Entity_Model lance_Entity_Model = new Lance_Entity_Model();

    public boolean render(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded,
            MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model) {
        if (renderMode == ModelTransformation.Mode.GUI || renderMode == ModelTransformation.Mode.GROUND
                || renderMode == ModelTransformation.Mode.FIXED) {
            return false;
        }

        matrices.push();
        model.getTransformation().getTransformation(renderMode).apply(leftHanded, matrices);
        matrices.translate(-0.7D, 0.27D, 0.0D);
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer spear = ItemRenderer.getItemGlintConsumer(vertexConsumers,
                this.lance_Entity_Model
                        .getLayer(Lance_Entity_Renderer.getTexture(((Lance_Item) stack.getItem()).getType())),
                false, stack.hasGlint());
        this.lance_Entity_Model.render(matrices, spear, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();
        return true;
    }
}