package net.medievalweapons.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BleedEffect extends MobEffect {

    public BleedEffect(MobEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.hurt(BleedingDamageSource.BLEEDING, 1.0f);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int i = 40 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        }
        return true;
    }

    private static class BleedingDamageSource extends DamageSource {
        public static final DamageSource BLEEDING = new BleedingDamageSource("bleed").bypassArmor();

        public BleedingDamageSource(String name) {
            super(name);
        }
    }
}
