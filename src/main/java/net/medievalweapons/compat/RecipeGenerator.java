package net.medievalweapons.compat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.resources.Identifier;

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

        JsonObject key = new JsonObject();
        key.addProperty("d", ingredient(headType, headItem));
        key.addProperty("e", ingredient(handleType, handleItem));
        json.add("key", key);

        JsonObject obj = new JsonObject();
        obj.addProperty("id", output.toString());
        obj.addProperty("count", 1);
        json.add("result", obj);

        return json;
    }

    public static JsonObject generateSmithingJson(Identifier base, Identifier addition, String baseType, String additionType, Identifier output, Identifier template) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:smithing_transform");

        json.addProperty("base", ingredient(baseType, base));
        json.addProperty("addition", ingredient(additionType, addition));

        JsonObject obj = new JsonObject();
        obj.addProperty("id", output.toString());
        json.add("result", obj);

        json.addProperty("template", template.toString());

        return json;
    }

    public static String ingredient(String type, Identifier id) {
        return "tag".equals(type) ? "#" + id : id.toString();
    }
}
