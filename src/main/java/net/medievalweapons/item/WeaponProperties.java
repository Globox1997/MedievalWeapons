package net.medievalweapons.item;

import net.medievalweapons.init.TagInit;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Weapon;

import java.util.List;
import java.util.Optional;

public class WeaponProperties {

    public static final float SHIELD_DISABLE_SECONDS = 5.0F;

    public record Bonus(Holder<Attribute> attribute, AttributeModifier modifier) {
    }

    public static Bonus bonus(Holder<Attribute> attribute, Identifier id, double value) {
        return new Bonus(attribute, new AttributeModifier(id, value, AttributeModifier.Operation.ADD_VALUE));
    }

    public static Item.Properties of(Identifier id) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id));
    }

    public static Item.Properties sword(Item.Properties properties, ToolMaterial material, float damage, float speed, Bonus... bonuses) {
        return sword(properties, material, material, damage, speed, bonuses);
    }

    public static Item.Properties sword(Item.Properties properties, ToolMaterial material, ToolMaterial attributeMaterial, float damage, float speed, Bonus... bonuses) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, damage + attributeMaterial.attackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, speed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
        for (Bonus bonus : bonuses) {
            builder.add(bonus.attribute(), bonus.modifier(), EquipmentSlotGroup.MAINHAND);
        }
        return properties.sword(material, damage, speed).attributes(builder.build());
    }

    public static Item.Properties swordWithoutAttributes(Item.Properties properties, ToolMaterial material) {
        return properties.sword(material, 0.0F, 0.0F).attributes(ItemAttributeModifiers.EMPTY);
    }

    public static Item.Properties weaponBlocking(Item.Properties properties, Holder<SoundEvent> blockSound) {
        return blocking(properties, blockSound, 1, TagInit.BYPASSES_WEAPON_BLOCK).component(DataComponents.WEAPON, new Weapon(1, SHIELD_DISABLE_SECONDS));
    }

    public static Item.Properties staffBlocking(Item.Properties properties) {
        return blocking(properties, SoundEvents.SHIELD_BLOCK, 0, DamageTypeTags.BYPASSES_SHIELD);
    }

    private static Item.Properties blocking(Item.Properties properties, Holder<SoundEvent> blockSound, int itemDamage, TagKey<DamageType> bypassedBy) {
        return properties.delayedComponent(DataComponents.BLOCKS_ATTACKS,
                context -> new BlocksAttacks(0.25F, 1.0F, List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                        new BlocksAttacks.ItemDamageFunction(Float.MIN_VALUE, itemDamage, 0.0F), Optional.of(context.getOrThrow(bypassedBy)), Optional.of(blockSound),
                        Optional.of(SoundEvents.SHIELD_BREAK)));
    }

}
