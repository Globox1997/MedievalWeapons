package net.medievalweapons.data;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class PackMcmetaLoader implements DataProvider {

    private final FabricPackOutput output;
    private final String description;

    public PackMcmetaLoader(FabricPackOutput output, String description) {
        this.output = output;
        this.description = description;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput writer) {
        JsonObject root = new JsonObject();
        JsonObject pack = new JsonObject();
        pack.addProperty("min_format", 97);
        pack.addProperty("max_format", 999);

        JsonObject descriptionObj = new JsonObject();
        descriptionObj.addProperty("text", description);
        pack.add("description", descriptionObj);

        root.add("pack", pack);

        Path path = output.getOutputFolder().resolve("pack.mcmeta");
        return DataProvider.saveStable(writer, root, path);
    }

    @Override
    public String getName() {
        return "Pack Metadata";
    }
}
