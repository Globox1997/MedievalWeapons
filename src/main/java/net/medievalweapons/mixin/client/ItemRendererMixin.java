package net.medievalweapons.mixin.client;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.medievalweapons.item.Big_Axe_Item;
import net.medievalweapons.item.Healing_Staff_Item;
import net.medievalweapons.item.Javelin_Item;
import net.medievalweapons.item.Lance_Item;
import net.medievalweapons.item.Long_Sword_Item;
import net.medievalweapons.item.Mace_Item;
import net.medievalweapons.item.Rapier_Item;
import net.medievalweapons.item.Sickle_Item;
import net.medievalweapons.item.Small_Axe_Item;
import net.medievalweapons.item.Thalleous_Sword_Item;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Inject(method = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;III)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V"))
    private void renderItemMixin(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
            World world, int light, int overlay, int seed, CallbackInfo info) {
        if (entity != null && (renderMode == ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND || renderMode == ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND) && entity.isBlocking()
                && (stack.getItem() instanceof Long_Sword_Item || stack.getItem() instanceof Big_Axe_Item || stack.getItem() instanceof Thalleous_Sword_Item)) {
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(leftHanded ? -20F : 20F));
        }
    }

    @ModifyVariable(method = "renderGuiItemModel", at = @At("HEAD"))
    private BakedModel renderGuiItemModelMixin(BakedModel original, ItemStack stack, int x, int y, BakedModel model) {
        if (stack.getItem() instanceof Long_Sword_Item || stack.getItem() instanceof Small_Axe_Item || stack.getItem() instanceof Big_Axe_Item || stack.getItem() instanceof Lance_Item
                || stack.getItem() instanceof Healing_Staff_Item || stack.getItem() instanceof Javelin_Item || stack.getItem() instanceof Mace_Item || stack.getItem() instanceof Sickle_Item
                || stack.getItem() instanceof Rapier_Item || stack.getItem() instanceof Thalleous_Sword_Item) {
            return this.getModel(stack, null, null, 0);
        }
        return original;
    }

    @Shadow
    public BakedModel getModel(ItemStack stack, @Nullable World world, @Nullable LivingEntity entity, int seed) {
        return null;
    }

}
