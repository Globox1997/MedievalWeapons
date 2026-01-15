package net.medievalweapons.item;

import net.medievalweapons.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;

import java.util.Map;

public class RapierItem extends SwordItem {

    private static final Map<ToolMaterial, Integer> ADDITION = Map.of(ToolMaterials.WOOD, 0, ToolMaterials.STONE, 0, ToolMaterials.IRON, 1, ToolMaterials.GOLD, 2, ToolMaterials.DIAMOND, 2, ToolMaterials.NETHERITE, 3);

    private final int addition;

    public RapierItem(ToolMaterial toolMaterial, int addition, Settings settings) {
        super(toolMaterial, settings);
        if (addition == -1) {
            this.addition = ADDITION.get(toolMaterial);
        } else {
            this.addition = addition;
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isDead() && attacker.getWorld().getRandom().nextFloat() <= 0.01F + ((float) addition / 10F)) {
            int amplifier = 0;
            if (target.hasStatusEffect(EffectInit.BLEED_EFFECT)) {
                amplifier = target.getStatusEffect(EffectInit.BLEED_EFFECT).getAmplifier() + 1;
            }
            target.addStatusEffect(new StatusEffectInstance(EffectInit.BLEED_EFFECT, 60 + addition * 20, Math.min(amplifier, 2), false, false, true));
        }
        return super.postHit(stack, target, attacker);
    }

}
