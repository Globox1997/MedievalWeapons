package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SmallAxeItem extends SwordItem {

    public static final ResourceLocation ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("double_handed_attack_bonus");

    public SmallAxeItem(Tier toolMaterial, Properties settings) {
        super(toolMaterial, settings);
    }

}
