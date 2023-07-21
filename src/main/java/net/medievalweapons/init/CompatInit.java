package net.medievalweapons.init;

import com.google.common.collect.ImmutableMultimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CompatInit {

    // ServerPlayNetworkHandlerMixin, PlayerEntityMixin, GameRendererMixin and LivingEntityMixin
    public static final EntityAttribute ATTACK_RANGE = new ClampedEntityAttribute("attribute.name.generic.attack_range", 0.0D, -1204.0D, 1024.0D).setTracked(true);

    public static final boolean isBetterCombatLoaded = FabricLoader.getInstance().isModLoaded("bettercombat");
    public static final Boolean isLevelZLoaded = FabricLoader.getInstance().isModLoaded("levelz");
    public static final Boolean isARRPLoaded = FabricLoader.getInstance().isModLoaded("advanced_runtime_resource_pack");
    public static final Boolean isBRRPLoaded = FabricLoader.getInstance().isModLoaded("brrp_v1");
    public static final Boolean isReachEntityAttributesLoaded = FabricLoader.getInstance().isModLoaded("reach-entity-attributes");

    public static void init() {
        if (!isReachEntityAttributesLoaded) {
            Registry.register(Registries.ATTRIBUTE, new Identifier("medievalweapons", "attack_range"), ATTACK_RANGE);
        }
    }

    public static void addRange(double range, ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder) {
        if (!isBetterCombatLoaded) {
            if (isReachEntityAttributesLoaded) {
                builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier("Attack range", range, EntityAttributeModifier.Operation.ADDITION));
                builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier("Attack range", range, EntityAttributeModifier.Operation.ADDITION));
            } else {
                builder.put(ATTACK_RANGE, new EntityAttributeModifier("Attack range", range, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    public static double getAttackRange(final LivingEntity entity, final double baseAttackRange) {
        @Nullable
        final var attackRange = entity.getAttributeInstance(ATTACK_RANGE);
        return (attackRange != null) ? (baseAttackRange + attackRange.getValue()) : baseAttackRange;
    }

    public static double getSquaredAttackRange(final LivingEntity entity, final double sqBaseAttackRange) {
        final var attackRange = getAttackRange(entity, Math.sqrt(sqBaseAttackRange));
        return attackRange * attackRange;
    }

    public static boolean isWithinAttackRange(final PlayerEntity player, final Entity entity) {
        return player.squaredDistanceTo(entity) <= getSquaredAttackRange(player, 64.0);
    }

}
