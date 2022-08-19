package net.medievalweapons.mixin.client;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.medievalweapons.access.PlayerAccess;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.EffectInit;
import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.Big_Axe_Item;
import net.medievalweapons.item.Long_Sword_Item;
import net.medievalweapons.item.Ninjato_Item;
import net.medievalweapons.network.PlayerPacket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;

@Environment(EnvType.CLIENT)
@Mixin(value = MinecraftClient.class, priority = 999)
public class MinecraftClientMixin {
    @Shadow
    @Nullable
    public ClientPlayerEntity player;
    @Shadow
    protected int attackCooldown;
    @Shadow
    @Nullable
    public HitResult crosshairTarget;
    @Shadow
    @Nullable
    public ClientPlayerInteractionManager interactionManager;
    @Unique
    private int offhandAttackCooldown;
    @Unique
    private boolean attackedOffhand;

    @Inject(method = "Lnet/minecraft/client/MinecraftClient;tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;handleInputEvents()V"))
    public void tickMixin(CallbackInfo info) {
        if (this.offhandAttackCooldown > 0)
            --this.offhandAttackCooldown;
    }

    @Inject(method = "doAttack", at = @At(value = "HEAD"), cancellable = true)
    private void doAttackMixin(CallbackInfoReturnable<Boolean> info) {
        if (player != null) {
            if (player.hasStatusEffect(EffectInit.STUN_EFFECT))
                info.cancel();

            if (!CompatInit.isBetterCombatLoaded) {
                ItemStack itemStack = player.getMainHandStack();
                if ((itemStack.isIn(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof Long_Sword_Item
                        || itemStack.getItem() instanceof Big_Axe_Item) && (!player.getOffHandStack().isEmpty() || player.isSwimming() || player.hasVehicle()))
                    info.setReturnValue(false);

                if (this.offhandAttackCooldown == 0 && this.attackCooldown < 5 && !this.player.isRiding() && itemStack.getItem() instanceof Ninjato_Item
                        && player.getOffHandStack().getItem() instanceof Ninjato_Item) {

                    if (this.attackedOffhand) {
                        this.attackedOffhand = false;

                        switch (this.crosshairTarget.getType()) {
                        case ENTITY: {
                            MinecraftClient.getInstance().getNetworkHandler().sendPacket(PlayerPacket.attackPacket(((EntityHitResult) this.crosshairTarget).getEntity()));
                            if (!this.player.isSpectator()) {
                                ((PlayerAccess) this.player).doOffhandAttack(((EntityHitResult) this.crosshairTarget).getEntity());
                                ((PlayerAccess) this.player).resetLastAttackedOffhandTicks();
                            }
                            this.offhandAttackCooldown = 5;
                            break;
                        }
                        case BLOCK: {
                            BlockHitResult blockHitResult = (BlockHitResult) this.crosshairTarget;
                            BlockPos blockPos = blockHitResult.getBlockPos();
                            if (!this.player.world.getBlockState(blockPos).isAir()) {
                                this.interactionManager.attackBlock(blockPos, blockHitResult.getSide());
                                if (!this.player.world.getBlockState(blockPos).isAir())
                                    break;
                                break;
                            }
                        }
                        case MISS: {
                            if (this.interactionManager.hasLimitedAttackSpeed()) {
                                this.offhandAttackCooldown = 10;
                            }
                            ((PlayerAccess) this.player).resetLastAttackedOffhandTicks();
                        }
                        }
                        this.player.swingHand(Hand.OFF_HAND);
                        info.setReturnValue(false);
                    } else
                        this.attackedOffhand = true;
                }
            }
        }
    }

    @Inject(method = "doItemUse", at = @At(value = "HEAD"), cancellable = true)
    private void doItemUseMixin(CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded && player != null) {
            ItemStack itemStack = player.getMainHandStack();
            if ((itemStack.isIn(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof Long_Sword_Item
                    || itemStack.getItem() instanceof Big_Axe_Item) && (!player.getOffHandStack().isEmpty() || player.isSwimming() || player.hasVehicle()))
                info.cancel();
        }
    }

    @Inject(method = "handleBlockBreaking", at = @At(value = "HEAD"), cancellable = true)
    private void handleBlockBreakingMixin(boolean bl, CallbackInfo info) {
        if (!CompatInit.isBetterCombatLoaded && player != null) {
            ItemStack itemStack = player.getMainHandStack();
            if ((itemStack.isIn(TagInit.DOUBLE_HANDED_ITEMS) || itemStack.isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof Long_Sword_Item
                    || itemStack.getItem() instanceof Big_Axe_Item) && (!player.getOffHandStack().isEmpty() || player.isSwimming() || player.hasVehicle()))
                info.cancel();
        }
    }

}
