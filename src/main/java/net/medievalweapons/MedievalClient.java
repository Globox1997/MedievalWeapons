package net.medievalweapons;

import net.fabricmc.api.ClientModInitializer;
import net.medievalweapons.init.ModelProviderInit;
import net.medievalweapons.init.RenderInit;

public class MedievalClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModelProviderInit.init();
        RenderInit.init();
    }

}