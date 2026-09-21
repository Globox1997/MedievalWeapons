package net.medievalweapons.data;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.medievalweapons.MedievalMain;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class WeaponAttributesLoader implements DataProvider {

    private static final Map<String, String> PARENTS = Map.ofEntries(
            Map.entry("big_axe", "bettercombat:heavy_axe"),
            Map.entry("dagger", "medievalweapons:dagger"),
            Map.entry("francisca", "bettercombat:axe"),
            Map.entry("healing_staff", "bettercombat:wand"),
            Map.entry("javelin", "bettercombat:trident"),
            Map.entry("lance", "bettercombat:spear"),
            Map.entry("long_sword", "bettercombat:spear"),
            Map.entry("mace", "bettercombat:mace"),
            Map.entry("ninjato", "bettercombat:cutlass"),
            Map.entry("rapier", "bettercombat:rapier"),
            Map.entry("sickle", "bettercombat:sickle"),
            Map.entry("small_axe", "bettercombat:axe")
    );

    private final FabricDataOutput output;
    private final Collection<String> materials;

    public WeaponAttributesLoader(FabricDataOutput output, Collection<String> materials) {
        this.output = output;
        this.materials = materials;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        DataOutput.PathResolver resolver = output.getResolver(DataOutput.OutputType.DATA_PACK, "weapon_attributes");

        for (String material : materials) {
            for (var entry : PARENTS.entrySet()) {
                String item = entry.getKey();
                String parent = entry.getValue();

                JsonObject json = new JsonObject();
                json.addProperty("parent", parent);

                Identifier id = MedievalMain.identifierOf(material + "_" + item);
                Path path = resolver.resolveJson(id);
                futures.add(DataProvider.writeToPath(writer, json, path));
            }
        }

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName() {
        return "Weapon Attributes";
    }
}
