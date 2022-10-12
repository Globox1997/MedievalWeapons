package net.medievalweapons.access;


import net.minecraft.world.entity.Entity;

public interface PlayerAccess {

    void doOffhandAttack(Entity entity);

    float getAttackCooldownProgressOffhand(float baseTime);

    void resetLastAttackedOffhandTicks();
}
