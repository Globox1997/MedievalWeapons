package net.medievalweapons.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.medievalweapons.compat.CompatRecipes;
import net.medievalweapons.compat.ShapedRecipeMaterial;
import net.medievalweapons.compat.SmithingRecipeMaterial;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class RecipeLoader extends FabricRecipeProvider {

    public RecipeLoader(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        for (var entry : CompatRecipes.VANILLA_SHAPED_RECIPES.entrySet()) {
            ShapedRecipeMaterial mat = entry.getValue();
            generateShaped(exporter, mat);
        }

        for (var entry : CompatRecipes.VANILLA_SMITHING_RECIPES.entrySet()) {
            SmithingRecipeMaterial mat = entry.getValue();
            generateSmithing(exporter, mat);
        }
    }

    private void generateShaped(RecipeExporter exporter, ShapedRecipeMaterial mat) {
        String[] pattern = getPattern(mat.itemName);
        if (pattern == null) {
            return;
        }
        Item output = Registries.ITEM.get(mat.output);

        ShapedRecipeJsonBuilder builder = ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output);

        for (String row : pattern) {
            builder.pattern(row);
        }

        if ("tag" .equals(mat.headType)) {
            builder.input('d', TagKey.of(Registries.ITEM.getKey(), mat.headItem));
        } else {
            builder.input('d', Registries.ITEM.get(mat.headItem));
        }

        if ("tag" .equals(mat.handleType)) {
            builder.input('e', TagKey.of(Registries.ITEM.getKey(), mat.handleItem));
        } else {
            builder.input('e', Registries.ITEM.get(mat.handleItem));
        }

        builder.criterion(hasItem(Registries.ITEM.get(mat.headItem)), conditionsFromItem(Registries.ITEM.get(mat.headItem)));
        builder.offerTo(exporter, mat.output);
    }

    private void generateSmithing(RecipeExporter exporter, SmithingRecipeMaterial mat) {
        Item base = Registries.ITEM.get(mat.baseItem);
        Item addition = Registries.ITEM.get(mat.additionItem);
        Item output = Registries.ITEM.get(mat.output);
        Item template = Registries.ITEM.get(mat.template);

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(template), Ingredient.ofItems(base), Ingredient.ofItems(addition), RecipeCategory.COMBAT, output)
                .criterion(hasItem(base), conditionsFromItem(base)).offerTo(exporter, mat.output);
    }

    private String[] getPattern(String itemName) {
        return switch (itemName) {
            case "big_axe" -> new String[]{" de", " ed", "ed "};
            case "dagger" -> new String[]{"d", "e"};
            case "francisca" -> new String[]{"de", " e"};
            case "healing_staff" -> new String[]{"  d", " e ", "d  "};
            case "javelin" -> new String[]{"d  ", " e ", "  e"};
            case "lance" -> new String[]{"  d", "ee ", "ee "};
            case "long_sword" -> new String[]{"  d", "dd ", "ed "};
            case "mace" -> new String[]{" dd", " dd", "e  "};
            case "small_axe" -> new String[]{" dd", " ed", "e  "};
            case "ninjato" -> new String[]{" d ", "d  ", "e  "};
            case "sickle" -> new String[]{" dd", "  d", " e "};
            case "rapier" -> new String[]{"  d", " d ", "e  "};
            default -> null;
        };
    }
}
