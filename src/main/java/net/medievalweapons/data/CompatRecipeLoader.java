package net.medievalweapons.data;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.medievalweapons.compat.CompatRecipes;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompatRecipeLoader implements DataProvider {

    private final FabricPackOutput output;
    private final Collection<String> materials;

    public CompatRecipeLoader(FabricPackOutput output, Collection<String> materials) {
        this.output = output;
        this.materials = materials;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        PackOutput.PathProvider resolver = output.createPathProvider(PackOutput.Target.DATA_PACK, "recipe");

        for (var entry : CompatRecipes.RECIPES.entrySet()) {
            Identifier id = entry.getKey();
            JsonObject json = entry.getValue();

            boolean matches = materials.stream().anyMatch(m -> id.getPath().startsWith(m + "_"));
            if (!matches){
                continue;
            }

            Path path = resolver.json(id);
            futures.add(DataProvider.saveStable(writer, json, path));
        }

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName() {
        return "Compat Recipes";
    }
}
