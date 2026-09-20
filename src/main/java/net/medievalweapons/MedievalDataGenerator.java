package net.medievalweapons;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.data.*;
import net.minecraft.util.Identifier;

public class MedievalDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider((FabricDataOutput output) -> new ModelLoader(output));
        pack.addProvider(RecipeLoader::new);
        pack.addProvider(LangLoader::new);

        for (String modId : CompatItems.MATERIALS_BY_MOD.keySet()) {
            Identifier packId = MedievalMain.identifierOf(modId + "_medievalweapons_compat");
            FabricDataGenerator.Pack compatPack = fabricDataGenerator.createBuiltinResourcePack(packId);
            compatPack.addProvider((FabricDataOutput output) -> new ModelLoader(output, CompatItems.MATERIALS_BY_MOD.get(modId)));
            compatPack.addProvider((output, lookup) -> new LangLoader(output, lookup, CompatItems.MATERIALS_BY_MOD.get(modId)));
            compatPack.addProvider((FabricDataOutput output) -> new CompatRecipeLoader(output, CompatItems.MATERIALS_BY_MOD.get(modId)));
            compatPack.addProvider((FabricDataOutput output) -> new PackMcmetaLoader(output, modId + " medievalweapons compat"));
        }
    }

}
