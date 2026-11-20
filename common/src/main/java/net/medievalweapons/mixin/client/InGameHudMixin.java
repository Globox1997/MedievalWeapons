package net.medievalweapons.mixin.client;

import net.medievalweapons.access.PlayerAccess;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.item.NinjatoItem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Hud.class)
public abstract class InGameHudMixin {

    @Shadow
    @Final
    private Minecraft minecraft;
    @Shadow
    @Final
    private static Identifier CROSSHAIR_ATTACK_INDICATOR_FULL_SPRITE;
    @Shadow
    @Final
    private static Identifier CROSSHAIR_ATTACK_INDICATOR_BACKGROUND_SPRITE;
    @Shadow
    @Final
    private static Identifier CROSSHAIR_ATTACK_INDICATOR_PROGRESS_SPRITE;
    @Shadow
    @Final
    private static Identifier HOTBAR_ATTACK_INDICATOR_BACKGROUND_SPRITE;
    @Shadow
    @Final
    private static Identifier HOTBAR_ATTACK_INDICATOR_PROGRESS_SPRITE;

    @Inject(method = "extractCrosshair", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getAttackStrengthScale(F)F", shift = Shift.AFTER))
    private void renderCrosshairMixin(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker, CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded) {
            if (showOffhandAttackCooldown(this.minecraft.player)) {
                int p = graphics.guiHeight() / 2 - 7 + 16 + 8;
                int t = graphics.guiWidth() / 2 - 8;
                float o = ((PlayerAccess) this.minecraft.player).getAttackCooldownProgressOffhand(1.0F);
                boolean bl = false;
                if (this.minecraft.crosshairPickEntity != null && this.minecraft.crosshairPickEntity instanceof LivingEntity && o >= 1.0f) {
                    bl = this.minecraft.player.getCurrentItemAttackStrengthDelay() > 5.0f;
                    bl &= this.minecraft.crosshairPickEntity.isAlive();
                }
                if (bl) {
                    graphics.blitSprite(RenderPipelines.CROSSHAIR, CROSSHAIR_ATTACK_INDICATOR_FULL_SPRITE, t, p, 16, 16);
                } else if (o < 1.0f) {
                    int l = (int) (o * 17.0f);
                    graphics.blitSprite(RenderPipelines.CROSSHAIR, CROSSHAIR_ATTACK_INDICATOR_BACKGROUND_SPRITE, t, p, 16, 4);
                    graphics.blitSprite(RenderPipelines.CROSSHAIR, CROSSHAIR_ATTACK_INDICATOR_PROGRESS_SPRITE, 16, 4, 0, 0, t, p, l, 4);
                }
            }
        }
    }

    @Inject(method = "extractItemHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getAttackStrengthScale(F)F", shift = Shift.AFTER))
    private void renderHotbarMixin(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker, CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded) {
            if (showOffhandAttackCooldown(this.minecraft.player)) {
                float o = ((PlayerAccess) this.minecraft.player).getAttackCooldownProgressOffhand(1.0F);
                if (o < 1.0F) {
                    HumanoidArm arm = this.minecraft.player.getMainArm().getOpposite();
                    int r = (graphics.guiWidth() / 2) + 91 + 6;
                    if (arm == HumanoidArm.RIGHT) {
                        r = (graphics.guiWidth() / 2) - 91 - 22;
                    }
                    int s = (int) (o * 19.0F);
                    int y = graphics.guiHeight() - 20;
                    graphics.blitSprite(RenderPipelines.GUI_TEXTURED, HOTBAR_ATTACK_INDICATOR_BACKGROUND_SPRITE, r + 18, y, 18, 18);
                    graphics.blitSprite(RenderPipelines.GUI_TEXTURED, HOTBAR_ATTACK_INDICATOR_PROGRESS_SPRITE, 18, 18, 0, 18 - s, r + 18, y + 18 - s, 18, s);
                }
            }
        }
    }

    @Unique
    private boolean showOffhandAttackCooldown(Player player) {
        return player.getMainHandItem().getItem() instanceof NinjatoItem && player.getOffhandItem().getItem() instanceof NinjatoItem;
    }

}
