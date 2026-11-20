package net.medievalweapons.fabric.platform;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.medievalweapons.platform.services.INetworkHelper;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public class FabricNetworkHelper implements INetworkHelper {

    @Override
    public boolean canSendToServer(CustomPacketPayload.Type<?> type) {
        return ClientPlayNetworking.canSend(type);
    }

    @Override
    public void sendToServer(CustomPacketPayload payload) {
        ClientPlayNetworking.send(payload);
    }

}
