package net.medievalweapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;

public class ParticleInit {

    public static final DefaultParticleType HEALING_AURA_PARTICLE = FabricParticleTypes.simple();

    public static void init() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("medievalweapons", "healing_aura_particle"),
                HEALING_AURA_PARTICLE);
    }

    @Environment(EnvType.CLIENT)
    static class HealingAuraParticle extends SpriteBillboardParticle {
        private final FabricSpriteProvider sprites;
        private boolean reachedGround;

        public HealingAuraParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i,
                SpriteProvider sprites) {
            super(clientWorld, d, e, f, g, h, i);
            setSprite(sprites.getSprite(world.random));
            this.colorRed = MathHelper.nextFloat(this.random, 0.182645F, 0.787239F);
            this.colorBlue = MathHelper.nextFloat(this.random, 0.136784F, 0.756783F);
            this.colorGreen = MathHelper.nextFloat(this.random, 0.8235294F, 0.9764706F);
            this.collidesWithWorld = true;
            this.scale *= 0.75F;
            this.maxAge = (int) (20.0D / ((double) this.random.nextFloat() * 0.8D + 0.2D));
            this.reachedGround = false;
            this.collidesWithWorld = true;
            this.sprites = (FabricSpriteProvider) sprites;
            this.setSpriteForAge(sprites);
        }

        @Override
        public void tick() {
            if (this.random.nextInt(2) == 0 && this.age == 0) {
                this.markDead();
            }
            this.prevPosX = this.x;
            this.prevPosY = this.y;
            this.prevPosZ = this.z;
            if (this.age++ >= this.maxAge) {
                this.markDead();
            } else {
                this.setSpriteForAge(this.sprites);
                if (this.onGround) {
                    this.velocityY = 0.0D;
                    this.reachedGround = true;
                }

                if (this.reachedGround) {
                    this.velocityY += 0.001D;
                }

                this.move(this.velocityX * 0.1D, this.velocityY * 0.1D, this.velocityZ * 0.1D);
                if (this.y == this.prevPosY) {
                    this.velocityX *= 1.1D;
                    this.velocityZ *= 1.1D;
                }

                this.velocityX *= 0.9599999785423279D;
                this.velocityZ *= 0.9599999785423279D;
                if (this.reachedGround) {
                    this.velocityY *= 0.9599999785423279D;
                }

            }
        }

        @Override
        public ParticleTextureSheet getType() {
            return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
        }

        @Override
        public float getSize(float tickDelta) {
            return this.scale
                    * MathHelper.clamp(((float) this.age + tickDelta) / (float) this.maxAge * 32.0F, 0.0F, 1.0F);
        }

        @Environment(EnvType.CLIENT)
        public static class Factory implements ParticleFactory<DefaultParticleType> {
            private final FabricSpriteProvider sprites;

            public Factory(FabricSpriteProvider sprites) {
                this.sprites = sprites;
            }

            @Override
            public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z,
                    double vX, double vY, double vZ) {
                return new HealingAuraParticle(world, x, y, z, vX, vY, vZ, sprites);
            }
        }
    }

}
