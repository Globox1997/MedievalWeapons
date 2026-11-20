package net.medievalweapons.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.medievalweapons.init.ConfigInit;
import net.medievalweapons.init.ParticleInit;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AreaEffectCloud.class)
public abstract class AreaEffectCloudEntityMixin {

    @WrapWithCondition(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/effect/MobEffect;applyInstantenousEffect(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/LivingEntity;ID)V"))
    private boolean tickMixin(MobEffect statusEffect, Entity source, Entity attacker, LivingEntity target, int amplifier, double proximity) {
        return ConfigInit.CONFIG.healing_staff_owner_healing || target != attacker || !getParticle().equals(ParticleInit.HEALING_AURA_PARTICLE);
    }

    @Shadow
    public abstract ParticleOptions getParticle();

}
