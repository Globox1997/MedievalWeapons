package net.medievalweapons.item;

import net.medievalweapons.init.EffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;



public class Rapier_Item extends SwordItem {

    private int addition;

    public Rapier_Item(Tiers toolMaterial, int attackDamage, float attackSpeed, int addition, Properties settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.addition = addition;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isDeadOrDying() && attacker.level.random.nextFloat() <= 0.01F + ((float) addition / 10F)) {
            int amplifier = 0;
            if (target.hasEffect(EffectInit.BLEED_EFFECT.get()))
                amplifier = target.getEffect(EffectInit.BLEED_EFFECT.get()).getAmplifier() + 1;
            target.addEffect(new MobEffectInstance(EffectInit.BLEED_EFFECT.get(), 60 + addition * 20, amplifier > 2 ? 2 : amplifier, false, false, true));
        }
        return super.hurtEnemy(stack, target, attacker);
    }

}
