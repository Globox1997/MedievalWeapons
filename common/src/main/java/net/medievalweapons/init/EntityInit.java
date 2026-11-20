package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatEntities;
import net.medievalweapons.entity.FranciscaEntity;
import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.item.FranciscaItem;
import net.medievalweapons.item.JavelinItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class EntityInit {

    // Map
    public static final Map<Identifier, EntityType<?>> ENTITY_TYPES = new LinkedHashMap<>();
    // Damage Types
    public static final ResourceKey<DamageType> JAVELIN = ResourceKey.create(Registries.DAMAGE_TYPE, MedievalMain.identifierOf("javelin"));
    public static final ResourceKey<DamageType> FRANCISCA = ResourceKey.create(Registries.DAMAGE_TYPE, MedievalMain.identifierOf("francisca"));
    public static final ResourceKey<DamageType> BLEEDING = ResourceKey.create(Registries.DAMAGE_TYPE, MedievalMain.identifierOf("bleed"));

    public static void register(BiConsumer<Identifier, EntityType<?>> registrar) {
        List<Identifier> ids = new ArrayList<>(ItemInit.throwableIds());
        ids.addAll(CompatEntities.throwableIds());
        for (Identifier id : ids) {
            EntityType<?> type = id.getPath().endsWith("_francisca") ? createFrancisca(id) : createJavelin(id);
            ENTITY_TYPES.put(id, type);
            registrar.accept(id, type);
        }
    }

    public static DamageSource damageSource(Entity context, ResourceKey<DamageType> key, @Nullable Entity directEntity, @Nullable Entity causingEntity) {
        return new DamageSource(context.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(key), directEntity, causingEntity);
    }

    public static EntityType<FranciscaEntity> createFrancisca(Identifier id) {
        return EntityType.Builder.<FranciscaEntity>of((entity, world) -> new FranciscaEntity(entity, world, (FranciscaItem) BuiltInRegistries.ITEM.getValue(id)), MobCategory.MISC)
                .sized(0.5F, 0.5F).build(ResourceKey.create(Registries.ENTITY_TYPE, id));
    }

    public static EntityType<JavelinEntity> createJavelin(Identifier id) {
        return EntityType.Builder.<JavelinEntity>of((entity, world) -> new JavelinEntity(entity, world, (JavelinItem) BuiltInRegistries.ITEM.getValue(id)), MobCategory.MISC)
                .sized(0.5F, 0.5F).build(ResourceKey.create(Registries.ENTITY_TYPE, id));
    }

}
