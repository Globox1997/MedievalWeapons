package net.medievalweapons.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.medievalweapons.access.PlayerAccess;
import net.medievalweapons.item.NinjatoItem;
import net.medievalweapons.network.packet.AttackPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;

public class MedievalServerPacket {

    private static final int MIN_OFFHAND_ATTACK_TICKS = 4;

    public static void init() {
        PayloadTypeRegistry.serverboundPlay().register(AttackPacket.PACKET_ID, AttackPacket.PACKET_CODEC);
        ServerPlayNetworking.registerGlobalReceiver(AttackPacket.PACKET_ID, (payload, context) -> {
            int entityId = payload.entityId();
            ServerPlayer player = context.player();
            context.server().execute(() -> {
                player.resetLastActionTime();
                if (entityId == AttackPacket.SWING_ONLY) {
                    if (player.isAlive() && !player.isSpectator() && holdsNinjatos(player)) {
                        player.swing(InteractionHand.OFF_HAND, player.getOffhandItem().getAttackAnimation(), false);
                    }
                    return;
                }
                Entity target = player.level().getEntity(entityId);
                if (canOffhandAttack(player, target)) {
                    player.swing(InteractionHand.OFF_HAND, player.getOffhandItem().getAttackAnimation(), false);
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
        if (!holdsNinjatos(player)) {
            return false;
        }
        if (((PlayerAccess) player).getLastAttackedOffhandTicks() < MIN_OFFHAND_ATTACK_TICKS) {
            return false;
        }
        return player.level().getWorldBorder().isWithinBounds(target.blockPosition()) && player.isWithinAttackRange(player.getOffhandItem(), target.getBoundingBox(), 3.0);
    }

    private static boolean holdsNinjatos(ServerPlayer player) {
        return player.getMainHandItem().getItem() instanceof NinjatoItem && player.getOffhandItem().getItem() instanceof NinjatoItem;
    }

}
