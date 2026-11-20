package net.medievalweapons.neoforge.platform;

import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.item.JavelinItem;
import net.medievalweapons.neoforge.item.NeoForgeJavelinItem;
import net.medievalweapons.platform.services.IItemHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.util.function.Supplier;

public class NeoForgeItemHelper implements IItemHelper {

    @Override
    public JavelinItem createJavelin(ToolMaterial material, Supplier<EntityType<JavelinEntity>> typeSupplier, Item.Properties settings) {
        return new NeoForgeJavelinItem(material, typeSupplier, settings);
    }

}
