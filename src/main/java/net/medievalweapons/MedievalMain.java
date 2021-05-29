package net.medievalweapons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.medievalweapons.init.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class MedievalMain implements ModInitializer {

  // All credits go to Plasma Studios: https://youtu.be/Uc7YMW3AKpg?t=1152
  // Thanks for the awesome series
  // Check it out here: https://youtu.be/yCNUP2NAt-A

  public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier("medievalweapons", "group"),
      () -> new ItemStack(ItemInit.DIAMOND_FRANCISCA_HT_ITEM));

  public static final Identifier ID(String path) {
    return new Identifier("medievalweapons", path);
  }

  @Override
  public void onInitialize() {
    ConfigInit.init();
    EntityInit.init();
    ItemInit.init();
    ParticleInit.init();
    SoundInit.init();
    TagInit.init();

  }

}

// You are LOVED!!!
// Jesus loves you unconditionally!