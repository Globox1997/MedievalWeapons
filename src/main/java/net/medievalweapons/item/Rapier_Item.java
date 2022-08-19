package net.medievalweapons.item;

import net.medievalweapons.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class Rapier_Item extends SwordItem {

    private int addition;

    public Rapier_Item(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, int addition, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.addition = addition;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isDead() && attacker.world.random.nextFloat() <= 0.01F + ((float) addition / 10F)) {
            int amplifier = 0;
            if (target.hasStatusEffect(EffectInit.BLEED_EFFECT))
                amplifier = target.getStatusEffect(EffectInit.BLEED_EFFECT).getAmplifier() + 1;
            target.addStatusEffect(new StatusEffectInstance(EffectInit.BLEED_EFFECT, 60 + addition * 20, amplifier > 2 ? 2 : amplifier, false, false, true));
        }
        return super.postHit(stack, target, attacker);
    }

}
