package net.medievalweapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.MedievalMain;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ModelInit {

    public static void init() {
        ModelPredicateProviderRegistry.register(ItemInit.LONG_BOW_ITEM, Identifier.of("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float) (stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 50.0F;
            }
        });
        ModelPredicateProviderRegistry.register(ItemInit.LONG_BOW_ITEM, Identifier.of("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(ItemInit.RECURVE_BOW_ITEM, Identifier.of("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float) (stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 12.0F;
            }
        });
        ModelPredicateProviderRegistry.register(ItemInit.RECURVE_BOW_ITEM, Identifier.of("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(MedievalMain.identifierOf("offhand"), (stack, world, entity, seed) -> {
            return entity != null && !entity.getOffHandStack().isEmpty() ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(Identifier.of("throwing"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f;
        });
        ModelPredicateProviderRegistry.register(MedievalMain.identifierOf("gui"), (stack, world, entity, seed) -> {
            return seed == 0 ? 1.0f : 0.0f;
        });
    }

}
