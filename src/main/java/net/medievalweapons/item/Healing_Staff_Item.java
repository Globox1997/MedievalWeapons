package net.medievalweapons.item;

import net.medievalweapons.init.ParticleInit;
import net.medievalweapons.init.SoundInit;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class Healing_Staff_Item extends SwordItem {
    private int addition;
    private @NotNull EntityType<AbstractArrow> cachedType = null;
    private final RegistryObject<EntityType<AbstractArrow>> typeSupplier;


    public EntityType<? extends ThrowableProjectile> getType() {
        if (cachedType == null) {
            cachedType = typeSupplier.get();
        }
        return cachedType;
    }

    public Healing_Staff_Item(Tiers toolMaterial, int attackDamage, float attackSpeed, int addition, Properties settings, RegistryObject<EntityType<AbstractArrow>> typeSupplier) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.addition = addition;
        this.typeSupplier = typeSupplier;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof Player) {
            Player playerEntity = (Player) user;
            int i = this.getUseDuration(stack) - remainingUseTicks;
            if (i >= 30) {
                if (!world.isClientSide) {
                    world.playSound(null, playerEntity.blockPosition(), SoundInit.MAGIC_SHOT_EVENT, SoundSource.PLAYERS, 0.9F, 1.0F);

                        BlockHitResult hitResult = (BlockHitResult) playerEntity.pick(8.0D + addition, 1.0F, false);
                        if (hitResult.getType().equals(BlockHitResult.Type.BLOCK)) {
                            AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(world, hitResult.getBlockPos().getX(), hitResult.getBlockPos().getY() + 0.1D, hitResult.getBlockPos().getZ());
                            areaEffectCloudEntity.setOwner(user);
                            areaEffectCloudEntity.setParticle(ParticleInit.HEALING_AURA_PARTICLE);
                            areaEffectCloudEntity.setRadius((float) this.addition);
                            areaEffectCloudEntity.setDuration(this.addition * 100);
                            areaEffectCloudEntity.setRadiusPerTick(-(12.0F - areaEffectCloudEntity.getRadius()) / 500.0F);
                            areaEffectCloudEntity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
                            world.playSound(null, hitResult.getBlockPos().getX(), hitResult.getBlockPos().getY() + 0.1D, hitResult.getBlockPos().getZ(), SoundInit.MAGIC_HEAL_AURA_EVENT, SoundSource.NEUTRAL, 0.9F, 1.0F);
                            world.addFreshEntity(areaEffectCloudEntity);
                        }
                    }
                }
                playerEntity.getCooldowns().addCooldown(this, 100 + (this.addition * 20));
            }
        }

    @Override
    public void onUseTick(Level world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        int i = this.getUseDuration(stack) - remainingUseTicks;
        if (user instanceof Player) {
            Player playerEntity = (Player) user;
            if (i >= 30) {

                    for (int u = 0; u < 3; u++) {
                        playerEntity.level.addParticle(ParticleInit.HEALING_AURA_PARTICLE, playerEntity.getRandomX(0.5D), playerEntity.getRandomY(), playerEntity.getRandomZ(0.5D), 0.0D, 0.0D,
                                0.0D);
                    }
                }
            }
        }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (itemStack.getMaxDamage() >= itemStack.getMaxDamage() - 1) {
            return InteractionResultHolder.fail(itemStack);
        } else {
            user.startUsingItem(hand);
            return InteractionResultHolder.consume(itemStack);
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BLOCK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

}