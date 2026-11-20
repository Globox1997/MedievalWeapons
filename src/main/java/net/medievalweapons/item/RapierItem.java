package net.medievalweapons.item;

import net.medievalweapons.init.EffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;

import java.util.Map;

public class RapierItem extends Item {

    private static final Map<ToolMaterial, Integer> ADDITION = Map.of(ToolMaterial.WOOD, 0, ToolMaterial.STONE, 0, ToolMaterial.IRON, 1, ToolMaterial.GOLD, 2, ToolMaterial.DIAMOND, 2, ToolMaterial.NETHERITE, 3);

    private final int addition;

    public RapierItem(ToolMaterial toolMaterial, int addition, Properties settings) {
        super(settings);
        if (addition == -1) {
            this.addition = ADDITION.get(toolMaterial);
        } else {
            this.addition = addition;
        }
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isDeadOrDying() && attacker.level().getRandom().nextFloat() <= 0.01F + ((float) addition / 10F)) {
            int amplifier = 0;
            if (target.hasEffect(EffectInit.BLEED_EFFECT)) {
                amplifier = target.getEffect(EffectInit.BLEED_EFFECT).getAmplifier() + 1;
            }
            target.addEffect(new MobEffectInstance(EffectInit.BLEED_EFFECT, 60 + addition * 20, Math.min(amplifier, 2), false, false, true));
        }
        super.hurtEnemy(stack, target, attacker);
    }

}
