package net.medievalweapons.compat;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.medievalweapons.entity.renderer.*;

public class CompatRender {

    public static void loadRenderer() {
        if (CompatItems.isBetterEndLoaded) {
            EntityRendererRegistry.INSTANCE.register(CompatEntities.AETERNIUM_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.AETERNIUM_JAVELIN, Javelin_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.TERMINITE_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.TERMINITE_JAVELIN, Javelin_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.THALLASIUM_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.THALLASIUM_JAVELIN, Javelin_Entity_Renderer::new);
        }
        if (CompatItems.isBetterNetherLoaded) {
            EntityRendererRegistry.INSTANCE.register(CompatEntities.NETHER_RUBY_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.NETHER_RUBY_JAVELIN, Javelin_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.CINCINNASITE_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.CINCINNASITE_JAVELIN, Javelin_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.CINCINNASITE_DIAMOND_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.CINCINNASITE_DIAMOND_JAVELIN, Javelin_Entity_Renderer::new);
        }
        if (CompatItems.isDragonLootLoaded) {
            EntityRendererRegistry.INSTANCE.register(CompatEntities.DRAGON_FRANCISCA_HT, Francisca_HT_Entity_Renderer::new);
            EntityRendererRegistry.INSTANCE.register(CompatEntities.DRAGON_JAVELIN, Javelin_Entity_Renderer::new);
        }
    }
}