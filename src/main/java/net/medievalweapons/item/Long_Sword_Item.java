package net.medievalweapons.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class Long_Sword_Item extends SwordItem {
  private final ToolMaterial material;
  private final float attackDamage;
  public final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

  public Long_Sword_Item(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
    super(material, attackDamage, attackSpeed, settings);
    this.material = material;
    this.attackDamage = attackDamage + material.getAttackDamage();
    ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
    builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
        "Tool modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
    builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
        "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
    builder.put(ReachEntityAttributes.ATTACK_RANGE,
        new EntityAttributeModifier("Attack range", 0.8D, EntityAttributeModifier.Operation.ADDITION));
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

}