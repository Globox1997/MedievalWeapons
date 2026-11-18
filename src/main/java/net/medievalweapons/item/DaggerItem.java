package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

public class DaggerItem extends SwordItem {

    public static final Identifier ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("sneaking_attack_bonus");
    private static final EntityAttributeModifier ATTACK_BONUS_MODIFIER;

    public DaggerItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    public static void updateAttackBonus(PlayerEntity player) {
        EntityAttributeInstance entityAttributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (entityAttributeInstance == null) {
            return;
        }
        boolean active = player.getMainHandStack().getItem() instanceof DaggerItem && (player.isSneaking() || player.hasStatusEffect(StatusEffects.INVISIBILITY));
        boolean hasModifier = entityAttributeInstance.hasModifier(ATTACK_BONUS_MODIFIER_ID);
        if (active && !hasModifier) {
            entityAttributeInstance.addTemporaryModifier(ATTACK_BONUS_MODIFIER);
        } else if (!active && hasModifier) {
            entityAttributeInstance.removeModifier(ATTACK_BONUS_MODIFIER_ID);
        }
    }

    static {
        ATTACK_BONUS_MODIFIER = new EntityAttributeModifier(ATTACK_BONUS_MODIFIER_ID, 2.0D, EntityAttributeModifier.Operation.ADD_VALUE);
    }

}
