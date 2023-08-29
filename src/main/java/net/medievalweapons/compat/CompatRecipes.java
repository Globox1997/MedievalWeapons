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
        SHAPED_RECIPES.put("wooden_big_axe", new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("wooden_dagger", new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_dagger"), "dagger"));
        SHAPED_RECIPES.put("wooden_francisca",
                new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_francisca"), "francisca"));
        SHAPED_RECIPES.put("wooden_healing_staff",
                new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("wooden_javelin", new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_javelin"), "javelin"));
        SHAPED_RECIPES.put("wooden_lance", new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_lance"), "lance"));
        SHAPED_RECIPES.put("wooden_long_sword",
                new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("wooden_mace", new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_mace"), "mace"));
        SHAPED_RECIPES.put("wooden_small_axe",
                new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("wooden_ninjato", new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("wooden_sickle", new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_sickle"), "sickle"));
        SHAPED_RECIPES.put("wooden_rapier", new ShapedRecipeMaterial(new Identifier("planks"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("wooden_rapier"), "rapier"));
        // Stone
        SHAPED_RECIPES.put("stone_big_axe",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("stone_dagger",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_dagger"), "dagger"));
        SHAPED_RECIPES.put("stone_francisca",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_francisca"), "francisca"));
        SHAPED_RECIPES.put("stone_healing_staff",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("stone_javelin",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_javelin"), "javelin"));
        SHAPED_RECIPES.put("stone_lance",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_lance"), "lance"));
        SHAPED_RECIPES.put("stone_long_sword",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("stone_mace", new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_mace"), "mace"));
        SHAPED_RECIPES.put("stone_small_axe",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("stone_ninjato",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("stone_sickle",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_sickle"), "sickle"));
        SHAPED_RECIPES.put("stone_rapier",
                new ShapedRecipeMaterial(new Identifier("stone_tool_materials"), Registries.ITEM.getId(Items.STICK), "tag", "item", MedievalMain.ID("stone_rapier"), "rapier"));
        // Gold
        SHAPED_RECIPES.put("golden_big_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("golden_dagger",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_dagger"), "dagger"));
        SHAPED_RECIPES.put("golden_francisca",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_francisca"), "francisca"));
        SHAPED_RECIPES.put("golden_healing_staff",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("golden_javelin",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_javelin"), "javelin"));
        SHAPED_RECIPES.put("golden_lance",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_lance"), "lance"));
        SHAPED_RECIPES.put("golden_long_sword",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("golden_mace",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_mace"), "mace"));
        SHAPED_RECIPES.put("golden_small_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("golden_ninjato",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("golden_sickle",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_sickle"), "sickle"));
        SHAPED_RECIPES.put("golden_rapier",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.GOLD_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("golden_rapier"), "rapier"));
        // Iron
        SHAPED_RECIPES.put("iron_big_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("iron_dagger",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_dagger"), "dagger"));
        SHAPED_RECIPES.put("iron_francisca",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_francisca"), "francisca"));
        SHAPED_RECIPES.put("iron_healing_staff",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("iron_javelin",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_javelin"), "javelin"));
        SHAPED_RECIPES.put("iron_lance",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_lance"), "lance"));
        SHAPED_RECIPES.put("iron_long_sword",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("iron_mace", new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_mace"), "mace"));
        SHAPED_RECIPES.put("iron_small_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("iron_ninjato",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("iron_sickle",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_sickle"), "sickle"));
        SHAPED_RECIPES.put("iron_rapier",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.IRON_INGOT), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("iron_rapier"), "rapier"));
        // Diamond
        SHAPED_RECIPES.put("diamond_big_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_big_axe"), "big_axe"));
        SHAPED_RECIPES.put("diamond_dagger",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_dagger"), "dagger"));
        SHAPED_RECIPES.put("diamond_francisca",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_francisca"), "francisca"));
        SHAPED_RECIPES.put("diamond_healing_staff",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_healing_staff"), "healing_staff"));
        SHAPED_RECIPES.put("diamond_javelin",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_javelin"), "javelin"));
        SHAPED_RECIPES.put("diamond_lance",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_lance"), "lance"));
        SHAPED_RECIPES.put("diamond_long_sword",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_long_sword"), "long_sword"));
        SHAPED_RECIPES.put("diamond_mace",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_mace"), "mace"));
        SHAPED_RECIPES.put("diamond_small_axe",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_small_axe"), "small_axe"));
        SHAPED_RECIPES.put("diamond_ninjato",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_ninjato"), "ninjato"));
        SHAPED_RECIPES.put("diamond_sickle",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_sickle"), "sickle"));
        SHAPED_RECIPES.put("diamond_rapier",
                new ShapedRecipeMaterial(Registries.ITEM.getId(Items.DIAMOND), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("diamond_rapier"), "rapier"));
        // Netherite
        SMITHING_RECIPES.put("netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.ID("diamond_big_axe"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_big_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_dagger", new SmithingRecipeMaterial(MedievalMain.ID("diamond_dagger"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_dagger"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_francisca", new SmithingRecipeMaterial(MedievalMain.ID("diamond_francisca"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_francisca"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.ID("diamond_healing_staff"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_healing_staff"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_javelin", new SmithingRecipeMaterial(MedievalMain.ID("diamond_javelin"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_javelin"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_lance", new SmithingRecipeMaterial(MedievalMain.ID("diamond_lance"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_lance"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.ID("diamond_long_sword"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_long_sword"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_mace", new SmithingRecipeMaterial(MedievalMain.ID("diamond_mace"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_mace"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.ID("diamond_small_axe"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_small_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.ID("diamond_ninjato"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_ninjato"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_sickle", new SmithingRecipeMaterial(MedievalMain.ID("diamond_sickle"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_sickle"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        SMITHING_RECIPES.put("netherite_rapier", new SmithingRecipeMaterial(MedievalMain.ID("diamond_rapier"), Registries.ITEM.getId(Items.NETHERITE_INGOT), "item", "item",
                MedievalMain.ID("netherite_rapier"), new Identifier("minecraft:netherite_upgrade_smithing_template")));

        if (CompatItems.isBetterEndLoaded) {
            SHAPED_RECIPES.put("terminite_small_axe",
                    new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("terminite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("thallasium_small_axe", new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("thallasium_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("aeternium_small_axe", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("terminite_long_sword", new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("terminite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("thallasium_long_sword", new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("thallasium_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("aeternium_long_sword", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("terminite_dagger",
                    new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("terminite_dagger"), "dagger"));
            SHAPED_RECIPES.put("thallasium_dagger",
                    new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("thallasium_dagger"), "dagger"));
            SHAPED_RECIPES.put("aeternium_dagger", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_dagger"), "dagger"));
            SHAPED_RECIPES.put("terminite_big_axe",
                    new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("terminite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("thallasium_big_axe",
                    new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("thallasium_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("aeternium_big_axe", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("terminite_lance",
                    new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("terminite_lance"), "lance"));
            SHAPED_RECIPES.put("thallasium_lance",
                    new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("thallasium_lance"), "lance"));
            SHAPED_RECIPES.put("aeternium_lance", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_lance"), "lance"));
            SHAPED_RECIPES.put("terminite_healing_staff", new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("terminite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("thallasium_healing_staff", new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("thallasium_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("aeternium_healing_staff", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item",
                    "item", MedievalMain.ID("aeternium_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("terminite_mace",
                    new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("terminite_mace"), "mace"));
            SHAPED_RECIPES.put("thallasium_mace",
                    new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("thallasium_mace"), "mace"));
            SHAPED_RECIPES.put("aeternium_mace", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_mace"), "mace"));
            SHAPED_RECIPES.put("terminite_francisca",
                    new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("terminite_francisca"), "francisca"));
            SHAPED_RECIPES.put("thallasium_francisca", new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("thallasium_francisca"), "francisca"));
            SHAPED_RECIPES.put("aeternium_francisca", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_francisca"), "francisca"));
            SHAPED_RECIPES.put("terminite_javelin",
                    new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("terminite_javelin"), "javelin"));
            SHAPED_RECIPES.put("thallasium_javelin",
                    new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("thallasium_javelin"), "javelin"));
            SHAPED_RECIPES.put("aeternium_javelin", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_javelin"), "javelin"));
            SHAPED_RECIPES.put("terminite_ninjato",
                    new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("terminite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("thallasium_ninjato",
                    new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("thallasium_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("aeternium_ninjato", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("terminite_sickle",
                    new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("terminite_sickle"), "sickle"));
            SHAPED_RECIPES.put("thallasium_sickle",
                    new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("thallasium_sickle"), "sickle"));
            SHAPED_RECIPES.put("aeternium_sickle", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_sickle"), "sickle"));
            SHAPED_RECIPES.put("terminite_rapier",
                    new ShapedRecipeMaterial(new Identifier("betterend", "terminite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("terminite_rapier"), "rapier"));
            SHAPED_RECIPES.put("thallasium_rapier",
                    new ShapedRecipeMaterial(new Identifier("betterend", "thallasium_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("thallasium_rapier"), "rapier"));
            SHAPED_RECIPES.put("aeternium_rapier", new ShapedRecipeMaterial(new Identifier("betterend", "aeternium_ingot"), new Identifier("betterend", "leather_wrapped_stick"), "item", "item",
                    MedievalMain.ID("aeternium_rapier"), "rapier"));
        }
        if (CompatItems.isBetterNetherLoaded) {
            SHAPED_RECIPES.put("nether_ruby_small_axe", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("cincinnasite_small_axe", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.ID("cincinnasite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("cincinnasite_diamond_small_axe", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_small_axe"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_small_axe"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_long_sword", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("cincinnasite_long_sword", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.ID("cincinnasite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("cincinnasite_diamond_long_sword", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_long_sword"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_long_sword"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_dagger", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_dagger"), "dagger"));
            SHAPED_RECIPES.put("cincinnasite_dagger", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.ID("cincinnasite_dagger"), "dagger"));
            SHAPED_RECIPES.put("cincinnasite_diamond_dagger", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_dagger"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_dagger"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_big_axe", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("cincinnasite_big_axe", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.ID("cincinnasite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("cincinnasite_diamond_big_axe", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_big_axe"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_big_axe"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_lance", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_lance"), "lance"));
            SHAPED_RECIPES.put("cincinnasite_lance", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("cincinnasite_lance"), "lance"));
            SHAPED_RECIPES.put("cincinnasite_diamond_lance", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_lance"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_lance"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_healing_staff", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("cincinnasite_healing_staff", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.ID("cincinnasite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("cincinnasite_diamond_healing_staff", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_healing_staff"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_healing_staff"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_mace", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_mace"), "mace"));
            SHAPED_RECIPES.put("cincinnasite_mace", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("cincinnasite_mace"), "mace"));
            SHAPED_RECIPES.put("cincinnasite_diamond_mace", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_mace"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_mace"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_francisca", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_francisca"), "francisca"));
            SHAPED_RECIPES.put("cincinnasite_francisca", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.ID("cincinnasite_francisca"), "francisca"));
            SHAPED_RECIPES.put("cincinnasite_diamond_francisca", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_francisca"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_francisca"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_javelin", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_javelin"), "javelin"));
            SHAPED_RECIPES.put("cincinnasite_javelin", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.ID("cincinnasite_javelin"), "javelin"));
            SHAPED_RECIPES.put("cincinnasite_diamond_javelin", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_javelin"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_javelin"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_ninjato", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("cincinnasite_ninjato", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.ID("cincinnasite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("cincinnasite_diamond_ninjato", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_ninjato"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_ninjato"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_sickle", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_sickle"), "sickle"));
            SHAPED_RECIPES.put("cincinnasite_sickle", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.ID("cincinnasite_sickle"), "sickle"));
            SHAPED_RECIPES.put("cincinnasite_diamond_sickle", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_sickle"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_sickle"), "cincinnasite"));
            SHAPED_RECIPES.put("nether_ruby_rapier", new ShapedRecipeMaterial(new Identifier("betternether", "nether_ruby"), new Identifier("betternether", "nether_reed_stem"), "item", "item",
                    MedievalMain.ID("nether_ruby_rapier"), "rapier"));
            SHAPED_RECIPES.put("cincinnasite_rapier", new ShapedRecipeMaterial(new Identifier("betternether", "cincinnasite_ingot"), new Identifier("betternether", "nether_reed_stem"), "item",
                    "item", MedievalMain.ID("cincinnasite_rapier"), "rapier"));
            SHAPED_RECIPES.put("cincinnasite_diamond_rapier", new ShapedRecipeMaterial(MedievalMain.ID("cincinnasite_rapier"), new Identifier("minecraft", "diamond"), "item", "item",
                    MedievalMain.ID("cincinnasite_diamond_rapier"), "cincinnasite"));
        }
        if (CompatItems.isDragonLootLoaded) {
            SMITHING_RECIPES.put("dragon_small_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_small_axe"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.ID("dragon_small_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_long_sword", new SmithingRecipeMaterial(MedievalMain.ID("netherite_long_sword"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.ID("dragon_long_sword"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_dagger", new SmithingRecipeMaterial(MedievalMain.ID("netherite_dagger"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.ID("dragon_dagger"),
                    new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_big_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_big_axe"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.ID("dragon_big_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_lance", new SmithingRecipeMaterial(MedievalMain.ID("netherite_lance"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.ID("dragon_lance"),
                    new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_healing_staff", new SmithingRecipeMaterial(MedievalMain.ID("netherite_healing_staff"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.ID("dragon_healing_staff"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_mace", new SmithingRecipeMaterial(MedievalMain.ID("netherite_mace"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.ID("dragon_mace"),
                    new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_francisca", new SmithingRecipeMaterial(MedievalMain.ID("netherite_francisca"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.ID("dragon_francisca"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_javelin", new SmithingRecipeMaterial(MedievalMain.ID("netherite_javelin"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.ID("dragon_javelin"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_ninjato", new SmithingRecipeMaterial(MedievalMain.ID("netherite_ninjato"), DragonLootMain.ID("dragon_scale"), "item", "item",
                    MedievalMain.ID("dragon_ninjato"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_sickle", new SmithingRecipeMaterial(MedievalMain.ID("netherite_sickle"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.ID("dragon_sickle"),
                    new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("dragon_rapier", new SmithingRecipeMaterial(MedievalMain.ID("netherite_rapier"), DragonLootMain.ID("dragon_scale"), "item", "item", MedievalMain.ID("dragon_rapier"),
                    new Identifier("minecraft:netherite_upgrade_smithing_template")));
        }
        if (CompatItems.isMythicMetalsLoaded) {
            SHAPED_RECIPES.put("adamantite_small_axe", new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("adamantite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("adamantite_long_sword", new ShapedRecipeMaterial(new Identifier("betterend", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("adamantite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("adamantite_dagger",
                    new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("adamantite_dagger"), "dagger"));
            SHAPED_RECIPES.put("adamantite_big_axe", new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("adamantite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("adamantite_lance",
                    new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("adamantite_lance"), "lance"));
            SHAPED_RECIPES.put("adamantite_healing_staff", new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("adamantite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("adamantite_mace",
                    new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("adamantite_mace"), "mace"));
            SHAPED_RECIPES.put("adamantite_francisca", new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("adamantite_francisca"), "francisca"));
            SHAPED_RECIPES.put("adamantite_javelin", new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("adamantite_javelin"), "javelin"));
            SHAPED_RECIPES.put("adamantite_ninjato", new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item",
                    MedievalMain.ID("adamantite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("adamantite_sickle",
                    new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("adamantite_sickle"), "sickle"));
            SHAPED_RECIPES.put("adamantite_rapier",
                    new ShapedRecipeMaterial(new Identifier("mythicmetals", "adamantite_ingot"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("adamantite_rapier"), "rapier"));
        }
        if (CompatItems.isParadiseLostLoaded) {
            SHAPED_RECIPES.put("olvite_small_axe",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_small_axe"), "small_axe"));
            SHAPED_RECIPES.put("olvite_long_sword",
                    new ShapedRecipeMaterial(new Identifier("betterend", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_long_sword"), "long_sword"));
            SHAPED_RECIPES.put("olvite_dagger",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_dagger"), "dagger"));
            SHAPED_RECIPES.put("olvite_big_axe",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_big_axe"), "big_axe"));
            SHAPED_RECIPES.put("olvite_lance",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_lance"), "lance"));
            SHAPED_RECIPES.put("olvite_healing_staff",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_healing_staff"), "healing_staff"));
            SHAPED_RECIPES.put("olvite_mace",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_mace"), "mace"));
            SHAPED_RECIPES.put("olvite_francisca",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_francisca"), "francisca"));
            SHAPED_RECIPES.put("olvite_javelin",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_javelin"), "javelin"));
            SHAPED_RECIPES.put("olvite_ninjato",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_ninjato"), "ninjato"));
            SHAPED_RECIPES.put("olvite_sickle",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_sickle"), "sickle"));
            SHAPED_RECIPES.put("olvite_rapier",
                    new ShapedRecipeMaterial(new Identifier("paradise_lost", "olvite"), Registries.ITEM.getId(Items.STICK), "item", "item", MedievalMain.ID("olvite_rapier"), "rapier"));
        }
        if (CompatItems.isBYGLoaded) {
            SMITHING_RECIPES.put("pendorite_small_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_small_axe"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_small_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_long_sword", new SmithingRecipeMaterial(MedievalMain.ID("netherite_long_sword"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_long_sword"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_dagger", new SmithingRecipeMaterial(MedievalMain.ID("netherite_dagger"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_dagger"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_big_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_big_axe"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_big_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_lance", new SmithingRecipeMaterial(MedievalMain.ID("netherite_lance"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_lance"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_healing_staff", new SmithingRecipeMaterial(MedievalMain.ID("netherite_healing_staff"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_healing_staff"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_mace", new SmithingRecipeMaterial(MedievalMain.ID("netherite_mace"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_mace"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_francisca", new SmithingRecipeMaterial(MedievalMain.ID("netherite_francisca"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_francisca"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_javelin", new SmithingRecipeMaterial(MedievalMain.ID("netherite_javelin"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_javelin"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_ninjato", new SmithingRecipeMaterial(MedievalMain.ID("netherite_ninjato"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_ninjato"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_sickle", new SmithingRecipeMaterial(MedievalMain.ID("netherite_sickle"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_sickle"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("pendorite_rapier", new SmithingRecipeMaterial(MedievalMain.ID("netherite_rapier"), new Identifier(BYG.MOD_ID, "pendorite_ingot"), "item", "item",
                    MedievalMain.ID("pendorite_rapier"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        }
        if (CompatItems.isAdditionalAdditionsLoaded) {
            SMITHING_RECIPES.put("gilded_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_small_axe"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_small_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.ID("netherite_long_sword"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_long_sword"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.ID("netherite_dagger"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_dagger"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_big_axe"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_big_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_lance", new SmithingRecipeMaterial(MedievalMain.ID("netherite_lance"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_lance"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.ID("netherite_healing_staff"), new Identifier("additionaladditions:gold_ring"), "item",
                    "item", MedievalMain.ID("gilded_netherite_healing_staff"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_mace", new SmithingRecipeMaterial(MedievalMain.ID("netherite_mace"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_mace"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.ID("netherite_francisca"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_francisca"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.ID("netherite_javelin"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_javelin"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.ID("netherite_ninjato"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_ninjato"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.ID("netherite_sickle"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_sickle"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("gilded_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.ID("netherite_rapier"), new Identifier("additionaladditions:gold_ring"), "item", "item",
                    MedievalMain.ID("gilded_netherite_rapier"), new Identifier("minecraft:netherite_upgrade_smithing_template")));

            SMITHING_RECIPES.put("rose_gold_small_axe", new SmithingRecipeMaterial(MedievalMain.ID("iron_small_axe"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_small_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_long_sword", new SmithingRecipeMaterial(MedievalMain.ID("iron_long_sword"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_long_sword"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_dagger", new SmithingRecipeMaterial(MedievalMain.ID("iron_dagger"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_dagger"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_big_axe", new SmithingRecipeMaterial(MedievalMain.ID("iron_big_axe"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_big_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_lance", new SmithingRecipeMaterial(MedievalMain.ID("iron_lance"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_lance"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_healing_staff", new SmithingRecipeMaterial(MedievalMain.ID("iron_healing_staff"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_healing_staff"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_mace", new SmithingRecipeMaterial(MedievalMain.ID("iron_mace"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_mace"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_francisca", new SmithingRecipeMaterial(MedievalMain.ID("iron_francisca"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_francisca"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_javelin", new SmithingRecipeMaterial(MedievalMain.ID("iron_javelin"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_javelin"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_ninjato", new SmithingRecipeMaterial(MedievalMain.ID("iron_ninjato"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_ninjato"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_rapier", new SmithingRecipeMaterial(MedievalMain.ID("iron_rapier"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_rapier"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("rose_gold_sickle", new SmithingRecipeMaterial(MedievalMain.ID("iron_sickle"), new Identifier("additionaladditions:rose_gold_alloy"), "item", "item",
                    MedievalMain.ID("rose_gold_sickle"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        }
        if (CompatItems.isMythicUpgradesLoaded) {
            SMITHING_RECIPES.put("ruby_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_small_axe"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_small_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.ID("netherite_long_sword"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_long_sword"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.ID("netherite_dagger"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_dagger"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_big_axe"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_big_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_lance", new SmithingRecipeMaterial(MedievalMain.ID("netherite_lance"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_lance"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.ID("netherite_healing_staff"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_healing_staff"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_mace", new SmithingRecipeMaterial(MedievalMain.ID("netherite_mace"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_mace"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.ID("netherite_francisca"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_francisca"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.ID("netherite_javelin"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_javelin"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.ID("netherite_ninjato"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_ninjato"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.ID("netherite_sickle"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_sickle"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("ruby_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.ID("netherite_rapier"), new Identifier("mythicupgrades:ruby"), "item", "item",
                    MedievalMain.ID("ruby_netherite_rapier"), new Identifier("minecraft:netherite_upgrade_smithing_template")));

            SMITHING_RECIPES.put("sapphire_netherite_small_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_small_axe"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_small_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_long_sword", new SmithingRecipeMaterial(MedievalMain.ID("netherite_long_sword"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_long_sword"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_dagger", new SmithingRecipeMaterial(MedievalMain.ID("netherite_dagger"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_dagger"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_big_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_big_axe"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_big_axe"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_lance", new SmithingRecipeMaterial(MedievalMain.ID("netherite_lance"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_lance"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_healing_staff", new SmithingRecipeMaterial(MedievalMain.ID("netherite_healing_staff"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_healing_staff"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_mace", new SmithingRecipeMaterial(MedievalMain.ID("netherite_mace"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_mace"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_francisca", new SmithingRecipeMaterial(MedievalMain.ID("netherite_francisca"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_francisca"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_javelin", new SmithingRecipeMaterial(MedievalMain.ID("netherite_javelin"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_javelin"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_ninjato", new SmithingRecipeMaterial(MedievalMain.ID("netherite_ninjato"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_ninjato"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_rapier", new SmithingRecipeMaterial(MedievalMain.ID("netherite_rapier"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_rapier"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
            SMITHING_RECIPES.put("sapphire_netherite_sickle", new SmithingRecipeMaterial(MedievalMain.ID("netherite_sickle"), new Identifier("mythicupgrades:sapphire"), "item", "item",
                    MedievalMain.ID("sapphire_netherite_sickle"), new Identifier("minecraft:netherite_upgrade_smithing_template")));
        }
        if (CompatItems.isDeeperDarkerLoaded) {
            SMITHING_RECIPES.put("warden_small_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_small_axe"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_small_axe"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_long_sword", new SmithingRecipeMaterial(MedievalMain.ID("netherite_long_sword"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_long_sword"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_dagger", new SmithingRecipeMaterial(MedievalMain.ID("netherite_dagger"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_dagger"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_big_axe", new SmithingRecipeMaterial(MedievalMain.ID("netherite_big_axe"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_big_axe"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_lance", new SmithingRecipeMaterial(MedievalMain.ID("netherite_lance"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_lance"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_healing_staff", new SmithingRecipeMaterial(MedievalMain.ID("netherite_healing_staff"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item",
                    "item", MedievalMain.ID("warden_healing_staff"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_mace", new SmithingRecipeMaterial(MedievalMain.ID("netherite_mace"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_mace"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_francisca", new SmithingRecipeMaterial(MedievalMain.ID("netherite_francisca"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_francisca"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_javelin", new SmithingRecipeMaterial(MedievalMain.ID("netherite_javelin"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_javelin"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_ninjato", new SmithingRecipeMaterial(MedievalMain.ID("netherite_ninjato"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_ninjato"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_sickle", new SmithingRecipeMaterial(MedievalMain.ID("netherite_sickle"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_sickle"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
            SMITHING_RECIPES.put("warden_rapier", new SmithingRecipeMaterial(MedievalMain.ID("netherite_rapier"), new Identifier("deeperdarker", "reinforced_echo_shard"), "item", "item",
                    MedievalMain.ID("warden_rapier"), new Identifier("deeperdarker", "warden_upgrade_smithing_template")));
        }

    }

    public static void loadRecipes() {
        for (String key : SHAPED_RECIPES.keySet()) {
            ShapedRecipeMaterial material = SHAPED_RECIPES.get(key);
            RECIPES.put(MedievalMain.ID(key), RecipeGenerator.generateJson(material.headItem, material.handleItem, material.headType, material.handleType, material.output, material.itemName));
        }
        for (String key : SMITHING_RECIPES.keySet()) {
            SmithingRecipeMaterial material = SMITHING_RECIPES.get(key);
            RECIPES.put(MedievalMain.ID(key),
                    RecipeGenerator.generateSmithingJson(material.baseItem, material.additionItem, material.baseType, material.additionType, material.output, material.template));
        }
    }

}
