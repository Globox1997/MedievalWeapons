package net.medievalweapons.item;

import net.medievalweapons.entity.Healing_Ball_Entity;
import net.medievalweapons.init.ParticleInit;
import net.medievalweapons.init.SoundInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class Healing_Staff_Item extends SwordItem {
  private int addition;

  public Healing_Staff_Item(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, int addition,
      Settings settings) {
    super(toolMaterial, attackDamage, attackSpeed, settings);
    this.addition = addition;
  }

  @Override
  public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
    if (user instanceof PlayerEntity) {
      PlayerEntity playerEntity = (PlayerEntity) user;
      int i = this.getMaxUseTime(stack) - remainingUseTicks;
      if (i >= 40) {
        if (!world.isClient) {
          stack.damage(2, playerEntity, entity -> entity.sendToolBreakStatus(user.getActiveHand()));
          Healing_Ball_Entity healing_Ball_Entity = new Healing_Ball_Entity(user, world, this.addition);
          healing_Ball_Entity.setProperties(playerEntity, playerEntity.pitch, playerEntity.yaw, 0.0F, 0.5F, 1.0F);
          healing_Ball_Entity.setPos(playerEntity.getX(), playerEntity.getY() + 1.6D, playerEntity.getZ());
          world.spawnEntity(healing_Ball_Entity);
          world.playSound(null, playerEntity.getBlockPos(), SoundInit.MAGIC_SHOT_EVENT, SoundCategory.PLAYERS, 0.9F,
              1.0F);
        }
        playerEntity.getItemCooldownManager().set(this, 100 + (this.addition * 20));
      }
    }
  }

  @Override
  public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
    int i = this.getMaxUseTime(stack) - remainingUseTicks;
    if (user instanceof PlayerEntity) {
      PlayerEntity playerEntity = (PlayerEntity) user;
      if (i >= 40) {
        if (playerEntity.world.isClient) {
          for (int u = 0; u < 3; u++) {
            playerEntity.world.addParticle(ParticleInit.HEALING_AURA_PARTICLE, playerEntity.getParticleX(0.5D),
                playerEntity.getRandomBodyY(), playerEntity.getParticleZ(0.5D), 0.0D, 0.0D, 0.0D);
          }
        } else if (i % 80 == 0 && i < 241) {
          playerEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0)));
        }
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
    return UseAction.BLOCK;
  }

  @Override
  public int getMaxUseTime(ItemStack stack) {
    return 72000;
  }

}