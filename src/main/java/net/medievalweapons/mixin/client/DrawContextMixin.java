package net.medievalweapons.mixin.client;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

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
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mixin(DrawContext.class)
public class DrawContextMixin {

    @Shadow
    @Mutable
    @Final
    private MinecraftClient client;

    @ModifyVariable(method = "Lnet/minecraft/client/gui/DrawContext;drawItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;IIII)V", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/client/render/item/ItemRenderer;getModel(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;I)Lnet/minecraft/client/render/model/BakedModel;"), ordinal = 0)
    private BakedModel drawItemMixin(BakedModel original, @Nullable LivingEntity entity, @Nullable World world, ItemStack stack, int x, int y, int seed, int z) {
        if (stack.getItem() instanceof Long_Sword_Item || stack.getItem() instanceof Small_Axe_Item || stack.getItem() instanceof Big_Axe_Item || stack.getItem() instanceof Lance_Item
                || stack.getItem() instanceof Healing_Staff_Item || stack.getItem() instanceof Javelin_Item || stack.getItem() instanceof Mace_Item || stack.getItem() instanceof Sickle_Item
                || stack.getItem() instanceof Rapier_Item || stack.getItem() instanceof Thalleous_Sword_Item) {
            return this.client.getItemRenderer().getModel(stack, world, entity, 0);
        }
        return original;
    }
}
