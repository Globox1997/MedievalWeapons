package net.medievalweapons.mixin.client;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.api.EnvType;
import net.medievalweapons.access.PlayerAccess;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.EffectInit;
import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.LongSwordItem;
import net.medievalweapons.item.NinjatoItem;
import net.medievalweapons.network.packet.AttackPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

@Environment(EnvType.CLIENT)
@Mixin(value = Minecraft.class, priority = 999)
public class MinecraftClientMixin {
    @Shadow
    @Nullable
    public LocalPlayer player;
    @Shadow
    public int missTime;
    @Shadow
    @Nullable
    public HitResult hitResult;
    @Shadow
    @Nullable
    public MultiPlayerGameMode gameMode;
    @Unique
    private int offhandAttackCooldown;
    @Unique
    private boolean attackedOffhand;

    @Inject(method = "tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;handleKeybinds()V"))
    public void tickMixin(CallbackInfo info) {
        if (this.offhandAttackCooldown > 0) {
            --this.offhandAttackCooldown;
        }
    }

    @Inject(method = "startAttack", at = @At(value = "HEAD"), cancellable = true)
    private void doAttackMixin(CallbackInfoReturnable<Boolean> info) {
        if (player != null) {
            if (player.hasEffect(EffectInit.STUN_EFFECT)) {
                info.cancel();
            }

            if (!CompatInit.isBetterCombatLoaded) {
                ItemStack itemStack = player.getMainHandItem();
                if ((itemStack.is(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                        || itemStack.getItem() instanceof BigAxeItem) && (!player.getOffhandItem().isEmpty() || player.isSwimming() || player.isPassenger())) {
                    info.setReturnValue(false);
                }

                if (this.hitResult != null && this.offhandAttackCooldown == 0 && this.missTime < 5 && !this.player.isHandsBusy() && itemStack.getItem() instanceof NinjatoItem
                        && player.getOffhandItem().getItem() instanceof NinjatoItem) {

                    if (this.attackedOffhand) {
                        this.attackedOffhand = false;

                        switch (this.hitResult.getType()) {
                            case ENTITY: {
                                ClientPlayNetworking.send(new AttackPacket(((EntityHitResult) this.hitResult).getEntity().getId()));
                                if (!this.player.isSpectator()) {
                                    ((PlayerAccess) this.player).doOffhandAttack(((EntityHitResult) this.hitResult).getEntity());
                                    ((PlayerAccess) this.player).resetLastAttackedOffhandTicks();
                                }
                                this.offhandAttackCooldown = 5;
                                break;
                            }
                            case BLOCK: {
                                BlockHitResult blockHitResult = (BlockHitResult) this.hitResult;
                                BlockPos blockPos = blockHitResult.getBlockPos();
                                if (!this.player.level().getBlockState(blockPos).isAir()) {
                                    this.gameMode.startDestroyBlock(blockPos, blockHitResult.getDirection());
                                    if (!this.player.level().getBlockState(blockPos).isAir())
                                        break;
                                    break;
                                }
                            }
                            case MISS: {
                                if (this.gameMode.hasMissTime()) {
                                    this.offhandAttackCooldown = 10;
                                }
                                ((PlayerAccess) this.player).resetLastAttackedOffhandTicks();
                            }
                        }
                        this.player.swing(InteractionHand.OFF_HAND);
                        info.setReturnValue(false);
                    } else {
                        this.attackedOffhand = true;
                    }
                }
            }
        }
    }

    @Inject(method = "startUseItem", at = @At(value = "HEAD"), cancellable = true)
    private void doItemUseMixin(CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded && player != null) {
            ItemStack itemStack = player.getMainHandItem();
            if ((itemStack.is(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                    || itemStack.getItem() instanceof BigAxeItem) && (!player.getOffhandItem().isEmpty() || player.isSwimming() || player.isPassenger())) {
                info.cancel();
            }
        }
    }

    @Inject(method = "continueAttack", at = @At(value = "HEAD"), cancellable = true)
    private void handleBlockBreakingMixin(boolean bl, CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded && player != null) {
            ItemStack itemStack = player.getMainHandItem();
            if ((itemStack.is(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof LongSwordItem
                    || itemStack.getItem() instanceof BigAxeItem) && (!player.getOffhandItem().isEmpty() || player.isSwimming() || player.isPassenger())) {
                info.cancel();
            }
        }
    }

}
