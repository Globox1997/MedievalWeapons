package net.medievalweapons.compat;

import net.minecraft.util.Identifier;

public class SmithingRecipeMaterial {

    public Identifier baseItem;
    public Identifier additionItem;
    public String baseType;
    public String additionType;
    public Identifier output;

    public SmithingRecipeMaterial(Identifier baseItem, Identifier additionItem, String baseType, String additionType, Identifier output) {
        this.baseItem = baseItem;
        this.additionItem = additionItem;
        this.baseType = baseType;
        this.additionType = additionType;
        this.output = output;
    }

}