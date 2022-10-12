package net.medievalweapons;


import com.mojang.logging.LogUtils;
import net.medievalweapons.init.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MedievalMain.MOD_ID)
public class MedievalMain {

    public static final String MOD_ID = "medievalweapons";
    private static final Logger LOGGER = LogUtils.getLogger();

    // All credits go to Plasma Studios: https://youtu.be/Uc7YMW3AKpg?t=1152
    // Thanks for the awesome series
    // Check it out here: https://youtu.be/yCNUP2NAt-A

    public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack( ItemInit.DIAMOND_FRANCISCA_ITEM.get());
        }

    };
    public MedievalMain()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ItemInit.register(modEventBus);
        EntityInit.register(modEventBus);
        EffectInit.register(modEventBus);
        ParticleInit.register(modEventBus);
        SoundInit.register(modEventBus);
        TagInit.register(modEventBus);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }

}

// You are LOVED!!!
// Jesus loves you unconditionally!