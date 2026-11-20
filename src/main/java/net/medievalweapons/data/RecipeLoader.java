package net.medievalweapons.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.medievalweapons.compat.CompatRecipes;
import net.medievalweapons.compat.RecipeGenerator;
import net.medievalweapons.compat.ShapedRecipeMaterial;
import net.medievalweapons.compat.SmithingRecipeMaterial;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeLoader implements DataProvider {

    private final FabricPackOutput output;

    public RecipeLoader(FabricPackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput writer) {
        PackOutput.PathProvider recipes = this.output.createPathProvider(PackOutput.Target.DATA_PACK, "recipe");
        PackOutput.PathProvider advancements = this.output.createPathProvider(PackOutput.Target.DATA_PACK, "advancement");
        List<CompletableFuture<?>> futures = new ArrayList<>();
        for (ShapedRecipeMaterial mat : CompatRecipes.VANILLA_SHAPED_RECIPES.values()) {
            JsonObject recipe = RecipeGenerator.generateJson(mat.headItem, mat.handleItem, mat.headType, mat.handleType, mat.output, mat.itemName);
            recipe.addProperty("category", "equipment");
            futures.add(DataProvider.saveStable(writer, recipe, recipes.json(mat.output)));
            futures.add(DataProvider.saveStable(writer, advancement(mat.output, mat.headItem, mat.headType), advancements.json(recipeAdvancementId(mat.output))));
        }
        for (SmithingRecipeMaterial mat : CompatRecipes.VANILLA_SMITHING_RECIPES.values()) {
            JsonObject recipe = RecipeGenerator.generateSmithingJson(mat.baseItem, mat.additionItem, mat.baseType, mat.additionType, mat.output, mat.template);
            futures.add(DataProvider.saveStable(writer, recipe, recipes.json(mat.output)));
            futures.add(DataProvider.saveStable(writer, advancement(mat.output, mat.baseItem, mat.baseType), advancements.json(recipeAdvancementId(mat.output))));
        }
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    private static Identifier recipeAdvancementId(Identifier recipe) {
        return Identifier.fromNamespaceAndPath(recipe.getNamespace(), "recipes/combat/" + recipe.getPath());
    }

    private static JsonObject advancement(Identifier recipe, Identifier unlockItem, String unlockType) {
        String criterion = "has_" + unlockItem.getPath();

        JsonObject itemPredicate = new JsonObject();
        itemPredicate.addProperty("items", RecipeGenerator.ingredient(unlockType, unlockItem));
        JsonArray items = new JsonArray();
        items.add(itemPredicate);
        JsonObject hasItemConditions = new JsonObject();
        hasItemConditions.add("items", items);
        JsonObject hasItem = new JsonObject();
        hasItem.add("conditions", hasItemConditions);
        hasItem.addProperty("trigger", "minecraft:inventory_changed");

        JsonObject hasRecipeConditions = new JsonObject();
        hasRecipeConditions.addProperty("recipes", recipe.toString());
        JsonObject hasRecipe = new JsonObject();
        hasRecipe.add("conditions", hasRecipeConditions);
        hasRecipe.addProperty("trigger", "minecraft:recipe_unlocked");

        JsonObject criteria = new JsonObject();
        criteria.add(criterion, hasItem);
        criteria.add("has_the_recipe", hasRecipe);

        JsonArray requirement = new JsonArray();
        requirement.add("has_the_recipe");
        requirement.add(criterion);
        JsonArray requirements = new JsonArray();
        requirements.add(requirement);

        JsonArray rewardRecipes = new JsonArray();
        rewardRecipes.add(recipe.toString());
        JsonObject rewards = new JsonObject();
        rewards.add("recipes", rewardRecipes);

        JsonObject json = new JsonObject();
        json.addProperty("parent", "minecraft:recipes/root");
        json.add("criteria", criteria);
        json.add("requirements", requirements);
        json.add("rewards", rewards);
        return json;
    }

    @Override
    public String getName() {
        return "Recipes";
    }

}
