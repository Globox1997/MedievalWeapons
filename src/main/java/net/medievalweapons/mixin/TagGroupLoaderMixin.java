package net.medievalweapons.mixin;

import java.util.List;
import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.compat.CompatItems;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagLoader;
import net.minecraft.tags.TagLoader.EntryWithSource;

@Mixin(TagLoader.class)
public class TagGroupLoaderMixin<T> {

    @Inject(method = "build(Ljava/util/Map;)Ljava/util/Map;", at = @At("HEAD"))
    private void buildGroupMixin(Map<Identifier, List<EntryWithSource>> map, CallbackInfoReturnable<Map<Identifier, List<T>>> info) {
        if (!CompatItems.isDragonLootLoaded) {
            map.remove(Identifier.fromNamespaceAndPath("dragonloot", "explosion_resistant"));
        }
    }
}
