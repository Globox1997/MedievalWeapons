package net.medievalweapons.entity;


import net.medievalweapons.item.Javelin_Item;
import net.medievalweapons.network.EntitySpawnPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class Javelin_Entity extends AbstractArrow implements ItemSupplier {
    private static final EntityDataAccessor<Byte> LOYALTY;
    private static final EntityDataAccessor<Boolean> ENCHANTMENT_GLINT;
    private ItemStack javelin;
    private final Set<UUID> piercedEntities = new HashSet<>();
    public int returnTimer;
    private boolean dealtDamage;

    public Javelin_Entity(EntityType<? extends Javelin_Entity> entityType, Level world, RegistryObject<Javelin_Item> item) {
        super(entityType, world);
        this.javelin = new ItemStack(item.get());
    }

    public Javelin_Entity(Level world, LivingEntity owner, Javelin_Item item, ItemStack stack) {
        super( item.getType(), owner, world);
        this.javelin = new ItemStack(item);
        this.javelin = stack.copy();
        this.entityData.set(ENCHANTMENT_GLINT, stack.hasFoil());
        this.entityData.set(LOYALTY, (byte) EnchantmentHelper.getLoyalty(stack));
    }

    public Javelin_Entity(EntityType<? extends AbstractArrow> entity, LivingEntity world,
                          Level item) {
        super(entity, world, item);
    }




    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LOYALTY, (byte) 0);
        this.entityData.define(ENCHANTMENT_GLINT, false);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return EntitySpawnPacket.createPacket(this);
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.javelin.copy();
    }

    public boolean enchantingGlint() {
        return this.entityData.get(ENCHANTMENT_GLINT);
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        int level = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PIERCING, this.javelin);
        Entity hitEntity = entityHitResult.getEntity();
        if (this.piercedEntities.contains(hitEntity.getUUID()) || this.piercedEntities.size() > level) {
            return;
        }
        this.piercedEntities.add(hitEntity.getUUID());
        float damage = ((Javelin_Item) this.javelin.getItem()).getDamage() * 2.35F;
        if (hitEntity instanceof Animal) {
            int impalingLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.IMPALING, this.javelin);
            if (impalingLevel > 0) {
                damage += impalingLevel * 1.5F;
            }
        }
        this.dealtDamage = true;
        Entity owner = this.getOwner();
        DamageSource damageSource = createDamageSource(this, owner == null ? this : owner);
        SoundEvent soundEvent = SoundEvents.TRIDENT_HIT;

        if (hitEntity.hurt(damageSource, damage)) {
            if (hitEntity.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (hitEntity instanceof LivingEntity) {
                LivingEntity hitLivingEntity = (LivingEntity) hitEntity;
                if (owner instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(hitLivingEntity, owner);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity) owner, hitLivingEntity);
                }
                this.playSound(soundEvent, 1.0F, 1.0F);
                this.onHit(entityHitResult);
            }
        }

        if (this.piercedEntities.size() > level) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        } else {
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.75,1.0,1.0));
        }

    }

    @Override
    @Nullable
    protected EntityHitResult findHitEntity(Vec3 currentPosition, Vec3 nextPosition) {
        return this.dealtDamage ? null : super.findHitEntity(currentPosition, nextPosition);
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }
        Entity entity = this.getOwner();
        byte i = this.entityData.get(LOYALTY);
        if (i > 0 && (this.dealtDamage || this.isNoPhysics()) && entity != null) {
            if (!this.isOwnerAlive()) {
                if (!this.level.isClientSide && this.pickup == AbstractArrow.Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1f);
                }
                this.discard();
            } else {
                this.setNoPhysics(true);
                Vec3 vec3d = entity.getEyePosition().subtract(this.getPosition(1.0F));
                this.setPos(this.getX(), this.getY() + vec3d.y * 0.015 * (double) i, this.getZ());
                if (this.level.isClientSide) {
                    this.yOld = this.getY();
                }
                double d = 0.05 * (double) i;
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.95,1.0,1.0).add(vec3d.normalize().multiply(1D,1,1)));
                if (this.returnTimer == 0) {
                    this.playSound(SoundEvents.TRIDENT_RETURN, 10.0f, 1.0f);
                }
                ++this.returnTimer;
            }
        }
        super.tick();
    }

    private boolean isOwnerAlive() {
        Entity entity = this.getOwner();
        if (entity != null && entity.isAlive()) {
            return !(entity instanceof ServerPlayer) || !entity.isSpectator();
        } else {
            return false;
        }
    }

    @Override
    public void playerTouch(Player player) {
        Entity entity = this.getOwner();
        if (entity == null || entity.getUUID() == player.getUUID()) {
            super.playerTouch(player);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("javelin", 10)) {
            this.javelin = ItemStack.of(nbt.getCompound("javelin"));
            this.entityData.set(ENCHANTMENT_GLINT, this.javelin.hasFoil());
        }

        this.piercedEntities.clear();
        if (nbt.contains("javelin_hit", 9)) {
            for (Tag hitEntity : nbt.getList("javelin_hit", 10)) {
                this.piercedEntities.add(((CompoundTag) hitEntity).getUUID("UUID"));
            }
        }
        this.dealtDamage = nbt.getBoolean("DealtDamage");
        this.entityData.set(LOYALTY, (byte) EnchantmentHelper.getLoyalty(this.javelin));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.put("javelin", this.javelin.save(new CompoundTag()));

        ListTag tags = new ListTag();
        for (UUID uuid : this.piercedEntities) {
            CompoundTag c = new CompoundTag();
            c.putUUID("UUID", uuid);
            tags.add(c);
        }
        nbt.putBoolean("DealtDamage", this.dealtDamage);
        nbt.put("javelin_hit", tags);
    }

    @Override
    public void tickDespawn() {
        int i = (Byte) this.entityData.get(LOYALTY);
        if (this.pickup != AbstractArrow.Pickup.ALLOWED || i <= 0) {
            super.tickDespawn();
        }

    }

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return true;
    }

    @Override
    public ItemStack getItem() {
        return javelin;
    }

    static {
        LOYALTY = SynchedEntityData.defineId(Javelin_Entity.class, EntityDataSerializers.BYTE);
        ENCHANTMENT_GLINT = SynchedEntityData.defineId(Javelin_Entity.class, EntityDataSerializers.BOOLEAN);
    }

    private static DamageSource createDamageSource(Entity entity, Entity owner) {
        return new IndirectEntityDamageSource("javelin", entity, owner).setProjectile();
    }

    public void setDeltaMovement(Player playerEntity, float xRot, float yRot, float v, float v1, float v2) {

    }
}