package net.medievalweapons.init;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.medievalweapons.entity.renderer.Big_Axe_Entity_Renderer;
import net.medievalweapons.entity.renderer.Francisca_HT_Entity_Renderer;
import net.medievalweapons.entity.renderer.Francisca_LT_Entity_Renderer;
import net.medievalweapons.entity.renderer.Javelin_Entity_Renderer;
import net.medievalweapons.network.EntitySpawnPacket;

public class RenderInit {

        public static void init() {

                ClientSidePacketRegistry.INSTANCE.register(EntitySpawnPacket.ID, EntitySpawnPacket::onPacket);

                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_FRANCISCA_LT,
                                (dispatcher, context) -> new Francisca_LT_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_FRANCISCA_LT,
                                (dispatcher, context) -> new Francisca_LT_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_FRANCISCA_HT,
                                (dispatcher, context) -> new Francisca_HT_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_FRANCISCA_HT,
                                (dispatcher, context) -> new Francisca_HT_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_FRANCISCA_HT,
                                (dispatcher, context) -> new Francisca_HT_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_FRANCISCA_HT,
                                (dispatcher, context) -> new Francisca_HT_Entity_Renderer(dispatcher));

                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_JAVELIN,
                                (dispatcher, context) -> new Javelin_Entity_Renderer(dispatcher));

                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_BIG_AXE,
                                (dispatcher, context) -> new Big_Axe_Entity_Renderer(dispatcher));

        }

}