package net.medievalweapons.init;

import com.google.common.collect.ImmutableMultimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;

public class CompatInit {

    public static final boolean isBetterCombatLoaded = FabricLoader.getInstance().isModLoaded("bettercombat");
    public static final Boolean isLevelZLoaded = FabricLoader.getInstance().isModLoaded("levelz");

    public static void init() {
    }

    public static void addRange(double range, ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder) {
        if (!isBetterCombatLoaded) {
            builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier("Attack range", range, EntityAttributeModifier.Operation.ADDITION));
            builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier("Attack range", range, EntityAttributeModifier.Operation.ADDITION));
        }
    }

}
