package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.EffectInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import java.util.Map;

public class MaceItem extends SwordItem {

    private static final Map<Tier, Integer> ADDITION = Map.of(Tiers.WOOD, 0, Tiers.STONE, 0, Tiers.IRON, 1, Tiers.GOLD, 2, Tiers.DIAMOND, 2, Tiers.NETHERITE, 3);

    private final int addition;

    public static final ResourceLocation ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("attack_bonus");

    public MaceItem(Tier toolMaterial, int addition, Properties settings) {
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
            target.addEffect(new MobEffectInstance(EffectInit.STUN_EFFECT, 60 + addition * 20, 0, false, false, true));
        }
        return super.hurtEnemy(stack, target, attacker);
    }

}
