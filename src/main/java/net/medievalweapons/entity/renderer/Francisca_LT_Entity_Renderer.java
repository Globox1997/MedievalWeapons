package net.medievalweapons.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.entity.Francisca_LT_Entity;
import net.medievalweapons.entity.model.Francisca_LT_Entity_Model;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class Francisca_LT_Entity_Renderer extends EntityRenderer<Francisca_LT_Entity> {
    private static final Map<EntityType<?>, Identifier> TEXTURES = new HashMap<>();
    private final Francisca_LT_Entity_Model model = new Francisca_LT_Entity_Model(Francisca_LT_Entity_Model.getTexturedModelData().createModel());

    public Francisca_LT_Entity_Renderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public void render(Francisca_LT_Entity francisca_LT_Entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumerProvider, model.getLayer(this.getTexture(francisca_LT_Entity)), false, francisca_LT_Entity.enchantingGlint());

        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, francisca_LT_Entity.prevYaw, francisca_LT_Entity.getYaw()) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, francisca_LT_Entity.prevPitch, francisca_LT_Entity.getPitch()) + 90.0F));
        matrixStack.translate(0.0D, -0.75D, 0.0D);
        model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.scale(1.0F, -1.0F, 1.0F);

        matrixStack.pop();
        super.render(francisca_LT_Entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(Francisca_LT_Entity francisca_LT_Entity) {
        return getTexture(francisca_LT_Entity.getType());
    }

    public static Identifier getTexture(EntityType<?> type) {
        if (!TEXTURES.containsKey(type)) {
            TEXTURES.put(type, new Identifier("medievalweapons", "textures/entity/" + Registry.ENTITY_TYPE.getId(type).getPath() + ".png"));
        }
        return TEXTURES.get(type);
    }
}