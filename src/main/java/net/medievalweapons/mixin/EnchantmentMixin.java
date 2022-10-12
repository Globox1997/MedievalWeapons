package net.medievalweapons.mixin;
/*
import net.medievalweapons.item.Javelin_Item;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    private void isAcceptableItemMixin(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        if (((Object) this == Enchantments.PIERCING || (Object) this == Enchantments.IMPALING || (Object) this == Enchantments.LOYALTY) && stack.getItem() instanceof Javelin_Item) {
            info.setReturnValue(true);
        }
    }
}

 */
