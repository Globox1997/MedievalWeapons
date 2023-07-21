package net.medievalweapons.mixin;

import java.util.List;
import java.util.Set;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import net.fabricmc.loader.api.FabricLoader;

public class MedievalWeaponsMixinPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if ((mixinClassName.contains("Big_Axe_ItemMixin") || mixinClassName.contains("Dagger_ItemMixin") || mixinClassName.contains("Francisca_ItemMixin")
                || mixinClassName.contains("Healing_Staff_ItemMixin") || mixinClassName.contains("Javelin_ItemMixin") || mixinClassName.contains("Lance_ItemMixin")
                || mixinClassName.contains("Long_Sword_ItemMixin") || mixinClassName.contains("Mace_ItemMixin") || mixinClassName.contains("Ninjato_ItemMixin")
                || mixinClassName.contains("Rapier_ItemMixin") || mixinClassName.contains("Sickle_ItemMixin") || mixinClassName.contains("Small_Axe_ItemMixin"))
                && !FabricLoader.getInstance().isModLoaded("betternether")) {
            return false;
        }

        if ((mixinClassName.contains("ServerPlayNetworkHandlerMixin") || mixinClassName.contains("GameRendererMixin")) && !FabricLoader.getInstance().isModLoaded("reach-entity-attributes")) {
            return false;
        }

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

}