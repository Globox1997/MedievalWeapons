package net.medievalweapons.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.init.ItemInit;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModelLoader extends FabricModelProvider {

    private static final Optional<ResourceLocation> HANDHELD = Optional.of(ResourceLocation.withDefaultNamespace("item/handheld"));

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
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        for (String item : ItemInit.ITEM_STRINGS) {
            for (String material : materials) {
                writeItemModel(item, material, itemModelGenerator.output);
            }
        }
    }

    private static void writeItemModel(String item, String material, BiConsumer<ResourceLocation, Supplier<JsonElement>> writer) {
        switch (item) {
            case "ninjato", "francisca" -> {
                ResourceLocation id = MedievalMain.identifierOf("item/" + material + "_" + item);
                new ModelTemplate(HANDHELD, Optional.of("medievalweapons:item/" + material + "_" + item), TextureSlot.LAYER0)
                        .create(id, TextureMapping.layer0(id), writer);
            }
            case "small_axe", "healing_staff", "mace", "sickle", "rapier" -> {
                ModelTemplates.FLAT_HANDHELD_ITEM.create(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMapping.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, false, false));
                ModelTemplates.FLAT_HANDHELD_ITEM.create(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMapping.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
            }
            case "long_sword", "big_axe", "lance" -> {
                ModelTemplates.FLAT_HANDHELD_ITEM.create(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMapping.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, true, true));
                ModelTemplates.FLAT_HANDHELD_ITEM.create(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMapping.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                new ModelTemplate(Optional.of(MedievalMain.identifierOf("item/" + item + "_bc")), Optional.empty(), TextureSlot.LAYER0)
                        .create(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMapping.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
            }
            case "dagger" -> {
                ModelTemplates.FLAT_HANDHELD_ITEM.create(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMapping.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, false, false, false, true));
                ModelTemplates.FLAT_HANDHELD_ITEM.create(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMapping.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
            }
            case "javelin" -> {
                ModelTemplates.FLAT_HANDHELD_ITEM.create(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMapping.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, true, false, true));
                ModelTemplates.FLAT_HANDHELD_ITEM.create(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMapping.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                new ModelTemplate(Optional.of(MedievalMain.identifierOf("item/" + item + "_throwing")), Optional.empty(), TextureSlot.LAYER0)
                        .create(MedievalMain.identifierOf("item/" + material + "_" + item + "_throwing"), TextureMapping.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
                new ModelTemplate(Optional.of(MedievalMain.identifierOf("item/" + item + "_bc")), Optional.empty(), TextureSlot.LAYER0)
                        .create(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMapping.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
            }
            default -> { }
        }
    }

    private static JsonObject createPredicateJson(ResourceLocation id, Map<TextureSlot, ResourceLocation> textures, String item, String material, boolean gui, boolean throwing, boolean offhand, boolean bettercombat) {
        JsonObject jsonObject = new ModelTemplate(Optional.of(MedievalMain.identifierOf("item/" + item)), Optional.of("medievalweapons:item/" + material + "_" + item), TextureSlot.LAYER0).createBaseTemplate(id, textures);

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
