package net.medievalweapons.item;

import com.mojang.authlib.GameProfile;


import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

public class Sickle_Item extends SwordItem {

    public Sickle_Item(Tiers toolMaterial, int attackDamage, float attackSpeed, Properties settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.isDeadOrDying() && attacker.level.random.nextFloat() <= 0.01F) {
            if (target instanceof Zombie)
                target.spawnAtLocation(new ItemStack(Items.ZOMBIE_HEAD));
            if (target instanceof Skeleton)
                target.spawnAtLocation(new ItemStack(Items.SKELETON_SKULL));
            if (target instanceof Creeper)
                target.spawnAtLocation(new ItemStack(Items.CREEPER_HEAD));
            if (target instanceof WitherSkeleton)
                target.spawnAtLocation(new ItemStack(Items.WITHER_SKELETON_SKULL));
            if (target instanceof Player) {
                GameProfile gameProfile = ((Player) target).getGameProfile();
                ItemStack playerHead = new ItemStack(Items.PLAYER_HEAD);
                playerHead.getOrCreateTag().put("SkullOwner", NbtUtils.writeGameProfile(new CompoundTag(), gameProfile));
                target.spawnAtLocation(playerHead);
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.getBlock() instanceof BushBlock) {
            Player playerEntity = context.getPlayer();
            ItemStack itemStack = context.getItemInHand();
            if (playerEntity instanceof ServerPlayer)
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) playerEntity, blockPos, itemStack);
            if (!world.isClientSide) {
                int breakedBlocks = 0;

                return InteractionResult.sidedSuccess(world.isClientSide);
            }
            return super.useOn(context);
        }
        return null;
    }
}
