package net.medievalweapons.item;

import java.util.List;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.medievalweapons.entity.Javelin_Entity;
import net.medievalweapons.init.ConfigInit;
import net.medievalweapons.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Javelin_Item extends Item implements Vanishable {
  private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

  private final ToolMaterial material;
  private final float attackDamage;
  private final Supplier<EntityType<Javelin_Entity>> typeSupplier;
  private EntityType<Javelin_Entity> cachedType = null;

  public Javelin_Item(ToolMaterial material, float attackDamage, float attackSpeed,
      Supplier<EntityType<Javelin_Entity>> typeSupplier, Item.Settings settings) {
    super(settings.maxDamageIfAbsent(material.getDurability()));
    this.material = material;
    this.attackDamage = attackDamage + material.getAttackDamage();
    this.typeSupplier = typeSupplier;
    ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
    builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
        "Tool modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
    builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
        "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
    this.attributeModifiers = builder.build();
  }

  public EntityType<Javelin_Entity> getType() {
    if (cachedType == null) {
      cachedType = typeSupplier.get();
    }
    return cachedType;
  }

  public ToolMaterial getMaterial() {
    return this.material;
  }

  @Override
  public int getEnchantability() {
    return this.material.getEnchantability();
  }

  @Override
  public boolean canRepair(ItemStack stack, ItemStack ingredient) {
    return this.material.getRepairIngredient().test(ingredient) || super.canRepair(stack, ingredient);
  }

  public float getAttackDamage() {
    return this.attackDamage;
  }

  @Override
  public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
    return !miner.isCreative();
  }

  @Override
  public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
    Block block = state.getBlock();
    if (block == Blocks.COBWEB) {
      return 15.0F;
    } else {
      Material material = state.getMaterial();
      return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && material != Material.UNUSED_PLANT
          && !state.isIn(BlockTags.LEAVES) && material != Material.GOURD ? 1.0F : 1.5F;
    }
  }

  @Override
  public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    stack.damage(1, attacker, entity -> entity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
    return true;
  }

  @Override
  public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
    if (state.getHardness(world, pos) != 0.0F) {
      stack.damage(2, miner, entity -> entity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
    }

    return true;
  }

  @Override
  public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
    return equipmentSlot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot);
  }

  @Override
  public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
    if (user instanceof PlayerEntity) {
      PlayerEntity playerEntity = (PlayerEntity) user;
      int i = this.getMaxUseTime(stack) - remainingUseTicks;
      if (i >= 10) {
        if (!world.isClient) {
          stack.damage(1, playerEntity, entity -> entity.sendToolBreakStatus(user.getActiveHand()));
          Javelin_Entity Javelin_Entity = new Javelin_Entity(world, playerEntity, this, stack);
          Javelin_Entity.setProperties(playerEntity, playerEntity.pitch, playerEntity.yaw, 0.0F, 2.5F, 1.0F);
          if (playerEntity.abilities.creativeMode) {
            Javelin_Entity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
          }
          world.spawnEntity(Javelin_Entity);
          world.playSoundFromEntity(null, Javelin_Entity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F,
              1.0F);
          if (!playerEntity.abilities.creativeMode) {
            playerEntity.inventory.removeOne(stack);
          }
        }

        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
      }
    }
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack itemStack = user.getStackInHand(hand);
    if (itemStack.getDamage() >= itemStack.getMaxDamage() - 1) {
      return TypedActionResult.fail(itemStack);
    } else {
      user.setCurrentHand(hand);
      return TypedActionResult.consume(itemStack);
    }
  }

  @Override
  public UseAction getUseAction(ItemStack stack) {
    return UseAction.SPEAR;
  }

  @Override
  public int getMaxUseTime(ItemStack stack) {
    return 72000;
  }

  @Override
  public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    if (ConfigInit.CONFIG.display_rareness) {
      tooltip.add(ItemInit.rareness(this.getMaterial()));
    }
  }

}