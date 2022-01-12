package net.medievalweapons.mixin.client;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.medievalweapons.item.Big_Axe_Item;
import net.medievalweapons.item.Healing_Staff_Item;
import net.medievalweapons.item.Javelin_Item;
import net.medievalweapons.item.Lance_Item;
import net.medievalweapons.item.Long_Sword_Item;
import net.medievalweapons.item.Mace_Item;
import net.medievalweapons.item.Thalleous_Sword_Item;
import net.medievalweapons.item.renderer.Big_Axe_Item_Renderer;
import net.medievalweapons.item.renderer.Healing_Staff_Item_Renderer;
import net.medievalweapons.item.renderer.Javelin_Item_Renderer;
import net.medievalweapons.item.renderer.Lance_Item_Renderer;
import net.medievalweapons.item.renderer.Mace_Item_Renderer;
import net.medievalweapons.item.renderer.Thalleous_Sword_Item_Renderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Environment(EnvType.CLIENT)
@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @Inject(method = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;III)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V"), locals = LocalCapture.CAPTURE_FAILSOFT)
    public void renderItemMixin(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
            World world, int light, int overlay, int seed, CallbackInfo info, BakedModel bakedModel) {
        if ((stack.getItem() instanceof Javelin_Item && Javelin_Item_Renderer.INSTANCE.render(entity, stack, renderMode, leftHanded, matrices, vertexConsumers, light, overlay, bakedModel))
                || (stack.getItem() instanceof Big_Axe_Item && Big_Axe_Item_Renderer.INSTANCE.render(entity, stack, renderMode, leftHanded, matrices, vertexConsumers, light, overlay, bakedModel))
                || (stack.getItem() instanceof Lance_Item && Lance_Item_Renderer.INSTANCE.render(entity, stack, renderMode, leftHanded, matrices, vertexConsumers, light, overlay, bakedModel))
                || (stack.getItem() instanceof Healing_Staff_Item
                        && Healing_Staff_Item_Renderer.INSTANCE.render(entity, stack, renderMode, leftHanded, matrices, vertexConsumers, light, overlay, bakedModel))
                || (stack.getItem() instanceof Thalleous_Sword_Item
                        && Thalleous_Sword_Item_Renderer.INSTANCE.render(entity, stack, renderMode, leftHanded, matrices, vertexConsumers, light, overlay, bakedModel))
                || (stack.getItem() instanceof Mace_Item && Mace_Item_Renderer.INSTANCE.render(entity, stack, renderMode, leftHanded, matrices, vertexConsumers, light, overlay, bakedModel))) {
            matrices.scale(0, 0, 0);
        }
    }

    @Inject(method = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;III)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V"))
    public void renderItemMixinTwo(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
            World world, int light, int overlay, int seed, CallbackInfo info) {
        if (entity != null && (renderMode == ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND || renderMode == ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND)
                && stack.getItem() instanceof Long_Sword_Item && entity.isBlocking()) {
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(20F));
        }
    }

}