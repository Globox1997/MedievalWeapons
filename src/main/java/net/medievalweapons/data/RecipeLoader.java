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
        for (ShapedRecipeMaterial mat : CompatRecipes.VANILLA_SHAPED_RECIPES.values()) {
            generateShaped(exporter, mat);
        }
        for (SmithingRecipeMaterial mat : CompatRecipes.VANILLA_SMITHING_RECIPES.values()) {
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

        if ("tag".equals(mat.headType)) {
            builder.input('d', TagKey.of(Registries.ITEM.getKey(), mat.headItem));
        } else {
            builder.input('d', Registries.ITEM.get(mat.headItem));
        }

        if ("tag".equals(mat.handleType)) {
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

//package net.medievalweapons.data;
//
//import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
//import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
//import net.medievalweapons.compat.CompatItems;
//import net.medievalweapons.compat.CompatRecipes;
//import net.medievalweapons.compat.ShapedRecipeMaterial;
//import net.medievalweapons.compat.SmithingRecipeMaterial;
//import net.minecraft.data.server.recipe.RecipeExporter;
//import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
//import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
//import net.minecraft.item.Item;
//import net.minecraft.recipe.Ingredient;
//import net.minecraft.recipe.book.RecipeCategory;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.RegistryWrapper;
//import net.minecraft.registry.tag.TagKey;
//import net.minecraft.util.Identifier;
//
//import java.util.Collection;
//import java.util.Set;
//import java.util.concurrent.CompletableFuture;
//import java.util.stream.Collectors;
//
//public class RecipeLoader extends FabricRecipeProvider {
//
//    private final Collection<String> materials;
//
//    public RecipeLoader(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
//        this(output, registriesFuture, null);
//    }
//
//    public RecipeLoader(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, Collection<String> materials) {
//        super(output, registriesFuture);
//        this.materials = materials;
//    }
//
//    @Override
//    public void generate(RecipeExporter exporter) {
//        if (materials == null) {
//            generateVanilla(exporter);
//        } else {
//            generateCompat(exporter);
//        }
//    }
//
//    private void generateVanilla(RecipeExporter exporter) {
//        Set<String> compatMaterials = CompatItems.MATERIALS_BY_MOD.values().stream()
//                .flatMap(Set::stream)
//                .collect(Collectors.toSet());
//
//        for (ShapedRecipeMaterial mat : CompatRecipes.VANILLA_SHAPED_RECIPES.values()) {
//            if (compatMaterials.stream().noneMatch(m -> startsWithMaterial(mat.output, m))) {
//                generateShaped(exporter, mat);
//            }
//        }
//        for (SmithingRecipeMaterial mat : CompatRecipes.VANILLA_SMITHING_RECIPES.values()) {
//            if (compatMaterials.stream().noneMatch(m -> startsWithMaterial(mat.output, m))) {
//                generateSmithing(exporter, mat);
//            }
//        }
//    }
//
//    private void generateCompat(RecipeExporter exporter) {
//        for (ShapedRecipeMaterial mat : CompatRecipes.SHAPED_RECIPES.values()) {
//            if (matchesMaterial(mat.output)) {
//                generateShaped(exporter, mat);
//            }
//        }
//        for (SmithingRecipeMaterial mat : CompatRecipes.SMITHING_RECIPES.values()) {
//            if (matchesMaterial(mat.output)) {
//                generateSmithing(exporter, mat);
//            }
//        }
//    }
//
//    private boolean matchesMaterial(Identifier output) {
//        return materials.stream().anyMatch(m -> startsWithMaterial(output, m));
//    }
//
//    private static boolean startsWithMaterial(Identifier output, String material) {
//        return output.getPath().startsWith(material + "_");
//    }
//
//    private void generateShaped(RecipeExporter exporter, ShapedRecipeMaterial mat) {
//        String[] pattern = getPattern(mat.itemName);
//        if (pattern == null) {
//            return;
//        }
//        Item output = Registries.ITEM.get(mat.output);
//
//        ShapedRecipeJsonBuilder builder = ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output);
//
//        for (String row : pattern) {
//            builder.pattern(row);
//        }
//
//        if ("tag".equals(mat.headType)) {
//            builder.input('d', TagKey.of(Registries.ITEM.getKey(), mat.headItem));
//        } else {
//            builder.input('d', Registries.ITEM.get(mat.headItem));
//        }
//
//        if ("tag".equals(mat.handleType)) {
//            builder.input('e', TagKey.of(Registries.ITEM.getKey(), mat.handleItem));
//        } else {
//            builder.input('e', Registries.ITEM.get(mat.handleItem));
//        }
//
//        builder.criterion(hasItem(Registries.ITEM.get(mat.headItem)), conditionsFromItem(Registries.ITEM.get(mat.headItem)));
//        builder.offerTo(exporter, mat.output);
//    }
//
//    private void generateSmithing(RecipeExporter exporter, SmithingRecipeMaterial mat) {
//        Item base = Registries.ITEM.get(mat.baseItem);
//        Item addition = Registries.ITEM.get(mat.additionItem);
//        Item output = Registries.ITEM.get(mat.output);
//        Item template = Registries.ITEM.get(mat.template);
//
//        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(template), Ingredient.ofItems(base), Ingredient.ofItems(addition), RecipeCategory.COMBAT, output)
//                .criterion(hasItem(base), conditionsFromItem(base)).offerTo(exporter, mat.output);
//    }
//
//    private String[] getPattern(String itemName) {
//        return switch (itemName) {
//            case "big_axe" -> new String[]{" de", " ed", "ed "};
//            case "dagger" -> new String[]{"d", "e"};
//            case "francisca" -> new String[]{"de", " e"};
//            case "healing_staff" -> new String[]{"  d", " e ", "d  "};
//            case "javelin" -> new String[]{"d  ", " e ", "  e"};
//            case "lance" -> new String[]{"  d", "ee ", "ee "};
//            case "long_sword" -> new String[]{"  d", "dd ", "ed "};
//            case "mace" -> new String[]{" dd", " dd", "e  "};
//            case "small_axe" -> new String[]{" dd", " ed", "e  "};
//            case "ninjato" -> new String[]{" d ", "d  ", "e  "};
//            case "sickle" -> new String[]{" dd", "  d", " e "};
//            case "rapier" -> new String[]{"  d", " d ", "e  "};
//            default -> null;
//        };
//    }
//}
