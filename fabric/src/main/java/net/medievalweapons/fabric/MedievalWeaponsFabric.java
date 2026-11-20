package net.medievalweapons.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.EnchantmentEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.fabric.api.util.TriState;
import net.fabricmc.loader.api.FabricLoader;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.*;
import net.medievalweapons.item.JavelinItem;
import net.medievalweapons.network.MedievalServerPacket;
import net.medievalweapons.network.packet.AttackPacket;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class MedievalWeaponsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MedievalMain.init();
        SoundInit.register((id, sound) -> Registry.register(BuiltInRegistries.SOUND_EVENT, id, sound));
        EffectInit.register((id, effect) -> Registry.register(BuiltInRegistries.MOB_EFFECT, id, effect));
        ParticleInit.register((id, particle) -> Registry.register(BuiltInRegistries.PARTICLE_TYPE, id, particle));
        EntityInit.register((id, type) -> Registry.register(BuiltInRegistries.ENTITY_TYPE, id, type));
        ItemInit.register((id, item) -> Registry.register(BuiltInRegistries.ITEM, id, item));
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ItemInit.MEDIEVALWEAPONS_ITEM_GROUP, FabricCreativeModeTab.builder().icon(ItemInit::creativeTabIcon)
                .title(ItemInit.creativeTabTitle()).displayItems((parameters, output) -> ItemInit.creativeTabItems().forEach(output::accept)).build());
        TagInit.init();

        for (String pack : CompatInit.builtinPacks()) {
            ResourceLoader.registerBuiltinPack(MedievalMain.identifierOf(pack), FabricLoader.getInstance().getModContainer(MedievalMain.MOD_ID).orElseThrow(),
                    PackActivationType.DEFAULT_ENABLED);
        }

        EnchantmentEvents.ALLOW_ENCHANTING.register((enchantment, target, enchantingContext) -> {
            if (target.getItem() instanceof JavelinItem && JavelinItem.allowsExtraEnchantment(enchantment)) {
                return TriState.TRUE;
            }
            return TriState.DEFAULT;
        });
        ServerTickEvents.END_SERVER_TICK.register(ItemInit::onServerTick);

        PayloadTypeRegistry.serverboundPlay().register(AttackPacket.PACKET_ID, AttackPacket.PACKET_CODEC);
        ServerPlayNetworking.registerGlobalReceiver(AttackPacket.PACKET_ID,
                (payload, context) -> context.server().execute(() -> MedievalServerPacket.handle(context.player(), payload.entityId())));
    }

}
