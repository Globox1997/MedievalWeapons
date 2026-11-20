package net.medievalweapons.item;

import net.medievalweapons.init.EffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import java.util.Map;

public class RapierItem extends SwordItem {

    private static final Map<Tier, Integer> ADDITION = Map.of(Tiers.WOOD, 0, Tiers.STONE, 0, Tiers.IRON, 1, Tiers.GOLD, 2, Tiers.DIAMOND, 2, Tiers.NETHERITE, 3);

    private final int addition;

    public RapierItem(Tier toolMaterial, int addition, Properties settings) {
        super(toolMaterial, settings);
        if (addition == -1) {
            this.addition = ADDITION.get(toolMaterial);
        } else {
            this.addition = addition;
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isDeadOrDying() && attacker.level().getRandom().nextFloat() <= 0.01F + ((float) addition / 10F)) {
            int amplifier = 0;
            if (target.hasEffect(EffectInit.BLEED_EFFECT)) {
                amplifier = target.getEffect(EffectInit.BLEED_EFFECT).getAmplifier() + 1;
            }
            target.addEffect(new MobEffectInstance(EffectInit.BLEED_EFFECT, 60 + addition * 20, Math.min(amplifier, 2), false, false, true));
        }
        return super.hurtEnemy(stack, target, attacker);
    }

}
