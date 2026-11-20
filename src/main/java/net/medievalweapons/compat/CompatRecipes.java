package net.medievalweapons.compat;

import com.google.gson.JsonObject;
import net.medievalweapons.MedievalMain;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import java.util.HashMap;

public class CompatRecipes {

    public static HashMap<String, ShapedRecipeMaterial> VANILLA_SHAPED_RECIPES = new HashMap<>();
    public static HashMap<String, SmithingRecipeMaterial> VANILLA_SMITHING_RECIPES = new HashMap<>();

    public static HashMap<String, ShapedRecipeMaterial> SHAPED_RECIPES = new HashMap<>();
    public static HashMap<String, SmithingRecipeMaterial> SMITHING_RECIPES = new HashMap<>();

    public static HashMap<ResourceLocation, JsonObject> RECIPES = new HashMap<>();

    public static void createRecipes() {
        // Wood
        VANILLA_SHAPED_RECIPES.put("wooden_big_axe", new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_big_axe"), "big_axe"));
        VANILLA_SHAPED_RECIPES.put("wooden_dagger", new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_dagger"), "dagger"));
        VANILLA_SHAPED_RECIPES.put("wooden_francisca", new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_francisca"), "francisca"));
        VANILLA_SHAPED_RECIPES.put("wooden_healing_staff",
                new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_healing_staff"), "healing_staff"));
        VANILLA_SHAPED_RECIPES.put("wooden_javelin", new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_javelin"), "javelin"));
        VANILLA_SHAPED_RECIPES.put("wooden_lance", new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_lance"), "lance"));
        VANILLA_SHAPED_RECIPES.put("wooden_long_sword",
                new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_long_sword"), "long_sword"));
        VANILLA_SHAPED_RECIPES.put("wooden_mace", new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_mace"), "mace"));
        VANILLA_SHAPED_RECIPES.put("wooden_small_axe", new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_small_axe"), "small_axe"));
        VANILLA_SHAPED_RECIPES.put("wooden_ninjato", new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_ninjato"), "ninjato"));
        VANILLA_SHAPED_RECIPES.put("wooden_sickle", new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_sickle"), "sickle"));
        VANILLA_SHAPED_RECIPES.put("wooden_rapier", new ShapedRecipeMaterial(ResourceLocation.parse("planks"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_rapier"), "rapier"));
        // Stone
        VANILLA_SHAPED_RECIPES.put("stone_big_axe",
                new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_big_axe"), "big_axe"));
        VANILLA_SHAPED_RECIPES.put("stone_dagger",
                new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_dagger"), "dagger"));
        VANILLA_SHAPED_RECIPES.put("stone_francisca",
                new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_francisca"), "francisca"));
        VANILLA_SHAPED_RECIPES.put("stone_healing_staff",
                new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_healing_staff"), "healing_staff"));
        VANILLA_SHAPED_RECIPES.put("stone_javelin",
                new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_javelin"), "javelin"));
        VANILLA_SHAPED_RECIPES.put("stone_lance", new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_lance"), "lance"));
        VANILLA_SHAPED_RECIPES.put("stone_long_sword",
                new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_long_sword"), "long_sword"));
        VANILLA_SHAPED_RECIPES.put("stone_mace", new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_mace"), "mace"));
        VANILLA_SHAPED_RECIPES.put("stone_small_axe",
                new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_small_axe"), "small_axe"));
        VANILLA_SHAPED_RECIPES.put("stone_ninjato",
                new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_ninjato"), "ninjato"));
        VANILLA_SHAPED_RECIPES.put("stone_sickle",
                new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_sickle"), "sickle"));
        VANILLA_SHAPED_RECIPES.put("stone_rapier",
                new ShapedRecipeMaterial(ResourceLocation.parse("stone_tool_materials"), BuiltInRegistries.ITEM.getKey(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_rapier"), "rapier"));
        // Gold
        VANILLA_SHAPED_RECIPES.put("golden_big_axe",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_big_axe"), "big_axe"));
        VANILLA_SHAPED_RECIPES.put("golden_dagger",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_dagger"), "dagger"));
        VANILLA_SHAPED_RECIPES.put("golden_francisca",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_francisca"), "francisca"));
        VANILLA_SHAPED_RECIPES.put("golden_healing_staff",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_healing_staff"), "healing_staff"));
        VANILLA_SHAPED_RECIPES.put("golden_javelin",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_javelin"), "javelin"));
        VANILLA_SHAPED_RECIPES.put("golden_lance",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_lance"), "lance"));
        VANILLA_SHAPED_RECIPES.put("golden_long_sword",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_long_sword"), "long_sword"));
        VANILLA_SHAPED_RECIPES.put("golden_mace",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_mace"), "mace"));
        VANILLA_SHAPED_RECIPES.put("golden_small_axe",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_small_axe"), "small_axe"));
        VANILLA_SHAPED_RECIPES.put("golden_ninjato",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_ninjato"), "ninjato"));
        VANILLA_SHAPED_RECIPES.put("golden_sickle",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_sickle"), "sickle"));
        VANILLA_SHAPED_RECIPES.put("golden_rapier",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.GOLD_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_rapier"), "rapier"));
        // Iron
        VANILLA_SHAPED_RECIPES.put("iron_big_axe",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_big_axe"), "big_axe"));
        VANILLA_SHAPED_RECIPES.put("iron_dagger",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_dagger"), "dagger"));
        VANILLA_SHAPED_RECIPES.put("iron_francisca",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_francisca"), "francisca"));
        VANILLA_SHAPED_RECIPES.put("iron_healing_staff",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_healing_staff"), "healing_staff"));
        VANILLA_SHAPED_RECIPES.put("iron_javelin",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_javelin"), "javelin"));
        VANILLA_SHAPED_RECIPES.put("iron_lance",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_lance"), "lance"));
        VANILLA_SHAPED_RECIPES.put("iron_long_sword",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_long_sword"), "long_sword"));
        VANILLA_SHAPED_RECIPES.put("iron_mace", new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_mace"), "mace"));
        VANILLA_SHAPED_RECIPES.put("iron_small_axe",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_small_axe"), "small_axe"));
        VANILLA_SHAPED_RECIPES.put("iron_ninjato",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_ninjato"), "ninjato"));
        VANILLA_SHAPED_RECIPES.put("iron_sickle",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_sickle"), "sickle"));
        VANILLA_SHAPED_RECIPES.put("iron_rapier",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_rapier"), "rapier"));
        // Diamond
        VANILLA_SHAPED_RECIPES.put("diamond_big_axe",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_big_axe"), "big_axe"));
        VANILLA_SHAPED_RECIPES.put("diamond_dagger",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_dagger"), "dagger"));
        VANILLA_SHAPED_RECIPES.put("diamond_francisca",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_francisca"), "francisca"));
        VANILLA_SHAPED_RECIPES.put("diamond_healing_staff",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_healing_staff"), "healing_staff"));
        VANILLA_SHAPED_RECIPES.put("diamond_javelin",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_javelin"), "javelin"));
        VANILLA_SHAPED_RECIPES.put("diamond_lance",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_lance"), "lance"));
        VANILLA_SHAPED_RECIPES.put("diamond_long_sword",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_long_sword"), "long_sword"));
        VANILLA_SHAPED_RECIPES.put("diamond_mace",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_mace"), "mace"));
        VANILLA_SHAPED_RECIPES.put("diamond_small_axe",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_small_axe"), "small_axe"));
        VANILLA_SHAPED_RECIPES.put("diamond_ninjato",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_ninjato"), "ninjato"));
        VANILLA_SHAPED_RECIPES.put("diamond_sickle",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_sickle"), "sickle"));
        VANILLA_SHAPED_RECIPES.put("diamond_rapier",
                new ShapedRecipeMaterial(BuiltInRegistries.ITEM.getKey(Items.DIAMOND), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_rapier"), "rapier"));
        // Netherite
        VANILLA_SMITHING_RECIPES.put("netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_big_axe"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_big_axe"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_dagger"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_dagger"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_francisca"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_francisca"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_healing_staff"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_healing_staff"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_javelin"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_javelin"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_lance"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_lance"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_long_sword"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_long_sword"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_mace"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_mace"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_small_axe"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_small_axe"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_ninjato"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_ninjato"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_sickle"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_sickle"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        VANILLA_SMITHING_RECIPES.put("netherite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_rapier"), BuiltInRegistries.ITEM.getKey(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_rapier"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));

        // Better End
        SHAPED_RECIPES.put("terminite_small_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("thallasium_small_axe", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item",
                MedievalMain.identifierOf("thallasium_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("aeternium_small_axe", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("terminite_long_sword", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item",
                MedievalMain.identifierOf("terminite_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("thallasium_long_sword", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item",
                MedievalMain.identifierOf("thallasium_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("aeternium_long_sword", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("terminite_dagger",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_dagger"), "dagger"));
        SHAPED_RECIPES.put("thallasium_dagger",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_dagger"), "dagger"));
        SHAPED_RECIPES.put("aeternium_dagger", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_dagger"), "dagger"));
        SHAPED_RECIPES.put("terminite_big_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("thallasium_big_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("aeternium_big_axe", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("terminite_lance",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_lance"), "lance"));
        SHAPED_RECIPES.put("thallasium_lance",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_lance"), "lance"));
        SHAPED_RECIPES.put("aeternium_lance", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_lance"), "lance"));
        SHAPED_RECIPES.put("terminite_healing_staff", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item",
                MedievalMain.identifierOf("terminite_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("thallasium_healing_staff", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item",
                MedievalMain.identifierOf("thallasium_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("aeternium_healing_staff", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("terminite_mace",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_mace"), "mace"));
        SHAPED_RECIPES.put("thallasium_mace",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_mace"), "mace"));
        SHAPED_RECIPES.put("aeternium_mace", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_mace"), "mace"));
        SHAPED_RECIPES.put("terminite_francisca",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_francisca"), "francisca"));
        SHAPED_RECIPES.put("thallasium_francisca", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item",
                MedievalMain.identifierOf("thallasium_francisca"), "francisca"));
        SHAPED_RECIPES.put("aeternium_francisca", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_francisca"), "francisca"));
        SHAPED_RECIPES.put("terminite_javelin",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_javelin"), "javelin"));
        SHAPED_RECIPES.put("thallasium_javelin",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_javelin"), "javelin"));
        SHAPED_RECIPES.put("aeternium_javelin", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_javelin"), "javelin"));
        SHAPED_RECIPES.put("terminite_ninjato",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("thallasium_ninjato",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("aeternium_ninjato", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("terminite_sickle",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_sickle"), "sickle"));
        SHAPED_RECIPES.put("thallasium_sickle",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_sickle"), "sickle"));
        SHAPED_RECIPES.put("aeternium_sickle", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_sickle"), "sickle"));
        SHAPED_RECIPES.put("terminite_rapier",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "terminite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_rapier"), "rapier"));
        SHAPED_RECIPES.put("thallasium_rapier",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "thallasium_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_rapier"), "rapier"));
        SHAPED_RECIPES.put("aeternium_rapier", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betterend", "aeternium_ingot"), ResourceLocation.fromNamespaceAndPath("betterend", "leather_wrapped_stick"), "item", "item",
                MedievalMain.identifierOf("aeternium_rapier"), "rapier"));

        // Better Nether
        SHAPED_RECIPES.put("nether_ruby_small_axe", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("cincinnasite_small_axe", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item",
                "item", MedievalMain.identifierOf("cincinnasite_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("cincinnasite_diamond_small_axe", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_small_axe"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_small_axe"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_long_sword", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("cincinnasite_long_sword", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item",
                "item", MedievalMain.identifierOf("cincinnasite_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("cincinnasite_diamond_long_sword", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_long_sword"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_long_sword"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_dagger", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_dagger"), "dagger"));
        SHAPED_RECIPES.put("cincinnasite_dagger", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_dagger"), "dagger"));
        SHAPED_RECIPES.put("cincinnasite_diamond_dagger", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_dagger"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_dagger"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_big_axe", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("cincinnasite_big_axe", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("cincinnasite_diamond_big_axe", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_big_axe"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_big_axe"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_lance", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_lance"), "lance"));
        SHAPED_RECIPES.put("cincinnasite_lance", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_lance"), "lance"));
        SHAPED_RECIPES.put("cincinnasite_diamond_lance", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_lance"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_lance"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_healing_staff", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("cincinnasite_healing_staff", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item",
                "item", MedievalMain.identifierOf("cincinnasite_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("cincinnasite_diamond_healing_staff", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_healing_staff"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_healing_staff"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_mace", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_mace"), "mace"));
        SHAPED_RECIPES.put("cincinnasite_mace", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_mace"), "mace"));
        SHAPED_RECIPES.put("cincinnasite_diamond_mace", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_mace"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_mace"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_francisca", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_francisca"), "francisca"));
        SHAPED_RECIPES.put("cincinnasite_francisca", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item",
                "item", MedievalMain.identifierOf("cincinnasite_francisca"), "francisca"));
        SHAPED_RECIPES.put("cincinnasite_diamond_francisca", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_francisca"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_francisca"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_javelin", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_javelin"), "javelin"));
        SHAPED_RECIPES.put("cincinnasite_javelin", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_javelin"), "javelin"));
        SHAPED_RECIPES.put("cincinnasite_diamond_javelin", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_javelin"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_javelin"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_ninjato", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("cincinnasite_ninjato", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("cincinnasite_diamond_ninjato", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_ninjato"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_ninjato"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_sickle", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_sickle"), "sickle"));
        SHAPED_RECIPES.put("cincinnasite_sickle", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_sickle"), "sickle"));
        SHAPED_RECIPES.put("cincinnasite_diamond_sickle", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_sickle"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_sickle"), "cincinnasite"));
        SHAPED_RECIPES.put("nether_ruby_rapier", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "nether_ruby"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("nether_ruby_rapier"), "rapier"));
        SHAPED_RECIPES.put("cincinnasite_rapier", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("betternether", "cincinnasite_ingot"), ResourceLocation.fromNamespaceAndPath("betternether", "nether_reed_stem"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_rapier"), "rapier"));
        SHAPED_RECIPES.put("cincinnasite_diamond_rapier", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_rapier"), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond"), "item", "item",
                MedievalMain.identifierOf("cincinnasite_diamond_rapier"), "cincinnasite"));

        // DragonLoot
        SMITHING_RECIPES.put("dragon_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item",
                MedievalMain.identifierOf("dragon_small_axe"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item",
                MedievalMain.identifierOf("dragon_long_sword"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item", MedievalMain.identifierOf("dragon_dagger"),
                ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item",
                MedievalMain.identifierOf("dragon_big_axe"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item", MedievalMain.identifierOf("dragon_lance"),
                ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item",
                MedievalMain.identifierOf("dragon_healing_staff"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item", MedievalMain.identifierOf("dragon_mace"),
                ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item",
                MedievalMain.identifierOf("dragon_francisca"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item",
                MedievalMain.identifierOf("dragon_javelin"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item",
                MedievalMain.identifierOf("dragon_ninjato"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item", MedievalMain.identifierOf("dragon_sickle"),
                ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("dragon_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale"), "item", "item", MedievalMain.identifierOf("dragon_rapier"),
                ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));

        // Mythic Metals
        SHAPED_RECIPES.put("adamantite_small_axe", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item",
                MedievalMain.identifierOf("adamantite_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("adamantite_long_sword", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item",
                MedievalMain.identifierOf("adamantite_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("adamantite_dagger",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_dagger"), "dagger"));
        SHAPED_RECIPES.put("adamantite_big_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("adamantite_lance",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_lance"), "lance"));
        SHAPED_RECIPES.put("adamantite_healing_staff", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item",
                MedievalMain.identifierOf("adamantite_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("adamantite_mace",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_mace"), "mace"));
        SHAPED_RECIPES.put("adamantite_francisca", new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item",
                MedievalMain.identifierOf("adamantite_francisca"), "francisca"));
        SHAPED_RECIPES.put("adamantite_javelin",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_javelin"), "javelin"));
        SHAPED_RECIPES.put("adamantite_ninjato",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("adamantite_sickle",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_sickle"), "sickle"));
        SHAPED_RECIPES.put("adamantite_rapier",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("mythicmetals", "adamantite_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_rapier"), "rapier"));

        // Paradise Lost
        SHAPED_RECIPES.put("olvite_small_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("olvite_long_sword",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("olvite_dagger",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_dagger"), "dagger"));
        SHAPED_RECIPES.put("olvite_big_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("olvite_lance",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_lance"), "lance"));
        SHAPED_RECIPES.put("olvite_healing_staff",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("olvite_mace",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_mace"), "mace"));
        SHAPED_RECIPES.put("olvite_francisca",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_francisca"), "francisca"));
        SHAPED_RECIPES.put("olvite_javelin",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_javelin"), "javelin"));
        SHAPED_RECIPES.put("olvite_ninjato",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("olvite_sickle",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_sickle"), "sickle"));
        SHAPED_RECIPES.put("olvite_rapier",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("paradise_lost", "olvite"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_rapier"), "rapier"));

        // BYG
        SMITHING_RECIPES.put("pendorite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_small_axe"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_long_sword"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_dagger"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_big_axe"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_lance"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_healing_staff"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_mace"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_francisca"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_javelin"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_ninjato"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_sickle"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("pendorite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), ResourceLocation.fromNamespaceAndPath("byg", "pendorite_ingot"), "item", "item",
                MedievalMain.identifierOf("pendorite_rapier"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));

        // AdditionalAdditions
        SMITHING_RECIPES.put("gilded_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_small_axe"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_long_sword"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_dagger"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_big_axe"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_lance"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), ResourceLocation.parse("additionaladditions:gold_ring"), "item",
                "item", MedievalMain.identifierOf("gilded_netherite_healing_staff"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_mace"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_francisca"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_javelin"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_ninjato"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_sickle"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));
        SMITHING_RECIPES.put("gilded_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), ResourceLocation.parse("additionaladditions:gold_ring"), "item", "item",
                MedievalMain.identifierOf("gilded_netherite_rapier"), ResourceLocation.parse("additionaladditions:gilded_netherite_upgrade")));

        SMITHING_RECIPES.put("rose_gold_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_small_axe"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_small_axe"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_long_sword"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_long_sword"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_dagger"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_dagger"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_big_axe"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_big_axe"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_lance"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_lance"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_healing_staff"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_healing_staff"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_mace"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_mace"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_francisca"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_francisca"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_javelin"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_javelin"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_ninjato"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_ninjato"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_rapier"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_rapier"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));
        SMITHING_RECIPES.put("rose_gold_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_sickle"), ResourceLocation.parse("additionaladditions:rose_gold_alloy"), "item", "item",
                MedievalMain.identifierOf("rose_gold_sickle"), ResourceLocation.parse("additionaladditions:rose_gold_upgrade")));

        // Mythic Upgrades
        SMITHING_RECIPES.put("ruby_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_small_axe"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_long_sword"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_dagger"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_big_axe"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_lance"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_healing_staff"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_mace"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_francisca"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_javelin"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_ninjato"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_sickle"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("ruby_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), ResourceLocation.parse("mythicupgrades:ruby"), "item", "item",
                MedievalMain.identifierOf("ruby_netherite_rapier"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));

        SMITHING_RECIPES.put("sapphire_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_small_axe"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_long_sword"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_dagger"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_big_axe"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_lance"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_healing_staff"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_mace"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_francisca"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_javelin"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_ninjato"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_rapier"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("sapphire_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), ResourceLocation.parse("mythicupgrades:sapphire"), "item", "item",
                MedievalMain.identifierOf("sapphire_netherite_sickle"), ResourceLocation.parse("minecraft:netherite_upgrade_smithing_template")));

        // Deeper Darker
        SMITHING_RECIPES.put("warden_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_small_axe"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_long_sword"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_dagger"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_big_axe"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_lance"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_healing_staff"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_mace"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_francisca"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_javelin"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_ninjato"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_sickle"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));
        SMITHING_RECIPES.put("warden_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "reinforced_echo_shard"), "item", "item",
                MedievalMain.identifierOf("warden_rapier"), ResourceLocation.fromNamespaceAndPath("deeperdarker", "warden_upgrade_smithing_template")));

        // EarlyStage
        SHAPED_RECIPES.put("steel_small_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("steel_long_sword",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("steel_dagger",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_dagger"), "dagger"));
        SHAPED_RECIPES.put("steel_big_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("steel_lance",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_lance"), "lance"));
        SHAPED_RECIPES.put("steel_healing_staff",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("steel_mace",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_mace"), "mace"));
        SHAPED_RECIPES.put("steel_francisca",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_francisca"), "francisca"));
        SHAPED_RECIPES.put("steel_javelin",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_javelin"), "javelin"));
        SHAPED_RECIPES.put("steel_ninjato",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("steel_sickle",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_sickle"), "sickle"));
        SHAPED_RECIPES.put("steel_rapier",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("steel_rapier"), "rapier"));

        SHAPED_RECIPES.put("damascus_steel_small_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("damascus_steel_long_sword",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("damascus_steel_dagger",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_dagger"), "dagger"));
        SHAPED_RECIPES.put("damascus_steel_big_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("damascus_steel_lance",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_lance"), "lance"));
        SHAPED_RECIPES.put("damascus_steel_healing_staff",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("damascus_steel_mace",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_mace"), "mace"));
        SHAPED_RECIPES.put("damascus_steel_francisca",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_francisca"), "francisca"));
        SHAPED_RECIPES.put("damascus_steel_javelin",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_javelin"), "javelin"));
        SHAPED_RECIPES.put("damascus_steel_ninjato",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("damascus_steel_sickle",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_sickle"), "sickle"));
        SHAPED_RECIPES.put("damascus_steel_rapier",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("earlystage", "damascus_steel_ingot"), BuiltInRegistries.ITEM.getKey(Items.STICK), "item", "item", MedievalMain.identifierOf("damascus_steel_rapier"), "rapier"));

        // Oblivion
        SMITHING_RECIPES.put("fiery_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_small_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_long_sword"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_dagger"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_big_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_lance"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_healing_staff"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_mace"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_francisca"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_javelin"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_ninjato"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_sickle"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("fiery_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_ingot"), "item", "item",
                MedievalMain.identifierOf("fiery_netherite_rapier"), ResourceLocation.fromNamespaceAndPath("oblivion", "fiery_netherite_upgrade_smithing_template")));

        SMITHING_RECIPES.put("scarlet_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_small_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_small_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_long_sword"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_long_sword"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_dagger"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_dagger"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_big_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_big_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_lance"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_lance"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_healing_staff"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_healing_staff"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_mace"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_mace"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_francisca"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_francisca"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_javelin"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_javelin"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_ninjato"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_ninjato"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_sickle"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_sickle"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));
        SMITHING_RECIPES.put("scarlet_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("fiery_netherite_rapier"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), "item", "item",
                MedievalMain.identifierOf("scarlet_rapier"), ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_upgrade_smithing_template")));

        SMITHING_RECIPES.put("solarite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_small_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_small_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_long_sword"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_long_sword"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_dagger"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_dagger"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_big_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_big_axe"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_lance"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_lance"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_healing_staff"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_healing_staff"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_mace"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_mace"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_francisca"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_francisca"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_javelin"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_javelin"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_ninjato"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_ninjato"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_sickle"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_sickle"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("solarite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("scarlet_rapier"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), "item", "item",
                MedievalMain.identifierOf("solarite_rapier"), ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_upgrade_smithing_template")));

        SHAPED_RECIPES.put("scarlet_small_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("scarlet_long_sword",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("scarlet_dagger",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_dagger"), "dagger"));
        SHAPED_RECIPES.put("scarlet_big_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("scarlet_lance",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_lance"), "lance"));
        SHAPED_RECIPES.put("scarlet_healing_staff",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("scarlet_mace",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_mace"), "mace"));
        SHAPED_RECIPES.put("scarlet_francisca",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_francisca"), "francisca"));
        SHAPED_RECIPES.put("scarlet_javelin",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_javelin"), "javelin"));
        SHAPED_RECIPES.put("scarlet_ninjato",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("scarlet_sickle",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_sickle"), "sickle"));
        SHAPED_RECIPES.put("scarlet_rapier",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "scarlet_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "iron_wood_stick"), "item", "item", MedievalMain.identifierOf("scarlet_rapier"), "rapier"));

        SHAPED_RECIPES.put("solarite_small_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("solarite_long_sword",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("solarite_dagger",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_dagger"), "dagger"));
        SHAPED_RECIPES.put("solarite_big_axe",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("solarite_lance",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_lance"), "lance"));
        SHAPED_RECIPES.put("solarite_healing_staff",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("solarite_mace",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_mace"), "mace"));
        SHAPED_RECIPES.put("solarite_francisca",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_francisca"), "francisca"));
        SHAPED_RECIPES.put("solarite_javelin",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_javelin"), "javelin"));
        SHAPED_RECIPES.put("solarite_ninjato",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("solarite_sickle",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_sickle"), "sickle"));
        SHAPED_RECIPES.put("solarite_rapier",
                new ShapedRecipeMaterial(ResourceLocation.fromNamespaceAndPath("oblivion", "solarite_ingot"), ResourceLocation.fromNamespaceAndPath("oblivion", "rune_wood_stick"), "item", "item", MedievalMain.identifierOf("solarite_rapier"), "rapier"));
    }

    public static void loadRecipes() {
        for (String key : SHAPED_RECIPES.keySet()) {
            ShapedRecipeMaterial material = SHAPED_RECIPES.get(key);
            RECIPES.put(MedievalMain.identifierOf(key), RecipeGenerator.generateJson(material.headItem, material.handleItem, material.headType, material.handleType, material.output, material.itemName));
        }
        for (String key : SMITHING_RECIPES.keySet()) {
            SmithingRecipeMaterial material = SMITHING_RECIPES.get(key);
            RECIPES.put(MedievalMain.identifierOf(key),
                    RecipeGenerator.generateSmithingJson(material.baseItem, material.additionItem, material.baseType, material.additionType, material.output, material.template));
        }
    }

}
