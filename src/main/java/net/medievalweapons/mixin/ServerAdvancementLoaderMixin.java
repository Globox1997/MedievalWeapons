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
            map.remove(new Identifier("medievalweapons", "medieval_aternium_end_recipes"));
            map.remove(new Identifier("medievalweapons", "medieval_terminite_end_recipes"));
            map.remove(new Identifier("medievalweapons", "medieval_thallasium_end_recipes"));
        }
        if (!CompatItems.isDragonLootLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval_dragon_recipes"));
        }
        if (!CompatItems.isMythicMetalsLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval_adamantite_recipes"));
        }
        if (!CompatItems.isBYGLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval_pendorite_recipes"));
        }
        if (!CompatItems.isAdditionalAdditionsLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval_gilded_netherite_recipes"));
            map.remove(new Identifier("medievalweapons", "medieval_rose_gold_recipes"));
        }
        if (!CompatItems.isParadiseLostLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval_olvite_recipes"));
            // map.remove(new Identifier("medievalweapons", "medieval_zanite_recipes"));
        }
        if (!CompatItems.isMythicUpgradesLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval_ruby_netherite_recipes"));
            map.remove(new Identifier("medievalweapons", "medieval_sapphire_netherite_recipes"));
        }
        if (!CompatItems.isMythicUpgradesLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval_ruby_netherite_recipes"));
            map.remove(new Identifier("medievalweapons", "medieval_sapphire_netherite_recipes"));
        }
        if (!CompatItems.isDeeperDarkerLoaded) {
            map.remove(new Identifier("medievalweapons", "medieval_warden_recipes"));
        }
    }
}