package net.medievalweapons.network.packet;

import net.medievalweapons.MedievalMain;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record AttackPacket(int entityId) implements CustomPayload {

    public static final CustomPayload.Id<AttackPacket> PACKET_ID = new CustomPayload.Id<>(MedievalMain.identifierOf("attack_packet"));

    public static final PacketCodec<RegistryByteBuf, AttackPacket> PACKET_CODEC = PacketCodec.of((value, buf) -> {
        buf.writeInt(value.entityId);
    }, buf -> new AttackPacket(buf.readInt()));

    @Override
    public Id<? extends CustomPayload> getId() {
        return PACKET_ID;
    }

}
