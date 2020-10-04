package net.medievalweapons.item;

import com.google.common.collect.ImmutableMultimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;

import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class Long_Sword_Item extends SwordItem {

  public Long_Sword_Item(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
    super(toolMaterial, attackDamage, attackSpeed, settings);
    ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
    builder.put(ReachEntityAttributes.REACH,
        new EntityAttributeModifier("Reach", 2.0D, EntityAttributeModifier.Operation.ADDITION));
    builder.put(ReachEntityAttributes.ATTACK_RANGE,
        new EntityAttributeModifier("Attack range", 2.0D, EntityAttributeModifier.Operation.ADDITION));
  }

}