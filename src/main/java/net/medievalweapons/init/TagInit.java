package net.medievalweapons.init;

import net.medievalweapons.MedievalMain;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TagInit {

    public static final DeferredRegister<Item> TAGS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MedievalMain.MOD_ID);
    public static final TagKey<Item> DOUBLE_HANDED_ITEMS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("medievalweapons", "double_handed_items"));
    public static final TagKey<Item> ACCROSS_DOUBLE_HANDED_ITEMS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("medievalweapons", "accross_double_handed_items"));

    public static void register(IEventBus eventBus){
        TAGS.register(eventBus);
    }


}