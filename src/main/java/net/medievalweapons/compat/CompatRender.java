package net.medievalweapons.compat;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.medievalweapons.entity.renderer.*;

@Environment(EnvType.CLIENT)
public class CompatRender {

    public static void loadRenderer() {
        if (CompatItems.isBetterEndLoaded) {
            EntityRendererRegistry.register(CompatEntities.AETERNIUM_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.AETERNIUM_JAVELIN, JavelinEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.TERMINITE_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.TERMINITE_JAVELIN, JavelinEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.THALLASIUM_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.THALLASIUM_JAVELIN, JavelinEntityRenderer::new);
        }
        if (CompatItems.isBetterNetherLoaded) {
            EntityRendererRegistry.register(CompatEntities.NETHER_RUBY_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.NETHER_RUBY_JAVELIN, JavelinEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.CINCINNASITE_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.CINCINNASITE_JAVELIN, JavelinEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.CINCINNASITE_DIAMOND_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.CINCINNASITE_DIAMOND_JAVELIN, JavelinEntityRenderer::new);
        }
        if (CompatItems.isDragonLootLoaded) {
            EntityRendererRegistry.register(CompatEntities.DRAGON_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.DRAGON_JAVELIN, JavelinEntityRenderer::new);
        }
        if (CompatItems.isMythicMetalsLoaded) {
            EntityRendererRegistry.register(CompatEntities.ADAMANTITE_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.ADAMANTITE_JAVELIN, JavelinEntityRenderer::new);
        }
        if (CompatItems.isParadiseLostLoaded) {
            EntityRendererRegistry.register(CompatEntities.OLVITE_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.OLVITE_JAVELIN, JavelinEntityRenderer::new);
        }
        if (CompatItems.isBYGLoaded) {
            EntityRendererRegistry.register(CompatEntities.PENDORITE_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.PENDORITE_JAVELIN, JavelinEntityRenderer::new);
        }
        if (CompatItems.isAdditionalAdditionsLoaded) {
            EntityRendererRegistry.register(CompatEntities.ROSE_GOLD_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.ROSE_GOLD_JAVELIN, JavelinEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.GILDED_NETHERITE_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.GILDED_NETHERITE_JAVELIN, JavelinEntityRenderer::new);
        }
        if (CompatItems.isMythicUpgradesLoaded) {
            EntityRendererRegistry.register(CompatEntities.RUBY_NETHERITE_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.RUBY_NETHERITE_JAVELIN, JavelinEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.SAPPHIRE_NETHERITE_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.SAPPHIRE_NETHERITE_JAVELIN, JavelinEntityRenderer::new);
        }
        if (CompatItems.isDeeperDarkerLoaded) {
            EntityRendererRegistry.register(CompatEntities.WARDEN_FRANCISCA, FranciscaEntityRenderer::new);
            EntityRendererRegistry.register(CompatEntities.WARDEN_JAVELIN, JavelinEntityRenderer::new);
        }
    }
}