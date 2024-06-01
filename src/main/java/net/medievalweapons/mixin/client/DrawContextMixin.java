package net.medievalweapons.mixin.client;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.HealingStaffItem;
import net.medievalweapons.item.JavelinItem;
import net.medievalweapons.item.LanceItem;
import net.medievalweapons.item.LongSwordItem;
import net.medievalweapons.item.MaceItem;
import net.medievalweapons.item.RapierItem;
import net.medievalweapons.item.SickleItem;
import net.medievalweapons.item.SmallAxeItem;
import net.medievalweapons.item.ThalleousSwordItem;
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
        if (stack.getItem() instanceof LongSwordItem || stack.getItem() instanceof SmallAxeItem || stack.getItem() instanceof BigAxeItem || stack.getItem() instanceof LanceItem
                || stack.getItem() instanceof HealingStaffItem || stack.getItem() instanceof JavelinItem || stack.getItem() instanceof MaceItem || stack.getItem() instanceof SickleItem
                || stack.getItem() instanceof RapierItem || stack.getItem() instanceof ThalleousSwordItem) {
            return this.client.getItemRenderer().getModel(stack, world, entity, 0);
        }
        return original;
    }
}
