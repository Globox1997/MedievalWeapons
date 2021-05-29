package net.medievalweapons.init;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.medievalweapons.compat.CompatEntities;
import net.medievalweapons.entity.Francisca_HT_Entity;
import net.medievalweapons.entity.Francisca_LT_Entity;
import net.medievalweapons.entity.Healing_Ball_Entity;
import net.medievalweapons.entity.Javelin_Entity;
import net.medievalweapons.item.Francisca_HT_Item;
import net.medievalweapons.item.Francisca_LT_Item;
import net.medievalweapons.item.Javelin_Item;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityInit {
        // Map
        public static final Map<Identifier, EntityType<?>> ENTITY_TYPES = new LinkedHashMap<>();
        // Francisca
        public static final EntityType<Francisca_LT_Entity> WOODEN_FRANCISCA_LT = register("wooden_francisca",
                        create_LT_Francisca(ItemInit.WOODEN_FRANCISCA_LT_ITEM));
        public static final EntityType<Francisca_LT_Entity> STONE_FRANCISCA_LT = register("stone_francisca",
                        create_LT_Francisca(ItemInit.STONE_FRANCISCA_LT_ITEM));
        public static final EntityType<Francisca_HT_Entity> IRON_FRANCISCA_HT = register("iron_francisca",
                        create_HT_Francisca(ItemInit.IRON_FRANCISCA_HT_ITEM));
        public static final EntityType<Francisca_HT_Entity> GOLDEN_FRANCISCA_HT = register("golden_francisca",
                        create_HT_Francisca(ItemInit.GOLDEN_FRANCISCA_HT_ITEM));
        public static final EntityType<Francisca_HT_Entity> DIAMOND_FRANCISCA_HT = register("diamond_francisca",
                        create_HT_Francisca(ItemInit.DIAMOND_FRANCISCA_HT_ITEM));
        public static final EntityType<Francisca_HT_Entity> NETHERITE_FRANCISCA_HT = register("netherite_francisca",
                        create_HT_Francisca(ItemInit.NETHERITE_FRANCISCA_HT_ITEM));
        // Javelin
        public static final EntityType<Javelin_Entity> WOODEN_JAVELIN = register("wooden_javelin",
                        create_Javelin(ItemInit.WOODEN_JAVELIN_ITEM));
        public static final EntityType<Javelin_Entity> STONE_JAVELIN = register("stone_javelin",
                        create_Javelin(ItemInit.STONE_JAVELIN_ITEM));
        public static final EntityType<Javelin_Entity> IRON_JAVELIN = register("iron_javelin",
                        create_Javelin(ItemInit.IRON_JAVELIN_ITEM));
        public static final EntityType<Javelin_Entity> GOLDEN_JAVELIN = register("golden_javelin",
                        create_Javelin(ItemInit.GOLDEN_JAVELIN_ITEM));
        public static final EntityType<Javelin_Entity> DIAMOND_JAVELIN = register("diamond_javelin",
                        create_Javelin(ItemInit.DIAMOND_JAVELIN_ITEM));
        public static final EntityType<Javelin_Entity> NETHERITE_JAVELIN = register("netherite_javelin",
                        create_Javelin(ItemInit.NETHERITE_JAVELIN_ITEM));
        // Healing Ball
        public static final EntityType<Healing_Ball_Entity> HEALING_BALL_ENTITY = register("healing_ball",
                        FabricEntityTypeBuilder.<Healing_Ball_Entity>create(SpawnGroup.MISC, Healing_Ball_Entity::new)
                                        .dimensions(EntityDimensions.fixed(0.3F, 0.3F)).build());

        public static void init() {
                CompatEntities.loadEntities();
                for (Identifier id : ENTITY_TYPES.keySet()) {
                        Registry.register(Registry.ENTITY_TYPE, id, ENTITY_TYPES.get(id));
                }
        }

        public static <T extends EntityType<?>> T register(String name, T type) {
                Identifier id = new Identifier("medievalweapons", name);
                ENTITY_TYPES.put(id, type);
                return type;
        }

        private static EntityType<Francisca_LT_Entity> create_LT_Francisca(Francisca_LT_Item item) {
                return FabricEntityTypeBuilder
                                .<Francisca_LT_Entity>create(SpawnGroup.MISC,
                                                (entity, world) -> new Francisca_LT_Entity(entity, world, item))
                                .dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build();
        }

        public static EntityType<Francisca_HT_Entity> create_HT_Francisca(Francisca_HT_Item item) {
                return FabricEntityTypeBuilder
                                .<Francisca_HT_Entity>create(SpawnGroup.MISC,
                                                (entity, world) -> new Francisca_HT_Entity(entity, world, item))
                                .dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build();
        }

        public static EntityType<Javelin_Entity> create_Javelin(Javelin_Item item) {
                return FabricEntityTypeBuilder
                                .<Javelin_Entity>create(SpawnGroup.MISC,
                                                (entity, world) -> new Javelin_Entity(entity, world, item))
                                .dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build();
        }

}