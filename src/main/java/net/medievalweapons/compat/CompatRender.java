package net.medievalweapons.compat;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.medievalweapons.entity.renderer.*;

public class CompatRender {

    public static void loadRenderer() {
        if (CompatItems.isBetterEndLoaded) {
            EntityRendererRegistry.register(CompatEntities.AETERNIUM_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.AETERNIUM_JAVELIN, Javelin_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.TERMINITE_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.TERMINITE_JAVELIN, Javelin_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.THALLASIUM_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.THALLASIUM_JAVELIN, Javelin_Entity_Renderer::new);
        }
        if (CompatItems.isBetterNetherLoaded) {
            EntityRendererRegistry.register(CompatEntities.NETHER_RUBY_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.NETHER_RUBY_JAVELIN, Javelin_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.CINCINNASITE_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.CINCINNASITE_JAVELIN, Javelin_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.CINCINNASITE_DIAMOND_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.CINCINNASITE_DIAMOND_JAVELIN, Javelin_Entity_Renderer::new);
        }
        if (CompatItems.isDragonLootLoaded) {
            EntityRendererRegistry.register(CompatEntities.DRAGON_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.DRAGON_JAVELIN, Javelin_Entity_Renderer::new);
        }
        if (CompatItems.isMythicMetalsLoaded) {
            EntityRendererRegistry.register(CompatEntities.ADAMANTITE_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.ADAMANTITE_JAVELIN, Javelin_Entity_Renderer::new);
        }
        if (CompatItems.isAetherLoaded) {
            EntityRendererRegistry.register(CompatEntities.GRAVITITE_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.GRAVITITE_JAVELIN, Javelin_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.ZANITE_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.ZANITE_JAVELIN, Javelin_Entity_Renderer::new);
        }
        if (CompatItems.isBYGLoaded) {
            EntityRendererRegistry.register(CompatEntities.PENDORITE_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.PENDORITE_JAVELIN, Javelin_Entity_Renderer::new);
        }
        if (CompatItems.isAdditionalAdditionsLoaded) {
            EntityRendererRegistry.register(CompatEntities.ROSE_GOLD_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.ROSE_GOLD_JAVELIN, Javelin_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.GILDED_NETHERITE_FRANCISCA, Francisca_Entity_Renderer::new);
            EntityRendererRegistry.register(CompatEntities.GILDED_NETHERITE_JAVELIN, Javelin_Entity_Renderer::new);
        }

    }
}