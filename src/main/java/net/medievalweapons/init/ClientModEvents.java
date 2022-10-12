package net.medievalweapons.init;


import net.medievalweapons.MedievalMain;
import net.medievalweapons.entity.renderer.Francisca_Entity_Renderer;
import net.medievalweapons.entity.renderer.Healing_Ball_Entity_Renderer;
import net.medievalweapons.entity.renderer.Javelin_Entity_Renderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MedievalMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void clientSetup(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.WOODEN_FRANCISCA.get(), Francisca_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.STONE_FRANCISCA.get(), Francisca_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.IRON_FRANCISCA.get(), Francisca_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.GOLDEN_FRANCISCA.get(), Francisca_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.DIAMOND_FRANCISCA.get(), Francisca_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.NETHERITE_FRANCISCA.get(), Francisca_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.WOODEN_JAVELIN.get(), Javelin_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.STONE_JAVELIN.get(), Javelin_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.IRON_JAVELIN.get(), Javelin_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.GOLDEN_JAVELIN.get(), Javelin_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.DIAMOND_FRANCISCA.get(), Javelin_Entity_Renderer::new);
        event.registerEntityRenderer(EntityInit.NETHERITE_JAVELIN.get(),Javelin_Entity_Renderer::new);

        event.registerEntityRenderer(EntityInit.HEALING_BALL_ENTITY.get(),Healing_Ball_Entity_Renderer::new);
    }
}