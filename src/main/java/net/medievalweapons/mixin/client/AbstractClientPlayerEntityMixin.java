package net.medievalweapons.mixin.client;

import com.mojang.authlib.GameProfile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.ItemInit;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Environment(EnvType.CLIENT)
@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerEntityMixin extends Player {

    public AbstractClientPlayerEntityMixin(Level world, GameProfile gameProfile) {
        super(world, gameProfile);
    }

    @ModifyArg(method = "getFieldOfViewModifier", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;lerp(FFF)F"), index = 2)
    private float getFovMultiplierMixin(float modifier) {
        Item item = this.getUseItem().getItem();
        if (this.isUsingItem() && (item == ItemInit.LONG_BOW_ITEM || item == ItemInit.RECURVE_BOW_ITEM)) {
            int i = this.getTicksUsingItem();
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

            return modifier * (1.0F - g * 0.15F);
        }
        return modifier;
    }

}
