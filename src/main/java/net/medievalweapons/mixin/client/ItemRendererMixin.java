package net.medievalweapons.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexMultiConsumer;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.ItemInit;
import net.medievalweapons.init.RenderInit;
import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.HeroSwordItem;
import net.medievalweapons.item.LongSwordItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Inject(method = "renderStatic(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/level/Level;III)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ItemRenderer;render(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/resources/model/BakedModel;)V"))
    private void renderItemMixin(@Nullable LivingEntity entity, ItemStack stack, ItemDisplayContext renderMode, boolean leftHanded, PoseStack matrices, MultiBufferSource vertexConsumers,
                                 @Nullable Level world, int light, int overlay, int seed, CallbackInfo info) {
        if (entity != null && !CompatInit.isBetterCombatLoaded && (renderMode == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || renderMode == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                && entity.isBlocking() && (stack.getItem() instanceof LongSwordItem || stack.getItem() instanceof BigAxeItem || stack.getItem() instanceof HeroSwordItem)) {
            matrices.mulPose(Axis.ZP.rotationDegrees(leftHanded ? -20F : 20F));
        }
    }

    @WrapOperation(method = "render(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/resources/model/BakedModel;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ItemRenderer;getFoilBufferDirect(Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/renderer/RenderType;ZZ)Lcom/mojang/blaze3d/vertex/VertexConsumer;"))
    private VertexConsumer renderItemMixin(MultiBufferSource provider, RenderType layer, boolean solid, boolean glint, Operation<VertexConsumer> original, ItemStack stack, ItemDisplayContext renderMode, boolean leftHanded, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay, BakedModel model) {
        if (stack.is(ItemInit.THALLEOUS_SWORD)) {
            return VertexMultiConsumer.create(vertexConsumers.getBuffer(RenderInit.CUSTOM_GLINT.get(DyeColor.BLUE)), vertexConsumers.getBuffer(layer));
        } else if (stack.is(ItemInit.DEATHSINGER_SWORD)) {
            return VertexMultiConsumer.create(vertexConsumers.getBuffer(RenderInit.CUSTOM_GLINT.get(DyeColor.RED)), vertexConsumers.getBuffer(layer));
        } else if (stack.is(ItemInit.TIDESINGER_STAFF)) {
            return VertexMultiConsumer.create(vertexConsumers.getBuffer(RenderInit.CUSTOM_GLINT.get(DyeColor.YELLOW)), vertexConsumers.getBuffer(layer));
        }
        return original.call(provider, layer, solid, glint);
    }
}
