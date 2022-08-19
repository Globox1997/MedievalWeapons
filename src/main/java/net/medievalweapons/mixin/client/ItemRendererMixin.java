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
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.registry.Registry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

import com.mojang.blaze3d.systems.RenderSystem;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    private static final Map<ItemStack, Identifier> TEXTURES = new HashMap<>();

    @Inject(method = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;III)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V"))
    private void renderItemMixin(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
            World world, int light, int overlay, int seed, CallbackInfo info) {
        if (entity != null && (renderMode == ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND || renderMode == ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND) && entity.isBlocking()
                && (stack.getItem() instanceof Long_Sword_Item || stack.getItem() instanceof Big_Axe_Item || stack.getItem() instanceof Thalleous_Sword_Item)) {
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(leftHanded ? -20F : 20F));
        }
    }

    @ModifyVariable(method = "renderGuiItemModel", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;applyModelViewMatrix()V", ordinal = 0), ordinal = 0)
    private ItemStack renderGuiItemModelMixin(ItemStack original, ItemStack stack, int x, int y, BakedModel model) {

        if (original.getItem() instanceof Long_Sword_Item || original.getItem() instanceof Small_Axe_Item || original.getItem() instanceof Big_Axe_Item || original.getItem() instanceof Lance_Item
                || original.getItem() instanceof Healing_Staff_Item || original.getItem() instanceof Javelin_Item || original.getItem() instanceof Mace_Item
                || original.getItem() instanceof Sickle_Item || original.getItem() instanceof Rapier_Item || original.getItem() instanceof Thalleous_Sword_Item) {

            RenderSystem.disableDepthTest();
            RenderSystem.disableTexture();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();

            MatrixStack matrices = new MatrixStack();
            matrices.push();
            RenderSystem.setShaderTexture(0, getTexture(original));
            DrawableHelper.drawTexture(matrices, x, y, 0F, 0F, 16, 16, 16, 16);
            matrices.pop();

            RenderSystem.enableTexture();
            RenderSystem.enableDepthTest();

            return ItemStack.EMPTY;
        }

        return original;
    }

    private static Identifier getTexture(ItemStack itemStack) {
        if (!TEXTURES.containsKey(itemStack))
            TEXTURES.put(itemStack, new Identifier("medievalweapons", "textures/item/extra/" + Registry.ITEM.getId(itemStack.getItem()).getPath() + ".png"));

        return TEXTURES.get(itemStack);
    }

}