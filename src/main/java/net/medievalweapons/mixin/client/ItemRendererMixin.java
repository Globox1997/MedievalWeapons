package net.medievalweapons.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.HeroSwordItem;
import net.medievalweapons.item.LongSwordItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.FirstPersonHandsAndItemsRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.FirstPersonHandsAndItemsRenderState;
import net.minecraft.client.renderer.state.level.PlayerRenderState;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(FirstPersonHandsAndItemsRenderer.class)
public class ItemRendererMixin {

    @Inject(method = "submitArmWithItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/item/ItemStackRenderState;submit(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;III)V", ordinal = 1))
    private void submitArmWithItemMixin(PlayerRenderState playerState, FirstPersonHandsAndItemsRenderState state, float partialTicks, float xRot, InteractionHand hand, float attack,
            ItemStack itemStack, float inverseArmHeight, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, CallbackInfo info) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null && !CompatInit.isBetterCombatLoaded && player.isBlocking()
                && (itemStack.getItem() instanceof LongSwordItem || itemStack.getItem() instanceof BigAxeItem || itemStack.getItem() instanceof HeroSwordItem)) {
            HumanoidArm arm = hand == InteractionHand.MAIN_HAND ? player.getMainArm() : player.getMainArm().getOpposite();
            poseStack.rotateDegrees(Axis.ZP, arm == HumanoidArm.LEFT ? -20F : 20F);
        }
    }

}
