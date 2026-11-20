package net.medievalweapons.neoforge.client;

import me.shedaniel.autoconfig.AutoConfigClient;
import net.medievalweapons.MedievalClient;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.config.MedievalConfig;
import net.medievalweapons.init.ModelInit;
import net.medievalweapons.init.ParticleInit;
import net.medievalweapons.init.RenderInit;
import net.medievalweapons.network.MedievalClientPacket;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterConditionalItemModelPropertyEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = MedievalMain.MOD_ID, dist = Dist.CLIENT)
public class MedievalWeaponsNeoForgeClient {

    public MedievalWeaponsNeoForgeClient(IEventBus modBus, ModContainer container) {
        modBus.addListener(RegisterConditionalItemModelPropertyEvent.class, event -> ModelInit.register(event::register));
        modBus.addListener(EntityRenderersEvent.RegisterRenderers.class, event -> RenderInit.registerEntityRenderers(event::registerEntityRenderer));
        modBus.addListener(RegisterParticleProvidersEvent.class,
                event -> event.registerSpriteSet(ParticleInit.HEALING_AURA_PARTICLE, ParticleInit.HealingAuraParticle.Factory::new));
        MedievalClientPacket.init();
        NeoForge.EVENT_BUS.addListener(ClientTickEvent.Pre.class, event -> MedievalClient.onClientTick(Minecraft.getInstance()));

        container.registerExtensionPoint(IConfigScreenFactory.class, (modContainer, parent) -> AutoConfigClient.getConfigScreen(MedievalConfig.class, parent).get());
    }

}
