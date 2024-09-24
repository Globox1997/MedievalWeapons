package net.medievalweapons.init;

import java.util.LinkedHashMap;
import java.util.Map;

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

public class EntityInit {
    // Map
    public static final Map<Identifier, EntityType<?>> ENTITY_TYPES = new LinkedHashMap<>();
    // Francisca
    public static final EntityType<FranciscaEntity> WOODEN_FRANCISCA = register("wooden_francisca", create_Francisca((FranciscaItem) ItemInit.WOODEN_FRANCISCA_ITEM));
    public static final EntityType<FranciscaEntity> STONE_FRANCISCA = register("stone_francisca", create_Francisca((FranciscaItem) ItemInit.STONE_FRANCISCA_ITEM));
    public static final EntityType<FranciscaEntity> IRON_FRANCISCA = register("iron_francisca", create_Francisca((FranciscaItem) ItemInit.IRON_FRANCISCA_ITEM));
    public static final EntityType<FranciscaEntity> GOLDEN_FRANCISCA = register("golden_francisca", create_Francisca((FranciscaItem) ItemInit.GOLDEN_FRANCISCA_ITEM));
    public static final EntityType<FranciscaEntity> DIAMOND_FRANCISCA = register("diamond_francisca", create_Francisca((FranciscaItem) ItemInit.DIAMOND_FRANCISCA_ITEM));
    public static final EntityType<FranciscaEntity> NETHERITE_FRANCISCA = register("netherite_francisca", create_Francisca((FranciscaItem) ItemInit.NETHERITE_FRANCISCA_ITEM));
    // Javelin
    public static final EntityType<JavelinEntity> WOODEN_JAVELIN = register("wooden_javelin", create_Javelin((JavelinItem) ItemInit.WOODEN_JAVELIN_ITEM));
    public static final EntityType<JavelinEntity> STONE_JAVELIN = register("stone_javelin", create_Javelin((JavelinItem) ItemInit.STONE_JAVELIN_ITEM));
    public static final EntityType<JavelinEntity> IRON_JAVELIN = register("iron_javelin", create_Javelin((JavelinItem) ItemInit.IRON_JAVELIN_ITEM));
    public static final EntityType<JavelinEntity> GOLDEN_JAVELIN = register("golden_javelin", create_Javelin((JavelinItem) ItemInit.GOLDEN_JAVELIN_ITEM));
    public static final EntityType<JavelinEntity> DIAMOND_JAVELIN = register("diamond_javelin", create_Javelin((JavelinItem) ItemInit.DIAMOND_JAVELIN_ITEM));
    public static final EntityType<JavelinEntity> NETHERITE_JAVELIN = register("netherite_javelin", create_Javelin((JavelinItem) ItemInit.NETHERITE_JAVELIN_ITEM));
    // Damage Types
    public static final RegistryKey<DamageType> JAVELIN = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, MedievalMain.id("javelin"));
    public static final RegistryKey<DamageType> FRANCISCA = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, MedievalMain.id("francisca"));
    public static final RegistryKey<DamageType> BLEEDING = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, MedievalMain.id("bleed"));

    public static void init() {
        CompatEntities.loadEntities();
        for (Identifier id : ENTITY_TYPES.keySet()) {
            Registry.register(Registries.ENTITY_TYPE, id, ENTITY_TYPES.get(id));
        }
    }

    public static <T extends EntityType<?>> T register(String name, T type) {
        Identifier id = MedievalMain.id(name);
        ENTITY_TYPES.put(id, type);
        return type;
    }

    public static EntityType<FranciscaEntity> create_Francisca(FranciscaItem item) {
        return EntityType.Builder.<FranciscaEntity>create((entity, world) -> new FranciscaEntity(entity, world, item), SpawnGroup.MISC).dimensions(0.5F, 0.5F).build();
    }

    public static EntityType<JavelinEntity> create_Javelin(JavelinItem item) {
        return EntityType.Builder.<JavelinEntity>create((entity, world) -> new JavelinEntity(entity, world, item), SpawnGroup.MISC).dimensions(0.5F, 0.5F).build();
    }

}