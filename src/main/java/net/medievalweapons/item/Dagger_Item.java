package net.medievalweapons.item;

import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;

import net.minecraft.entity.Entity;
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

  public Dagger_Item(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
    super(toolMaterial, attackDamage, attackSpeed, settings);
    ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
    builder.put(ReachEntityAttributes.REACH,
        new EntityAttributeModifier("Reach", -2.0D, EntityAttributeModifier.Operation.ADDITION));
    builder.put(ReachEntityAttributes.ATTACK_RANGE,
        new EntityAttributeModifier("Attack range", -2.0D, EntityAttributeModifier.Operation.ADDITION));
  }

  @Override
  public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
    if (entity instanceof PlayerEntity) {
      PlayerEntity player = (PlayerEntity) entity;
      if ((player.isSneaking() || player.hasStatusEffect(StatusEffects.INVISIBILITY)) && !player.getAttributes()
          .hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID)) {
        EntityAttributeInstance entityAttributeInstance = player
            .getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        entityAttributeInstance.removeModifier(ATTACK_BONUS_MODIFIER);
        entityAttributeInstance.addTemporaryModifier(ATTACK_BONUS_MODIFIER);
      } else if (player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE,
          ATTACK_BONUS_MODIFIER_ID)) {
        player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(ATTACK_BONUS_MODIFIER_ID);
      }
    }
  }

  static {
    ATTACK_BONUS_MODIFIER = new EntityAttributeModifier(ATTACK_BONUS_MODIFIER_ID, "Sneaking attack bonus", 1.5D,
        EntityAttributeModifier.Operation.ADDITION);
  }

}