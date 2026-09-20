package net.medievalweapons.data;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.medievalweapons.compat.CompatRecipes;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompatRecipeLoader implements DataProvider {

    private final FabricDataOutput output;
    private final Collection<String> materials;

    public CompatRecipeLoader(FabricDataOutput output, Collection<String> materials) {
        this.output = output;
        this.materials = materials;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        DataOutput.PathResolver resolver = output.getResolver(DataOutput.OutputType.DATA_PACK, "recipe");

        for (var entry : CompatRecipes.RECIPES.entrySet()) {
            Identifier id = entry.getKey();
            JsonObject json = entry.getValue();

            boolean matches = materials.stream().anyMatch(m -> id.getPath().startsWith(m + "_"));
            if (!matches){
                continue;
            }

            Path path = resolver.resolveJson(id);
            futures.add(DataProvider.writeToPath(writer, json, path));
        }

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName() {
        return "Compat Recipes";
    }
}
