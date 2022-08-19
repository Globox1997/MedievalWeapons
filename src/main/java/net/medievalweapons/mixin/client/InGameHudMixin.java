package net.medievalweapons.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.api.Environment;
import net.medievalweapons.access.PlayerAccess;
import net.medievalweapons.init.CompatInit;
import net.fabricmc.api.EnvType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin extends DrawableHelper {

    @Shadow
    @Final
    @Mutable
    private final MinecraftClient client;
    @Shadow
    private int scaledWidth;
    @Shadow
    private int scaledHeight;

    public InGameHudMixin(MinecraftClient client) {
        this.client = client;
    }

    @Inject(method = "renderCrosshair", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getAttackCooldownProgress(F)F", shift = Shift.AFTER))
    private void renderCrosshairMixin(MatrixStack matrices, CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded) {
            float o = ((PlayerAccess) this.client.player).getAttackCooldownProgressOffhand(1.0F);
            if (o < 1.0F) {
                int u = (int) (o * 17.0F);
                this.drawTexture(matrices, this.scaledWidth / 2 - 8, this.scaledHeight / 2 - 7 + 16 + 8, 36, 94, 16, 4);
                this.drawTexture(matrices, this.scaledWidth / 2 - 8, this.scaledHeight / 2 - 7 + 16 + 8, 52, 94, u, 4);
            }
        }
    }

    @Inject(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getAttackCooldownProgress(F)F", shift = Shift.AFTER))
    private void renderHotbar(float tickDelta, MatrixStack matrices, CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded) {
            float o = ((PlayerAccess) this.client.player).getAttackCooldownProgressOffhand(1.0F);
            if (o < 1.0F) {
                Arm arm = this.client.player.getMainArm().getOpposite();
                int r = (this.scaledWidth / 2) + 91 + 6;
                if (arm == Arm.RIGHT) {
                    r = (this.scaledWidth / 2) - 91 - 22;
                }
                int s = (int) (o * 19.0F);
                RenderSystem.setShaderTexture(0, DrawableHelper.GUI_ICONS_TEXTURE);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                drawTexture(matrices, r + 18, this.scaledHeight - 20, 0, 94, 18, 18);
                drawTexture(matrices, r + 18, this.scaledHeight - 20 + 18 - s, 18, 112 - s, 18, s);
            }
        }
    }

}
