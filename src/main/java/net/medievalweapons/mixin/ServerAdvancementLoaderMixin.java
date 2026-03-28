package net.medievalweapons.mixin;

import com.google.gson.JsonElement;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.minecraft.resource.ResourceManager;
import net.minecraft.server.ServerAdvancementLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ServerAdvancementLoader.class)
public class ServerAdvancementLoaderMixin {

    @Inject(method = "apply", at = @At("HEAD"))
    protected void applyMixin(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
        if (!CompatItems.isBetterEndLoaded) {
            map.remove(MedievalMain.identifierOf("medieval_ruby_nether_recipes"));
            map.remove(MedievalMain.identifierOf("medieval_cincinnasite_nether_recipes"));
            map.remove(MedievalMain.identifierOf("medieval_cincinnasite_diamond_nether_recipes"));
        }
        if (!CompatItems.isBetterNetherLoaded) {
            map.remove(MedievalMain.identifierOf("medieval_aternium_end_recipes"));
            map.remove(MedievalMain.identifierOf("medieval_terminite_end_recipes"));
            map.remove(MedievalMain.identifierOf("medieval_thallasium_end_recipes"));
        }
        if (!CompatItems.isDragonLootLoaded) {
            map.remove(MedievalMain.identifierOf("medieval_dragon_recipes"));
        }
        if (!CompatItems.isMythicMetalsLoaded) {
            map.remove(MedievalMain.identifierOf("medieval_adamantite_recipes"));
        }
        if (!CompatItems.isBYGLoaded) {
            map.remove(MedievalMain.identifierOf("medieval_pendorite_recipes"));
        }
        if (!CompatItems.isAdditionalAdditionsLoaded) {
            map.remove(MedievalMain.identifierOf("medieval_gilded_netherite_recipes"));
            map.remove(MedievalMain.identifierOf("medieval_rose_gold_recipes"));
        }
        if (!CompatItems.isParadiseLostLoaded) {
            map.remove(MedievalMain.identifierOf("medieval_olvite_recipes"));
        }
        if (!CompatItems.isMythicUpgradesLoaded) {
            map.remove(MedievalMain.identifierOf("medieval_ruby_netherite_recipes"));
            map.remove(MedievalMain.identifierOf("medieval_sapphire_netherite_recipes"));
        }
        if (!CompatItems.isMythicUpgradesLoaded) {
            map.remove(MedievalMain.identifierOf("medieval_ruby_netherite_recipes"));
            map.remove(MedievalMain.identifierOf("medieval_sapphire_netherite_recipes"));
        }
        if (!CompatItems.isDeeperDarkerLoaded) {
            map.remove(MedievalMain.identifierOf("medieval_warden_recipes"));
        }
    }
}