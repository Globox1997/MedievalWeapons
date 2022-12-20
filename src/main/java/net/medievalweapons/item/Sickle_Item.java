package net.medievalweapons.item;

import com.mojang.authlib.GameProfile;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
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
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Sickle_Item extends SwordItem {

    public Sickle_Item(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.isDead() && attacker.world.random.nextFloat() <= 0.01F) {
            if (target instanceof ZombieEntity)
                target.dropStack(new ItemStack(Items.ZOMBIE_HEAD));
            if (target instanceof SkeletonEntity)
                target.dropStack(new ItemStack(Items.SKELETON_SKULL));
            if (target instanceof CreeperEntity)
                target.dropStack(new ItemStack(Items.CREEPER_HEAD));
            if (target instanceof WitherSkeletonEntity)
                target.dropStack(new ItemStack(Items.WITHER_SKELETON_SKULL));
            if (target instanceof PlayerEntity) {
                GameProfile gameProfile = ((PlayerEntity) target).getGameProfile();
                ItemStack playerHead = new ItemStack(Items.PLAYER_HEAD);
                playerHead.getOrCreateNbt().put("SkullOwner", NbtHelper.writeGameProfile(new NbtCompound(), gameProfile));
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
            if (playerEntity instanceof ServerPlayerEntity)
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
            if (!world.isClient) {
                int breakedBlocks = 0;
                for (int i = -1; i < 2; i++) {
                    BlockPos otherBlockPos = blockPos.offset(playerEntity.getHorizontalFacing().rotateYClockwise().getAxis(), i);
                    if (world.getBlockState(otherBlockPos).getBlock() instanceof PlantBlock) {
                        world.breakBlock(otherBlockPos, true, playerEntity);
                        breakedBlocks++;
                    }
                }
                if (playerEntity != null)
                    itemStack.damage(breakedBlocks, playerEntity, player -> player.sendToolBreakStatus(context.getHand()));
            }
            return ActionResult.success(world.isClient);
        }
        return super.useOnBlock(context);
    }
}
