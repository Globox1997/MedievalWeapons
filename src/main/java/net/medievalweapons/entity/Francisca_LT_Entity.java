package net.medievalweapons.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.item.Francisca_LT_Item;
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
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Francisca_LT_Entity extends PersistentProjectileEntity {
  private static final TrackedData<Boolean> ENCHANTMENT_GLINT;
  private ItemStack francisca_LT;
  private final Set<UUID> piercedEntities = new HashSet<>();

  public Francisca_LT_Entity(EntityType<? extends Francisca_LT_Entity> entityType, World world,
      Francisca_LT_Item item) {
    super(entityType, world);
    this.francisca_LT = new ItemStack(item);
  }

  public Francisca_LT_Entity(World world, LivingEntity owner, Francisca_LT_Item item, ItemStack stack) {
    super(item.getType(), owner, world);
    this.francisca_LT = new ItemStack(item);
    this.francisca_LT = stack.copy();
    this.dataTracker.set(ENCHANTMENT_GLINT, stack.hasGlint());
  }

  @Environment(EnvType.CLIENT)
  public Francisca_LT_Entity(World world, double x, double y, double z, Francisca_LT_Item item) {
    super(item.getType(), x, y, z, world);
    this.francisca_LT = new ItemStack(item);
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

  @Override
  protected ItemStack asItemStack() {
    return this.francisca_LT.copy();
  }

  @Environment(EnvType.CLIENT)
  public boolean enchantingGlint() {
    return this.dataTracker.get(ENCHANTMENT_GLINT);
  }

  @Override
  protected void onEntityHit(EntityHitResult entityHitResult) {
    int level = EnchantmentHelper.getLevel(Enchantments.PIERCING, this.francisca_LT);
    Entity hitEntity = entityHitResult.getEntity();
    if (this.piercedEntities.contains(hitEntity.getUuid()) || this.piercedEntities.size() > level) {
      return;
    }
    this.piercedEntities.add(hitEntity.getUuid());
    float damage = ((Francisca_LT_Item) this.francisca_LT.getItem()).getAttackDamage() * 2;
    if (hitEntity instanceof AnimalEntity) {
      int impalingLevel = EnchantmentHelper.getLevel(Enchantments.IMPALING, this.francisca_LT);
      if (impalingLevel > 0) {
        damage += impalingLevel * 1.5F;
      }
    }

    Entity owner = this.getOwner();
    DamageSource damageSource = createDamageSource(this, owner == null ? this : owner);
    SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_HIT;
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
        this.playSound(soundEvent, 1.0F, 1.0F);
        this.onHit(hitLivingEntity);
      }
    }

    if (this.piercedEntities.size() > level) {
      this.setVelocity(this.getVelocity().multiply(-0.01D, -0.1D, -0.01D));
    } else {
      this.setVelocity(this.getVelocity().multiply(0.75));
    }

  }

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
    if (tag.contains("francisca_lt", 10)) {
      this.francisca_LT = ItemStack.fromTag(tag.getCompound("francisca_lt"));
      this.dataTracker.set(ENCHANTMENT_GLINT, this.francisca_LT.hasGlint());
    }

    this.piercedEntities.clear();
    if (tag.contains("francisca_lt_hit", 9)) {
      for (Tag hitEntity : tag.getList("francisca_lt_hit", 10)) {
        this.piercedEntities.add(((CompoundTag) hitEntity).getUuid("UUID"));
      }
    }
  }

  @Override
  public void writeCustomDataToTag(CompoundTag tag) {
    super.writeCustomDataToTag(tag);
    tag.put("francisca_lt", this.francisca_LT.toTag(new CompoundTag()));

    ListTag tags = new ListTag();
    for (UUID uuid : this.piercedEntities) {
      CompoundTag c = new CompoundTag();
      c.putUuid("UUID", uuid);
      tags.add(c);
    }
    tag.put("francisca_lt_hit", tags);
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
    ENCHANTMENT_GLINT = DataTracker.registerData(Francisca_LT_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
  }

  public static DamageSource createDamageSource(Entity entity, Entity owner) {
    return new ProjectileDamageSource("francisca_lt", entity, owner).setProjectile();
  }

}