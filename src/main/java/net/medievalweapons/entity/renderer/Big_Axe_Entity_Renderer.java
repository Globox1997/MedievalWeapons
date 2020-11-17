package net.medievalweapons.entity.renderer;

import java.util.HashMap;
import java.util.Map;

import net.medievalweapons.entity.Big_Axe_Entity;
import net.medievalweapons.entity.model.Big_Axe_Entity_Model;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Big_Axe_Entity_Renderer extends EntityRenderer<Big_Axe_Entity> {
  private static final Map<EntityType<?>, Identifier> TEXTURES = new HashMap<>();
  private final Big_Axe_Entity_Model model = new Big_Axe_Entity_Model();

  public Big_Axe_Entity_Renderer(EntityRenderDispatcher entityRenderDispatcher) {
    super(entityRenderDispatcher);
  }

  @Override
  public void render(Big_Axe_Entity big_Axe_Entity, float f, float g, MatrixStack matrixStack,
      VertexConsumerProvider vertexConsumerProvider, int i) {
    matrixStack.push();
    VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumerProvider,
        model.getLayer(this.getTexture(big_Axe_Entity)), false, big_Axe_Entity.enchantingGlint());
    model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
    matrixStack.scale(1.0F, -1.0F, 1.0F);
    matrixStack.translate(0.0D, -4.0D, 0.0D);
    matrixStack.pop();
    super.render(big_Axe_Entity, f, g, matrixStack, vertexConsumerProvider, i);
  }

  @Override
  public Identifier getTexture(Big_Axe_Entity big_Axe_Entity) {
    return getTexture(big_Axe_Entity.getType());
  }

  public static Identifier getTexture(EntityType<?> type) {
    if (!TEXTURES.containsKey(type)) {
      TEXTURES.put(type,
          new Identifier("medievalweapons", "textures/entity/" + Registry.ENTITY_TYPE.getId(type).getPath() + ".png"));
    }
    return TEXTURES.get(type);
  }
}