package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.ParticleInit;
import net.medievalweapons.init.SoundInit;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.Map;

public class HealingStaffItem extends SwordItem {

    private static final Map<ToolMaterial, Integer> ADDITION = Map.of(ToolMaterials.WOOD, 1, ToolMaterials.STONE, 2, ToolMaterials.IRON, 2, ToolMaterials.GOLD, 3, ToolMaterials.DIAMOND, 4, ToolMaterials.NETHERITE, 5);

    public static final Identifier ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("range_attack_bonus");
    private final int addition;

    public HealingStaffItem(ToolMaterial toolMaterial, int addition, Settings settings) {
        super(toolMaterial, settings);
        if (addition == -1) {
            this.addition = ADDITION.get(toolMaterial);
        } else {
            this.addition = addition;
        }
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack, user) - remainingUseTicks;
            if (i >= 30) {
                if (!world.isClient()) {
                    stack.damage(3, playerEntity, LivingEntity.getSlotForHand(user.getActiveHand()));
                    world.playSound(null, playerEntity.getBlockPos(), SoundInit.MAGIC_SHOT_EVENT, SoundCategory.PLAYERS, 0.9F, 1.0F);

                    HitResult hitResult = playerEntity.raycast(8.0D + addition, 1.0F, false);
                    if (hitResult.getType().equals(HitResult.Type.BLOCK)) {
                        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(world, hitResult.getPos().x, hitResult.getPos().y + 0.1D, hitResult.getPos().z);
                        areaEffectCloudEntity.setOwner(user);
                        areaEffectCloudEntity.setParticleType(ParticleInit.HEALING_AURA_PARTICLE);
                        areaEffectCloudEntity.setRadius((float) this.addition);
                        areaEffectCloudEntity.setDuration(this.addition * 100);
                        areaEffectCloudEntity.setRadiusGrowth(-(12.0F - areaEffectCloudEntity.getRadius()) / 500.0F);
                        areaEffectCloudEntity.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0));
                        world.playSound(null, hitResult.getPos().x, hitResult.getPos().y + 0.1D, hitResult.getPos().z, SoundInit.MAGIC_HEAL_AURA_EVENT, SoundCategory.NEUTRAL, 0.9F, 1.0F);
                        world.spawnEntity(areaEffectCloudEntity);
                    }
                }
                playerEntity.getItemCooldownManager().set(this, 100 + (this.addition * 20));
            }
        }
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        int i = this.getMaxUseTime(stack, user) - remainingUseTicks;
        if (user instanceof PlayerEntity playerEntity) {
            if (i >= 30) {
                if (world.isClient()) {
                    HitResult hitResult = playerEntity.raycast(8.0D + addition, 0.0F, false);
                    if (hitResult.getType().equals(HitResult.Type.BLOCK)) {
                        playerEntity.getWorld().addParticle(ParticleInit.HEALING_AURA_PARTICLE, hitResult.getPos().x - 0.2D + world.random.nextDouble() * 0.4D,
                                hitResult.getPos().y - 0.1D + world.random.nextDouble() * 0.2D, hitResult.getPos().z - 0.2D + world.random.nextDouble() * 0.4D, 0.0D, 0.0D, 0.0D);
                    }
                    for (int u = 0; u < 3; u++) {
                        playerEntity.getWorld().addParticle(ParticleInit.HEALING_AURA_PARTICLE, playerEntity.getParticleX(0.5D), playerEntity.getRandomBodyY(), playerEntity.getParticleZ(0.5D), 0.0D,
                                0.0D, 0.0D);
                    }
                } else if (i % 80 == 0 && i < 241) {
                    stack.damage(1, playerEntity, LivingEntity.getSlotForHand(user.getActiveHand()));
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
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

}
