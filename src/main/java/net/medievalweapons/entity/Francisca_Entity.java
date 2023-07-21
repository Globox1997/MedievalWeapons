package net.medievalweapons.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.levelz.access.PlayerStatsManagerAccess;
import net.levelz.init.ConfigInit;
import net.levelz.stats.Skill;
import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.EntityInit;
import net.medievalweapons.item.Francisca_Item;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
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
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class Francisca_Entity extends PersistentProjectileEntity implements FlyingItemEntity {
    private static final TrackedData<Boolean> ENCHANTMENT_GLINT;
    private ItemStack francisca;

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

        float damage = ((Francisca_Item) this.francisca.getItem()).getAttackDamage() * 2.3F;

        int sharpnessLevel = EnchantmentHelper.getLevel(Enchantments.SHARPNESS, this.francisca);
        if (sharpnessLevel > 0) {
            damage += sharpnessLevel * 0.6F;
        }

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

                int fireAspectLevel = EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, this.francisca);
                if (fireAspectLevel > 0) {
                    hitLivingEntity.setOnFireFor(fireAspectLevel * 4);
                }
                this.playSound(soundEvent, 1.0F, 1.0F);
                this.onHit(hitLivingEntity);
            }
        }

        this.setVelocity(this.getVelocity().multiply(0.75));
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

    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.put("francisca", this.francisca.writeNbt(new NbtCompound()));
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

    private DamageSource createDamageSource(Entity source, Entity attacker) {
        return attacker.getDamageSources().create(EntityInit.FRANCISCA, source, attacker);
    }

}