package net.medievalweapons.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.medievalweapons.access.PlayerAccess;
import net.medievalweapons.network.packet.AttackPacket;

public class MedievalServerPacket {

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(AttackPacket.PACKET_ID, (payload, context) -> {
            int entityId = payload.entityId();
            context.player().server.execute(() -> {
                context.player().updateLastActionTime();
                if (context.player().getWorld().getEntityById(entityId) != null) {
                    ((PlayerAccess) context.player()).doOffhandAttack(context.player().getWorld().getEntityById(entityId));
                }
            });
        });
    }

}
