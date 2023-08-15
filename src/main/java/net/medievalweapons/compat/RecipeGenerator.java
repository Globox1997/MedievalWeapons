package net.medievalweapons.compat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.util.Identifier;

public class RecipeGenerator {

    public static JsonObject generateJson(Identifier headItem, Identifier handleItem, String headType, String handleType, Identifier output, String itemName) {
        JsonObject json = new JsonObject();

        json.addProperty("type", "minecraft:crafting_shaped");

        JsonArray jsonArray = new JsonArray();
        switch (itemName) {
        case "big_axe":
            jsonArray.add(" de");
            jsonArray.add(" ed");
            jsonArray.add("ed ");
            break;
        case "dagger":
            jsonArray.add("d");
            jsonArray.add("e");
            break;
        case "francisca":
            jsonArray.add("de");
            jsonArray.add(" e");
            break;
        case "healing_staff":
            jsonArray.add("  d");
            jsonArray.add(" e ");
            jsonArray.add("d  ");
            break;
        case "javelin":
            jsonArray.add("d  ");
            jsonArray.add(" e ");
            jsonArray.add("  e");
            break;
        case "lance":
            jsonArray.add("  d");
            jsonArray.add("ee ");
            jsonArray.add("ee ");
            break;
        case "long_sword":
            jsonArray.add("  d");
            jsonArray.add("dd ");
            jsonArray.add("ed ");
            break;
        case "mace":
            jsonArray.add(" dd");
            jsonArray.add(" dd");
            jsonArray.add("e  ");
            break;
        case "small_axe":
            jsonArray.add(" dd");
            jsonArray.add(" ed");
            jsonArray.add("e  ");
            break;
        case "cincinnasite":
            jsonArray.add("ede");
            break;
        case "ninjato":
            jsonArray.add(" d ");
            jsonArray.add("d  ");
            jsonArray.add("e  ");
            break;
        case "sickle":
            jsonArray.add(" dd");
            jsonArray.add("  d");
            jsonArray.add(" e ");
            break;
        case "rapier":
            jsonArray.add("  d");
            jsonArray.add(" d ");
            jsonArray.add("e  ");
            break;
        }

        json.add("pattern", jsonArray);

        JsonObject obj = new JsonObject();
        JsonObject key = new JsonObject();

        obj.addProperty(headType, headItem.toString());
        key.add("d", obj);

        obj = new JsonObject();
        obj.addProperty(handleType, handleItem.toString());
        key.add("e", obj);

        json.add("key", key);

        obj = new JsonObject();
        obj.addProperty("item", output.toString());
        obj.addProperty("count", 1);
        json.add("result", obj);

        return json;
    }

    public static JsonObject generateSmithingJson(Identifier base, Identifier addition, String baseType, String additionType, Identifier output, Identifier template) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:smithing_transform");

        JsonObject obj = new JsonObject();
        obj.addProperty(baseType, base.toString());
        json.add("base", obj);

        obj = new JsonObject();
        obj.addProperty(additionType, addition.toString());
        json.add("addition", obj);

        obj = new JsonObject();
        obj.addProperty("item", output.toString());
        json.add("result", obj);

        obj = new JsonObject();
        obj.addProperty("item", template.toString());
        json.add("template", obj);

        return json;
    }
}