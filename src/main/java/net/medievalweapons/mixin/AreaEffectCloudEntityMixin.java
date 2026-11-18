package net.medievalweapons.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.medievalweapons.init.ConfigInit;
import net.medievalweapons.init.ParticleInit;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.particle.ParticleEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AreaEffectCloudEntity.class)
public abstract class AreaEffectCloudEntityMixin {

    @WrapWithCondition(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/effect/StatusEffect;applyInstantEffect(Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/LivingEntity;ID)V"))
    private boolean tickMixin(StatusEffect statusEffect, Entity source, Entity attacker, LivingEntity target, int amplifier, double proximity) {
        return ConfigInit.CONFIG.healing_staff_owner_healing || target != attacker || !getParticleType().equals(ParticleInit.HEALING_AURA_PARTICLE);
    }

    @Shadow
    public abstract ParticleEffect getParticleType();

}
