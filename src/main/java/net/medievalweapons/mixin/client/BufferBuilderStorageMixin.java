package net.medievalweapons.mixin.client;

import com.mojang.blaze3d.vertex.ByteBufferBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.RenderInit;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(RenderBuffers.class)
public class BufferBuilderStorageMixin {

    @Inject(method = "put", at = @At("HEAD"))
    private static void assignBufferBuilder(Object2ObjectLinkedOpenHashMap<RenderType, ByteBufferBuilder> builderStorage, RenderType layer, CallbackInfo info) {
        for (RenderType customLayer : RenderInit.CUSTOM_GLINT.values()) {
            if (!builderStorage.containsKey(customLayer)) {
                builderStorage.put(customLayer, new ByteBufferBuilder(256));
            }
        }
    }
}
