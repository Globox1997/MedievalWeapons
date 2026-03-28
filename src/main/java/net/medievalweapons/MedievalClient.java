package net.medievalweapons;

import net.fabricmc.api.ClientModInitializer;
import net.medievalweapons.init.ModelInit;
import net.medievalweapons.init.RenderInit;
import net.medievalweapons.network.MedievalClientPacket;

public class MedievalClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModelInit.init();
        RenderInit.init();
        MedievalClientPacket.init();
    }

}