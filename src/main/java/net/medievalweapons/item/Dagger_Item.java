package net.medievalweapons.item;

import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.medievalweapons.init.CompatInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class Dagger_Item extends SwordItem {
    private static final UUID ATTACK_BONUS_MODIFIER_ID = UUID.fromString("fbd4e4e4-62f7-4108-9be3-eb6781231298");
    private static final EntityAttributeModifier ATTACK_BONUS_MODIFIER;
    private final ToolMaterial material;
    private final float attackDamage;
    public final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public Dagger_Item(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        this.material = material;
        this.attackDamage = attackDamage + material.getAttackDamage();

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        CompatInit.addRange(-1.0D, builder);
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot);
    }

    @Override
    public ToolMaterial getMaterial() {
        return this.material;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity && !world.isClient) {
            PlayerEntity player = (PlayerEntity) entity;
            Boolean extra = player.isSneaking() || player.hasStatusEffect(StatusEffects.INVISIBILITY);
            if (selected && extra && !player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID)) {
                EntityAttributeInstance entityAttributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                entityAttributeInstance.addTemporaryModifier(ATTACK_BONUS_MODIFIER);
            } else if (player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID) && !extra) {
                player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(ATTACK_BONUS_MODIFIER_ID);
            }
        }
    }

    static {
        ATTACK_BONUS_MODIFIER = new EntityAttributeModifier(ATTACK_BONUS_MODIFIER_ID, "Sneaking attack bonus", 2.0D, EntityAttributeModifier.Operation.ADDITION);
    }

}