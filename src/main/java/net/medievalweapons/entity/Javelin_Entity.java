package net.medievalweapons.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.item.Javelin_Item;
import net.medievalweapons.network.EntitySpawnPacket;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.Packet;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Javelin_Entity extends PersistentProjectileEntity {
  private static final TrackedData<Boolean> ENCHANTMENT_GLINT;
  private ItemStack javelin;
  private final Set<UUID> piercedEntities = new HashSet<>();

  public Javelin_Entity(EntityType<? extends Javelin_Entity> entityType, World world, Javelin_Item item) {
    super(entityType, world);
    this.javelin = new ItemStack(item);
  }

  public Javelin_Entity(World world, LivingEntity owner, Javelin_Item item, ItemStack stack) {
    super(item.getType(), owner, world);
    this.javelin = new ItemStack(item);
    this.javelin = stack.copy();
    this.dataTracker.set(ENCHANTMENT_GLINT, stack.hasGlint());
  }

  @Environment(EnvType.CLIENT)
  public Javelin_Entity(World world, double x, double y, double z, Javelin_Item item) {
    super(item.getType(), x, y, z, world);
    this.javelin = new ItemStack(item);
  }

  @Override
  protected void initDataTracker() {
    super.initDataTracker();
    this.dataTracker.startTracking(ENCHANTMENT_GLINT, false);
  }

  @Override
  public Packet<?> createSpawnPacket() {
    return EntitySpawnPacket.createPacket(this);
  }

  // public Packet<?> createSpawnPacket() {
  // Entity entity = this.getOwner();
  // return new EntitySpawnS2CPacket(this, entity == null ? 0 :
  // entity.getEntityId());
  // }

  @Override
  protected ItemStack asItemStack() {
    return this.javelin.copy();
  }

  @Environment(EnvType.CLIENT)
  public boolean enchantingGlint() {
    return this.dataTracker.get(ENCHANTMENT_GLINT);
  }

  @Override
  protected void onEntityHit(EntityHitResult entityHitResult) {
    int level = EnchantmentHelper.getLevel(Enchantments.PIERCING, this.javelin);
    Entity hitEntity = entityHitResult.getEntity();
    if (this.piercedEntities.contains(hitEntity.getUuid()) || this.piercedEntities.size() > level) {
      return;
    }
    this.piercedEntities.add(hitEntity.getUuid());
    float damage = ((Javelin_Item) this.javelin.getItem()).getAttackDamage() * 2;
    if (hitEntity instanceof AnimalEntity) {
      int impalingLevel = EnchantmentHelper.getLevel(Enchantments.IMPALING, this.javelin);
      if (impalingLevel > 0) {
        damage += impalingLevel * 1.5F;
      }
    }

    Entity owner = this.getOwner();
    DamageSource damageSource = createDamageSource(this, owner == null ? this : owner);
    // SoundEvent soundEvent = CampanionSoundEvents.SPEAR_HIT_FLESH;
    if (hitEntity.damage(damageSource, damage)) {
      if (hitEntity.getType() == EntityType.ENDERMAN) {
        return;
      }

      if (hitEntity instanceof LivingEntity) {
        LivingEntity hitLivingEntity = (LivingEntity) hitEntity;
        if (owner instanceof LivingEntity) {
          EnchantmentHelper.onUserDamaged(hitLivingEntity, owner);
          EnchantmentHelper.onTargetDamaged((LivingEntity) owner, hitLivingEntity);
        }

        this.onHit(hitLivingEntity);
      }
    }

    if (this.piercedEntities.size() > level) {
      this.setVelocity(this.getVelocity().multiply(-0.01D, -0.1D, -0.01D));
    } else {
      this.setVelocity(this.getVelocity().multiply(0.75));
    }
    // this.playSound(soundEvent, 1.0F, 1.0F);
  }

  // @Override
  // protected SoundEvent getHitSound() {
  // return CampanionSoundEvents.SPEAR_HIT_GROUND;
  // }

  @Override
  public void onPlayerCollision(PlayerEntity player) {
    Entity entity = this.getOwner();
    if (entity == null || entity.getUuid() == player.getUuid()) {
      super.onPlayerCollision(player);
    }
  }

  @Override
  public void readCustomDataFromTag(CompoundTag tag) {
    super.readCustomDataFromTag(tag);
    if (tag.contains("javelin", 10)) {
      this.javelin = ItemStack.fromTag(tag.getCompound("javelin"));
      this.dataTracker.set(ENCHANTMENT_GLINT, this.javelin.hasGlint());
    }

    this.piercedEntities.clear();
    if (tag.contains("javelin_hit", 9)) {
      for (Tag hitEntity : tag.getList("javelin_hit", 10)) {
        this.piercedEntities.add(((CompoundTag) hitEntity).getUuid("UUID"));
      }
    }
  }

  @Override
  public void writeCustomDataToTag(CompoundTag tag) {
    super.writeCustomDataToTag(tag);
    tag.put("javelin", this.javelin.toTag(new CompoundTag()));

    ListTag tags = new ListTag();
    for (UUID uuid : this.piercedEntities) {
      CompoundTag c = new CompoundTag();
      c.putUuid("UUID", uuid);
      tags.add(c);
    }
    tag.put("javelin_hit", tags);
  }

  @Override
  public void age() {
    if (this.pickupType != PersistentProjectileEntity.PickupPermission.ALLOWED) {
      super.age();
    }
  }

  @Override
  @Environment(EnvType.CLIENT)
  public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
    return true;
  }

  static {
    ENCHANTMENT_GLINT = DataTracker.registerData(Javelin_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
  }

  public static DamageSource createDamageSource(Entity entity, Entity owner) {
    return new ProjectileDamageSource("javelin", entity, owner).setProjectile();
  }

}