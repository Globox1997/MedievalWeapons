package net.medievalweapons.platform.services;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public interface INetworkHelper {

    boolean canSendToServer(CustomPacketPayload.Type<?> type);

    void sendToServer(CustomPacketPayload payload);

}
