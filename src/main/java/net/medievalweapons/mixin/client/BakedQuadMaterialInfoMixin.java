package net.medievalweapons.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.medievalweapons.init.RenderInit;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(BakedQuad.MaterialInfo.class)
public class BakedQuadMaterialInfoMixin {

    @Inject(method = "of", at = @At("RETURN"), cancellable = true)
    private static void ofMixin(CallbackInfoReturnable<BakedQuad.MaterialInfo> info) {
        BakedQuad.MaterialInfo materialInfo = info.getReturnValue();
        if (!materialInfo.sprite().atlasLocation().equals(TextureAtlas.LOCATION_ITEMS)) {
            return;
        }
        RenderType glint = RenderInit.getCustomGlint(materialInfo.sprite().contents().name(), materialInfo.layer().translucent());
        if (glint != null) {
            info.setReturnValue(new BakedQuad.MaterialInfo(materialInfo.sprite(), materialInfo.layer(), materialInfo.itemRenderType(), glint, materialInfo.itemGlintSpecialRenderType(),
                    materialInfo.tintIndex(), materialInfo.shadeDirectionOverride(), materialInfo.lightEmission()));
        }
    }

}
