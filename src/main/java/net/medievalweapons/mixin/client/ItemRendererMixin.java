package net.medievalweapons.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.ItemInit;
import net.medievalweapons.init.RenderInit;
import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.HeroSwordItem;
import net.medievalweapons.item.LongSwordItem;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexConsumers;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Inject(method = "renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;III)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V"))
    private void renderItemMixin(@Nullable LivingEntity entity, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
                                 @Nullable World world, int light, int overlay, int seed, CallbackInfo info) {
        if (entity != null && !CompatInit.isBetterCombatLoaded && (renderMode == ModelTransformationMode.FIRST_PERSON_LEFT_HAND || renderMode == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND)
                && entity.isBlocking() && (stack.getItem() instanceof LongSwordItem || stack.getItem() instanceof BigAxeItem || stack.getItem() instanceof HeroSwordItem)) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(leftHanded ? -20F : 20F));
        }
    }

    @WrapOperation(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;getDirectItemGlintConsumer(Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/render/RenderLayer;ZZ)Lnet/minecraft/client/render/VertexConsumer;"))
    private VertexConsumer renderItemMixin(VertexConsumerProvider provider, RenderLayer layer, boolean solid, boolean glint, Operation<VertexConsumer> original, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model) {
        if (stack.isOf(ItemInit.THALLEOUS_SWORD)) {
            return VertexConsumers.union(vertexConsumers.getBuffer(RenderInit.CUSTOM_GLINT.get(DyeColor.BLUE)), vertexConsumers.getBuffer(layer));
        } else if (stack.isOf(ItemInit.DEATHSINGER_SWORD)) {
            return VertexConsumers.union(vertexConsumers.getBuffer(RenderInit.CUSTOM_GLINT.get(DyeColor.RED)), vertexConsumers.getBuffer(layer));
        } else if (stack.isOf(ItemInit.TIDESINGER_STAFF)) {
            return VertexConsumers.union(vertexConsumers.getBuffer(RenderInit.CUSTOM_GLINT.get(DyeColor.YELLOW)), vertexConsumers.getBuffer(layer));
        }
        return original.call(provider, layer, solid, glint);
    }
}
