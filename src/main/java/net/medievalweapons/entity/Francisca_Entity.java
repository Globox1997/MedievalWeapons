package net.medievalweapons.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.item.Francisca_Item;
import net.medievalweapons.network.EntitySpawnPacket;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
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
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.Packet;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Francisca_Entity extends PersistentProjectileEntity implements FlyingItemEntity {
    private static final TrackedData<Boolean> ENCHANTMENT_GLINT;
    private ItemStack francisca;
    private final Set<UUID> piercedEntities = new HashSet<>();

    public Francisca_Entity(EntityType<? extends Francisca_Entity> entityType, World world, Francisca_Item item) {
        super(entityType, world);
        this.francisca = new ItemStack(item);
    }

    public Francisca_Entity(World world, LivingEntity owner, Francisca_Item item, ItemStack stack) {
        super(item.getType(), owner, world);
        this.francisca = new ItemStack(item);
        this.francisca = stack.copy();
        this.dataTracker.set(ENCHANTMENT_GLINT, stack.hasGlint());
    }

    @Environment(EnvType.CLIENT)
    public Francisca_Entity(World world, double x, double y, double z, Francisca_Item item) {
        super(item.getType(), x, y, z, world);
        this.francisca = new ItemStack(item);
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
        return this.francisca.copy();
    }

    @Environment(EnvType.CLIENT)
    public boolean enchantingGlint() {
        return this.dataTracker.get(ENCHANTMENT_GLINT);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        int level = EnchantmentHelper.getLevel(Enchantments.PIERCING, this.francisca);
        Entity hitEntity = entityHitResult.getEntity();
        if (this.piercedEntities.contains(hitEntity.getUuid()) || this.piercedEntities.size() > level) {
            return;
        }
        this.piercedEntities.add(hitEntity.getUuid());
        float damage = ((Francisca_Item) this.francisca.getItem()).getAttackDamage() * 2.3F;
        if (hitEntity instanceof AnimalEntity) {
            int impalingLevel = EnchantmentHelper.getLevel(Enchantments.IMPALING, this.francisca);
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
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("francisca", 10)) {
            this.francisca = ItemStack.fromNbt(nbt.getCompound("francisca"));
            this.dataTracker.set(ENCHANTMENT_GLINT, this.francisca.hasGlint());
        }

        this.piercedEntities.clear();
        if (nbt.contains("francisca_hit", 9)) {
            for (NbtElement hitEntity : nbt.getList("francisca_hit", 10)) {
                this.piercedEntities.add(((NbtCompound) hitEntity).getUuid("UUID"));
            }
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.put("francisca", this.francisca.writeNbt(new NbtCompound()));

        NbtList tags = new NbtList();
        for (UUID uuid : this.piercedEntities) {
            NbtCompound c = new NbtCompound();
            c.putUuid("UUID", uuid);
            tags.add(c);
        }
        nbt.put("francisca_hit", tags);
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

    @Override
    public ItemStack getStack() {
        return francisca;
    }

    static {
        ENCHANTMENT_GLINT = DataTracker.registerData(Francisca_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    private static DamageSource createDamageSource(Entity entity, Entity owner) {
        return new ProjectileDamageSource("francisca", entity, owner).setProjectile();
    }

}