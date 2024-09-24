package net.medievalweapons.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.compat.CompatRecipes;
import net.medievalweapons.item.*;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemInit {

    // Item Group
    public static final RegistryKey<ItemGroup> MEDIEVALWEAPONS_ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of("medievalweapons", "item_group"));

    // Lists
    public static final ArrayList<String> MATERIAL_STRINGS = new ArrayList<String>(Arrays.asList("wooden", "stone", "iron", "golden", "diamond", "netherite"));
    public static final ArrayList<String> ITEM_STRINGS = new ArrayList<String>(
            Arrays.asList("small_axe", "long_sword", "dagger", "francisca", "big_axe", "javelin", "lance", "healing_staff", "mace", "ninjato", "sickle", "rapier"));
    // Map
    public static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();
    // Small Axe
    public static final Item WOODEN_SMALL_AXE_ITEM = register("wooden_small_axe",
            new SmallAxeItem(ToolMaterials.WOOD,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item STONE_SMALL_AXE_ITEM = register("stone_small_axe",
            new SmallAxeItem(ToolMaterials.STONE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item IRON_SMALL_AXE_ITEM = register("iron_small_axe",
            new SmallAxeItem(ToolMaterials.IRON,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item GOLDEN_SMALL_AXE_ITEM = register("golden_small_axe",
            new SmallAxeItem(ToolMaterials.GOLD,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item DIAMOND_SMALL_AXE_ITEM = register("diamond_small_axe",
            new SmallAxeItem(ToolMaterials.DIAMOND,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item NETHERITE_SMALL_AXE_ITEM = register("netherite_small_axe",
            new SmallAxeItem(ToolMaterials.NETHERITE,
                    new Item.Settings()
                            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                    new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                            .fireproof()));

    // Long Sword
    public static final Item WOOD_LONG_SWORD_ITEM = register("wooden_long_sword",
            new LongSwordItem(ToolMaterials.WOOD,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item STONE_LONG_SWORD_ITEM = register("stone_long_sword",
            new LongSwordItem(ToolMaterials.STONE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item IRON_LONG_SWORD_ITEM = register("iron_long_sword",
            new LongSwordItem(ToolMaterials.IRON,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item GOLDEN_LONG_SWORD_ITEM = register("golden_long_sword",
            new LongSwordItem(ToolMaterials.GOLD,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item DIAMOND_LONG_SWORD_ITEM = register("diamond_long_sword",
            new LongSwordItem(ToolMaterials.DIAMOND,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item NETHERITE_LONG_SWORD_ITEM = register("netherite_long_sword",
            new LongSwordItem(ToolMaterials.NETHERITE,
                    new Item.Settings()
                            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                            .fireproof()));
    // Dagger
    public static final Item WOOD_DAGGER_ITEM = register("wooden_dagger",
            new DaggerItem(ToolMaterials.WOOD,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item STONE_DAGGER_ITEM = register("stone_dagger",
            new DaggerItem(ToolMaterials.STONE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item IRON_DAGGER_ITEM = register("iron_dagger",
            new DaggerItem(ToolMaterials.IRON,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item GOLDEN_DAGGER_ITEM = register("golden_dagger",
            new DaggerItem(ToolMaterials.GOLD,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item DIAMOND_DAGGER_ITEM = register("diamond_dagger",
            new DaggerItem(ToolMaterials.DIAMOND,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item NETHERITE_DAGGER_ITEM = register("netherite_dagger",
            new DaggerItem(ToolMaterials.NETHERITE,
                    new Item.Settings()
                            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                            .fireproof()));
    // Francisca
    public static final Item WOODEN_FRANCISCA_ITEM = register("wooden_francisca",
            new FranciscaItem(ToolMaterials.WOOD, () -> EntityInit.WOODEN_FRANCISCA, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 1, -2.6f))));
    public static final Item STONE_FRANCISCA_ITEM = register("stone_francisca",
            new FranciscaItem(ToolMaterials.STONE, () -> EntityInit.STONE_FRANCISCA, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 1, -2.6f))));
    public static final Item IRON_FRANCISCA_ITEM = register("iron_francisca",
            new FranciscaItem(ToolMaterials.IRON, () -> EntityInit.IRON_FRANCISCA, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 1, -2.6f))));
    public static final Item GOLDEN_FRANCISCA_ITEM = register("golden_francisca",
            new FranciscaItem(ToolMaterials.GOLD, () -> EntityInit.GOLDEN_FRANCISCA, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 1, -2.6f))));
    public static final Item DIAMOND_FRANCISCA_ITEM = register("diamond_francisca",
            new FranciscaItem(ToolMaterials.DIAMOND, () -> EntityInit.DIAMOND_FRANCISCA, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.6f))));
    public static final Item NETHERITE_FRANCISCA_ITEM = register("netherite_francisca", new FranciscaItem(ToolMaterials.NETHERITE, () -> EntityInit.NETHERITE_FRANCISCA,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 1, -2.6f)).fireproof()));
    // Big Axe
    public static final Item WOODEN_BIG_AXE_ITEM = register("wooden_big_axe",
            new BigAxeItem(ToolMaterials.WOOD,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item STONE_BIG_AXE_ITEM = register("stone_big_axe",
            new BigAxeItem(ToolMaterials.STONE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item IRON_BIG_AXE_ITEM = register("iron_big_axe",
            new BigAxeItem(ToolMaterials.IRON,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item GOLDEN_BIG_AXE_ITEM = register("golden_big_axe",
            new BigAxeItem(ToolMaterials.GOLD,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item DIAMOND_BIG_AXE_ITEM = register("diamond_big_axe",
            new BigAxeItem(ToolMaterials.DIAMOND,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item NETHERITE_BIG_AXE_ITEM = register("netherite_big_axe",
            new BigAxeItem(ToolMaterials.NETHERITE,
                    new Item.Settings()
                            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                    new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                            .fireproof()));
    // Javelin
    public static final Item WOODEN_JAVELIN_ITEM = register("wooden_javelin",
            new JavelinItem(ToolMaterials.WOOD, () -> EntityInit.WOODEN_JAVELIN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 2, -2.7f))));
    public static final Item STONE_JAVELIN_ITEM = register("stone_javelin",
            new JavelinItem(ToolMaterials.STONE, () -> EntityInit.STONE_JAVELIN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 2, -2.7f))));
    public static final Item IRON_JAVELIN_ITEM = register("iron_javelin",
            new JavelinItem(ToolMaterials.IRON, () -> EntityInit.IRON_JAVELIN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.7f))));
    public static final Item GOLDEN_JAVELIN_ITEM = register("golden_javelin",
            new JavelinItem(ToolMaterials.GOLD, () -> EntityInit.GOLDEN_JAVELIN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 2, -2.7f))));
    public static final Item DIAMOND_JAVELIN_ITEM = register("diamond_javelin",
            new JavelinItem(ToolMaterials.DIAMOND, () -> EntityInit.DIAMOND_JAVELIN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -2.7f))));
    public static final Item NETHERITE_JAVELIN_ITEM = register("netherite_javelin", new JavelinItem(ToolMaterials.NETHERITE, () -> EntityInit.NETHERITE_JAVELIN,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.7f)).fireproof()));
    // Lance
    public static final Item WOODEN_LANCE_ITEM = register("wooden_lance",
            new LanceItem(ToolMaterials.WOOD,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item STONE_LANCE_ITEM = register("stone_lance",
            new LanceItem(ToolMaterials.STONE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item IRON_LANCE_ITEM = register("iron_lance",
            new LanceItem(ToolMaterials.IRON,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item GOLDEN_LANCE_ITEM = register("golden_lance",
            new LanceItem(ToolMaterials.GOLD,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item DIAMOND_LANCE_ITEM = register("diamond_lance",
            new LanceItem(ToolMaterials.DIAMOND,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item NETHERITE_LANCE_ITEM = register("netherite_lance",
            new LanceItem(ToolMaterials.NETHERITE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)).fireproof()));
    // Healing Staff
    public static final Item WOODEN_HEALING_STAFF_ITEM = register("wooden_healing_staff",
            new HealingStaffItem(ToolMaterials.WOOD, 1, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 1, -3.3f))));
    public static final Item STONE_HEALING_STAFF_ITEM = register("stone_healing_staff",
            new HealingStaffItem(ToolMaterials.STONE, 2, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 1, -3.3f))));
    public static final Item IRON_HEALING_STAFF_ITEM = register("iron_healing_staff",
            new HealingStaffItem(ToolMaterials.IRON, 3, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 1, -3.3f))));
    public static final Item GOLDEN_HEALING_STAFF_ITEM = register("golden_healing_staff",
            new HealingStaffItem(ToolMaterials.GOLD, 3, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 1, -3.3f))));
    public static final Item DIAMOND_HEALING_STAFF_ITEM = register("diamond_healing_staff",
            new HealingStaffItem(ToolMaterials.DIAMOND, 4, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -3.3f))));
    public static final Item NETHERITE_HEALING_STAFF_ITEM = register("netherite_healing_staff",
            new HealingStaffItem(ToolMaterials.NETHERITE, 5, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 1, -3.3f)).fireproof()));
    // Mace
    public static final Item WOODEN_MACE_ITEM = register("wooden_mace",
            new MaceItem(ToolMaterials.WOOD, 0,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item STONE_MACE_ITEM = register("stone_mace",
            new MaceItem(ToolMaterials.STONE, 0,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item IRON_MACE_ITEM = register("iron_mace",
            new MaceItem(ToolMaterials.IRON, 1,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item GOLDEN_MACE_ITEM = register("golden_mace",
            new MaceItem(ToolMaterials.GOLD, 2,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item DIAMOND_MACE_ITEM = register("diamond_mace",
            new MaceItem(ToolMaterials.DIAMOND, 2,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
    public static final Item NETHERITE_MACE_ITEM = register("netherite_mace",
            new MaceItem(ToolMaterials.NETHERITE, 3,
                    new Item.Settings()
                            .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                            .fireproof()));
    // Ninjato
    public static final Item WOODEN_NINJATO_ITEM = register("wooden_ninjato",
            new NinjatoItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 2, -2.1f))));
    public static final Item STONE_NINJATO_ITEM = register("stone_ninjato",
            new NinjatoItem(ToolMaterials.STONE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 2, -2.1f))));
    public static final Item IRON_NINJATO_ITEM = register("iron_ninjato",
            new NinjatoItem(ToolMaterials.IRON, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.1f))));
    public static final Item GOLDEN_NINJATO_ITEM = register("golden_ninjato",
            new NinjatoItem(ToolMaterials.GOLD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 2, -2.1f))));
    public static final Item DIAMOND_NINJATO_ITEM = register("diamond_ninjato",
            new NinjatoItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -2.1f))));
    public static final Item NETHERITE_NINJATO_ITEM = register("netherite_ninjato",
            new NinjatoItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.1f)).fireproof()));
    // Sickle
    public static final Item WOODEN_SICKLE_ITEM = register("wooden_sickle",
            new SickleItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 2, -2.2f))));
    public static final Item STONE_SICKLE_ITEM = register("stone_sickle",
            new SickleItem(ToolMaterials.STONE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 2, -2.2f))));
    public static final Item IRON_SICKLE_ITEM = register("iron_sickle",
            new SickleItem(ToolMaterials.IRON, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.2f))));
    public static final Item GOLDEN_SICKLE_ITEM = register("golden_sickle",
            new SickleItem(ToolMaterials.GOLD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 2, -2.2f))));
    public static final Item DIAMOND_SICKLE_ITEM = register("diamond_sickle",
            new SickleItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -2.2f))));
    public static final Item NETHERITE_SICKLE_ITEM = register("netherite_sickle",
            new SickleItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.2f)).fireproof()));
    // Rapier

    public static final Item WOODEN_RAPIER_ITEM = register("wooden_rapier",
            new RapierItem(ToolMaterials.WOOD, 0, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 2, -2.0f))));
    public static final Item STONE_RAPIER_ITEM = register("stone_rapier",
            new RapierItem(ToolMaterials.STONE, 0, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 2, -2.0f))));
    public static final Item IRON_RAPIER_ITEM = register("iron_rapier",
            new RapierItem(ToolMaterials.IRON, 1, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.0f))));
    public static final Item GOLDEN_RAPIER_ITEM = register("golden_rapier",
            new RapierItem(ToolMaterials.GOLD, 2, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 2, -2.0f))));
    public static final Item DIAMOND_RAPIER_ITEM = register("diamond_rapier",
            new RapierItem(ToolMaterials.DIAMOND, 2, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -2.0f))));
    public static final Item NETHERITE_RAPIER_ITEM = register("netherite_rapier",
            new RapierItem(ToolMaterials.NETHERITE, 3, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.0f)).fireproof()));
    // Long Bow
    public static final Item LONG_BOW_ITEM = register("long_bow", new LongBowItem(new Item.Settings().maxDamage(443)));
    // Recurve Bow
    public static final Item RECURVE_BOW_ITEM = register("recurve_bow", new RecurveBowItem(new Item.Settings().maxDamage(361)));
    // Thalleous Sword
    public static final Item THALLEOUS_SWORD = register("thalleous_sword",
            new ThalleousSwordItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 10, -3.0f)
                    .with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 1.0f, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.MAINHAND)
                    .with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(ThalleousSwordItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.MAINHAND))));

    public static Item register(String id, Item item) {
        return register(MedievalMain.id(id), item);
    }

    private static Item register(Identifier id, Item item) {
        ItemGroupEvents.modifyEntriesEvent(MEDIEVALWEAPONS_ITEM_GROUP).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, MEDIEVALWEAPONS_ITEM_GROUP,
                FabricItemGroup.builder().icon(() -> new ItemStack(DIAMOND_FRANCISCA_ITEM)).displayName(Text.translatable("item.medievalweapons.item_group")).build());

        CompatItems.loadItems();
        CompatRecipes.createRecipes();
        CompatRecipes.loadRecipes();

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registries.ITEM, id, ITEMS.get(id));
            ItemGroupEvents.modifyEntriesEvent(MEDIEVALWEAPONS_ITEM_GROUP).register(entries -> entries.add(ITEMS.get(id)));
        }
    }

}