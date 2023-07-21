package net.medievalweapons.mixin.client;

import com.mojang.authlib.GameProfile;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.medievalweapons.init.ItemInit;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin extends PlayerEntity {

    public AbstractClientPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @SuppressWarnings("resource")
    @Inject(method = "getFovMultiplier", at = @At(value = "TAIL"), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private void getFovMultiplierMixin(CallbackInfoReturnable<Float> info, float f) {
        Item item = this.getActiveItem().getItem();
        if (this.isUsingItem() && (item == ItemInit.LONG_BOW_ITEM || item == ItemInit.RECURVE_BOW_ITEM)) {
            int i = this.getItemUseTime();
            float g;
            if (item == ItemInit.LONG_BOW_ITEM) {
                g = (float) i / 60.0F;
            } else {
                g = (float) i / 12.0F;
            }

            if (g > 1.0F) {
                g = 1.0F;
            } else {
                g *= g;
            }

            f *= 1.0F - g * 0.15F;
            info.setReturnValue(MathHelper.lerp(MinecraftClient.getInstance().options.getFovEffectScale().getValue().floatValue(), 1.0f, f));
            return;
        }

    }

}
