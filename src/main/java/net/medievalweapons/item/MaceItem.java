package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;

import java.util.Map;

public class MaceItem extends SwordItem {

    private static final Map<ToolMaterial, Integer> ADDITION = Map.of(ToolMaterials.WOOD, 0, ToolMaterials.STONE, 0, ToolMaterials.IRON, 1, ToolMaterials.GOLD, 2, ToolMaterials.DIAMOND, 2, ToolMaterials.NETHERITE, 3);

    private final int addition;

    public static final Identifier ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("attack_bonus");

    public MaceItem(ToolMaterial toolMaterial, int addition, Settings settings) {
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
            target.addStatusEffect(new StatusEffectInstance(EffectInit.STUN_EFFECT, 60 + addition * 20, 0, false, false, true));
        }
        return super.postHit(stack, target, attacker);
    }

}
