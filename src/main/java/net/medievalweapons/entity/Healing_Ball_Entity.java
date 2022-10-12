package net.medievalweapons.entity;

import java.util.Iterator;
import java.util.List;


import net.medievalweapons.init.EntityInit;
import net.medievalweapons.init.ParticleInit;
import net.medievalweapons.init.SoundInit;
import net.medievalweapons.item.Francisca_Item;
import net.medievalweapons.item.Healing_Staff_Item;
import net.medievalweapons.network.EntitySpawnPacket;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class Healing_Ball_Entity extends ThrowableProjectile {
    private int addition = 0;
    private ItemStack healing_ball;

    public Healing_Ball_Entity(EntityType<? extends Healing_Ball_Entity> entityType, Level world) {
        super(entityType, world);
    }

    public Healing_Ball_Entity(EntityType<? extends Healing_Ball_Entity> entityType, double d, double e, double f, Level world) {
        super(entityType, d, e, f, world);
    }

    public Healing_Ball_Entity(LivingEntity livingEntity, Level world, int addition, Healing_Staff_Item item) {
        super(item.getType(), livingEntity, world);
        this.addition = addition;
        this.healing_ball = new ItemStack((ItemLike) item);
    }



    @Override
    public Packet<?> getAddEntityPacket() {
        return EntitySpawnPacket.createPacket(this);
    }

    @Override
    public void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        Entity entity = this.getOwner();
        if (hitResult.getType() != HitResult.Type.ENTITY || !((EntityHitResult) hitResult).getEntity().is(entity)) {
            if (!this.level.isClientSide) {
                List<LivingEntity> list = this.level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(4.0D, 2.0D, 4.0D));
                AreaEffectCloud areaEffectCloudEntity = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
                if (entity instanceof LivingEntity) {
                    areaEffectCloudEntity.setOwner((LivingEntity) entity);
                }
                areaEffectCloudEntity.setParticle(ParticleInit.HEALING_AURA_PARTICLE);
                areaEffectCloudEntity.setRadius((float) this.addition);
                areaEffectCloudEntity.setDuration(this.addition * 100);
                areaEffectCloudEntity.setRadiusPerTick(-(12.0F - areaEffectCloudEntity.getRadius()) / 500.0F);
                areaEffectCloudEntity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
                if (!list.isEmpty()) {
                    Iterator<LivingEntity> var5 = list.iterator();
                    while (var5.hasNext()) {
                        LivingEntity livingEntity = (LivingEntity) var5.next();
                        double d = this.distanceToSqr(livingEntity);
                        if (d < 16.0D) {
                            areaEffectCloudEntity.absMoveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                            break;
                        }
                    }
                }
                this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundInit.MAGIC_HEAL_AURA_EVENT, SoundSource.NEUTRAL, 0.9F, 1.0F);
                this.level.addFreshEntity(areaEffectCloudEntity);
                this.discard();
            }

        }
    }

    @Override
    public void tick() {
        super.tick();
        this.checkInsideBlocks();
        Vec3 vec3d = this.getDeltaMovement();
        double d = this.getX() + vec3d.x;
        double e = this.getY() + vec3d.y;
        double f = this.getZ() + vec3d.z;
        this.updateRotation();
        float j;
        if (this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                this.level.addParticle(ParticleTypes.BUBBLE, d - vec3d.x * 0.25D, e - vec3d.y * 0.25D, f - vec3d.z * 0.25D, vec3d.x, vec3d.y, vec3d.z);
            }

            j = 0.8F;
        } else {
            j = 0.99F;
        }


        if (!this.isNoGravity()) {
            Vec3 vec3d2 = this.getDeltaMovement();
            // Drag
            this.setDeltaMovement(vec3d2.x, vec3d2.y - (0.002D - ((double) this.addition / 3000D)), vec3d2.z);
        }

        this.absMoveTo(d, e, f);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }

    @Override
    protected void defineSynchedData() {
    }

    public void setDeltaMovement(Player playerEntity, float xRot, float yRot, float v, float v1, float v2) {

    }
}
