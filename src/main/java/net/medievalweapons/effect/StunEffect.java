package net.medievalweapons.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class StunEffect extends MobEffect {

    public static final Vec3 STUCK_MULTIPLIER = new Vec3(0.05F, 0.1F, 0.05F);

    public StunEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity livingEntity, int amplifier) {
        livingEntity.makeStuckInBlock(livingEntity.getInBlockState(), STUCK_MULTIPLIER);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

}
