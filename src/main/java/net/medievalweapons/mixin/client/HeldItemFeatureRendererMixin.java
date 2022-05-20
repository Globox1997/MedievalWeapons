package net.medievalweapons.mixin.client;

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
import net.minecraft.util.math.Vec3f;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.Dagger_Item;
import net.medievalweapons.item.Long_Sword_Item;
import net.minecraft.client.render.VertexConsumerProvider;

@Environment(EnvType.CLIENT)
@Mixin(HeldItemFeatureRenderer.class)
public abstract class HeldItemFeatureRendererMixin {

    @Inject(method = "Lnet/minecraft/client/render/entity/feature/HeldItemFeatureRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;Lnet/minecraft/util/Arm;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At(value = "HEAD"))
    protected void renderItemMixin(LivingEntity entity, ItemStack stack, ModelTransformation.Mode transformationMode, Arm arm, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
            CallbackInfo info) {
        if ((stack.isIn(TagInit.DOUBLE_HANDED_ITEMS) || stack.getItem() instanceof Long_Sword_Item) && entity.getOffHandStack().isEmpty() && !entity.isSwimming() && !entity.hasVehicle()) {
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(arm == Arm.LEFT ? -50.0F : 30.0F));
            matrices.translate(arm == Arm.LEFT ? -0.4D : 0.24D, arm == Arm.LEFT ? 0.1D : 0.0D, arm == Arm.LEFT ? 0.1D : 0.0D);
            if (arm == Arm.LEFT && entity.isBlocking()) {
                matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(30.0F));
            }
        }
    }

    @Inject(method = "Lnet/minecraft/client/render/entity/feature/HeldItemFeatureRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;Lnet/minecraft/util/Arm;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;multiply(Lnet/minecraft/util/math/Quaternion;)V"))
    protected void renderItemMixinTwo(LivingEntity entity, ItemStack stack, ModelTransformation.Mode transformationMode, Arm arm, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
            int light, CallbackInfo info) {
        if (stack.getItem() instanceof Dagger_Item)
            matrices.multiply(Vec3f.NEGATIVE_Y.getDegreesQuaternion(180.0F));
    }

    @Inject(method = "Lnet/minecraft/client/render/entity/feature/HeldItemFeatureRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;Lnet/minecraft/util/Arm;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(DDD)V"))
    protected void renderItemMixinThree(LivingEntity entity, ItemStack stack, ModelTransformation.Mode transformationMode, Arm arm, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
            int light, CallbackInfo info) {
        if (stack.getItem() instanceof Dagger_Item)
            matrices.translate(0.0D, 0.1D, 1.0D);
    }

}