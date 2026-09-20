package net.medievalweapons.data;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class PackMcmetaLoader implements DataProvider {

    private final FabricDataOutput output;
    private final String description;

    public PackMcmetaLoader(FabricDataOutput output, String description) {
        this.output = output;
        this.description = description;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        JsonObject root = new JsonObject();
        JsonObject pack = new JsonObject();
        pack.addProperty("pack_format", 15);

        JsonObject supportedFormats = new JsonObject();
        supportedFormats.addProperty("min_inclusive", 1);
        supportedFormats.addProperty("max_inclusive", 999);
        pack.add("supported_formats", supportedFormats);

        JsonObject descriptionObj = new JsonObject();
        descriptionObj.addProperty("text", description);
        pack.add("description", descriptionObj);

        root.add("pack", pack);

        Path path = output.getPath().resolve("pack.mcmeta");
        return DataProvider.writeToPath(writer, root, path);
    }

    @Override
    public String getName() {
        return "Pack Metadata";
    }
}
