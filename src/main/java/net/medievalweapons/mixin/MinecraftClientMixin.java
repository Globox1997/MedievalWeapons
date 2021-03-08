package net.medievalweapons.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.TagInit;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
  @Shadow
  @Nullable
  public ClientPlayerEntity player;

  @Inject(method = "doAttack", at = @At(value = "HEAD"), cancellable = true)
  public void doAttackMixin(CallbackInfo info) {
    if (player != null
        && (player.getMainHandStack().getItem().isIn(TagInit.DOUBLE_HANDED_ITEMS)
            || player.getMainHandStack().getItem().isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS))
        && (!player.getOffHandStack().isEmpty() || player.isSwimming() || player.hasVehicle())) {
      info.cancel();
    }
  }

  @Inject(method = "doItemUse", at = @At(value = "HEAD"), cancellable = true)
  private void doItemUseMixin(CallbackInfo info) {
    if (player != null
        && (player.getMainHandStack().getItem().isIn(TagInit.DOUBLE_HANDED_ITEMS)
            || player.getMainHandStack().getItem().isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS))
        && (!player.getOffHandStack().isEmpty() || player.isSwimming() || player.hasVehicle())) {
      info.cancel();
    }
  }

  @Inject(method = "handleBlockBreaking", at = @At(value = "HEAD"), cancellable = true)
  private void handleBlockBreakingMixin(boolean bl, CallbackInfo info) {
    if (player != null
        && (player.getMainHandStack().getItem().isIn(TagInit.DOUBLE_HANDED_ITEMS)
            || player.getMainHandStack().getItem().isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS))
        && (!player.getOffHandStack().isEmpty() || player.isSwimming() || player.hasVehicle())) {
      info.cancel();
    }
  }

}
