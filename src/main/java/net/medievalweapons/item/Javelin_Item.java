package net.medievalweapons.item;

import java.util.function.Supplier;

import net.medievalweapons.entity.Javelin_Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class Javelin_Item extends SwordItem {

    private final Supplier<EntityType<Javelin_Entity>> typeSupplier;
    private EntityType<Javelin_Entity> cachedType = null;

    public Javelin_Item(Tiers toolMaterial, float attackDamage, float attackSpeed, Supplier<EntityType<Javelin_Entity>> typeSupplier, Properties settings) {
        super(toolMaterial, (int) attackDamage, attackSpeed, settings);
        this.typeSupplier = typeSupplier;
    }

    public EntityType<Javelin_Entity> getType() {
        if (cachedType == null) {
            cachedType = typeSupplier.get();
        }
        return cachedType;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof Player) {
            Player playerEntity = (Player) user;
            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            if (i >= 10) {
                if (!world.isClientSide) {
                    stack.hurt(1, playerEntity, entity -> entity.broadcastBreakEvent(user.getUsedItemHand()));
                    Javelin_Entity Javelin_Entity = new Javelin_Entity(world, playerEntity, this, stack);
                    Javelin_Entity.setD(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, 2.5F, 1.0F);
                    if (playerEntity.isCreative()) {
                        Javelin_Entity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                    }
                    world.spawnEntity(Javelin_Entity);
                    world.playSoundFromEntity(null, Javelin_Entity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    if (!playerEntity.isCreative()) {
                        playerEntity.getInventory().removeOne(stack);
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

}