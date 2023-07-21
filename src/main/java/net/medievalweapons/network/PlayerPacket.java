package net.medievalweapons.network;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.medievalweapons.access.PlayerAccess;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Identifier;

public class PlayerPacket {

    public static final Identifier DUAL_PACKET = new Identifier("medievalweapons", "dual_weapon");

    public static Packet<?> attackPacket(Entity entity) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(entity.getId());
        return ClientPlayNetworking.createC2SPacket(DUAL_PACKET, buf);
    }

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(DUAL_PACKET, (server, player, handler, buffer, sender) -> {
            int entityId = buffer.readInt();
            server.execute(() -> {
                player.updateLastActionTime();
                if (player.getWorld().getEntityById(entityId) != null)
                    ((PlayerAccess) player).doOffhandAttack(player.getWorld().getEntityById(entityId));
            });

        });

    }
}
