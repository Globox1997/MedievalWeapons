package net.medievalweapons.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.medievalweapons.init.CompatInit;
import net.medievalweapons.init.EffectInit;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class Mace_Item extends SwordItem {

    private final ToolMaterial material;
    private final float attackDamage;
    public final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    private int addition;

    public Mace_Item(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, int addition, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.material = toolMaterial;
        this.attackDamage = attackDamage + material.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        CompatInit.addRange(-0.5D, builder);
        this.attributeModifiers = builder.build();
        this.addition = addition;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot);
    }

    @Override
    public ToolMaterial getMaterial() {
        return this.material;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isDead() && attacker.world.random.nextFloat() <= 0.01F + ((float) addition / 10F))
            target.addStatusEffect(new StatusEffectInstance(EffectInit.STUN_EFFECT, 60 + addition * 20, 0, false, false, true));
        return super.postHit(stack, target, attacker);
    }

}
