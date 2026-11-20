package net.medievalweapons.network.packet;

import net.medievalweapons.MedievalMain;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record AttackPacket(int entityId) implements CustomPacketPayload {

    public static final int SWING_ONLY = -1;

    public static final CustomPacketPayload.Type<AttackPacket> PACKET_ID = new CustomPacketPayload.Type<>(MedievalMain.identifierOf("attack_packet"));

    public static final StreamCodec<RegistryFriendlyByteBuf, AttackPacket> PACKET_CODEC = StreamCodec.ofMember((value, buf) -> {
        buf.writeInt(value.entityId);
    }, buf -> new AttackPacket(buf.readInt()));

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return PACKET_ID;
    }

}
