package net.medievalweapons.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.ItemInit;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ModelLoader extends FabricModelProvider {

    private static final Optional<Identifier> HANDHELD = Optional.of(Identifier.ofVanilla("item/handheld"));
//    private static final Optional<Identifier> SMALL_AXE = Optional.of(MedievalMain.id("item/small_axe"));


    public ModelLoader(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        for (String item : ItemInit.ITEM_STRINGS) {
            for (String material : ItemInit.MATERIAL_STRINGS) {
//                ARRP_RESOURCE_PACK.addModel(getJModel(item, ItemInit.MATERIAL_STRINGS.get(i)), Identifier.of("medievalweapons", "item/" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item));
                // Check for gui item models

//                if (item.equals("ninjato") || item.equals("small_axe")) {
                Model model = getItemModel(item, material, itemModelGenerator.writer);
                if (model != null) {
                    itemModelGenerator.register(Registries.ITEM.get(MedievalMain.identifierOf(material + "_" + item)), model);
                }
//                }
                if (item.equals("big_axe") || item.equals("healing_staff") || item.equals("javelin") || item.equals("lance") || item.equals("long_sword") || item.equals("mace")
                        || item.equals("rapier") || item.equals("sickle") || item.equals("small_axe")) {
//                    ARRP_RESOURCE_PACK.addModel(getGuiJModel(item, ItemInit.MATERIAL_STRINGS.get(i)),
//                            Identifier.of("medievalweapons", "item/" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item + "_gui"));

                }
                // Check for bc item models
                if (item.equals("dagger") || item.equals("big_axe") || item.equals("lance") || item.equals("long_sword")) {
//                    ARRP_RESOURCE_PACK.addModel(getOtherJModel(item, ItemInit.MATERIAL_STRINGS.get(i)),
//                            Identifier.of("medievalweapons", "item/bc_" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item));
                }
                // Check ARRP_RESOURCE_PACK throwing item models
                if (item.equals("javelin")) {
//                    ARRP_RESOURCE_PACK.addModel(getOtherJModel(item, ItemInit.MATERIAL_STRINGS.get(i)),
//                            Identifier.of("medievalweapons", "item/" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item + "_throwing"));
                }
            }
        }
    }

//    public static final Model SMALL_AXE = new Model(Optional.of(MedievalMain.id("item/small_axe")), Optional.empty(), TextureKey.LAYER0);

    @Nullable
    private static Model getItemModel(String item, String material, BiConsumer<Identifier, Supplier<JsonElement>> writer) {
        switch (item) {
            case "ninjato":
                return new Model(HANDHELD, Optional.of("medievalweapons:item/" + material + "_" + item), TextureKey.LAYER0);
            case "francisca":
                return new Model(HANDHELD, Optional.of("medievalweapons:item/" + material + "_" + item), TextureKey.LAYER0);
            case "small_axe":
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, false, false));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                return null;
            case "long_sword":
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, true, true));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                new Model(Optional.of(MedievalMain.identifierOf("item/" + item + "_bc")), Optional.empty(), TextureKey.LAYER0).upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
                return null;
            case "dagger":
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, false, false, false, true));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
                return null;
            case "big_axe":
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, true, true));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                new Model(Optional.of(MedievalMain.identifierOf("item/" + item + "_bc")), Optional.empty(), TextureKey.LAYER0).upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
                return null;
            case "javelin":
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, true, false, true));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                new Model(Optional.of(MedievalMain.identifierOf("item/" + item + "_throwing")), Optional.empty(), TextureKey.LAYER0).upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_throwing"), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
                new Model(Optional.of(MedievalMain.identifierOf("item/" + item + "_bc")), Optional.empty(), TextureKey.LAYER0).upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
                return null;
            case "lance":
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, true, true));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                new Model(Optional.of(MedievalMain.identifierOf("item/" + item + "_bc")), Optional.empty(), TextureKey.LAYER0).upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_bc"), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer);
                return null;
            case "healing_staff":
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, false, false));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                return null;
            case "mace":
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, false, false));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                return null;
            case "sickle":
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, false, false));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                return null;
            case "rapier":
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item), TextureMap.layer0(MedievalMain.identifierOf("item/" + material + "_" + item)), writer, (id, textures) -> createPredicateJson(id, textures, item, material, true, false, false, false));
                Models.HANDHELD.upload(MedievalMain.identifierOf("item/" + material + "_" + item + "_gui"), TextureMap.layer0(MedievalMain.identifierOf("item/extra/" + material + "_" + item)), writer);
                return null;
            default:
                return null;
        }
    }

    private static JsonObject createPredicateJson(Identifier id, Map<TextureKey, Identifier> textures, String item, String material, boolean gui, boolean throwing, boolean offhand, boolean bettercombat) {
        JsonObject jsonObject = new Model(Optional.of(MedievalMain.identifierOf("item/" + item)), Optional.of("medievalweapons:item/" + material + "_" + item), TextureKey.LAYER0).createJson(id, textures);

        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject2;
        JsonObject jsonObject3;
        // Needs to be in the following order
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
