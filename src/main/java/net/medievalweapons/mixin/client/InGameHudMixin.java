package net.medievalweapons.mixin.client;

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
import net.medievalweapons.item.NinjatoItem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
@Mixin(Gui.class)
public abstract class InGameHudMixin {

    @Shadow
    @Final
    @Mutable
    private Minecraft minecraft;
    @Shadow
    @Final
    @Mutable
    private static ResourceLocation CROSSHAIR_ATTACK_INDICATOR_FULL_SPRITE;
    @Shadow
    @Final
    @Mutable
    private static ResourceLocation CROSSHAIR_ATTACK_INDICATOR_BACKGROUND_SPRITE;
    @Shadow
    @Final
    @Mutable
    private static ResourceLocation CROSSHAIR_ATTACK_INDICATOR_PROGRESS_SPRITE;
    @Shadow
    @Final
    @Mutable
    private static ResourceLocation HOTBAR_ATTACK_INDICATOR_BACKGROUND_SPRITE;
    @Shadow
    @Final
    @Mutable
    private static ResourceLocation HOTBAR_ATTACK_INDICATOR_PROGRESS_SPRITE;

    @Inject(method = "renderCrosshair", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getAttackStrengthScale(F)F", shift = Shift.AFTER))
    private void renderCrosshairMixin(GuiGraphics context, DeltaTracker tickCounter, CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded) {
            if (showOffhandAttackCooldown(this.minecraft.player)) {
                int p = context.guiHeight() / 2 - 7 + 16 + 8;
                int t = context.guiWidth() / 2 - 8;
                float o = ((PlayerAccess) this.minecraft.player).getAttackCooldownProgressOffhand(1.0F);
                boolean bl = false;
                if (this.minecraft.crosshairPickEntity != null && this.minecraft.crosshairPickEntity instanceof LivingEntity && o >= 1.0f) {
                    bl = this.minecraft.player.getCurrentItemAttackStrengthDelay() > 5.0f;
                    bl &= this.minecraft.crosshairPickEntity.isAlive();
                }
                if (bl) {
                    context.blitSprite(CROSSHAIR_ATTACK_INDICATOR_FULL_SPRITE, t, p, 16, 16);
                } else if (o < 1.0f) {
                    int l = (int) (o * 17.0f);
                    context.blitSprite(CROSSHAIR_ATTACK_INDICATOR_BACKGROUND_SPRITE, t, p, 16, 4);
                    context.blitSprite(CROSSHAIR_ATTACK_INDICATOR_PROGRESS_SPRITE, 16, 4, 0, 0, t, p, l, 4);
                }
            }
        }
    }

    @Inject(method = "renderItemHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getAttackStrengthScale(F)F", shift = Shift.AFTER))
    private void renderHotbarMixin(GuiGraphics context, DeltaTracker tickCounter, CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded) {
            if (showOffhandAttackCooldown(this.minecraft.player)) {
                float o = ((PlayerAccess) this.minecraft.player).getAttackCooldownProgressOffhand(1.0F);
                if (o < 1.0F) {
                    HumanoidArm arm = this.minecraft.player.getMainArm().getOpposite();
                    int r = (context.guiWidth() / 2) + 91 + 6;
                    if (arm == HumanoidArm.RIGHT) {
                        r = (context.guiWidth() / 2) - 91 - 22;
                    }
                    int s = (int) (o * 19.0F);
                    int y = context.guiHeight() - 20;
                    context.blitSprite(HOTBAR_ATTACK_INDICATOR_BACKGROUND_SPRITE, r + 18, y, 18, 18);
                    context.blitSprite(HOTBAR_ATTACK_INDICATOR_PROGRESS_SPRITE, 18, 18, 0, 18 - s, r + 18, y + 18 - s, 18, s);
                }
            }
        }
    }

    private boolean showOffhandAttackCooldown(Player player) {
        if (player.getMainHandItem().getItem() instanceof NinjatoItem && player.getOffhandItem().getItem() instanceof NinjatoItem) {
            return true;
        }
        return false;
    }

}
