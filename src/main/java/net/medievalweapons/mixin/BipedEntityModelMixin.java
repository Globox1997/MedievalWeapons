package net.medievalweapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.TagInit;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin<T extends LivingEntity> extends AnimalModel<T>
    implements ModelWithArms, ModelWithHead {
  @Shadow
  public ModelPart rightArm;
  @Shadow
  public ModelPart leftArm;
  @Shadow
  public ModelPart head;

  @Inject(method = "setAngles", at = @At(value = "TAIL"))
  public void setAnglesMixin(T livingEntity, float f, float g, float h, float i, float j, CallbackInfo info) {

    if (livingEntity.getOffHandStack().isEmpty() && !livingEntity.isSwimming() && !livingEntity.hasVehicle()) {
      if (livingEntity.getMainHandStack().getItem().isIn(TagInit.DOUBLE_HANDED_ITEMS)) {
        this.rightArm.pitch = -0.8727F + (MathHelper.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15);
        this.rightArm.yaw = -0.5672F;
        this.rightArm.roll = 0.0F;
        this.leftArm.pitch = -1.0472F + (MathHelper.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15);
        this.leftArm.yaw = 0.829F;
        this.leftArm.roll = -0.0436F;
        if (this.handSwingProgress > 0) {
          float gx = 1.0F - this.handSwingProgress;
          float hx = MathHelper.sin(gx * 3.1415927F);
          float kx = this.head.pitch;
          if (kx < 0) {
            kx = 0.25F;
          }
          float ix = MathHelper.sin(this.handSwingProgress * 3.1415927F) * -((kx) - 0.7F) * 0.75F * 0.6F;
          this.rightArm.pitch = (float) ((double) this.rightArm.pitch - ((double) hx * 1.2D + (double) ix));
          this.leftArm.pitch = (float) ((double) this.leftArm.pitch - ((double) hx * 1.2D + (double) ix) * 1.2D)
              * 0.75F;
        }

        if (livingEntity.isBlocking()) {
          this.rightArm.pitch = -1.25F;
          this.leftArm.pitch = -1.17F;
          this.rightArm.roll = 0.7F;
        }
      } else if (livingEntity.getMainHandStack().getItem().isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS)) {
        this.rightArm.pitch = -0.5236F + (MathHelper.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15);
        this.rightArm.yaw = 0.0F;
        this.rightArm.roll = 0.0F;
        this.leftArm.pitch = -1.2217F + (MathHelper.cos(f * 0.6662F) * 2.0F * g * 0.5F / 15);
        this.leftArm.yaw = 0.0F;
        this.leftArm.roll = 0.0F;
        if (this.handSwingProgress > 0) {
          float gx = 1.0F - this.handSwingProgress;
          float hx = MathHelper.sin(gx * 3.1415927F);
          float kx = this.head.pitch;
          if (kx < 0) {
            kx = 0.25F;
          }
          float ix = MathHelper.sin(this.handSwingProgress * 3.1415927F) * -((kx) - 0.7F) * 0.75F * 0.6F;
          this.rightArm.pitch = (float) ((double) this.rightArm.pitch - ((double) hx * 1.2D + (double) ix));
          this.leftArm.pitch = (float) ((double) this.leftArm.pitch - ((double) hx * 1.2D + (double) ix) * 1.2D) * 0.75F
              * 1.2F;
        }
        if (livingEntity.isBlocking()) {
          this.rightArm.pitch = -1.0234747F;
          this.leftArm.pitch = -1.6393949F;
        }
      }
    }

  }

}