package net.medievalweapons.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.levelz.util.BonusHelper;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.EntityInit;
import net.medievalweapons.item.FranciscaItem;
import net.medievalweapons.mixin.client.PersistentProjectileEntityAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.SynchedEntityData.Builder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class FranciscaEntity extends AbstractArrow implements ItemSupplier {
    private static final EntityDataAccessor<Boolean> ENCHANTMENT_GLINT;
    private ItemStack francisca;

    public FranciscaEntity(EntityType<? extends FranciscaEntity> entityType, Level world, FranciscaItem item) {
        super(entityType, world);
        this.francisca = new ItemStack(item);
    }

    public FranciscaEntity(Level world, LivingEntity owner, ItemStack stack) {
        super(((FranciscaItem) stack.getItem()).getType(), owner, world, stack, null);
        this.francisca = stack;
        this.entityData.set(ENCHANTMENT_GLINT, stack.hasFoil());
    }

    public FranciscaEntity(Level world, double x, double y, double z, ItemStack stack) {
        super(((FranciscaItem) stack.getItem()).getType(), x, y, z, world, stack, stack);
        this.francisca = stack;
        this.entityData.set(ENCHANTMENT_GLINT, stack.hasFoil());
    }

    @Override
    protected void defineSynchedData(Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ENCHANTMENT_GLINT, false);
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.francisca.copy();
    }

    @Environment(EnvType.CLIENT)
    public boolean enchantingGlint() {
        return this.entityData.get(ENCHANTMENT_GLINT);
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity hitEntity = entityHitResult.getEntity();
        float damage = Math.max(1.0F, ((FranciscaItem) this.francisca.getItem()).getTier().getAttackDamageBonus()) * 2.3F;
        Entity owner = this.getOwner();
        if (this.level() instanceof ServerLevel serverWorld) {
            damage = EnchantmentHelper.modifyDamage(serverWorld, this.getWeaponItem(), hitEntity, createDamageSource(this, owner == null ? this : owner), damage);
        }

        if (CompatInit.isLevelZLoaded && owner instanceof Player playerEntity) {
            BonusHelper.bowBonus(playerEntity,this);
        }

        DamageSource damageSource = createDamageSource(this, owner == null ? this : owner);
        if (hitEntity.hurt(damageSource, damage)) {
            if (hitEntity.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (this.level() instanceof ServerLevel serverWorld) {
                EnchantmentHelper.doPostAttackEffectsWithItemSource(serverWorld, hitEntity, damageSource, this.getWeaponItem());
            }
            if (hitEntity instanceof LivingEntity livingEntity) {
                this.doKnockback(livingEntity, damageSource);
                this.doPostHurtEffects(livingEntity);
            }
        }
        this.setDeltaMovement(this.getDeltaMovement().scale(0.75));
        this.playSound(SoundEvents.TRIDENT_HIT, 1.0f, 1.0f);
    }

    @Override
    public void playerTouch(Player player) {
        Entity entity = this.getOwner();
        if (entity == null || entity.getUUID().equals(player.getUUID())) {
            super.playerTouch(player);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("francisca", 10)) {
            this.francisca = ItemStack.parse(this.registryAccess(), nbt.getCompound("francisca")).orElse(this.getDefaultPickupItem());
            this.entityData.set(ENCHANTMENT_GLINT, this.francisca.hasFoil());
        }

    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        if (!this.francisca.isEmpty()) {
            nbt.put("francisca", this.francisca.save(this.registryAccess()));
        }
    }

    @Override
    public ItemStack getWeaponItem() {
        return this.francisca.copy();
    }

    @Override
    public ItemStack getItem() {
        return francisca;
    }

    public boolean inGround() {
        return ((PersistentProjectileEntityAccessor) this).getInGround();
    }

    static {
        ENCHANTMENT_GLINT = SynchedEntityData.defineId(FranciscaEntity.class, EntityDataSerializers.BOOLEAN);
    }

    private DamageSource createDamageSource(Entity source, Entity attacker) {
        return attacker.damageSources().source(EntityInit.FRANCISCA, source, attacker);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return this.francisca;
    }

}