package net.medievalweapons.compat;

import net.minecraft.util.Identifier;

public class ShapedRecipeMaterial {

    public Identifier headItem;
    public Identifier handleItem;
    public String headType;
    public String handleType;
    public Identifier output;
    public String itemName;

    public ShapedRecipeMaterial(Identifier headItem, Identifier handleItem, String headType, String handleType, Identifier output, String itemName) {
        this.headItem = headItem;
        this.handleItem = handleItem;
        this.headType = headType;
        this.handleType = handleType;
        this.output = output;
        this.itemName = itemName;
    }

}