package net.medievalweapons.effect;

import net.minecraft.server.level.ServerLevel;
import net.medievalweapons.init.EntityInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class BleedEffect extends MobEffect {

    public BleedEffect(MobEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {
        entity.hurtServer(serverLevel, createDamageSource(entity), 1.0f);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int i = 40 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        }
        return true;
    }

    private DamageSource createDamageSource(Entity source) {
        return source.damageSources().source(EntityInit.BLEEDING);
    }
}
