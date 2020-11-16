package net.medievalweapons.entity;

import net.fabricmc.api.Environment;
import net.medievalweapons.item.Big_Axe_Item;
import net.medievalweapons.network.EntitySpawnPacket;
import net.fabricmc.api.EnvType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

public class Big_Axe_Entity extends Entity {
  private static final TrackedData<Boolean> ENCHANTMENT_GLINT;
  private ItemStack stack;;

  public Big_Axe_Entity(EntityType<?> type, World world) {
    super(type, world);
  }

  public Big_Axe_Entity(EntityType<? extends Big_Axe_Entity> entityType, World world, Big_Axe_Item item) {
    super(entityType, world);
    this.stack = new ItemStack(item);
    this.dataTracker.set(ENCHANTMENT_GLINT, stack.hasGlint());
  }

  @Environment(EnvType.CLIENT)
  public boolean enchantingGlint() {
    return this.dataTracker.get(ENCHANTMENT_GLINT);
  }

  @Override
  protected void initDataTracker() {
    this.dataTracker.startTracking(ENCHANTMENT_GLINT, false);
  }

  @Override
  protected void readCustomDataFromTag(CompoundTag tag) {
    if (tag.contains("big_axe", 10)) {
      this.dataTracker.set(ENCHANTMENT_GLINT, this.stack.hasGlint());
    }
  }

  @Override
  protected void writeCustomDataToTag(CompoundTag tag) {
    tag.put("big_axe", this.stack.toTag(new CompoundTag()));
  }

  @Override
  public Packet<?> createSpawnPacket() {
    return EntitySpawnPacket.createPacket(this);
  }

  static {
    ENCHANTMENT_GLINT = DataTracker.registerData(Big_Axe_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
  }

}
