package net.medievalweapons.mixin;

import net.medievalweapons.item.Big_Axe_Item;
import net.medievalweapons.item.Healing_Staff_Item;
import net.medievalweapons.item.Javelin_Item;
import net.medievalweapons.item.Lance_Item;
import net.medievalweapons.item.renderer.Big_Axe_Item_Renderer;
import net.medievalweapons.item.renderer.Healing_Staff_Item_Renderer;
import net.medievalweapons.item.renderer.Javelin_Item_Renderer;
import net.medievalweapons.item.renderer.Lance_Item_Renderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

  @Inject(method = "renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;II)V", at = @At("HEAD"), cancellable = true)
  public void renderItemMixin(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode,
      boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, World world, int light,
      int overlay, CallbackInfo info) {
    BakedModel model = MinecraftClient.getInstance().getItemRenderer().getHeldItemModel(stack, world, entity);
    if ((stack.getItem() instanceof Javelin_Item && Javelin_Item_Renderer.INSTANCE.render(entity, stack, renderMode,
        leftHanded, matrices, vertexConsumers, light, overlay, model))
        || (stack.getItem() instanceof Big_Axe_Item && Big_Axe_Item_Renderer.INSTANCE.render(entity, stack, renderMode,
            leftHanded, matrices, vertexConsumers, light, overlay, model))
        || (stack.getItem() instanceof Lance_Item && Lance_Item_Renderer.INSTANCE.render(entity, stack, renderMode,
            leftHanded, matrices, vertexConsumers, light, overlay, model))
        || (stack.getItem() instanceof Healing_Staff_Item && Healing_Staff_Item_Renderer.INSTANCE.render(entity, stack,
            renderMode, leftHanded, matrices, vertexConsumers, light, overlay, model))) {
      info.cancel();
    }
  }

}