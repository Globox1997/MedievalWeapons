package net.medievalweapons.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.levelz.access.PlayerStatsManagerAccess;
import net.levelz.init.ConfigInit;
import net.levelz.stats.Skill;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.EntityInit;
import net.medievalweapons.item.Javelin_Item;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.jetbrains.annotations.Nullable;

public class Javelin_Entity extends PersistentProjectileEntity implements FlyingItemEntity {
    private static final TrackedData<Byte> LOYALTY;
    private static final TrackedData<Boolean> ENCHANTMENT_GLINT;
    private ItemStack javelin;
    private final Set<UUID> piercedEntities = new HashSet<>();
    public int returnTimer;
    private boolean dealtDamage;

    public Javelin_Entity(EntityType<? extends Javelin_Entity> entityType, World world, Javelin_Item item) {
        super(entityType, world);
        this.javelin = new ItemStack(item);
    }

    public Javelin_Entity(World world, LivingEntity owner, Javelin_Item item, ItemStack stack) {
        super(item.getType(), owner, world);
        this.javelin = new ItemStack(item);
        this.javelin = stack.copy();
        this.dataTracker.set(ENCHANTMENT_GLINT, stack.hasGlint());
        this.dataTracker.set(LOYALTY, (byte) EnchantmentHelper.getLoyalty(stack));
    }

    @Environment(EnvType.CLIENT)
    public Javelin_Entity(World world, double x, double y, double z, Javelin_Item item) {
        super(item.getType(), x, y, z, world);
        this.javelin = new ItemStack(item);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(LOYALTY, (byte) 0);
        this.dataTracker.startTracking(ENCHANTMENT_GLINT, false);
    }

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
        float damage = ((Javelin_Item) this.javelin.getItem()).getAttackDamage() * 2.35F;
        if (hitEntity instanceof LivingEntity && ((LivingEntity) hitEntity).getGroup() == EntityGroup.AQUATIC) {
            int impalingLevel = EnchantmentHelper.getLevel(Enchantments.IMPALING, this.javelin);
            if (impalingLevel > 0) {
                damage += impalingLevel * 1.5F;
            }
        }
        this.dealtDamage = true;

        Entity owner = this.getOwner();
        if (CompatInit.isLevelZLoaded && owner instanceof PlayerEntity) {
            int archeryLevel = ((PlayerStatsManagerAccess) owner).getPlayerStatsManager().getSkillLevel(Skill.ARCHERY);
            damage += archeryLevel >= ConfigInit.CONFIG.maxLevel && ConfigInit.CONFIG.archeryDoubleDamageChance > this.getWorld().getRandom().nextFloat() ? damage
                    : (double) archeryLevel * ConfigInit.CONFIG.archeryBowExtraDamage;
        }

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

                int fireAspectLevel = EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, this.javelin);
                if (fireAspectLevel > 0) {
                    hitLivingEntity.setOnFireFor(fireAspectLevel * 4);
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
    @Nullable
    protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        return this.dealtDamage ? null : super.getEntityCollision(currentPosition, nextPosition);
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }
        Entity entity = this.getOwner();
        byte i = this.dataTracker.get(LOYALTY);
        if (i > 0 && (this.dealtDamage || this.isNoClip()) && entity != null) {
            if (!this.isOwnerAlive()) {
                if (!this.getWorld().isClient() && this.pickupType == PersistentProjectileEntity.PickupPermission.ALLOWED) {
                    this.dropStack(this.asItemStack(), 0.1f);
                }
                this.discard();
            } else {
                this.setNoClip(true);
                Vec3d vec3d = entity.getEyePos().subtract(this.getPos());
                this.setPos(this.getX(), this.getY() + vec3d.y * 0.015 * (double) i, this.getZ());
                if (this.getWorld().isClient()) {
                    this.lastRenderY = this.getY();
                }
                double d = 0.05 * (double) i;
                this.setVelocity(this.getVelocity().multiply(0.95).add(vec3d.normalize().multiply(d)));
                if (this.returnTimer == 0) {
                    this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0f, 1.0f);
                }
                ++this.returnTimer;
            }
        }
        super.tick();
    }

    private boolean isOwnerAlive() {
        Entity entity = this.getOwner();
        if (entity != null && entity.isAlive()) {
            return !(entity instanceof ServerPlayerEntity) || !entity.isSpectator();
        } else {
            return false;
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
        if (nbt.contains("javelin", 10)) {
            this.javelin = ItemStack.fromNbt(nbt.getCompound("javelin"));
            this.dataTracker.set(ENCHANTMENT_GLINT, this.javelin.hasGlint());
        }

        this.piercedEntities.clear();
        if (nbt.contains("javelin_hit", 9)) {
            for (NbtElement hitEntity : nbt.getList("javelin_hit", 10)) {
                this.piercedEntities.add(((NbtCompound) hitEntity).getUuid("UUID"));
            }
        }
        this.dealtDamage = nbt.getBoolean("DealtDamage");
        this.dataTracker.set(LOYALTY, (byte) EnchantmentHelper.getLoyalty(this.javelin));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.put("javelin", this.javelin.writeNbt(new NbtCompound()));

        NbtList tags = new NbtList();
        for (UUID uuid : this.piercedEntities) {
            NbtCompound c = new NbtCompound();
            c.putUuid("UUID", uuid);
            tags.add(c);
        }
        nbt.putBoolean("DealtDamage", this.dealtDamage);
        nbt.put("javelin_hit", tags);
    }

    @Override
    public void age() {
        int i = (Byte) this.dataTracker.get(LOYALTY);
        if (this.pickupType != PersistentProjectileEntity.PickupPermission.ALLOWED || i <= 0) {
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
        return javelin;
    }

    static {
        LOYALTY = DataTracker.registerData(Javelin_Entity.class, TrackedDataHandlerRegistry.BYTE);
        ENCHANTMENT_GLINT = DataTracker.registerData(Javelin_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    private DamageSource createDamageSource(Entity source, Entity attacker) {
        return attacker.getDamageSources().create(EntityInit.JAVELIN, source, attacker);
    }

}