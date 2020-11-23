package net.medievalweapons.entity;

import net.fabricmc.api.Environment;
import net.medievalweapons.item.Healing_Staff_Item;
import net.medievalweapons.network.EntitySpawnPacket;
import net.fabricmc.api.EnvType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

public class Healing_Staff_Entity extends Entity {
    private static final TrackedData<Boolean> ENCHANTMENT_GLINT;
    private ItemStack stack;;

    public Healing_Staff_Entity(EntityType<?> type, World world) {
        super(type, world);
    }

    public Healing_Staff_Entity(EntityType<? extends Healing_Staff_Entity> entityType, World world,
            Healing_Staff_Item item) {
        super(entityType, world);
        this.stack = new ItemStack(item);
        this.dataTracker.set(ENCHANTMENT_GLINT, stack.hasGlint());
    }

    @Environment(EnvType.CLIENT)
    public boolean enchantingGlint() {
        return this.dataTracker.get(ENCHANTMENT_GLINT);
    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(ENCHANTMENT_GLINT, false);
    }

    @Override
    protected void readCustomDataFromTag(CompoundTag tag) {
        if (tag.contains("healing_staff", 10)) {
            this.dataTracker.set(ENCHANTMENT_GLINT, this.stack.hasGlint());
        }
    }

    @Override
    protected void writeCustomDataToTag(CompoundTag tag) {
        tag.put("healing_staff", this.stack.toTag(new CompoundTag()));
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.createPacket(this);
    }

    static {
        ENCHANTMENT_GLINT = DataTracker.registerData(Healing_Staff_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

}
