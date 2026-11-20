package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.CompatInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class BigAxeItem extends Item {

    public static final Identifier ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("double_handed_attack_bonus");

    public BigAxeItem(Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag type) {
        super.appendHoverText(stack, context, display, builder, type);
        if (!CompatInit.isBetterCombatLoaded) {
            builder.accept(Component.translatable("item.medievalweapons.double_handed.tooltip"));
        }
    }

}
