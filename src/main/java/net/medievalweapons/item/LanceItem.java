package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class LanceItem extends SwordItem {

    public static final ResourceLocation ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("riding_attack_bonus");
    private static final AttributeModifier ATTACK_BONUS_MODIFIER;

    public LanceItem(Tier material, Properties settings) {
        super(material, settings);
    }

    public static void updateAttackBonus(Player player) {
        AttributeInstance entityAttributeInstance = player.getAttribute(Attributes.ATTACK_DAMAGE);
        if (entityAttributeInstance == null) {
            return;
        }
        boolean active = player.getMainHandItem().getItem() instanceof LanceItem && player.isPassenger();
        boolean hasModifier = entityAttributeInstance.hasModifier(ATTACK_BONUS_MODIFIER_ID);
        if (active && !hasModifier) {
            entityAttributeInstance.addTransientModifier(ATTACK_BONUS_MODIFIER);
        } else if (!active && hasModifier) {
            entityAttributeInstance.removeModifier(ATTACK_BONUS_MODIFIER_ID);
        }
    }

    static {
        ATTACK_BONUS_MODIFIER = new AttributeModifier(ATTACK_BONUS_MODIFIER_ID, 2.0D, AttributeModifier.Operation.ADD_VALUE);
    }

}
