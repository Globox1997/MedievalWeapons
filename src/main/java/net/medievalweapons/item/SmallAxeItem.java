package net.medievalweapons.item;

import net.medievalweapons.MedievalMain;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

public class SmallAxeItem extends Item {

    public static final Identifier ATTACK_BONUS_MODIFIER_ID = MedievalMain.identifierOf("double_handed_attack_bonus");

    public SmallAxeItem(Properties settings) {
        super(settings);
    }

}
