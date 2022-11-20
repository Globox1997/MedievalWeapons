package net.medievalweapons.mixin;

import java.util.Iterator;
import java.util.List;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AreaEffectCloud.class)
public abstract class AreaEffectCloudEntityMixin {
    @Shadow
    private LivingEntity owner;

    @Inject(method = "Lnet/minecraft/world/entity/AreaEffectCloud;tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/effect/MobEffect;applyInstantenousEffect(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/LivingEntity;ID)V"), cancellable = true, locals = LocalCapture.CAPTURE_FAILSOFT)
    private void tickMixin(CallbackInfo info, boolean bl, float f, List<MobEffectInstance> list, List<LivingEntity> list2, Iterator<LivingEntity> var6, LivingEntity livingEntity) {


    }

    @Shadow
    public ParticleOptions getParticle() {
        return null;
    }

}


