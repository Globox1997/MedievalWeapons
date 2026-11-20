package net.medievalweapons.neoforge;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.*;
import net.medievalweapons.network.MedievalServerPacket;
import net.medievalweapons.network.packet.AttackPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(MedievalMain.MOD_ID)
public class MedievalWeaponsNeoForge {

    public MedievalWeaponsNeoForge(IEventBus modBus) {
        MedievalMain.init();
        modBus.addListener(RegisterEvent.class, MedievalWeaponsNeoForge::register);
        modBus.addListener(RegisterPayloadHandlersEvent.class, MedievalWeaponsNeoForge::registerPayloads);
        modBus.addListener(AddPackFindersEvent.class, MedievalWeaponsNeoForge::addPackFinders);
        NeoForge.EVENT_BUS.addListener(ServerTickEvent.Post.class, event -> ItemInit.onServerTick(event.getServer()));
        TagInit.init();
    }

    private static void register(RegisterEvent event) {
        event.register(Registries.SOUND_EVENT, helper -> SoundInit.register(helper::register));
        event.register(Registries.MOB_EFFECT, helper -> EffectInit.register(helper::register));
        event.register(Registries.PARTICLE_TYPE, helper -> ParticleInit.register(helper::register));
        event.register(Registries.ENTITY_TYPE, helper -> EntityInit.register(helper::register));
        event.register(Registries.ITEM, helper -> ItemInit.register(helper::register));
        event.register(Registries.CREATIVE_MODE_TAB, helper -> helper.register(ItemInit.MEDIEVALWEAPONS_ITEM_GROUP, CreativeModeTab.builder().icon(ItemInit::creativeTabIcon)
                .title(ItemInit.creativeTabTitle()).displayItems((parameters, output) -> ItemInit.creativeTabItems().forEach(output::accept)).build()));
    }

    private static void registerPayloads(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1").optional();
        registrar.playToServer(AttackPacket.PACKET_ID, AttackPacket.PACKET_CODEC,
                (payload, context) -> MedievalServerPacket.handle((ServerPlayer) context.player(), payload.entityId()));
    }

    private static void addPackFinders(AddPackFindersEvent event) {
        for (String pack : CompatInit.builtinPacks()) {
            event.addPackFinders(MedievalMain.identifierOf("resourcepacks/" + pack), event.getPackType(), Component.translatable("pack.medievalweapons." + pack), PackSource.BUILT_IN, true,
                    Pack.Position.TOP);
        }
    }

}
