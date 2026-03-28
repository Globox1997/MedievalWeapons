package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatEntities;
import net.medievalweapons.entity.FranciscaEntity;
import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.item.FranciscaItem;
import net.medievalweapons.item.JavelinItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class EntityInit {

    // Map
    public static final Map<Identifier, EntityType> ENTITY_TYPES = new LinkedHashMap<>();
    // Damage Types
    public static final RegistryKey<DamageType> JAVELIN = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, MedievalMain.identifierOf("javelin"));
    public static final RegistryKey<DamageType> FRANCISCA = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, MedievalMain.identifierOf("francisca"));
    public static final RegistryKey<DamageType> BLEEDING = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, MedievalMain.identifierOf("bleed"));

    public static void init() {
        CompatEntities.loadEntities();
        for (Identifier id : ENTITY_TYPES.keySet()) {
            Registry.register(Registries.ENTITY_TYPE, id, ENTITY_TYPES.get(id));
        }
    }

    public static <T extends EntityType<?>> T register(String name, T type) {
        Identifier id = MedievalMain.identifierOf(name);
        ENTITY_TYPES.put(id, type);
        return type;
    }

    public static EntityType<FranciscaEntity> createFrancisca(FranciscaItem item) {
        return EntityType.Builder.<FranciscaEntity>create((entity, world) -> new FranciscaEntity(entity, world, item), SpawnGroup.MISC).dimensions(0.5F, 0.5F).build();
    }

    public static EntityType<JavelinEntity> createJavelin(JavelinItem item) {
        return EntityType.Builder.<JavelinEntity>create((entity, world) -> new JavelinEntity(entity, world, item), SpawnGroup.MISC).dimensions(0.5F, 0.5F).build();
    }

}
