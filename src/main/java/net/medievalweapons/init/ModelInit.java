package net.medievalweapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.MedievalMain;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class ModelInit {

    public static void init() {
        ItemProperties.register(ItemInit.LONG_BOW_ITEM, ResourceLocation.parse("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 50.0F;
            }
        });
        ItemProperties.register(ItemInit.LONG_BOW_ITEM, ResourceLocation.parse("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.RECURVE_BOW_ITEM, ResourceLocation.parse("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 12.0F;
            }
        });
        ItemProperties.register(ItemInit.RECURVE_BOW_ITEM, ResourceLocation.parse("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
        });
        ItemProperties.registerGeneric(MedievalMain.identifierOf("offhand"), (stack, world, entity, seed) -> {
            return entity != null && !entity.getOffhandItem().isEmpty() ? 1.0F : 0.0F;
        });
        ItemProperties.registerGeneric(ResourceLocation.parse("throwing"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0f : 0.0f;
        });
        ItemProperties.registerGeneric(MedievalMain.identifierOf("gui"), (stack, world, entity, seed) -> {
            return seed == 0 ? 1.0f : 0.0f;
        });
    }

}
