package net.medievalweapons.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.init.ItemInit;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModelLoader extends FabricModelProvider {

    private static final Optional<Identifier> HANDHELD = Optional.of(Identifier.ofVanilla("item/handheld"));

    private final Collection<String> materials;

    public ModelLoader(FabricDataOutput output) {
        super(output);
        Set<String> compatMaterials = CompatItems.MATERIALS_BY_MOD.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
        this.materials = ItemInit.MATERIAL_STRINGS.stream().filter(m -> !compatMaterials.contains(m)).toList();
    }

    public ModelLoader(FabricDataOutput output, Collection<String> materials) {
        super(output);
        this.materials = materials;
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (String item : ItemInit.ITEM_STRINGS) {
            for (String material : materials) {
                writeItemModel(item, material, itemModelGenerator.writer);
            }
        }
    }

    private static void writeItemModel(String item, String material, BiConsumer<Identifier, Supplier<JsonElement>> writer) {
        switch (item) {
            case "ninjato", "francisca" -> {
                Identifier id = MedievalMain.identifierOf("item/" + material + "_" + item);
                new Model(HANDHELD, Optional.of("medievalweapons:item/" + material + "_" + item), TextureKey.LAYER0)
                        .upload(id, TextureMap.layer0(id), writer);
            }
            case "small_axe", "healing_staff", "mace", "sickle", "rapier" -> {
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, false, false));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
            }
            case "long_sword", "big_axe", "lance" -> {
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, true, true));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                new Model(Optional.of(MedievalMain.identifierOf("item/" + item + "_bc")), Optional.empty(), TextureKey.LAYER0)
                        .upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
            }
            case "dagger" -> {
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, false, false, false, true));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
            }
            case "javelin" -> {
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, true, false, true));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                new Model(Optional.of(MedievalMain.identifierOf("item/" + item + "_throwing")), Optional.empty(), TextureKey.LAYER0)
                        .upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_throwing"), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
                new Model(Optional.of(MedievalMain.identifierOf("item/" + item + "_bc")), Optional.empty(), TextureKey.LAYER0)
                        .upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
            }
            default -> { }
        }
    }

    private static JsonObject createPredicateJson(Identifier id, Map<TextureKey, Identifier> textures, String item, String material, boolean gui, boolean throwing, boolean offhand, boolean bettercombat) {
        JsonObject jsonObject = new Model(Optional.of(MedievalMain.identifierOf("item/" + item)), Optional.of("medievalweapons:item/" + material + "_" + item), TextureKey.LAYER0).createJson(id, textures);

        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject2;
        JsonObject jsonObject3;
        if (bettercombat) {
            jsonObject2 = new JsonObject();
            jsonObject3 = new JsonObject();
            jsonObject3.addProperty("bettercombat:loaded", 1.0f);
            jsonObject2.add("predicate", jsonObject3);
            jsonObject2.addProperty("model", "medievalweapons:item/" + material + "_" + item + "_bc");
            jsonArray.add(jsonObject2);
        }
        if (throwing) {
            jsonObject2 = new JsonObject();
            jsonObject3 = new JsonObject();
            jsonObject3.addProperty("throwing", 1.0f);
            jsonObject2.add("predicate", jsonObject3);
            jsonObject2.addProperty("model", "medievalweapons:item/" + material + "_" + item + "_throwing");
            jsonArray.add(jsonObject2);
        }
        if (offhand) {
            jsonObject2 = new JsonObject();
            jsonObject3 = new JsonObject();
            jsonObject3.addProperty(MedievalMain.identifierOf("offhand").toString(), 1.0f);
            jsonObject2.add("predicate", jsonObject3);
            jsonObject2.addProperty("model", "medievalweapons:item/" + material + "_" + item + "_bc");
            jsonArray.add(jsonObject2);
        }
        if (gui) {
            jsonObject2 = new JsonObject();
            jsonObject3 = new JsonObject();
            jsonObject3.addProperty(MedievalMain.identifierOf("gui").toString(), 1.0f);
            jsonObject2.add("predicate", jsonObject3);
            jsonObject2.addProperty("model", id.toString() + "_gui");
            jsonArray.add(jsonObject2);
        }
        jsonObject.add("overrides", jsonArray);
        return jsonObject;
    }

}
