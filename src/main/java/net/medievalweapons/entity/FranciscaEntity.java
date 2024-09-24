package net.medievalweapons.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.levelz.access.PlayerStatsManagerAccess;
import net.levelz.init.ConfigInit;
import net.levelz.stats.Skill;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.EntityInit;
import net.medievalweapons.item.FranciscaItem;
import net.medievalweapons.mixin.client.PersistentProjectileEntityAccessor;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker.Builder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class FranciscaEntity extends PersistentProjectileEntity implements FlyingItemEntity {
    private static final TrackedData<Boolean> ENCHANTMENT_GLINT;
    private ItemStack francisca;

    public FranciscaEntity(EntityType<? extends FranciscaEntity> entityType, World world, FranciscaItem item) {
        super(entityType, world);
        this.francisca = new ItemStack(item);
    }

    public FranciscaEntity(World world, LivingEntity owner, ItemStack stack) {
        super(((FranciscaItem) stack.getItem()).getType(), owner, world, stack, null);
        this.francisca = stack;
        this.dataTracker.set(ENCHANTMENT_GLINT, stack.hasGlint());
    }

    public FranciscaEntity(World world, double x, double y, double z, ItemStack stack) {
        super(((FranciscaItem) stack.getItem()).getType(), z, z, z, world, stack, stack);
        this.francisca = stack;
        this.dataTracker.set(ENCHANTMENT_GLINT, stack.hasGlint());
    }

    @Override
    protected void initDataTracker(Builder builder) {
        super.initDataTracker(builder);
        builder.add(ENCHANTMENT_GLINT, false);
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
        Entity hitEntity = entityHitResult.getEntity();
        float damage = ((FranciscaItem) this.francisca.getItem()).getMaterial().getAttackDamage() * 2.3F;
        Entity owner = this.getOwner();
        if (this.getWorld() instanceof ServerWorld serverWorld) {
            damage = EnchantmentHelper.getDamage(serverWorld, this.getWeaponStack(), hitEntity, createDamageSource(this, owner == null ? this : owner), damage);
        }

        if (CompatInit.isLevelZLoaded && owner instanceof PlayerEntity) {
            int archeryLevel = ((PlayerStatsManagerAccess) owner).getPlayerStatsManager().getSkillLevel(Skill.ARCHERY);
            damage += archeryLevel >= ConfigInit.CONFIG.maxLevel && ConfigInit.CONFIG.archeryDoubleDamageChance > this.getWorld().getRandom().nextFloat() ? damage
                    : (double) archeryLevel * ConfigInit.CONFIG.archeryBowExtraDamage;
        }

        DamageSource damageSource = createDamageSource(this, owner == null ? this : owner);
        if (hitEntity.damage(damageSource, damage)) {
            if (hitEntity.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (this.getWorld() instanceof ServerWorld serverWorld) {
                EnchantmentHelper.onTargetDamaged(serverWorld, hitEntity, damageSource, this.getWeaponStack());
            }
            if (hitEntity instanceof LivingEntity livingEntity) {
                this.knockback(livingEntity, damageSource);
                this.onHit(livingEntity);
            }
        }
        this.setVelocity(this.getVelocity().multiply(0.75));
        this.playSound(SoundEvents.ITEM_TRIDENT_HIT, 1.0f, 1.0f);
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
            this.francisca = ItemStack.fromNbt(this.getRegistryManager(), nbt.getCompound("francisca")).orElse(this.getDefaultItemStack());
            this.dataTracker.set(ENCHANTMENT_GLINT, this.francisca.hasGlint());
        }

    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.put("francisca", this.francisca.encode(this.getRegistryManager()));
    }

    @Override
    public void age() {
        if (this.pickupType != PersistentProjectileEntity.PickupPermission.ALLOWED) {
            super.age();
        }
    }

    @Override
    public ItemStack getWeaponStack() {
        return this.francisca.copy();
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

    public boolean inGround() {
        return ((PersistentProjectileEntityAccessor) this).getInGround();
    }

    static {
        ENCHANTMENT_GLINT = DataTracker.registerData(FranciscaEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    private DamageSource createDamageSource(Entity source, Entity attacker) {
        return attacker.getDamageSources().create(EntityInit.FRANCISCA, source, attacker);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return this.francisca;
    }

}