package net.medievalweapons.mixin.compat;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.medievalweapons.init.CompatInit;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayNetworkHandler;

@Mixin(targets = "net/minecraft/server/network/ServerPlayNetworkHandler$1")
public class ServerPlayNetworkHandlerMixin {

    @Shadow
    @Mutable
    @Final
    ServerPlayNetworkHandler field_28963;

    @Shadow
    @Mutable
    @Final
    Entity field_28962;

    @Inject(method = "attack()V", at = @At("HEAD"), require = 1, allow = 1, cancellable = true)
    private void ensureWithinAttackRange(final CallbackInfo info) {
        if (!CompatInit.isReachEntityAttributesLoaded) {
            if (!CompatInit.isWithinAttackRange(this.field_28963.player, this.field_28962)) {
                info.cancel();
            }
        }
    }
}
