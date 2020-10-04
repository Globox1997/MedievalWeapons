package net.medievalweapons.init;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModelProviderInit {

  public static void init() {
    FabricModelPredicateProviderRegistry.register(ItemInit.LONG_BOW_ITEM, new Identifier("pull"),
        (stack, world, entity) -> {
          if (entity == null) {
            return 0.0F;
          } else {
            return entity.getActiveItem() != stack ? 0.0F
                : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 40.0F;
          }
        });
    FabricModelPredicateProviderRegistry.register(ItemInit.LONG_BOW_ITEM, new Identifier("pulling"),
        (stack, world, entity) -> {
          return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
    FabricModelPredicateProviderRegistry.register(ItemInit.RECURVE_BOW_ITEM, new Identifier("pull"),
        (stack, world, entity) -> {
          if (entity == null) {
            return 0.0F;
          } else {
            return entity.getActiveItem() != stack ? 0.0F
                : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 18.0F;
          }
        });
    FabricModelPredicateProviderRegistry.register(ItemInit.RECURVE_BOW_ITEM, new Identifier("pulling"),
        (stack, world, entity) -> {
          return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });

  }

}