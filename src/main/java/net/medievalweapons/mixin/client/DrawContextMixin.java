package net.medievalweapons.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.medievalweapons.init.ItemInit;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DrawContext.class)
public class DrawContextMixin {

    @WrapOperation(method = "drawItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;IIII)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;getModel(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;I)Lnet/minecraft/client/render/model/BakedModel;"))
    private BakedModel drawItemMixin(ItemRenderer instance, ItemStack stack, World world, LivingEntity entity, int seed, Operation<BakedModel> original) {
        if (ItemInit.CUSTOM_MODEL_ITEMS.contains(stack.getItem())) {
            return original.call(instance, stack, world, entity, 0);
        }
        return original.call(instance, stack, world, entity, seed);
    }

}
