package net.medievalweapons.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.medievalweapons.access.PlayerAccess;
import net.medievalweapons.item.NinjatoItem;
import net.medievalweapons.network.packet.AttackPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;

public class MedievalServerPacket {

    private static final int MIN_OFFHAND_ATTACK_TICKS = 4;

    public static void init() {
        PayloadTypeRegistry.playC2S().register(AttackPacket.PACKET_ID, AttackPacket.PACKET_CODEC);
        ServerPlayNetworking.registerGlobalReceiver(AttackPacket.PACKET_ID, (payload, context) -> {
            int entityId = payload.entityId();
            ServerPlayer player = context.player();
            player.server.execute(() -> {
                player.resetLastActionTime();
                Entity target = player.serverLevel().getEntity(entityId);
                if (canOffhandAttack(player, target)) {
                    ((PlayerAccess) player).doOffhandAttack(target);
                }
            });
        });
    }

    private static boolean canOffhandAttack(ServerPlayer player, Entity target) {
        if (target == null || target == player || !player.isAlive() || player.isSpectator()) {
            return false;
        }
        if (target instanceof ItemEntity || target instanceof ExperienceOrb || target instanceof AbstractArrow) {
            return false;
        }
        if (!(player.getMainHandItem().getItem() instanceof NinjatoItem) || !(player.getOffhandItem().getItem() instanceof NinjatoItem)) {
            return false;
        }
        if (((PlayerAccess) player).getLastAttackedOffhandTicks() < MIN_OFFHAND_ATTACK_TICKS) {
            return false;
        }
        return player.canInteractWithEntity(target.getBoundingBox(), 1.0);
    }

}
