package net.medievalweapons.init;

import com.mojang.serialization.MapCodec;
import net.medievalweapons.MedievalMain;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

public class ModelInit {

    public static void register(BiConsumer<Identifier, MapCodec<? extends ConditionalItemModelProperty>> registrar) {
        registrar.accept(MedievalMain.identifierOf("offhand"), OffhandProperty.MAP_CODEC);
        registrar.accept(MedievalMain.identifierOf("bettercombat_loaded"), BetterCombatLoadedProperty.MAP_CODEC);
    }

    public record OffhandProperty() implements ConditionalItemModelProperty {
        public static final MapCodec<OffhandProperty> MAP_CODEC = MapCodec.unit(new OffhandProperty());

        @Override
        public boolean get(ItemStack itemStack, @Nullable ClientLevel level, @Nullable LivingEntity owner, int seed, ItemDisplayContext displayContext) {
            return owner != null && !owner.getOffhandItem().isEmpty();
        }

        @Override
        public MapCodec<OffhandProperty> type() {
            return MAP_CODEC;
        }
    }

    public record BetterCombatLoadedProperty() implements ConditionalItemModelProperty {
        public static final MapCodec<BetterCombatLoadedProperty> MAP_CODEC = MapCodec.unit(new BetterCombatLoadedProperty());

        @Override
        public boolean get(ItemStack itemStack, @Nullable ClientLevel level, @Nullable LivingEntity owner, int seed, ItemDisplayContext displayContext) {
            return CompatInit.isBetterCombatLoaded;
        }

        @Override
        public MapCodec<BetterCombatLoadedProperty> type() {
            return MAP_CODEC;
        }
    }

}
