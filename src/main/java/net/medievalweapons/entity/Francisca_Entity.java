package net.medievalweapons.entity;


import net.medievalweapons.item.Francisca_Item;
import net.medievalweapons.network.EntitySpawnPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Francisca_Entity extends AbstractArrow implements ItemSupplier {
    private static final EntityDataAccessor<Boolean> ENCHANTMENT_GLINT;
    private ItemStack francisca;
    private final Set<UUID> piercedEntities = new HashSet<>();

    public Francisca_Entity(EntityType<? extends Francisca_Entity> entityType, Level world, Francisca_Item item) {
        super(entityType, world);
        this.francisca = new ItemStack((ItemLike) item);
    }

    public Francisca_Entity(Level world, LivingEntity owner, RegistryObject<Francisca_Item> item, ItemStack stack) {
        super(item.get().getType(), owner, world);
        this.francisca = new ItemStack(item.get());
        this.francisca = stack.copy();
        this.entityData.set(ENCHANTMENT_GLINT, stack.hasFoil());
    }

    public Francisca_Entity(Level world, double x, double y, double z, Francisca_Item item) {
        super(item.getType(), x, y, z, world);
        this.francisca = new ItemStack((ItemLike) item);
    }

    public Francisca_Entity(RegistryObject<Francisca_Item> item,Level world) {
        super(item.get().getType(), world);
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ENCHANTMENT_GLINT, false);
    }


    public Packet<?> getAddEntityPacket() {
        return EntitySpawnPacket.createPacket(this);
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.francisca.copy();
    }

    public boolean enchantingGlint() {
        return this.entityData.get(ENCHANTMENT_GLINT);
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        int level = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PIERCING, this.francisca);
        Entity hitEntity = entityHitResult.getEntity();
        if (this.piercedEntities.contains(hitEntity.getUUID()) || this.piercedEntities.size() > level) {
            return;
        }
        this.piercedEntities.add(hitEntity.getUUID());
        float damage = ( this.francisca.getItem()).getMaxDamage() * 2.3F;
        if (hitEntity instanceof Animal) {
            int impalingLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.IMPALING, this.francisca);
            if (impalingLevel > 0) {
                damage += impalingLevel * 1.5F;
            }
        }

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
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.75D,1.0,1.0));
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
        if (nbt.contains("francisca", 10)) {
            this.francisca = ItemStack.of(nbt.getCompound("francisca"));
            this.entityData.set(ENCHANTMENT_GLINT, this.francisca.hasFoil());
        }

        this.piercedEntities.clear();
        if (nbt.contains("francisca_hit", 9)) {
            for (Tag hitEntity : nbt.getList("francisca_hit", 10)) {
                this.piercedEntities.add(((CompoundTag) hitEntity).getUUID("UUID"));
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.put("francisca", this.francisca.save(new CompoundTag()));

        ListTag tags = new ListTag();
        for (UUID uuid : this.piercedEntities) {
            CompoundTag c = new CompoundTag();
            c.putUUID("UUID", uuid);
            tags.add(c);
        }
        nbt.put("francisca_hit", tags);
    }

    @Override
    public void tickDespawn() {
        if (this.pickup != AbstractArrow.Pickup.ALLOWED) {
            super.tickDespawn();
        }
    }

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return true;
    }

    @Override
    public ItemStack getItem() {
        return francisca;
    }

    static {
        ENCHANTMENT_GLINT = SynchedEntityData.defineId(Francisca_Entity.class, EntityDataSerializers.BOOLEAN);
    }

    private static DamageSource createDamageSource(Entity entity, Entity owner) {
        return new IndirectEntityDamageSource("francisca", entity, owner).setProjectile();
    }

    public void setDeltaMovement(Player playerEntity, float xRot, float yRot, float v, float v1, float v2) {

    }
}