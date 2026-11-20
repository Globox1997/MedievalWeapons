package net.medievalweapons.item;

import java.util.List;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.CompatInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class HeroSwordItem extends SwordItem {

    public static final ResourceLocation ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("double_handed_attack_bonus");

    public HeroSwordItem(Tier toolMaterial, Properties settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        super.appendHoverText(stack, context, tooltip, type);
        if (!CompatInit.isBetterCombatLoaded) {
            tooltip.add(Component.translatable("item.medievalweapons.double_handed.tooltip"));
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BLOCK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        user.startUsingItem(hand);
        return InteractionResultHolder.consume(itemStack);
    }

}
