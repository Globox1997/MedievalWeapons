package net.medievalweapons.compat;

import net.minecraft.resources.ResourceLocation;

public class ShapedRecipeMaterial {

    public ResourceLocation headItem;
    public ResourceLocation handleItem;
    public String headType;
    public String handleType;
    public ResourceLocation output;
    public String itemName;

    public ShapedRecipeMaterial(ResourceLocation headItem, ResourceLocation handleItem, String headType, String handleType, ResourceLocation output, String itemName) {
        this.headItem = headItem;
        this.handleItem = handleItem;
        this.headType = headType;
        this.handleType = handleType;
        this.output = output;
        this.itemName = itemName;
    }

}