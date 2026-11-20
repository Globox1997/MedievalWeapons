package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;import net.medievalweapons.entity.JavelinEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.resources.Identifier;import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class JavelinItem extends Item implements ProjectileItem {

    public static final Identifier ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("range_attack_bonus");
    private final ToolMaterial material;
    private final Supplier<EntityType<JavelinEntity>> typeSupplier;
    private EntityType<JavelinEntity> cachedType = null;

    public JavelinItem(ToolMaterial toolMaterial, Supplier<EntityType<JavelinEntity>> typeSupplier, Item.Properties settings) {
        super(settings);
        this.material = toolMaterial;
        this.typeSupplier = typeSupplier;
    }

    public ToolMaterial getMaterial() {
        return this.material;
    }

    public EntityType<JavelinEntity> getType() {
        if (cachedType == null) {
            cachedType = typeSupplier.get();
        }
        return cachedType;
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof Player playerEntity) {
            int i = this.getUseDuration(stack, user) - remainingUseTicks;
            if (i >= 10) {
                if (!world.isClientSide()) {
                    stack.hurtAndBreak(1, playerEntity, user.getUsedItemHand());
                    JavelinEntity javelinEntity = new JavelinEntity(world, playerEntity, stack);
                    javelinEntity.shootFromRotation(playerEntity, playerEntity.getXRot(), playerEntity.getYRot(), 0.0F, 2.5F, 1.0F);
                    if (playerEntity.isCreative()) {
                        javelinEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                    }
                    world.addFreshEntity(javelinEntity);
                    world.playSound(null, javelinEntity, SoundEvents.TRIDENT_THROW.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                    if (!playerEntity.isCreative()) {
                        playerEntity.getInventory().removeItem(stack);
                    }
                }

                playerEntity.awardStat(Stats.ITEM_USED.get(this));
                return true;
            }
        }
        return false;
    }

    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (itemStack.getDamageValue() >= itemStack.getMaxDamage() - 1) {
            return InteractionResult.FAIL;
        } else {
            user.startUsingItem(hand);
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.TRIDENT;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public Projectile asProjectile(Level world, Position pos, ItemStack stack, Direction direction) {
        JavelinEntity javelinEntity = new JavelinEntity(world, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1));
        javelinEntity.pickup = AbstractArrow.Pickup.ALLOWED;
        return javelinEntity;
    }

}
