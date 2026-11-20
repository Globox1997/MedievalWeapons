package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatEntities;
import net.medievalweapons.entity.FranciscaEntity;
import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.item.FranciscaItem;
import net.medievalweapons.item.JavelinItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import java.util.LinkedHashMap;
import java.util.Map;

public class EntityInit {

    // Map
    public static final Map<ResourceLocation, EntityType> ENTITY_TYPES = new LinkedHashMap<>();
    // Damage Types
    public static final ResourceKey<DamageType> JAVELIN = ResourceKey.create(Registries.DAMAGE_TYPE, MedievalMain.identifierOf("javelin"));
    public static final ResourceKey<DamageType> FRANCISCA = ResourceKey.create(Registries.DAMAGE_TYPE, MedievalMain.identifierOf("francisca"));
    public static final ResourceKey<DamageType> BLEEDING = ResourceKey.create(Registries.DAMAGE_TYPE, MedievalMain.identifierOf("bleed"));

    public static void init() {
        CompatEntities.loadEntities();
        for (ResourceLocation id : ENTITY_TYPES.keySet()) {
            Registry.register(BuiltInRegistries.ENTITY_TYPE, id, ENTITY_TYPES.get(id));
        }
    }

    public static <T extends EntityType<?>> T register(String name, T type) {
        ResourceLocation id = MedievalMain.identifierOf(name);
        ENTITY_TYPES.put(id, type);
        return type;
    }

    public static EntityType<FranciscaEntity> createFrancisca(FranciscaItem item) {
        return EntityType.Builder.<FranciscaEntity>of((entity, world) -> new FranciscaEntity(entity, world, item), MobCategory.MISC).sized(0.5F, 0.5F).build();
    }

    public static EntityType<JavelinEntity> createJavelin(JavelinItem item) {
        return EntityType.Builder.<JavelinEntity>of((entity, world) -> new JavelinEntity(entity, world, item), MobCategory.MISC).sized(0.5F, 0.5F).build();
    }

}
