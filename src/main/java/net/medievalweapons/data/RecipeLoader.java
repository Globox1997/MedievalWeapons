package net.medievalweapons.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.medievalweapons.compat.CompatRecipes;
import net.medievalweapons.compat.ShapedRecipeMaterial;
import net.medievalweapons.init.ItemInit;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class RecipeLoader extends FabricRecipeProvider {

    public RecipeLoader(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
//        for (Item item : ItemInit.ITEMS.values()) {
////        for(String material: ItemInit.MATERIAL_STRINGS){
////            for(String item: ItemInit.ITEM_STRINGS){
//
//            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, item).pattern("###")
//                    .input('#', entry.getValue().get(1))
//                    .criterion(FabricRecipeProvider.hasItem(entry.getValue().get(1)),
//                            FabricRecipeProvider.conditionsFromItem(entry.getValue().get(1)))
//                    .offerTo(exporter);
//
////
////        }
//        for(Map.Entry<String, ShapedRecipeMaterial>entry: CompatRecipes.SHAPED_RECIPES.entrySet()){
//            entry.getValue().
//        }

    }
}
