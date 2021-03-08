package net.medievalweapons.mixin;

import com.mojang.authlib.GameProfile;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.ConfigInit;
import net.medievalweapons.init.TagInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

  PlayerEntity playerEntity = (PlayerEntity) (Object) this;
  @Shadow
  public final PlayerInventory inventory = new PlayerInventory(playerEntity);

  public PlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
    super(EntityType.PLAYER, world);
  }

  // Use item tag for both hand using
  @Inject(method = "tickMovement", at = @At("HEAD"))
  public void tickMovementMixin(CallbackInfo info) {
    if (ConfigInit.CONFIG.auto_switch && (playerEntity.getMainHandStack().getItem().isIn(TagInit.DOUBLE_HANDED_ITEMS)
        || playerEntity.getMainHandStack().getItem().isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS))) {
      if (!this.inventory.offHand.get(0).isEmpty() && !this.world.isClient) {
        for (int k = 0; k < this.inventory.offHand.size(); ++k) {
          ItemStack stack = this.inventory.offHand.get(k);
          this.inventory.setStack(this.inventory.getEmptySlot(), stack);
        }
        this.inventory.offHand.clear();
      }
    }
  }
}
