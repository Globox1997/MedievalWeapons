package net.medievalweapons.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.medievalweapons.item.Rapier_Item;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {

    public MobEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void takeKnockback(double strength, double x, double z) {
        if (this.getAttacker() == null || this.getAttacker().getMainHandStack().isEmpty() || !(this.getAttacker().getMainHandStack().getItem() instanceof Rapier_Item)) {
            super.takeKnockback(strength, x, z);
        }
    }

}
