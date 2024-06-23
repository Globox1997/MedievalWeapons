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
import net.fabricmc.api.EnvType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    @Shadow
    @Final
    @Mutable
    private MinecraftClient client;
    @Shadow
    @Final
    @Mutable
    private static Identifier CROSSHAIR_ATTACK_INDICATOR_FULL_TEXTURE;
    @Shadow
    @Final
    @Mutable
    private static Identifier CROSSHAIR_ATTACK_INDICATOR_BACKGROUND_TEXTURE;
    @Shadow
    @Final
    @Mutable
    private static Identifier CROSSHAIR_ATTACK_INDICATOR_PROGRESS_TEXTURE;
    @Shadow
    @Final
    @Mutable
    private static Identifier HOTBAR_ATTACK_INDICATOR_BACKGROUND_TEXTURE;
    @Shadow
    @Final
    @Mutable
    private static Identifier HOTBAR_ATTACK_INDICATOR_PROGRESS_TEXTURE;

    @Inject(method = "renderCrosshair", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getAttackCooldownProgress(F)F", shift = Shift.AFTER))
    private void renderCrosshairMixin(DrawContext context, RenderTickCounter tickCounter, CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded) {
            if (showOffhandAttackCooldown(this.client.player)) {
                int p = context.getScaledWindowHeight() / 2 - 7 + 16 + 8;
                int t = context.getScaledWindowWidth() / 2 - 8;
                float o = ((PlayerAccess) this.client.player).getAttackCooldownProgressOffhand(1.0F);
                boolean bl = false;
                if (this.client.targetedEntity != null && this.client.targetedEntity instanceof LivingEntity && o >= 1.0f) {
                    bl = this.client.player.getAttackCooldownProgressPerTick() > 5.0f;
                    bl &= this.client.targetedEntity.isAlive();
                }
                if (bl) {
                    context.drawGuiTexture(CROSSHAIR_ATTACK_INDICATOR_FULL_TEXTURE, t, p, 16, 16);
                } else if (o < 1.0f) {
                    int l = (int) (o * 17.0f);
                    context.drawGuiTexture(CROSSHAIR_ATTACK_INDICATOR_BACKGROUND_TEXTURE, t, p, 16, 4);
                    context.drawGuiTexture(CROSSHAIR_ATTACK_INDICATOR_PROGRESS_TEXTURE, 16, 4, 0, 0, t, p, l, 4);
                }
            }
        }
    }

    @Inject(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getAttackCooldownProgress(F)F", shift = Shift.AFTER))
    private void renderHotbarMixin(DrawContext context, RenderTickCounter tickCounter, CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded) {
            if (showOffhandAttackCooldown(this.client.player)) {
                float o = ((PlayerAccess) this.client.player).getAttackCooldownProgressOffhand(1.0F);
                if (o < 1.0F) {
                    Arm arm = this.client.player.getMainArm().getOpposite();
                    int r = (context.getScaledWindowWidth() / 2) + 91 + 6;
                    if (arm == Arm.RIGHT) {
                        r = (context.getScaledWindowWidth() / 2) - 91 - 22;
                    }
                    int s = (int) (o * 19.0F);
                    context.drawGuiTexture(HOTBAR_ATTACK_INDICATOR_BACKGROUND_TEXTURE, r + 18, context.getScaledWindowHeight() - 20, 94, 18, 18);
                    context.drawGuiTexture(HOTBAR_ATTACK_INDICATOR_PROGRESS_TEXTURE, r + 18, context.getScaledWindowHeight() - 20 + 18 - s, 112 - s, 18, s);
                }
            }
        }
    }

    private boolean showOffhandAttackCooldown(PlayerEntity player) {
        if (player.getMainHandStack().getItem() instanceof NinjatoItem && player.getOffHandStack().getItem() instanceof NinjatoItem) {
            return true;
        }
        return false;
    }

}
