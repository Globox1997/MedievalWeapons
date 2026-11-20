package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.EffectInit;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;

import java.util.Map;

public class MaceItem extends Item {

    private static final Map<ToolMaterial, Integer> ADDITION = Map.of(ToolMaterial.WOOD, 0, ToolMaterial.STONE, 0, ToolMaterial.IRON, 1, ToolMaterial.GOLD, 2, ToolMaterial.DIAMOND, 2, ToolMaterial.NETHERITE, 3);

    private final int addition;

    public static final Identifier ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("attack_bonus");

    public MaceItem(ToolMaterial toolMaterial, int addition, Properties settings) {
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
            target.addEffect(new MobEffectInstance(EffectInit.STUN_EFFECT, 60 + addition * 20, 0, false, false, true));
        }
        super.hurtEnemy(stack, target, attacker);
    }

}
