package net.medievalweapons.item;

import net.medievalweapons.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class MaceItem extends SwordItem {

    private final int addition;

    public MaceItem(ToolMaterial toolMaterial, int addition, Settings settings) {
        super(toolMaterial, settings);
        this.addition = addition;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isDead() && attacker.getWorld().getRandom().nextFloat() <= 0.01F + ((float) addition / 10F)) {
            target.addStatusEffect(new StatusEffectInstance(EffectInit.STUN_EFFECT, 60 + addition * 20, 0, false, false, true));
        }
        return super.postHit(stack, target, attacker);
    }

}
