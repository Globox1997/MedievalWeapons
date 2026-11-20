package net.medievalweapons.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.init.ItemInit;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModelLoader implements DataProvider {

    private static final String HANDHELD = "minecraft:item/handheld";

    private final FabricPackOutput output;
    private final Collection<String> materials;

    public ModelLoader(FabricPackOutput output) {
        this.output = output;
        Set<String> compatMaterials = CompatItems.MATERIALS_BY_MOD.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
        this.materials = ItemInit.MATERIAL_STRINGS.stream().filter(m -> !compatMaterials.contains(m)).toList();
    }

    public ModelLoader(FabricPackOutput output, Collection<String> materials) {
        this.output = output;
        this.materials = materials;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput writer) {
        PackOutput.PathProvider models = this.output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models");
        PackOutput.PathProvider items = this.output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "items");
        List<CompletableFuture<?>> futures = new ArrayList<>();
        for (String item : ItemInit.ITEM_STRINGS) {
            for (String material : this.materials) {
                writeItem(item, material, writer, models, items, futures);
            }
        }
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    private static void writeItem(String item, String material, CachedOutput writer, PackOutput.PathProvider models, PackOutput.PathProvider items, List<CompletableFuture<?>> futures) {
        String name = material + "_" + item;
        String texture = "medievalweapons:item/" + name;
        String model = "medievalweapons:item/" + name;
        JsonObject definition;
        switch (item) {
            case "ninjato", "francisca" -> {
                model(writer, models, futures, name, HANDHELD, texture);
                definition = plain(model);
            }
            case "small_axe", "healing_staff", "mace", "sickle", "rapier" -> {
                model(writer, models, futures, name, "medievalweapons:item/" + item, texture);
                model(writer, models, futures, name + "_gui", HANDHELD, "medievalweapons:item/extra/" + name);
                definition = gui(model + "_gui", plain(model));
            }
            case "long_sword", "big_axe", "lance" -> {
                model(writer, models, futures, name, "medievalweapons:item/" + item, texture);
                model(writer, models, futures, name + "_gui", HANDHELD, "medievalweapons:item/extra/" + name);
                model(writer, models, futures, name + "_bc", "medievalweapons:item/" + item + "_bc", texture);
                definition = gui(model + "_gui", condition("medievalweapons:offhand", plain(model + "_bc"), betterCombat(model + "_bc", plain(model))));
            }
            case "dagger" -> {
                model(writer, models, futures, name, "medievalweapons:item/" + item, texture);
                model(writer, models, futures, name + "_bc", HANDHELD, texture);
                definition = betterCombat(model + "_bc", plain(model));
            }
            case "javelin" -> {
                model(writer, models, futures, name, "medievalweapons:item/" + item, texture);
                model(writer, models, futures, name + "_gui", HANDHELD, "medievalweapons:item/extra/" + name);
                model(writer, models, futures, name + "_throwing", "medievalweapons:item/" + item + "_throwing", texture);
                model(writer, models, futures, name + "_bc", "medievalweapons:item/" + item + "_bc", texture);
                definition = gui(model + "_gui", condition("minecraft:using_item", plain(model + "_throwing"), betterCombat(model + "_bc", plain(model))));
            }
            default -> {
                return;
            }
        }
        JsonObject root = new JsonObject();
        root.add("model", definition);
        futures.add(DataProvider.saveStable(writer, root, items.json(MedievalMain.identifierOf(name))));
    }

    private static void model(CachedOutput writer, PackOutput.PathProvider models, List<CompletableFuture<?>> futures, String name, String parent, String texture) {
        JsonObject json = new JsonObject();
        json.addProperty("parent", parent);
        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", texture);
        json.add("textures", textures);
        futures.add(DataProvider.saveStable(writer, json, models.json(MedievalMain.identifierOf("item/" + name))));
    }

    private static JsonObject plain(String model) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:model");
        json.addProperty("model", model);
        return json;
    }

    private static JsonObject condition(String property, JsonObject onTrue, JsonObject onFalse) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:condition");
        json.addProperty("property", property);
        json.add("on_true", onTrue);
        json.add("on_false", onFalse);
        return json;
    }

    private static JsonObject betterCombat(String betterCombatModel, JsonObject fallback) {
        return condition("medievalweapons:bettercombat_loaded", plain(betterCombatModel), fallback);
    }

    private static JsonObject gui(String guiModel, JsonObject fallback) {
        JsonObject guiCase = new JsonObject();
        guiCase.addProperty("when", "gui");
        guiCase.add("model", plain(guiModel));
        JsonArray cases = new JsonArray();
        cases.add(guiCase);
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:select");
        json.addProperty("property", "minecraft:display_context");
        json.add("cases", cases);
        json.add("fallback", fallback);
        return json;
    }

    @Override
    public String getName() {
        return "Models and Item Definitions";
    }

}
