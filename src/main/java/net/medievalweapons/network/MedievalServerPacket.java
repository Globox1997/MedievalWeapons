package net.medievalweapons.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.medievalweapons.access.PlayerAccess;
import net.medievalweapons.item.NinjatoItem;
import net.medievalweapons.network.packet.AttackPacket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public class MedievalServerPacket {

    private static final int MIN_OFFHAND_ATTACK_TICKS = 4;

    public static void init() {
        PayloadTypeRegistry.playC2S().register(AttackPacket.PACKET_ID, AttackPacket.PACKET_CODEC);
        ServerPlayNetworking.registerGlobalReceiver(AttackPacket.PACKET_ID, (payload, context) -> {
            int entityId = payload.entityId();
            ServerPlayerEntity player = context.player();
            player.server.execute(() -> {
                player.updateLastActionTime();
                Entity target = player.getServerWorld().getEntityById(entityId);
                if (canOffhandAttack(player, target)) {
                    ((PlayerAccess) player).doOffhandAttack(target);
                }
            });
        });
    }

    private static boolean canOffhandAttack(ServerPlayerEntity player, Entity target) {
        if (target == null || target == player || !player.isAlive() || player.isSpectator()) {
            return false;
        }
        if (target instanceof ItemEntity || target instanceof ExperienceOrbEntity || target instanceof PersistentProjectileEntity) {
            return false;
        }
        if (!(player.getMainHandStack().getItem() instanceof NinjatoItem) || !(player.getOffHandStack().getItem() instanceof NinjatoItem)) {
            return false;
        }
        if (((PlayerAccess) player).getLastAttackedOffhandTicks() < MIN_OFFHAND_ATTACK_TICKS) {
            return false;
        }
        return player.canInteractWithEntityIn(target.getBoundingBox(), 1.0);
    }

}
