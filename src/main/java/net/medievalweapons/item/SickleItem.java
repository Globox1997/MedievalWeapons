package net.medievalweapons.item;

import net.medievalweapons.init.ConfigInit;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ProfileComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SickleItem extends SwordItem {

    public SickleItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.isDead() && attacker.getWorld().getRandom().nextFloat() <= ConfigInit.CONFIG.sickle_head_drop_chance) {
            if (target instanceof ZombieEntity) {
                target.dropStack(new ItemStack(Items.ZOMBIE_HEAD));
            } else if (target instanceof SkeletonEntity) {
                target.dropStack(new ItemStack(Items.SKELETON_SKULL));
            } else if (target instanceof CreeperEntity) {
                target.dropStack(new ItemStack(Items.CREEPER_HEAD));
            } else if (target instanceof WitherSkeletonEntity) {
                target.dropStack(new ItemStack(Items.WITHER_SKELETON_SKULL));
            } else if (target instanceof PlayerEntity playerEntity) {
                ItemStack playerHead = new ItemStack(Items.PLAYER_HEAD);
                playerHead.set(DataComponentTypes.PROFILE, new ProfileComponent(playerEntity.getGameProfile()));
                target.dropStack(playerHead);
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.getBlock() instanceof PlantBlock) {
            PlayerEntity playerEntity = context.getPlayer();
            ItemStack itemStack = context.getStack();
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
            }
            if (!world.isClient()) {
                int breakedBlocks = 0;
                for (int i = -1; i < 2; i++) {
                    BlockPos otherBlockPos = blockPos.offset(playerEntity.getHorizontalFacing().rotateYClockwise().getAxis(), i);
                    if (world.getBlockState(otherBlockPos).getBlock() instanceof PlantBlock) {
                        world.breakBlock(otherBlockPos, true, playerEntity);
                        breakedBlocks++;
                    }
                }
                if (playerEntity != null) {
                    itemStack.damage(breakedBlocks, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                }
            }
            return ActionResult.success(world.isClient);
        }
        return super.useOnBlock(context);
    }
}
