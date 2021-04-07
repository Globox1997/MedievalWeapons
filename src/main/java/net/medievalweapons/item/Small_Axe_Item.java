package net.medievalweapons.item;

import java.util.List;

import net.medievalweapons.init.ConfigInit;
import net.medievalweapons.init.ItemInit;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class Small_Axe_Item extends SwordItem {

  public Small_Axe_Item(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
    super(toolMaterial, attackDamage, attackSpeed, settings);
  }

  // Built in knockback is done by mixin

  @Override
  public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    if (ConfigInit.CONFIG.display_rareness) {
      tooltip.add(ItemInit.rareness(this.getMaterial()));
    }
  }

}