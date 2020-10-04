package net.medievalweapons.item;

import java.util.function.Supplier;

import net.medievalweapons.entity.Big_Axe_Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class Big_Axe_Item extends SwordItem {
  private final Supplier<EntityType<Big_Axe_Entity>> typeSupplier;
  private EntityType<Big_Axe_Entity> cachedType = null;

  public Big_Axe_Item(ToolMaterial toolMaterial, int attackDamage, float attackSpeed,
      Supplier<EntityType<Big_Axe_Entity>> typeSupplier, Settings settings) {
    super(toolMaterial, attackDamage, attackSpeed, settings);
    this.typeSupplier = typeSupplier;
  }

  public EntityType<Big_Axe_Entity> getType() {
    if (cachedType == null) {
      cachedType = typeSupplier.get();
    }
    return cachedType;
  }

}