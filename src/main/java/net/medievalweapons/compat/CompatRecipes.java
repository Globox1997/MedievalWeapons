package net.medievalweapons.compat;

import com.google.gson.JsonObject;

import net.dragonloot.DragonLootMain;
import net.medievalweapons.MedievalMain;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import potionstudios.byg.BYG;

import java.util.HashMap;

public class CompatRecipes {

    public static HashMap<String, ShapedRecipeMaterial> SHAPED_RECIPES = new HashMap<>();
    public static HashMap<String, SmithingRecipeMaterial> SMITHING_RECIPES = new HashMap<>();

    public static HashMap<Identifier, JsonObject> RECIPES = new HashMap<>();

    public static void createRecipes() {
        // Wood
        SHAPED_RECIPES.put("wooden_big_axe", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("wooden_dagger", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_dagger"), "dagger"));
        SHAPED_RECIPES.put("wooden_francisca", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_francisca"), "francisca"));
        SHAPED_RECIPES.put("wooden_healing_staff",
                new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("wooden_javelin", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_javelin"), "javelin"));
        SHAPED_RECIPES.put("wooden_lance", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_lance"), "lance"));
        SHAPED_RECIPES.put("wooden_long_sword",
                new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("wooden_mace", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_mace"), "mace"));
        SHAPED_RECIPES.put("wooden_small_axe", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("wooden_ninjato", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("wooden_sickle", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_sickle"), "sickle"));
        SHAPED_RECIPES.put("wooden_rapier", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("wooden_rapier"), "rapier"));
        // Stone
        SHAPED_RECIPES.put("stone_big_axe",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("stone_dagger",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_dagger"), "dagger"));
        SHAPED_RECIPES.put("stone_francisca",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_francisca"), "francisca"));
        SHAPED_RECIPES.put("stone_healing_staff",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("stone_javelin",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_javelin"), "javelin"));
        SHAPED_RECIPES.put("stone_lance", new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_lance"), "lance"));
        SHAPED_RECIPES.put("stone_long_sword",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("stone_mace", new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_mace"), "mace"));
        SHAPED_RECIPES.put("stone_small_axe",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("stone_ninjato",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("stone_sickle",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_sickle"), "sickle"));
        SHAPED_RECIPES.put("stone_rapier",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.id("stone_rapier"), "rapier"));
        // Gold
        SHAPED_RECIPES.put("golden_big_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("golden_dagger",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_dagger"), "dagger"));
        SHAPED_RECIPES.put("golden_francisca",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_francisca"), "francisca"));
        SHAPED_RECIPES.put("golden_healing_staff",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("golden_javelin",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_javelin"), "javelin"));
        SHAPED_RECIPES.put("golden_lance",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_lance"), "lance"));
        SHAPED_RECIPES.put("golden_long_sword",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("golden_mace",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_mace"), "mace"));
        SHAPED_RECIPES.put("golden_small_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("golden_ninjato",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("golden_sickle",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_sickle"), "sickle"));
        SHAPED_RECIPES.put("golden_rapier",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("golden_rapier"), "rapier"));
        // Iron
        SHAPED_RECIPES.put("iron_big_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("iron_dagger",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_dagger"), "dagger"));
        SHAPED_RECIPES.put("iron_francisca",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_francisca"), "francisca"));
        SHAPED_RECIPES.put("iron_healing_staff",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("iron_javelin",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_javelin"), "javelin"));
        SHAPED_RECIPES.put("iron_lance",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_lance"), "lance"));
        SHAPED_RECIPES.put("iron_long_sword",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("iron_mace", new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_mace"), "mace"));
        SHAPED_RECIPES.put("iron_small_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("iron_ninjato",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("iron_sickle",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_sickle"), "sickle"));
        SHAPED_RECIPES.put("iron_rapier",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("iron_rapier"), "rapier"));
        // Diamond
        SHAPED_RECIPES.put("diamond_big_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("diamond_dagger",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_dagger"), "dagger"));
        SHAPED_RECIPES.put("diamond_francisca",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_francisca"), "francisca"));
        SHAPED_RECIPES.put("diamond_healing_staff",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("diamond_javelin",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_javelin"), "javelin"));
        SHAPED_RECIPES.put("diamond_lance",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_lance"), "lance"));
        SHAPED_RECIPES.put("diamond_long_sword",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("diamond_mace",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_mace"), "mace"));
        SHAPED_RECIPES.put("diamond_small_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("diamond_ninjato",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("diamond_sickle",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_sickle"), "sickle"));
        SHAPED_RECIPES.put("diamond_rapier",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("diamond_rapier"), "rapier"));
        // Netherite
        SMITHING_RECIPES.put("netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.id("diamond_big_axe"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_big_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_dagger", new SmithingRecipeMaterial(MedievalMain.id("diamond_dagger"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_dagger"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_francisca", new SmithingRecipeMaterial(MedievalMain.id("diamond_francisca"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_francisca"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.id("diamond_healing_staff"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_healing_staff"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_javelin", new SmithingRecipeMaterial(MedievalMain.id("diamond_javelin"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_javelin"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_lance", new SmithingRecipeMaterial(MedievalMain.id("diamond_lance"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_lance"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.id("diamond_long_sword"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_long_sword"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_mace", new SmithingRecipeMaterial(MedievalMain.id("diamond_mace"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_mace"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.id("diamond_small_axe"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_small_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.id("diamond_ninjato"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_ninjato"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_sickle", new SmithingRecipeMaterial(MedievalMain.id("diamond_sickle"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_sickle"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_rapier", new SmithingRecipeMaterial(MedievalMain.id("diamond_rapier"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.id("netherite_rapier"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));

        if (CompatItems.isBetterEndLoaded) {
            SHAPED_RECIPES.put("terminite_small_axe",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("terminite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("thallasium_small_axe", new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.id("thallasium_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("aeternium_small_axe", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("terminite_long_sword", new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.id("terminite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("thallasium_long_sword", new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.id("thallasium_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("aeternium_long_sword", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("terminite_dagger",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("terminite_dagger"), "dagger"));
            SHAPED_RECIPES.put("thallasium_dagger",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("thallasium_dagger"), "dagger"));
            SHAPED_RECIPES.put("aeternium_dagger", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_dagger"), "dagger"));
            SHAPED_RECIPES.put("terminite_big_axe",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("terminite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("thallasium_big_axe",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("thallasium_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("aeternium_big_axe", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("terminite_lance",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("terminite_lance"), "lance"));
            SHAPED_RECIPES.put("thallasium_lance",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("thallasium_lance"), "lance"));
            SHAPED_RECIPES.put("aeternium_lance", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_lance"), "lance"));
            SHAPED_RECIPES.put("terminite_healing_staff", new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.id("terminite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("thallasium_healing_staff", new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.id("thallasium_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("aeternium_healing_staff", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("terminite_mace",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("terminite_mace"), "mace"));
            SHAPED_RECIPES.put("thallasium_mace",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("thallasium_mace"), "mace"));
            SHAPED_RECIPES.put("aeternium_mace", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_mace"), "mace"));
            SHAPED_RECIPES.put("terminite_francisca",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("terminite_francisca"), "francisca"));
            SHAPED_RECIPES.put("thallasium_francisca", new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.id("thallasium_francisca"), "francisca"));
            SHAPED_RECIPES.put("aeternium_francisca", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_francisca"), "francisca"));
            SHAPED_RECIPES.put("terminite_javelin",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("terminite_javelin"), "javelin"));
            SHAPED_RECIPES.put("thallasium_javelin",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("thallasium_javelin"), "javelin"));
            SHAPED_RECIPES.put("aeternium_javelin", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_javelin"), "javelin"));
            SHAPED_RECIPES.put("terminite_ninjato",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("terminite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("thallasium_ninjato",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("thallasium_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("aeternium_ninjato", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("terminite_sickle",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("terminite_sickle"), "sickle"));
            SHAPED_RECIPES.put("thallasium_sickle",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("thallasium_sickle"), "sickle"));
            SHAPED_RECIPES.put("aeternium_sickle", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_sickle"), "sickle"));
            SHAPED_RECIPES.put("terminite_rapier",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("terminite_rapier"), "rapier"));
            SHAPED_RECIPES.put("thallasium_rapier",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("thallasium_rapier"), "rapier"));
            SHAPED_RECIPES.put("aeternium_rapier", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.id("aeternium_rapier"), "rapier"));
        }
        if (CompatItems.isBetterNetherLoaded) {
            SHAPED_RECIPES.put("nether_ruby_small_axe", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("cincinnasite_small_axe", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.id("cincinnasite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("cincinnasite_diamond_small_axe", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_small_axe"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_small_axe"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_long_sword", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("cincinnasite_long_sword", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.id("cincinnasite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("cincinnasite_diamond_long_sword", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_long_sword"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_long_sword"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_dagger", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_dagger"), "dagger"));
            SHAPED_RECIPES.put("cincinnasite_dagger", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("cincinnasite_dagger"), "dagger"));
            SHAPED_RECIPES.put("cincinnasite_diamond_dagger", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_dagger"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_dagger"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_big_axe", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("cincinnasite_big_axe", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("cincinnasite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("cincinnasite_diamond_big_axe", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_big_axe"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_big_axe"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_lance", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_lance"), "lance"));
            SHAPED_RECIPES.put("cincinnasite_lance", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("cincinnasite_lance"), "lance"));
            SHAPED_RECIPES.put("cincinnasite_diamond_lance", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_lance"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_lance"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_healing_staff", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("cincinnasite_healing_staff", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.id("cincinnasite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("cincinnasite_diamond_healing_staff", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_healing_staff"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_healing_staff"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_mace", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_mace"), "mace"));
            SHAPED_RECIPES.put("cincinnasite_mace", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("cincinnasite_mace"), "mace"));
            SHAPED_RECIPES.put("cincinnasite_diamond_mace", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_mace"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_mace"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_francisca", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_francisca"), "francisca"));
            SHAPED_RECIPES.put("cincinnasite_francisca", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.id("cincinnasite_francisca"), "francisca"));
            SHAPED_RECIPES.put("cincinnasite_diamond_francisca", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_francisca"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_francisca"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_javelin", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_javelin"), "javelin"));
            SHAPED_RECIPES.put("cincinnasite_javelin", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("cincinnasite_javelin"), "javelin"));
            SHAPED_RECIPES.put("cincinnasite_diamond_javelin", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_javelin"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_javelin"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_ninjato", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("cincinnasite_ninjato", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("cincinnasite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("cincinnasite_diamond_ninjato", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_ninjato"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_ninjato"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_sickle", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_sickle"), "sickle"));
            SHAPED_RECIPES.put("cincinnasite_sickle", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("cincinnasite_sickle"), "sickle"));
            SHAPED_RECIPES.put("cincinnasite_diamond_sickle", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_sickle"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_sickle"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_rapier", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("nether_ruby_rapier"), "rapier"));
            SHAPED_RECIPES.put("cincinnasite_rapier", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.id("cincinnasite_rapier"), "rapier"));
            SHAPED_RECIPES.put("cincinnasite_diamond_rapier", new ShapedRecipeMaterial(MedievalMain.id("cincinnasite_rapier"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.id("cincinnasite_diamond_rapier"), "cincinnasite"));
        }
        if (CompatItems.isDragonLootLoaded) {
            SMITHING_RECIPES.put("dragon_small_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_small_axe"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.id("dragon_small_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_long_sword", new SmithingRecipeMaterial(MedievalMain.id("netherite_long_sword"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.id("dragon_long_sword"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_dagger", new SmithingRecipeMaterial(MedievalMain.id("netherite_dagger"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.id("dragon_dagger"),
                    Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_big_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_big_axe"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.id("dragon_big_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_lance", new SmithingRecipeMaterial(MedievalMain.id("netherite_lance"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.id("dragon_lance"),
                    Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_healing_staff", new SmithingRecipeMaterial(MedievalMain.id("netherite_healing_staff"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.id("dragon_healing_staff"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_mace", new SmithingRecipeMaterial(MedievalMain.id("netherite_mace"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.id("dragon_mace"),
                    Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_francisca", new SmithingRecipeMaterial(MedievalMain.id("netherite_francisca"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.id("dragon_francisca"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_javelin", new SmithingRecipeMaterial(MedievalMain.id("netherite_javelin"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.id("dragon_javelin"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_ninjato", new SmithingRecipeMaterial(MedievalMain.id("netherite_ninjato"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.id("dragon_ninjato"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_sickle", new SmithingRecipeMaterial(MedievalMain.id("netherite_sickle"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.id("dragon_sickle"),
                    Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_rapier", new SmithingRecipeMaterial(MedievalMain.id("netherite_rapier"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.id("dragon_rapier"),
                    Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        }
        if (CompatItems.isMythicMetalsLoaded) {
            SHAPED_RECIPES.put("adamantite_small_axe", new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.id("adamantite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("adamantite_long_sword", new ShapedRecipeMaterial(Identifier.of("betterend", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.id("adamantite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("adamantite_dagger",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("adamantite_dagger"), "dagger"));
            SHAPED_RECIPES.put("adamantite_big_axe",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("adamantite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("adamantite_lance",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("adamantite_lance"), "lance"));
            SHAPED_RECIPES.put("adamantite_healing_staff", new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.id("adamantite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("adamantite_mace",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("adamantite_mace"), "mace"));
            SHAPED_RECIPES.put("adamantite_francisca", new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.id("adamantite_francisca"), "francisca"));
            SHAPED_RECIPES.put("adamantite_javelin",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("adamantite_javelin"), "javelin"));
            SHAPED_RECIPES.put("adamantite_ninjato",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("adamantite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("adamantite_sickle",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("adamantite_sickle"), "sickle"));
            SHAPED_RECIPES.put("adamantite_rapier",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("adamantite_rapier"), "rapier"));
        }
        if (CompatItems.isParadiseLostLoaded) {
            SHAPED_RECIPES.put("olvite_small_axe",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("olvite_long_sword",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("olvite_dagger",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_dagger"), "dagger"));
            SHAPED_RECIPES.put("olvite_big_axe",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("olvite_lance",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_lance"), "lance"));
            SHAPED_RECIPES.put("olvite_healing_staff",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("olvite_mace",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_mace"), "mace"));
            SHAPED_RECIPES.put("olvite_francisca",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_francisca"), "francisca"));
            SHAPED_RECIPES.put("olvite_javelin",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_javelin"), "javelin"));
            SHAPED_RECIPES.put("olvite_ninjato",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("olvite_sickle",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_sickle"), "sickle"));
            SHAPED_RECIPES.put("olvite_rapier",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.id("olvite_rapier"), "rapier"));
        }
        if (CompatItems.isBYGLoaded) {
            SMITHING_RECIPES.put("pendorite_small_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_small_axe"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_small_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_long_sword", new SmithingRecipeMaterial(MedievalMain.id("netherite_long_sword"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_long_sword"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_dagger", new SmithingRecipeMaterial(MedievalMain.id("netherite_dagger"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_dagger"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_big_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_big_axe"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_big_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_lance", new SmithingRecipeMaterial(MedievalMain.id("netherite_lance"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_lance"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_healing_staff", new SmithingRecipeMaterial(MedievalMain.id("netherite_healing_staff"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_healing_staff"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_mace", new SmithingRecipeMaterial(MedievalMain.id("netherite_mace"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_mace"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_francisca", new SmithingRecipeMaterial(MedievalMain.id("netherite_francisca"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_francisca"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_javelin", new SmithingRecipeMaterial(MedievalMain.id("netherite_javelin"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_javelin"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_ninjato", new SmithingRecipeMaterial(MedievalMain.id("netherite_ninjato"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_ninjato"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_sickle", new SmithingRecipeMaterial(MedievalMain.id("netherite_sickle"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_sickle"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_rapier", new SmithingRecipeMaterial(MedievalMain.id("netherite_rapier"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.id("pendorite_rapier"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        }
        if (CompatItems.isAdditionalAdditionsLoaded) {
            SMITHING_RECIPES.put("gilded_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_small_axe"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_small_axe"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.id("netherite_long_sword"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_long_sword"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.id("netherite_dagger"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_dagger"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_big_axe"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_big_axe"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_lance", new SmithingRecipeMaterial(MedievalMain.id("netherite_lance"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_lance"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.id("netherite_healing_staff"), Identifier.of("additionaladditions:gold_ring"), "item",
                    "item", MedievalMain.id("gilded_netherite_healing_staff"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_mace", new SmithingRecipeMaterial(MedievalMain.id("netherite_mace"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_mace"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.id("netherite_francisca"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_francisca"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.id("netherite_javelin"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_javelin"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.id("netherite_ninjato"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_ninjato"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.id("netherite_sickle"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_sickle"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.id("netherite_rapier"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.id("gilded_netherite_rapier"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));

            SMITHING_RECIPES.put("rose_gold_small_axe", new SmithingRecipeMaterial(MedievalMain.id("iron_small_axe"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_small_axe"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_long_sword", new SmithingRecipeMaterial(MedievalMain.id("iron_long_sword"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_long_sword"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_dagger", new SmithingRecipeMaterial(MedievalMain.id("iron_dagger"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_dagger"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_big_axe", new SmithingRecipeMaterial(MedievalMain.id("iron_big_axe"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_big_axe"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_lance", new SmithingRecipeMaterial(MedievalMain.id("iron_lance"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_lance"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_healing_staff", new SmithingRecipeMaterial(MedievalMain.id("iron_healing_staff"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_healing_staff"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_mace", new SmithingRecipeMaterial(MedievalMain.id("iron_mace"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_mace"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_francisca", new SmithingRecipeMaterial(MedievalMain.id("iron_francisca"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_francisca"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_javelin", new SmithingRecipeMaterial(MedievalMain.id("iron_javelin"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_javelin"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_ninjato", new SmithingRecipeMaterial(MedievalMain.id("iron_ninjato"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_ninjato"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_rapier", new SmithingRecipeMaterial(MedievalMain.id("iron_rapier"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_rapier"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_sickle", new SmithingRecipeMaterial(MedievalMain.id("iron_sickle"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.id("rose_gold_sickle"), Identifier.of("additionaladditions:rose_gold_upgrade")));
        }
        if (CompatItems.isMythicUpgradesLoaded) {
            SMITHING_RECIPES.put("ruby_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_small_axe"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_small_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.id("netherite_long_sword"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_long_sword"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.id("netherite_dagger"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_dagger"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_big_axe"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_big_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_lance", new SmithingRecipeMaterial(MedievalMain.id("netherite_lance"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_lance"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.id("netherite_healing_staff"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_healing_staff"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_mace", new SmithingRecipeMaterial(MedievalMain.id("netherite_mace"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_mace"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.id("netherite_francisca"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_francisca"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.id("netherite_javelin"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_javelin"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.id("netherite_ninjato"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_ninjato"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.id("netherite_sickle"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_sickle"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.id("netherite_rapier"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.id("ruby_netherite_rapier"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));

            SMITHING_RECIPES.put("sapphire_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_small_axe"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_small_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.id("netherite_long_sword"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_long_sword"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.id("netherite_dagger"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_dagger"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_big_axe"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_big_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_lance", new SmithingRecipeMaterial(MedievalMain.id("netherite_lance"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_lance"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.id("netherite_healing_staff"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_healing_staff"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_mace", new SmithingRecipeMaterial(MedievalMain.id("netherite_mace"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_mace"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.id("netherite_francisca"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_francisca"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.id("netherite_javelin"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_javelin"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.id("netherite_ninjato"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_ninjato"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.id("netherite_rapier"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_rapier"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.id("netherite_sickle"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.id("sapphire_netherite_sickle"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        }
        if (CompatItems.isDeeperDarkerLoaded) {
            SMITHING_RECIPES.put("warden_small_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_small_axe"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_small_axe"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_long_sword", new SmithingRecipeMaterial(MedievalMain.id("netherite_long_sword"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_long_sword"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_dagger", new SmithingRecipeMaterial(MedievalMain.id("netherite_dagger"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_dagger"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_big_axe", new SmithingRecipeMaterial(MedievalMain.id("netherite_big_axe"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_big_axe"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_lance", new SmithingRecipeMaterial(MedievalMain.id("netherite_lance"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_lance"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_healing_staff", new SmithingRecipeMaterial(MedievalMain.id("netherite_healing_staff"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_healing_staff"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_mace", new SmithingRecipeMaterial(MedievalMain.id("netherite_mace"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_mace"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_francisca", new SmithingRecipeMaterial(MedievalMain.id("netherite_francisca"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_francisca"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_javelin", new SmithingRecipeMaterial(MedievalMain.id("netherite_javelin"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_javelin"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_ninjato", new SmithingRecipeMaterial(MedievalMain.id("netherite_ninjato"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_ninjato"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_sickle", new SmithingRecipeMaterial(MedievalMain.id("netherite_sickle"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_sickle"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_rapier", new SmithingRecipeMaterial(MedievalMain.id("netherite_rapier"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.id("warden_rapier"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
        }

    }

    public static void loadRecipes() {
        for (String key : SHAPED_RECIPES.keySet()) {
            ShapedRecipeMaterial material = SHAPED_RECIPES.get(key);
            RECIPES.put(MedievalMain.id(key), RecipeGenerator.generateJson(material.headItem, material.handleItem, material.headType, material.handleType, material.output, material.itemName));
        }
        for (String key : SMITHING_RECIPES.keySet()) {
            SmithingRecipeMaterial material = SMITHING_RECIPES.get(key);
            RECIPES.put(MedievalMain.id(key),
                    RecipeGenerator.generateSmithingJson(material.baseItem, material.additionItem, material.baseType, material.additionType, material.output, material.template));
        }
    }

}
