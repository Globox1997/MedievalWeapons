package net.medievalweapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.medievalweapons.MedievalMain;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.Mth;

public class ParticleInit {

    public static final SimpleParticleType HEALING_AURA_PARTICLE = FabricParticleTypes.simple();

    public static void init() {
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, MedievalMain.identifierOf("healing_aura_particle"), HEALING_AURA_PARTICLE);
    }

    @Environment(EnvType.CLIENT)
    static class HealingAuraParticle extends TextureSheetParticle {
        private final FabricSpriteProvider sprites;
        private boolean reachedGround;

        public HealingAuraParticle(ClientLevel clientWorld, double d, double e, double f, double g, double h, double i, SpriteSet sprites) {
            super(clientWorld, d, e, f, g, h, i);
            setSprite(sprites.get(level.random));
            this.rCol = Mth.nextFloat(this.random, 0.182645F, 0.787239F);
            this.bCol = Mth.nextFloat(this.random, 0.136784F, 0.756783F);
            this.gCol = Mth.nextFloat(this.random, 0.8235294F, 0.9764706F);
            this.hasPhysics = true;
            this.quadSize *= 0.75F;
            this.lifetime = (int) (20.0D / ((double) this.random.nextFloat() * 0.8D + 0.2D));
            this.reachedGround = false;
            this.hasPhysics = true;
            this.sprites = (FabricSpriteProvider) sprites;
            this.setSpriteFromAge(sprites);
        }

        @Override
        public void tick() {
            if (this.random.nextInt(2) == 0 && this.age == 0) {
                this.remove();
            }
            this.xo = this.x;
            this.yo = this.y;
            this.zo = this.z;
            if (this.age++ >= this.lifetime) {
                this.remove();
            } else {
                this.setSpriteFromAge(this.sprites);
                if (this.onGround) {
                    this.yd = 0.0D;
                    this.reachedGround = true;
                }

                if (this.reachedGround) {
                    this.yd += 0.001D;
                }

                this.move(this.xd * 0.1D, this.yd * 0.1D, this.zd * 0.1D);
                if (this.y == this.yo) {
                    this.xd *= 1.1D;
                    this.zd *= 1.1D;
                }

                this.xd *= 0.9599999785423279D;
                this.zd *= 0.9599999785423279D;
                if (this.reachedGround) {
                    this.yd *= 0.9599999785423279D;
                }

            }
        }

        @Override
        public ParticleRenderType getRenderType() {
            return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
        }

        @Override
        public float getQuadSize(float tickDelta) {
            return this.quadSize * Mth.clamp(((float) this.age + tickDelta) / (float) this.lifetime * 32.0F, 0.0F, 1.0F);
        }

        @Environment(EnvType.CLIENT)
        public static class Factory implements ParticleProvider<SimpleParticleType> {
            private final FabricSpriteProvider sprites;

            public Factory(FabricSpriteProvider sprites) {
                this.sprites = sprites;
            }

            @Override
            public Particle createParticle(SimpleParticleType type, ClientLevel world, double x, double y, double z, double vX, double vY, double vZ) {
                return new HealingAuraParticle(world, x, y, z, vX, vY, vZ, sprites);
            }
        }
    }

}
