package net.medievalweapons;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.data.*;
import net.medievalweapons.init.ItemInit;
import net.minecraft.resources.ResourceLocation;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class MedievalDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider((FabricDataOutput output) -> new ModelLoader(output));
        pack.addProvider(RecipeLoader::new);
        pack.addProvider(LangLoader::new);
        pack.addProvider(ItemTagLoader::new);
        pack.addProvider((FabricDataOutput output) -> new WeaponAttributesLoader(output, coreMaterials()));

        for (String modId : CompatItems.MATERIALS_BY_MOD.keySet()) {
            ResourceLocation packId = MedievalMain.identifierOf(modId + "_medievalweapons_compat");
            FabricDataGenerator.Pack compatPack = fabricDataGenerator.createBuiltinResourcePack(packId);
            compatPack.addProvider((FabricDataOutput output) -> new ModelLoader(output, CompatItems.MATERIALS_BY_MOD.get(modId)));
            compatPack.addProvider((output, lookup) -> new LangLoader(output, lookup, CompatItems.MATERIALS_BY_MOD.get(modId)));
            compatPack.addProvider((FabricDataOutput output) -> new CompatRecipeLoader(output, CompatItems.MATERIALS_BY_MOD.get(modId)));
            compatPack.addProvider((FabricDataOutput output) -> new PackMcmetaLoader(output, modId + " medievalweapons compat"));
            compatPack.addProvider((output, lookup) -> new ItemTagLoader(output, lookup, CompatItems.MATERIALS_BY_MOD.get(modId)));
            compatPack.addProvider((FabricDataOutput output) -> new WeaponAttributesLoader(output, CompatItems.MATERIALS_BY_MOD.get(modId)));
        }
    }

    private static Collection<String> coreMaterials() {
        Set<String> compatMaterials = CompatItems.MATERIALS_BY_MOD.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
        return ItemInit.MATERIAL_STRINGS.stream().filter(m -> !compatMaterials.contains(m)).toList();
    }

}
