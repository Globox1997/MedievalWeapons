package net.medievalweapons.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.medievalweapons.init.EffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class Mace_Item extends SwordItem {

    private final Tiers material;
    private final float attackDamage;
    public final ImmutableMultimap<Attribute, AttributeModifier> attributeModifiers;
    private int addition;

    public Mace_Item(Tiers toolMaterial, int attackDamage, float attackSpeed, int addition, Properties settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.material = toolMaterial;
        this.attackDamage = attackDamage + material.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", attackSpeed, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
        this.addition = addition;
    }


    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack itemStack) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot,itemStack);
    }

    @Override
    public Tiers getTier() {
        return this.material;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isDeadOrDying() && attacker.level.random.nextFloat() <= 0.01F + ((float) addition / 10F))
            target.addEffect(new MobEffectInstance(EffectInit.STUN_EFFECT.get(), 60 + addition * 20, 0, false, false, true));
        return super.hurtEnemy(stack, target, attacker);
    }

}
