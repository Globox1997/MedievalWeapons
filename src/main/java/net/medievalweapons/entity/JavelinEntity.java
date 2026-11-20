package net.medievalweapons.entity;

import net.levelz.util.BonusHelper;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.EntityInit;
import net.medievalweapons.item.JavelinItem;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class JavelinEntity extends AbstractArrow implements ItemSupplier {
    private static final EntityDataAccessor<Byte> LOYALTY = SynchedEntityData.defineId(JavelinEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> ENCHANTMENT_GLINT = SynchedEntityData.defineId(JavelinEntity.class, EntityDataSerializers.BOOLEAN);
    private ItemStack javelin;
    private final Set<UUID> piercedEntities = new HashSet<>();
    public int returnTimer;
    private boolean dealtDamage;

    public JavelinEntity(EntityType<? extends JavelinEntity> entityType, Level world, JavelinItem item) {
        super(entityType, world);
        this.javelin = new ItemStack(item);
    }

    public JavelinEntity(Level world, LivingEntity owner, ItemStack stack) {
        super(((JavelinItem) stack.getItem()).getType(), owner, world, stack, stack);
        this.javelin = stack;
        this.entityData.set(LOYALTY, this.getLoyalty(stack));
        this.entityData.set(ENCHANTMENT_GLINT, stack.hasFoil());
    }

    public JavelinEntity(Level world, double x, double y, double z, ItemStack stack) {
        super(((JavelinItem) stack.getItem()).getType(), x, y, z, world, stack, stack);
        this.javelin = stack;
        this.entityData.set(LOYALTY, this.getLoyalty(stack));
        this.entityData.set(ENCHANTMENT_GLINT, stack.hasFoil());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LOYALTY, (byte) 0);
        builder.define(ENCHANTMENT_GLINT, false);
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
        Entity hitEntity = entityHitResult.getEntity();
        if (this.dealtDamage || !this.piercedEntities.add(hitEntity.getUUID())) {
            return;
        }
        boolean finished = this.piercedEntities.size() > this.getPierceLevel();
        if (finished) {
            this.dealtDamage = true;
        }
        float damage = Math.max(1.0F, ((JavelinItem) this.javelin.getItem()).getMaterial().attackDamageBonus()) * 2.35F;

        Entity owner = this.getOwner();
        DamageSource damageSource = createDamageSource(this, owner == null ? this : owner);
        if (this.level() instanceof ServerLevel serverWorld) {
            damage = EnchantmentHelper.modifyDamage(serverWorld, this.getWeaponItem(), hitEntity, damageSource, damage);
        }

        if (CompatInit.isLevelZLoaded && owner instanceof Player playerEntity) {
            BonusHelper.bowBonus(playerEntity, this);
        }

        if (hitEntity.hurtOrSimulate(damageSource, damage)) {
            if (hitEntity.getType() == EntityTypes.ENDERMAN) {
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

        if (finished) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        } else {
            this.setDeltaMovement(this.getDeltaMovement().scale(0.75));
        }
        this.playSound(SoundEvents.TRIDENT_HIT, 1.0f, 1.0f);
    }

    @Override
    protected @Nullable EntityHitResult findHitEntity(Vec3 currentPosition, Vec3 nextPosition) {
        return this.dealtDamage ? null : super.findHitEntity(currentPosition, nextPosition);
    }

    @Override
    protected Collection<EntityHitResult> findHitEntities(Vec3 from, Vec3 to) {
        EntityHitResult hitResult = this.findHitEntity(from, to);
        return hitResult != null ? List.of(hitResult) : List.of();
    }

    @Override
    protected boolean canHitEntity(Entity entity) {
        return super.canHitEntity(entity) && !this.piercedEntities.contains(entity.getUUID());
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
                if (this.level() instanceof ServerLevel serverLevel && this.pickup == AbstractArrow.Pickup.ALLOWED) {
                    this.spawnAtLocation(serverLevel, this.getPickupItem(), 0.1f);
                }
                this.discard();
            } else {
                this.setNoPhysics(true);
                Vec3 vec3d = entity.getEyePosition().subtract(this.position());
                this.setPosRaw(this.getX(), this.getY() + vec3d.y * 0.015 * (double) i, this.getZ());
                double d = 0.05 * (double) i;
                this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add(vec3d.normalize().scale(d)));
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
        if (entity == null || entity.getUUID().equals(player.getUUID())) {
            super.playerTouch(player);
        }
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        input.read("javelin", ItemStack.CODEC).ifPresent(stack -> {
            this.javelin = stack;
            this.entityData.set(ENCHANTMENT_GLINT, stack.hasFoil());
        });
        this.piercedEntities.clear();
        for (ValueInput hitEntity : input.childrenListOrEmpty("javelin_hit")) {
            hitEntity.read("UUID", UUIDUtil.CODEC).ifPresent(this.piercedEntities::add);
        }
        this.dealtDamage = input.getBooleanOr("DealtDamage", false);
        this.entityData.set(LOYALTY, this.getLoyalty(this.getPickupItemStackOrigin()));
    }

    private byte getLoyalty(ItemStack stack) {
        if (this.level() instanceof ServerLevel serverWorld) {
            return (byte) Mth.clamp(EnchantmentHelper.getTridentReturnToOwnerAcceleration(serverWorld, stack, this), 0, 127);
        }
        return 0;
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        if (!this.javelin.isEmpty()) {
            output.store("javelin", ItemStack.CODEC, this.javelin);
            ValueOutput.ValueOutputList hits = output.childrenList("javelin_hit");
            for (UUID uuid : this.piercedEntities) {
                hits.addChild().store("UUID", UUIDUtil.CODEC, uuid);
            }
            output.putBoolean("DealtDamage", this.dealtDamage);
        }
    }

    @Override
    protected void tickDespawn() {
        int i = this.entityData.get(LOYALTY);
        if (this.pickup != AbstractArrow.Pickup.ALLOWED || i <= 0) {
            super.tickDespawn();
        }
    }

    @Override
    public ItemStack getWeaponItem() {
        return this.javelin.copy();
    }

    @Override
    public ItemStack getItem() {
        return this.javelin;
    }

    private DamageSource createDamageSource(Entity source, Entity attacker) {
        return attacker.damageSources().source(EntityInit.JAVELIN, source, attacker);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return this.javelin;
    }

}
