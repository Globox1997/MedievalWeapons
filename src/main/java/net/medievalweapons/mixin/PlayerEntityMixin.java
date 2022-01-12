package net.medievalweapons.mixin;

import com.mojang.authlib.GameProfile;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.ConfigInit;
import net.medievalweapons.item.Mace_Item;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    @Shadow
    public final PlayerInventory inventory = new PlayerInventory((PlayerEntity) (Object) this);

    public PlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
        super(EntityType.PLAYER, world);
    }

    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getSweepingMultiplier(Lnet/minecraft/entity/LivingEntity;)F"))
    public void attackMixin(Entity target, CallbackInfo info) {
        ItemStack itemStack = this.getStackInHand(Hand.MAIN_HAND);
        if (!this.world.isClient && itemStack.getItem() instanceof Mace_Item && target instanceof LivingEntity) {
            Mace_Item mace_Item = (Mace_Item) itemStack.getItem();
            if (this.world.random.nextFloat() <= 0.1F + ((float) mace_Item.getAddition() / 10F)) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60 + mace_Item.getAddition() * 20, 0, false, false, true));
            }
        }
    }

    @Inject(method = "takeShieldHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;takeShieldHit(Lnet/minecraft/entity/LivingEntity;)V", shift = Shift.AFTER))
    public void takeShieldHitMixin(LivingEntity attacker, CallbackInfo info) {
        if (!(attacker.getMainHandStack().getItem() instanceof AxeItem)) {
            PlayerEntity playerEntity = (PlayerEntity) (Object) this;
            playerEntity.getItemCooldownManager().set(Items.SHIELD, ConfigInit.CONFIG.shield_blocking_cooldown);
            playerEntity.clearActiveItem();
        }

    }

}