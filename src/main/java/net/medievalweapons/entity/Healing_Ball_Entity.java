package net.medievalweapons.entity;

import java.util.Iterator;
import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.EntityInit;
import net.medievalweapons.init.ParticleInit;
import net.medievalweapons.init.SoundInit;
import net.medievalweapons.network.EntitySpawnPacket;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.network.Packet;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Healing_Ball_Entity extends ThrownEntity {
    private int addition = 0;

    public Healing_Ball_Entity(EntityType<? extends Healing_Ball_Entity> entityType, World world) {
        super(entityType, world);
    }

    public Healing_Ball_Entity(EntityType<? extends Healing_Ball_Entity> entityType, double d, double e, double f, World world) {
        super(entityType, d, e, f, world);
    }

    public Healing_Ball_Entity(LivingEntity livingEntity, World world, int addition) {
        super(EntityInit.HEALING_BALL_ENTITY, livingEntity, world);
        this.addition = addition;
    }

    @Environment(EnvType.CLIENT)
    public Healing_Ball_Entity(World world, double x, double y, double z, double directionX, double directionY, double directionZ) {
        super(EntityInit.HEALING_BALL_ENTITY, x, y, z, world);
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.createPacket(this);
    }

    @Override
    public void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        Entity entity = this.getOwner();
        if (hitResult.getType() != HitResult.Type.ENTITY || !((EntityHitResult) hitResult).getEntity().isPartOf(entity)) {
            if (!this.world.isClient) {
                List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(4.0D, 2.0D, 4.0D));
                AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.world, this.getX(), this.getY(), this.getZ());
                if (entity instanceof LivingEntity) {
                    areaEffectCloudEntity.setOwner((LivingEntity) entity);
                }
                areaEffectCloudEntity.setParticleType(ParticleInit.HEALING_AURA_PARTICLE);
                areaEffectCloudEntity.setRadius((float) this.addition);
                areaEffectCloudEntity.setDuration(this.addition * 100);
                areaEffectCloudEntity.setRadiusGrowth(-(12.0F - areaEffectCloudEntity.getRadius()) / 500.0F);
                areaEffectCloudEntity.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0));
                if (!list.isEmpty()) {
                    Iterator<LivingEntity> var5 = list.iterator();
                    while (var5.hasNext()) {
                        LivingEntity livingEntity = (LivingEntity) var5.next();
                        double d = this.squaredDistanceTo(livingEntity);
                        if (d < 16.0D) {
                            areaEffectCloudEntity.updatePosition(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                            break;
                        }
                    }
                }
                this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundInit.MAGIC_HEAL_AURA_EVENT, SoundCategory.NEUTRAL, 0.9F, 1.0F);
                this.world.spawnEntity(areaEffectCloudEntity);
                this.discard();
            }

        }
    }

    @Override
    public void tick() {
        super.tick();
        this.checkBlockCollision();
        Vec3d vec3d = this.getVelocity();
        double d = this.getX() + vec3d.x;
        double e = this.getY() + vec3d.y;
        double f = this.getZ() + vec3d.z;
        this.updateRotation();
        float j;
        if (this.isTouchingWater()) {
            for (int i = 0; i < 4; ++i) {
                this.world.addParticle(ParticleTypes.BUBBLE, d - vec3d.x * 0.25D, e - vec3d.y * 0.25D, f - vec3d.z * 0.25D, vec3d.x, vec3d.y, vec3d.z);
            }

            j = 0.8F;
        } else {
            j = 0.99F;
        }

        this.setVelocity(vec3d.multiply((double) j));
        if (!this.hasNoGravity()) {
            Vec3d vec3d2 = this.getVelocity();
            // Drag
            this.setVelocity(vec3d2.x, vec3d2.y - (0.002D - ((double) this.addition / 3000D)), vec3d2.z);
        }

        this.updatePosition(d, e, f);
    }

    @Override
    public boolean collides() {
        return false;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        return false;
    }

    @Override
    protected void initDataTracker() {
    }
}
