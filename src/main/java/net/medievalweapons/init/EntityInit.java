package net.medievalweapons.init;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatEntities;
import net.medievalweapons.entity.Francisca_Entity;
import net.medievalweapons.entity.Healing_Ball_Entity;
import net.medievalweapons.entity.Javelin_Entity;
import net.medievalweapons.item.Francisca_Item;
import net.medievalweapons.item.Javelin_Item;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    // Map
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MedievalMain.MOD_ID);
    // Francisca
    public static final EntityType<Francisca_Entity> WOODEN_FRANCISCA = register("wooden_francisca", create_Francisca(ItemInit.WOODEN_FRANCISCA_ITEM));
    public static final EntityType<Francisca_Entity> STONE_FRANCISCA = register("stone_francisca", create_Francisca(ItemInit.STONE_FRANCISCA_ITEM));
    public static final EntityType<Francisca_Entity> IRON_FRANCISCA = register("iron_francisca", create_Francisca(ItemInit.IRON_FRANCISCA_ITEM));
    public static final EntityType<Francisca_Entity> GOLDEN_FRANCISCA = register("golden_francisca", create_Francisca(ItemInit.GOLDEN_FRANCISCA_ITEM));
    public static final EntityType<Francisca_Entity> DIAMOND_FRANCISCA = register("diamond_francisca", create_Francisca(ItemInit.DIAMOND_FRANCISCA_ITEM));
    public static final EntityType<Francisca_Entity> NETHERITE_FRANCISCA = register("netherite_francisca", create_Francisca(ItemInit.NETHERITE_FRANCISCA_ITEM));
    // Javelin
    public static final EntityType<Javelin_Entity> WOODEN_JAVELIN = register("wooden_javelin", create_Javelin(ItemInit.WOODEN_JAVELIN_ITEM));
    public static final EntityType<Javelin_Entity> STONE_JAVELIN = register("stone_javelin", create_Javelin(ItemInit.STONE_JAVELIN_ITEM));
    public static final EntityType<Javelin_Entity> IRON_JAVELIN = register("iron_javelin", create_Javelin(ItemInit.IRON_JAVELIN_ITEM));
    public static final EntityType<Javelin_Entity> GOLDEN_JAVELIN = register("golden_javelin", create_Javelin(ItemInit.GOLDEN_JAVELIN_ITEM));
    public static final EntityType<Javelin_Entity> DIAMOND_JAVELIN = register("diamond_javelin", create_Javelin(ItemInit.DIAMOND_JAVELIN_ITEM));
    public static final EntityType<Javelin_Entity> NETHERITE_JAVELIN = register("netherite_javelin", create_Javelin(ItemInit.NETHERITE_JAVELIN_ITEM));
    // Healing Ball
    public static final EntityType<Healing_Ball_Entity> HEALING_BALL_ENTITY = register("healing_ball",
            EntityType.<Healing_Ball_Entity>create(MobCategory.MISC, Healing_Ball_Entity::new).dimensions(EntityDimensions.fixed(0.3F, 0.3F)).build());





    public static EntityType<AbstractArrow> create_Francisca(Francisca_Item item) {
        return EntityType.<AbstractArrow>create(MobCategory.MISC, () -> new Francisca_Entity(item)).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build();
    }

    public static EntityType<AbstractArrow> create_Javelin(Javelin_Item item) {
        return EntityType.<AbstractArrow>create(MobCategory.MISC, (entity, world) -> new Javelin_Entity(entity, world, item)).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build();
    }
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}