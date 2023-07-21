package net.medievalweapons.mixin.client;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.CompatInit;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Shadow
    @Mutable
    @Final
    MinecraftClient client;

    @ModifyConstant(method = "updateTargetedEntity", constant = @Constant(doubleValue = 3.0))
    private double getActualAttackRange0(final double attackRange) {
        if (this.client.player != null) {
            return CompatInit.getAttackRange(this.client.player, attackRange);
        }
        return attackRange;
    }

    @ModifyConstant(method = "updateTargetedEntity", constant = @Constant(doubleValue = 9.0))
    private double getActualAttackRange1(final double attackRange) {
        if (this.client.player != null) {
            return CompatInit.getSquaredAttackRange(this.client.player, attackRange);
        }
        return attackRange;
    }
}
