package net.medievalweapons.mixin;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.compat.CompatItems;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagGroupLoader;
import net.minecraft.util.Identifier;

@Mixin(TagGroupLoader.class)
public class TagGroupLoaderMixin<T> {

    @Inject(method = "buildGroup", at = @At("HEAD"))
    private void buildGroupMixin(Map<Identifier, Tag.Builder> tags, CallbackInfoReturnable<Map<Identifier, Tag<T>>> info) {
        if (!CompatItems.isDragonLootLoaded) {
            tags.remove(new Identifier("dragonloot", "explosion_resistant"));
        }
    }
}
