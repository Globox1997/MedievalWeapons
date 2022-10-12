package net.medievalweapons.item;

import java.util.List;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.medievalweapons.MedievalMain;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class Long_Sword_Item extends SwordItem {
    private final Tiers material;

    public static final DeferredRegister<Attributes> ATTRIBUTES =
            DeferredRegister.create((ResourceLocation) ForgeRegistries.ATTRIBUTES, MedievalMain.MOD_ID);
    private final float attackDamage;
    public final ImmutableMultimap<RegistryObject, AttributeModifier> attributeModifiers;



    public Long_Sword_Item(Tiers material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
        this.material = material;
        this.attackDamage = attackDamage + material.getAttackDamageBonus();
        ImmutableMultimap.Builder<RegistryObject, AttributeModifier> builder = ImmutableMultimap.builder();
        ImmutableMultimap.Builder<RegistryObject<Attribute>, AttributeModifier> builder2 = ImmutableMultimap.builder();
        builder.put(this.ATTACK_DAMAGE_MOD, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(this.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", attackSpeed, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.REACH_DISTANCE, new AttributeModifier("Attack range", 0.8D, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ATTACK_RANGE, new AttributeModifier("Attack range", 0.8D, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }
    public static final RegistryObject<Attributes> ATTACK_DAMAGE_MOD = register("generic.attack_damage", new RangedAttribute("attribute.name.generic.attack_damage", 2.0D, 0.0D, 2048.0D));

    public static final RegistryObject<Attributes> ATTACK_SPEED = register("generic.attack_speed", (RangedAttribute) (new RangedAttribute("attribute.name.generic.attack_speed", 4.0D, 0.0D, 1024.0D)).setSyncable(true));



    private static RegistryObject register(String s, RangedAttribute rangedAttribute) {
        return null;
    }


    public static void register(IEventBus eventBus) {
        ATTRIBUTES.register(eventBus);
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);
        if (!CompatInit.isBetterCombatLoaded)
            tooltip.add(Component.translatable("item.medievalweapons.double_handed.tooltip"));
    }

    public Multimap<? extends Object, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack itemStack) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot,itemStack);
    }

    @Override
    public Tiers getTier() {
        return this.material;
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