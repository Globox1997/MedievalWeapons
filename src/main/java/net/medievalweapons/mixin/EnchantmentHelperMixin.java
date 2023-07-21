package net.medievalweapons.mixin;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.init.TagInit;
import net.medievalweapons.item.Big_Axe_Item;
import net.medievalweapons.item.Javelin_Item;
import net.medievalweapons.item.Lance_Item;
import net.medievalweapons.item.Small_Axe_Item;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.SweepingEnchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

    @Inject(method = "getSweepingMultiplier", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getEquipmentLevel(Lnet/minecraft/enchantment/Enchantment;Lnet/minecraft/entity/LivingEntity;)I"), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private static void getSweepingMultiplierMixin(LivingEntity entity, CallbackInfoReturnable<Float> info, int i) {
        ItemStack itemStack = entity.getMainHandStack();

        if (itemStack.isIn(TagInit.ACCROSS_DOUBLE_HANDED_ITEMS) || itemStack.getItem() instanceof Big_Axe_Item) {
            info.setReturnValue(SweepingEnchantment.getMultiplier(i + 1));
        }
    }

    @Inject(method = "getPossibleEntries", at = @At("TAIL"), cancellable = true)
    private static void getPossibleEntriesMixin(int i, ItemStack stack, boolean treasureAllowed, CallbackInfoReturnable<List<EnchantmentLevelEntry>> info) {
        List<EnchantmentLevelEntry> currentEnchantments = info.getReturnValue();
        if (currentEnchantments != null) {
            if (stack.getItem() instanceof Javelin_Item) {
                List<EnchantmentLevelEntry> enchantments = new ArrayList<>();
                currentEnchantments.forEach(enchantment -> {
                    if ((enchantment.enchantment.target == EnchantmentTarget.WEAPON && enchantment.enchantment != Enchantments.SWEEPING) || enchantment.enchantment == Enchantments.IMPALING
                            || enchantment.enchantment == Enchantments.PIERCING || enchantment.enchantment == Enchantments.LOYALTY) {
                        enchantments.add(enchantment);
                    }
                });

                info.setReturnValue(enchantments);
            } else if (stack.getItem() instanceof Lance_Item) {
                List<EnchantmentLevelEntry> enchantments = new ArrayList<>();
                currentEnchantments.forEach(enchantment -> {
                    if (enchantment.enchantment.target == EnchantmentTarget.WEAPON && enchantment.enchantment != Enchantments.SWEEPING) {
                        enchantments.add(enchantment);
                    }
                });
                info.setReturnValue(enchantments);
            }
        }
    }

    @Inject(method = "getKnockback", at = @At("HEAD"), cancellable = true)
    private static void getKnockbackMixin(LivingEntity entity, CallbackInfoReturnable<Integer> info) {
        ItemStack itemStack = entity.getStackInHand(Hand.MAIN_HAND);
        if (itemStack.getItem() instanceof Small_Axe_Item) {
            info.setReturnValue(1 + getEquipmentLevel(Enchantments.KNOCKBACK, entity));
        }
    }

    @Shadow
    public static int getEquipmentLevel(Enchantment enchantment, LivingEntity entity) {
        return 1;
    }

}
