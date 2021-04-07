package net.medievalweapons.item;

import java.util.List;
import java.util.function.Supplier;

import net.medievalweapons.entity.Big_Axe_Entity;
import net.medievalweapons.init.ConfigInit;
import net.medievalweapons.init.ItemInit;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

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

  @Override
  public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    if (ConfigInit.CONFIG.display_rareness) {
      tooltip.add(ItemInit.rareness(this.getMaterial()));
    }
  }

  @Override
  public UseAction getUseAction(ItemStack stack) {
    return UseAction.BLOCK;
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack itemStack = user.getStackInHand(hand);
    user.setCurrentHand(hand);
    return TypedActionResult.consume(itemStack);
  }

}