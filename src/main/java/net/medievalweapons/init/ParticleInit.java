package net.medievalweapons.init;


import net.medievalweapons.MedievalMain;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleInit {

    public static final ParticleOptions HEALING_AURA_PARTICLE = ParticleTypes.EXPLOSION;

    public static final DeferredRegister<ParticleTypes> PARTICLE_DEFERRED_REGISTER =
            DeferredRegister.create((ResourceLocation) ForgeRegistries.PARTICLE_TYPES, MedievalMain.MOD_ID);



    static class HealingAuraParticle extends TextureSheetParticle {
        private final SpriteSet sprites;
        private boolean reachedGround;

        public HealingAuraParticle(ClientLevel clientWorld, double d, double e, double f, double g, double h, double i, SpriteSet sprites) {
            super(clientWorld, d, e, f, g, h, i);
            setSprite(sprites.get(level.random));
            this.rCol = Mth.nextFloat(this.random, 0.182645F, 0.787239F);
            this.bCol = Mth.nextFloat(this.random, 0.136784F, 0.756783F);
            this.gCol = Mth.nextFloat(this.random, 0.8235294F, 0.9764706F);
            this.hasPhysics = true;
            this.lifetime = (int) (20.0D / ((double) this.random.nextFloat() * 0.8D + 0.2D));
            this.reachedGround = false;
            this.hasPhysics = true;
            this.sprites = (SpriteSet) sprites;
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




        public static class Factory implements ParticleProvider<SimpleParticleType> {
            private final SpriteSet sprites;

            public Factory(SpriteSet sprites) {
                this.sprites = sprites;
            }

            @Override
            public Particle createParticle(SimpleParticleType type, ClientLevel world, double x, double y, double z, double vX, double vY, double vZ) {
                return new HealingAuraParticle(world, x, y, z, vX, vY, vZ, sprites);
            }
        }
    }
    public static void register(IEventBus eventBus) {
        PARTICLE_DEFERRED_REGISTER.register(eventBus);
    }


}
