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
        SHAPED_RECIPES.put("wooden_big_axe", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("wooden_dagger", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_dagger"), "dagger"));
        SHAPED_RECIPES.put("wooden_francisca", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_francisca"), "francisca"));
        SHAPED_RECIPES.put("wooden_healing_staff",
                new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("wooden_javelin", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_javelin"), "javelin"));
        SHAPED_RECIPES.put("wooden_lance", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_lance"), "lance"));
        SHAPED_RECIPES.put("wooden_long_sword",
                new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("wooden_mace", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_mace"), "mace"));
        SHAPED_RECIPES.put("wooden_small_axe", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("wooden_ninjato", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("wooden_sickle", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_sickle"), "sickle"));
        SHAPED_RECIPES.put("wooden_rapier", new ShapedRecipeMaterial(Identifier.of("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("wooden_rapier"), "rapier"));
        // Stone
        SHAPED_RECIPES.put("stone_big_axe",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("stone_dagger",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_dagger"), "dagger"));
        SHAPED_RECIPES.put("stone_francisca",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_francisca"), "francisca"));
        SHAPED_RECIPES.put("stone_healing_staff",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("stone_javelin",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_javelin"), "javelin"));
        SHAPED_RECIPES.put("stone_lance", new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_lance"), "lance"));
        SHAPED_RECIPES.put("stone_long_sword",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("stone_mace", new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_mace"), "mace"));
        SHAPED_RECIPES.put("stone_small_axe",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("stone_ninjato",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("stone_sickle",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_sickle"), "sickle"));
        SHAPED_RECIPES.put("stone_rapier",
                new ShapedRecipeMaterial(Identifier.of("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.identifierOf("stone_rapier"), "rapier"));
        // Gold
        SHAPED_RECIPES.put("golden_big_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("golden_dagger",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_dagger"), "dagger"));
        SHAPED_RECIPES.put("golden_francisca",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_francisca"), "francisca"));
        SHAPED_RECIPES.put("golden_healing_staff",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("golden_javelin",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_javelin"), "javelin"));
        SHAPED_RECIPES.put("golden_lance",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_lance"), "lance"));
        SHAPED_RECIPES.put("golden_long_sword",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("golden_mace",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_mace"), "mace"));
        SHAPED_RECIPES.put("golden_small_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("golden_ninjato",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("golden_sickle",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_sickle"), "sickle"));
        SHAPED_RECIPES.put("golden_rapier",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("golden_rapier"), "rapier"));
        // Iron
        SHAPED_RECIPES.put("iron_big_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("iron_dagger",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_dagger"), "dagger"));
        SHAPED_RECIPES.put("iron_francisca",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_francisca"), "francisca"));
        SHAPED_RECIPES.put("iron_healing_staff",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("iron_javelin",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_javelin"), "javelin"));
        SHAPED_RECIPES.put("iron_lance",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_lance"), "lance"));
        SHAPED_RECIPES.put("iron_long_sword",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("iron_mace", new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_mace"), "mace"));
        SHAPED_RECIPES.put("iron_small_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("iron_ninjato",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("iron_sickle",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_sickle"), "sickle"));
        SHAPED_RECIPES.put("iron_rapier",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("iron_rapier"), "rapier"));
        // Diamond
        SHAPED_RECIPES.put("diamond_big_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("diamond_dagger",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_dagger"), "dagger"));
        SHAPED_RECIPES.put("diamond_francisca",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_francisca"), "francisca"));
        SHAPED_RECIPES.put("diamond_healing_staff",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("diamond_javelin",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_javelin"), "javelin"));
        SHAPED_RECIPES.put("diamond_lance",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_lance"), "lance"));
        SHAPED_RECIPES.put("diamond_long_sword",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("diamond_mace",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_mace"), "mace"));
        SHAPED_RECIPES.put("diamond_small_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("diamond_ninjato",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("diamond_sickle",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_sickle"), "sickle"));
        SHAPED_RECIPES.put("diamond_rapier",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("diamond_rapier"), "rapier"));
        // Netherite
        SMITHING_RECIPES.put("netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_big_axe"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_big_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_dagger"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_dagger"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_francisca"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_francisca"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_healing_staff"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_healing_staff"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_javelin"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_javelin"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_lance"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_lance"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_long_sword"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_long_sword"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_mace"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_mace"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_small_axe"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_small_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_ninjato"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_ninjato"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_sickle"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_sickle"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("diamond_rapier"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.identifierOf("netherite_rapier"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));

        if (CompatItems.isBetterEndLoaded) {
            SHAPED_RECIPES.put("terminite_small_axe",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("thallasium_small_axe", new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.identifierOf("thallasium_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("aeternium_small_axe", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("terminite_long_sword", new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.identifierOf("terminite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("thallasium_long_sword", new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.identifierOf("thallasium_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("aeternium_long_sword", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("terminite_dagger",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_dagger"), "dagger"));
            SHAPED_RECIPES.put("thallasium_dagger",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_dagger"), "dagger"));
            SHAPED_RECIPES.put("aeternium_dagger", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_dagger"), "dagger"));
            SHAPED_RECIPES.put("terminite_big_axe",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("thallasium_big_axe",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("aeternium_big_axe", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("terminite_lance",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_lance"), "lance"));
            SHAPED_RECIPES.put("thallasium_lance",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_lance"), "lance"));
            SHAPED_RECIPES.put("aeternium_lance", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_lance"), "lance"));
            SHAPED_RECIPES.put("terminite_healing_staff", new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.identifierOf("terminite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("thallasium_healing_staff", new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.identifierOf("thallasium_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("aeternium_healing_staff", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("terminite_mace",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_mace"), "mace"));
            SHAPED_RECIPES.put("thallasium_mace",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_mace"), "mace"));
            SHAPED_RECIPES.put("aeternium_mace", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_mace"), "mace"));
            SHAPED_RECIPES.put("terminite_francisca",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_francisca"), "francisca"));
            SHAPED_RECIPES.put("thallasium_francisca", new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.identifierOf("thallasium_francisca"), "francisca"));
            SHAPED_RECIPES.put("aeternium_francisca", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_francisca"), "francisca"));
            SHAPED_RECIPES.put("terminite_javelin",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_javelin"), "javelin"));
            SHAPED_RECIPES.put("thallasium_javelin",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_javelin"), "javelin"));
            SHAPED_RECIPES.put("aeternium_javelin", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_javelin"), "javelin"));
            SHAPED_RECIPES.put("terminite_ninjato",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("thallasium_ninjato",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("aeternium_ninjato", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("terminite_sickle",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_sickle"), "sickle"));
            SHAPED_RECIPES.put("thallasium_sickle",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_sickle"), "sickle"));
            SHAPED_RECIPES.put("aeternium_sickle", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_sickle"), "sickle"));
            SHAPED_RECIPES.put("terminite_rapier",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("terminite_rapier"), "rapier"));
            SHAPED_RECIPES.put("thallasium_rapier",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("thallasium_rapier"), "rapier"));
            SHAPED_RECIPES.put("aeternium_rapier", new ShapedRecipeMaterial(Identifier.of("betterend", "aeternium_ingot"), Identifier.of("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.identifierOf("aeternium_rapier"), "rapier"));
        }
        if (CompatItems.isBetterNetherLoaded) {
            SHAPED_RECIPES.put("nether_ruby_small_axe", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("cincinnasite_small_axe", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.identifierOf("cincinnasite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("cincinnasite_diamond_small_axe", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_small_axe"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_small_axe"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_long_sword", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("cincinnasite_long_sword", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.identifierOf("cincinnasite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("cincinnasite_diamond_long_sword", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_long_sword"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_long_sword"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_dagger", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_dagger"), "dagger"));
            SHAPED_RECIPES.put("cincinnasite_dagger", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_dagger"), "dagger"));
            SHAPED_RECIPES.put("cincinnasite_diamond_dagger", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_dagger"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_dagger"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_big_axe", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("cincinnasite_big_axe", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("cincinnasite_diamond_big_axe", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_big_axe"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_big_axe"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_lance", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_lance"), "lance"));
            SHAPED_RECIPES.put("cincinnasite_lance", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_lance"), "lance"));
            SHAPED_RECIPES.put("cincinnasite_diamond_lance", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_lance"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_lance"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_healing_staff", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("cincinnasite_healing_staff", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.identifierOf("cincinnasite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("cincinnasite_diamond_healing_staff", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_healing_staff"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_healing_staff"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_mace", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_mace"), "mace"));
            SHAPED_RECIPES.put("cincinnasite_mace", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_mace"), "mace"));
            SHAPED_RECIPES.put("cincinnasite_diamond_mace", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_mace"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_mace"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_francisca", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_francisca"), "francisca"));
            SHAPED_RECIPES.put("cincinnasite_francisca", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.identifierOf("cincinnasite_francisca"), "francisca"));
            SHAPED_RECIPES.put("cincinnasite_diamond_francisca", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_francisca"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_francisca"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_javelin", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_javelin"), "javelin"));
            SHAPED_RECIPES.put("cincinnasite_javelin", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_javelin"), "javelin"));
            SHAPED_RECIPES.put("cincinnasite_diamond_javelin", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_javelin"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_javelin"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_ninjato", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("cincinnasite_ninjato", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("cincinnasite_diamond_ninjato", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_ninjato"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_ninjato"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_sickle", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_sickle"), "sickle"));
            SHAPED_RECIPES.put("cincinnasite_sickle", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_sickle"), "sickle"));
            SHAPED_RECIPES.put("cincinnasite_diamond_sickle", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_sickle"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_sickle"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_rapier", new ShapedRecipeMaterial(Identifier.of("betternether", "nether_ruby"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("nether_ruby_rapier"), "rapier"));
            SHAPED_RECIPES.put("cincinnasite_rapier", new ShapedRecipeMaterial(Identifier.of("betternether", "cincinnasite_ingot"), Identifier.of("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_rapier"), "rapier"));
            SHAPED_RECIPES.put("cincinnasite_diamond_rapier", new ShapedRecipeMaterial(MedievalMain.identifierOf("cincinnasite_rapier"), Identifier.of("minecraft", "diamond"), "item", "item",
                    MedievalMain.identifierOf("cincinnasite_diamond_rapier"), "cincinnasite"));
        }
        if (CompatItems.isDragonLootLoaded) {
            SMITHING_RECIPES.put("dragon_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.identifierOf("dragon_small_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.identifierOf("dragon_long_sword"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.identifierOf("dragon_dagger"),
                    Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.identifierOf("dragon_big_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.identifierOf("dragon_lance"),
                    Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.identifierOf("dragon_healing_staff"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.identifierOf("dragon_mace"),
                    Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.identifierOf("dragon_francisca"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.identifierOf("dragon_javelin"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.identifierOf("dragon_ninjato"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.identifierOf("dragon_sickle"),
                    Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.identifierOf("dragon_rapier"),
                    Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        }
        if (CompatItems.isMythicMetalsLoaded) {
            SHAPED_RECIPES.put("adamantite_small_axe", new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.identifierOf("adamantite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("adamantite_long_sword", new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.identifierOf("adamantite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("adamantite_dagger",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_dagger"), "dagger"));
            SHAPED_RECIPES.put("adamantite_big_axe",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("adamantite_lance",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_lance"), "lance"));
            SHAPED_RECIPES.put("adamantite_healing_staff", new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.identifierOf("adamantite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("adamantite_mace",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_mace"), "mace"));
            SHAPED_RECIPES.put("adamantite_francisca", new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.identifierOf("adamantite_francisca"), "francisca"));
            SHAPED_RECIPES.put("adamantite_javelin",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_javelin"), "javelin"));
            SHAPED_RECIPES.put("adamantite_ninjato",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("adamantite_sickle",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_sickle"), "sickle"));
            SHAPED_RECIPES.put("adamantite_rapier",
                    new ShapedRecipeMaterial(Identifier.of("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("adamantite_rapier"), "rapier"));
        }
        if (CompatItems.isParadiseLostLoaded) {
            SHAPED_RECIPES.put("olvite_small_axe",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("olvite_long_sword",
                    new ShapedRecipeMaterial(Identifier.of("betterend", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("olvite_dagger",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_dagger"), "dagger"));
            SHAPED_RECIPES.put("olvite_big_axe",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("olvite_lance",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_lance"), "lance"));
            SHAPED_RECIPES.put("olvite_healing_staff",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("olvite_mace",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_mace"), "mace"));
            SHAPED_RECIPES.put("olvite_francisca",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_francisca"), "francisca"));
            SHAPED_RECIPES.put("olvite_javelin",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_javelin"), "javelin"));
            SHAPED_RECIPES.put("olvite_ninjato",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("olvite_sickle",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_sickle"), "sickle"));
            SHAPED_RECIPES.put("olvite_rapier",
                    new ShapedRecipeMaterial(Identifier.of("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.identifierOf("olvite_rapier"), "rapier"));
        }
        if (CompatItems.isBYGLoaded) {
            SMITHING_RECIPES.put("pendorite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_small_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_long_sword"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_dagger"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_big_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_lance"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_healing_staff"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_mace"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_francisca"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_javelin"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_ninjato"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_sickle"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), Identifier.of(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.identifierOf("pendorite_rapier"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        }
        if (CompatItems.isAdditionalAdditionsLoaded) {
            SMITHING_RECIPES.put("gilded_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_small_axe"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_long_sword"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_dagger"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_big_axe"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_lance"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), Identifier.of("additionaladditions:gold_ring"), "item",
                    "item", MedievalMain.identifierOf("gilded_netherite_healing_staff"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_mace"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_francisca"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_javelin"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_ninjato"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_sickle"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));
            SMITHING_RECIPES.put("gilded_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), Identifier.of("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.identifierOf("gilded_netherite_rapier"), Identifier.of("additionaladditions:gilded_netherite_upgrade")));

            SMITHING_RECIPES.put("rose_gold_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_small_axe"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_small_axe"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_long_sword"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_long_sword"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_dagger"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_dagger"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_big_axe"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_big_axe"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_lance"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_lance"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_healing_staff"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_healing_staff"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_mace"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_mace"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_francisca"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_francisca"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_javelin"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_javelin"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_ninjato"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_ninjato"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_rapier"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_rapier"), Identifier.of("additionaladditions:rose_gold_upgrade")));
            SMITHING_RECIPES.put("rose_gold_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("iron_sickle"), Identifier.of("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.identifierOf("rose_gold_sickle"), Identifier.of("additionaladditions:rose_gold_upgrade")));
        }
        if (CompatItems.isMythicUpgradesLoaded) {
            SMITHING_RECIPES.put("ruby_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_small_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_long_sword"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_dagger"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_big_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_lance"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_healing_staff"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_mace"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_francisca"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_javelin"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_ninjato"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_sickle"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), Identifier.of("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.identifierOf("ruby_netherite_rapier"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));

            SMITHING_RECIPES.put("sapphire_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_small_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_long_sword"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_dagger"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_big_axe"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_lance"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_healing_staff"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_mace"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_francisca"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_javelin"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_ninjato"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_rapier"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), Identifier.of("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.identifierOf("sapphire_netherite_sickle"), Identifier.of("minecraft:netherite_upgrade_smithing_template")));
        }
        if (CompatItems.isDeeperDarkerLoaded) {
            SMITHING_RECIPES.put("warden_small_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_small_axe"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_small_axe"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_long_sword", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_long_sword"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_long_sword"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_dagger", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_dagger"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_dagger"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_big_axe", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_big_axe"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_big_axe"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_lance", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_lance"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_lance"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_healing_staff", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_healing_staff"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_healing_staff"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_mace", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_mace"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_mace"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_francisca", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_francisca"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_francisca"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_javelin", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_javelin"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_javelin"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_ninjato", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_ninjato"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_ninjato"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_sickle", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_sickle"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_sickle"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_rapier", new SmithingRecipeMaterial(MedievalMain.identifierOf("netherite_rapier"), Identifier.of("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.identifierOf("warden_rapier"), Identifier.of("deeperdarker", "warden_upgrade_smithing_template")));
        }

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
