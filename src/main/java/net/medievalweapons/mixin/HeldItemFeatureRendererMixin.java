package net.medievalweapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.medievalweapons.init.TagInit;
import net.minecraft.client.render.VertexConsumerProvider;

@Mixin(HeldItemFeatureRenderer.class)
public abstract class HeldItemFeatureRendererMixin {

  @Inject(method = "Lnet/minecraft/client/render/entity/feature/HeldItemFeatureRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;Lnet/minecraft/util/Arm;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At(value = "HEAD"))
  public void renderItemRedirect(LivingEntity entity, ItemStack stack, ModelTransformation.Mode transformationMode,
      Arm arm, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo info) {
    if (stack.getItem().isIn(TagInit.DOUBLE_HANDED_ITEMS) && entity.getOffHandStack().isEmpty() && !entity.isSwimming()
        && !entity.hasVehicle()) {
      matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(30.0F));
      matrices.translate(0.24D, 0.0D, 0.0D);
    }
  }

}