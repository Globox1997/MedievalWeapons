package net.medievalweapons.network;

import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.Registry;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import java.util.UUID;

import static net.medievalweapons.MedievalMain.MOD_ID;

@SuppressWarnings("resource")
public class EntitySpawnPacket {

    public static Packet<?> createPacket(Entity entity) {
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        buf.writeVarInt(Registry.ENTITY_TYPE.getId(entity.getType()));
        buf.writeUUID(entity.getUUID());
        buf.writeVarInt(entity.getId());
        buf.writeDouble(entity.getX());
        buf.writeDouble(entity.getY());
        buf.writeDouble(entity.getZ());
        buf.writeByte(Mth.floor(entity.getXRot() * 256.0F / 360.0F));
        buf.writeByte(Mth.floor(entity.getYRot() * 256.0F / 360.0F));

        return ConnectionProtocol.PLAY.createPacket(PacketFlow.SERVERBOUND, (int) 1.0,buf);
    }

    public static void onPacket(Minecraft client, ClientPacketListener networkHandler, FriendlyByteBuf buffer, PacketFlow sender) {
        EntityType<?> type = Registry.ENTITY_TYPE.get(buffer.readResourceLocation());
        UUID entityUUID = buffer.readUUID();
        int entityID = buffer.readVarInt();
        double x = buffer.readDouble();
        double y = buffer.readDouble();
        double z = buffer.readDouble();
        float pitch = (buffer.readByte() * 360) / 256.0F;
        float yaw = (buffer.readByte() * 360) / 256.0F;
        client.execute(() -> {
            Level world = client.player.getCommandSenderWorld();
            Entity entity = type.create(world);
            if (entity != null && world.isClientSide) {
                entity.absMoveTo(x, y, z);
                entity.syncPacketPositionCodec(x, y, z);
                entity.setXRot(pitch);
                entity.setYRot(yaw);
                entity.setId(entityID);
                entity.setUUID(entityUUID);
                ClientLevel clientWorld = Minecraft.getInstance().level;
                clientWorld.putNonPlayerEntity(entityID, entity);
            }
        });
    }

}