package net.medievalweapons.fabric.platform;

import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.item.JavelinItem;
import net.medievalweapons.platform.services.IItemHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.util.function.Supplier;

public class FabricItemHelper implements IItemHelper {

    @Override
    public JavelinItem createJavelin(ToolMaterial material, Supplier<EntityType<JavelinEntity>> typeSupplier, Item.Properties settings) {
        return new JavelinItem(material, typeSupplier, settings);
    }

}
