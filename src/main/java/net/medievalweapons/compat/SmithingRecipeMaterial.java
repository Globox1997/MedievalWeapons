package net.medievalweapons.compat;

import net.minecraft.resources.ResourceLocation;

public class SmithingRecipeMaterial {

    public ResourceLocation baseItem;
    public ResourceLocation additionItem;
    public String baseType;
    public String additionType;
    public ResourceLocation output;

    public SmithingRecipeMaterial(ResourceLocation baseItem, ResourceLocation additionItem, String baseType, String additionType, ResourceLocation output) {
        this.baseItem = baseItem;
        this.additionItem = additionItem;
        this.baseType = baseType;
        this.additionType = additionType;
        this.output = output;
    }

}