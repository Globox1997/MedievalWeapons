package net.medievalweapons.item;

import net.medievalweapons.init.ConfigInit;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.skeleton.WitherSkeleton;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SickleItem extends Item {

    public SickleItem(Properties settings) {
        super(settings);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.level() instanceof ServerLevel serverLevel && target.isDeadOrDying() && attacker.level().getRandom().nextFloat() <= ConfigInit.CONFIG.sickle_head_drop_chance) {
            if (target instanceof Zombie) {
                target.spawnAtLocation(serverLevel, new ItemStack(Items.ZOMBIE_HEAD));
            } else if (target instanceof Skeleton) {
                target.spawnAtLocation(serverLevel, new ItemStack(Items.SKELETON_SKULL));
            } else if (target instanceof Creeper) {
                target.spawnAtLocation(serverLevel, new ItemStack(Items.CREEPER_HEAD));
            } else if (target instanceof WitherSkeleton) {
                target.spawnAtLocation(serverLevel, new ItemStack(Items.WITHER_SKELETON_SKULL));
            } else if (target instanceof Player playerEntity) {
                ItemStack playerHead = new ItemStack(Items.PLAYER_HEAD);
                playerHead.set(DataComponents.PROFILE, ResolvableProfile.createResolved(playerEntity.getGameProfile()));
                target.spawnAtLocation(serverLevel, playerHead);
            }
        }
        super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.getBlock() instanceof VegetationBlock) {
            Player playerEntity = context.getPlayer();
            ItemStack itemStack = context.getItemInHand();
            if (playerEntity instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) playerEntity, blockPos, itemStack);
            }
            if (!world.isClientSide()) {
                int breakedBlocks = 0;
                for (int i = -1; i < 2; i++) {
                    BlockPos otherBlockPos = blockPos.relative(context.getHorizontalDirection().getClockWise().getAxis(), i);
                    if (world.getBlockState(otherBlockPos).getBlock() instanceof VegetationBlock) {
                        world.destroyBlock(otherBlockPos, true, playerEntity);
                        breakedBlocks++;
                    }
                }
                if (playerEntity != null) {
                    itemStack.hurtAndBreak(breakedBlocks, playerEntity, context.getHand());
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.useOn(context);
    }
}
