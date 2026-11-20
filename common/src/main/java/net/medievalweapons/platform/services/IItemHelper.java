package net.medievalweapons.platform.services;

import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.item.JavelinItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.util.function.Supplier;

public interface IItemHelper {

    JavelinItem createJavelin(ToolMaterial material, Supplier<EntityType<JavelinEntity>> typeSupplier, Item.Properties settings);

}
