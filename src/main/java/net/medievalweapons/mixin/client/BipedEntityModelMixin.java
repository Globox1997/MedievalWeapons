package net.medievalweapons.mixin.client;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.BigAxeItem;
import net.medievalweapons.item.LongSwordItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
@Mixin(HumanoidModel.class)
public abstract class BipedEntityModelMixin {
    @Shadow
    @Mutable
    @Final
    public ModelPart rightArm;
    @Shadow
    @Mutable
    @Final
    public ModelPart leftArm;
    @Shadow
    @Mutable
    @Final
    public ModelPart head;

    @Inject(method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/HumanoidRenderState;)V", at = @At(value = "TAIL"))
    private void setAnglesMixin(HumanoidRenderState state, CallbackInfo info) {
        float f = state.walkAnimationPos;
        float g = state.walkAnimationSpeed;
        ItemStack mainHandStack = state.getMainHandItemStack();
        if (state.getUseItemStackForArm(state.mainArm.getOpposite()).isEmpty() && !state.isVisuallySwimming && !state.isPassenger) {
            if (mainHandStack.is(TagInit.DOUBLE_HANDED_ITEMS) || mainHandStack.getItem() instanceof LongSwordItem) {
                if (!CompatInit.isBetterCombatLoaded) {
                    this.rightArm.xRot = -0.8727F + (Mth.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15);
                    this.rightArm.yRot = -0.5672F;
                    this.rightArm.zRot = 0.0F;
                    this.leftArm.xRot = -1.0472F + (Mth.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15);
                    this.leftArm.yRot = 0.829F;
                    this.leftArm.zRot = -0.0436F;
                    if (state.swingAnimation > 0) {
                        float gx = 1.0F - state.swingAnimation;
                        float hx = Mth.sin(gx * 3.1415927F);
                        float kx = this.head.xRot;
                        if (kx < 0) {
                            kx = 0.25F;
                        }
                        float ix = Mth.sin(state.swingAnimation * 3.1415927F) * -((kx) - 0.7F) * 0.75F * 0.6F;
                        this.rightArm.xRot = (float) ((double) this.rightArm.xRot - ((double) hx * 1.2D + (double) ix));
                        this.leftArm.xRot = (float) ((double) this.leftArm.xRot - ((double) hx * 1.2D + (double) ix) * 1.2D) * 0.75F;
                    }
                }

                if (isBlocking(state, mainHandStack)) {
                    if (!CompatInit.isBetterCombatLoaded) {
                        this.rightArm.xRot = -1.25F;
                        this.leftArm.xRot = -1.17F;
                        this.rightArm.zRot = 0.7F;
                    } else {
                        this.rightArm.xRot = -1.25F;
                        this.rightArm.yRot = -0.8f;
                        this.leftArm.xRot = -1.25F;
                        this.leftArm.yRot = 0.8f;
                    }
                }
            } else if (mainHandStack.is(TagInit.ACROSS_DOUBLE_HANDED_ITEMS) || mainHandStack.getItem() instanceof BigAxeItem) {
                if (!CompatInit.isBetterCombatLoaded) {
                    this.rightArm.xRot = -0.5236F + (Mth.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15);
                    this.rightArm.yRot = 0.0F;
                    this.rightArm.zRot = 0.0F;
                    this.leftArm.xRot = -1.2217F + (Mth.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15);
                    this.leftArm.yRot = 0.0F;
                    this.leftArm.zRot = 0.0F;
                    if (state.swingAnimation > 0) {
                        float gx = 1.0F - state.swingAnimation;
                        float hx = Mth.sin(gx * 3.1415927F);
                        float kx = this.head.xRot;
                        if (kx < 0) {
                            kx = 0.25F;
                        }
                        float ix = Mth.sin(state.swingAnimation * 3.1415927F) * -((kx) - 0.7F) * 0.75F * 0.6F;
                        this.rightArm.xRot = (float) ((double) this.rightArm.xRot - ((double) hx * 1.2D + (double) ix));
                        this.leftArm.xRot = (float) ((double) this.leftArm.xRot - ((double) hx * 1.2D + (double) ix) * 1.2D) * 0.75F * 1.2F;
                    }
                }
                if (isBlocking(state, mainHandStack)) {
                    if (!CompatInit.isBetterCombatLoaded) {
                        this.rightArm.xRot = -1.0234747F;
                        this.leftArm.xRot = -1.6393949F;
                    }else{
                        this.rightArm.xRot = -1.0234747F;
                        this.leftArm.xRot = -1.3393949F;
                        this.rightArm.yRot = -0.6f;
                        this.leftArm.yRot = 0.15f;
                        this.rightArm.zRot = 1.0f;
                    }
                }
            }
        }

    }

    @Unique
    private static boolean isBlocking(HumanoidRenderState state, ItemStack mainHandStack) {
        return state.isUsingItem && state.useItemHand == InteractionHand.MAIN_HAND && mainHandStack.has(DataComponents.BLOCKS_ATTACKS) && state.ticksUsingItem >= 5.0F;
    }

}
