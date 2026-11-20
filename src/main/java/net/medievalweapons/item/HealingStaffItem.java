package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.ParticleInit;
import net.medievalweapons.init.SoundInit;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import java.util.Map;

public class HealingStaffItem extends Item {

    private static final Map<ToolMaterial, Integer> ADDITION = Map.of(ToolMaterial.WOOD, 1, ToolMaterial.STONE, 2, ToolMaterial.IRON, 2, ToolMaterial.GOLD, 3, ToolMaterial.DIAMOND, 4, ToolMaterial.NETHERITE, 5);

    public static final Identifier ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("range_attack_bonus");
    private final int addition;

    public HealingStaffItem(ToolMaterial toolMaterial, int addition, Properties settings) {
        super(settings);
        if (addition == -1) {
            this.addition = ADDITION.get(toolMaterial);
        } else {
            this.addition = addition;
        }
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof Player playerEntity) {
            int i = this.getUseDuration(stack, user) - remainingUseTicks;
            if (i >= 30) {
                if (!world.isClientSide()) {
                    stack.hurtAndBreak(3, playerEntity, user.getUsedItemHand());
                    world.playSound(null, playerEntity.blockPosition(), SoundInit.MAGIC_SHOT_EVENT.value(), SoundSource.PLAYERS, 0.9F, 1.0F);

                    HitResult hitResult = playerEntity.pick(8.0D + addition, 1.0F, false);
                    if (hitResult.getType().equals(HitResult.Type.BLOCK)) {
                        AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(world, hitResult.getLocation().x, hitResult.getLocation().y + 0.1D, hitResult.getLocation().z);
                        areaEffectCloudEntity.setOwner(user);
                        areaEffectCloudEntity.setCustomParticle(ParticleInit.HEALING_AURA_PARTICLE);
                        areaEffectCloudEntity.setRadius((float) this.addition);
                        areaEffectCloudEntity.setDuration(this.addition * 100);
                        areaEffectCloudEntity.setRadiusPerTick(-(12.0F - areaEffectCloudEntity.getRadius()) / 500.0F);
                        areaEffectCloudEntity.addEffect(new MobEffectInstance(MobEffects.INSTANT_HEALTH, 1, 0));
                        world.playSound(null, hitResult.getLocation().x, hitResult.getLocation().y + 0.1D, hitResult.getLocation().z, SoundInit.MAGIC_HEAL_AURA_EVENT.value(), SoundSource.NEUTRAL, 0.9F,
                                1.0F);
                        world.addFreshEntity(areaEffectCloudEntity);
                    }
                }
                playerEntity.getCooldowns().addCooldown(stack, 100 + (this.addition * 20));
                return true;
            }
        }
        return false;
    }

    @Override
    public void onUseTick(Level world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        int i = this.getUseDuration(stack, user) - remainingUseTicks;
        if (user instanceof Player playerEntity) {
            if (i >= 30) {
                if (world.isClientSide()) {
                    HitResult hitResult = playerEntity.pick(8.0D + addition, 0.0F, false);
                    if (hitResult.getType().equals(HitResult.Type.BLOCK)) {
                        playerEntity.level().addParticle(ParticleInit.HEALING_AURA_PARTICLE, hitResult.getLocation().x - 0.2D + world.getRandom().nextDouble() * 0.4D,
                                hitResult.getLocation().y - 0.1D + world.getRandom().nextDouble() * 0.2D, hitResult.getLocation().z - 0.2D + world.getRandom().nextDouble() * 0.4D, 0.0D, 0.0D, 0.0D);
                    }
                    for (int u = 0; u < 3; u++) {
                        playerEntity.level().addParticle(ParticleInit.HEALING_AURA_PARTICLE, playerEntity.getRandomX(0.5D), playerEntity.getRandomY(), playerEntity.getRandomZ(0.5D), 0.0D,
                                0.0D, 0.0D);
                    }
                } else if (i % 80 == 0 && i < 241) {
                    stack.hurtAndBreak(1, playerEntity, user.getUsedItemHand());
                    playerEntity.addEffect((new MobEffectInstance(MobEffects.INSTANT_HEALTH, 1, 0)));
                }
            }
        }
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
        return ItemUseAnimation.BLOCK;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity user) {
        return 72000;
    }

}
