package net.medievalweapons.mixin;

import java.util.Map;

import com.google.gson.JsonElement;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.medievalweapons.compat.CompatItems;
import net.minecraft.resource.ResourceManager;
import net.minecraft.server.ServerAdvancementLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

@Mixin(ServerAdvancementLoader.class)
public class ServerAdvancementLoaderMixin {

    @Inject(method = "apply", at = @At("HEAD"))
    protected void applyMixin(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
        if (!CompatItems.isBetterEndLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval_ruby_nether_recipes"));
            map.remove(new Identifier("medievalweapons", "medieval_cincinnasite_nether_recipes"));
            map.remove(new Identifier("medievalweapons", "medieval_cincinnasite_diamond_nether_recipes"));
        }
        if (!CompatItems.isBetterNetherLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval__aternium_end_recipes"));
            map.remove(new Identifier("medievalweapons", "medieval__terminite_end_recipes"));
            map.remove(new Identifier("medievalweapons", "medieval__thallasium_end_recipes"));
        }
        if (!CompatItems.isDragonLootLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval_dragon_recipes"));
        }
    }
}