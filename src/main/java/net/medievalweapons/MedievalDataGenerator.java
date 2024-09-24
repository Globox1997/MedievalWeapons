package net.medievalweapons;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.medievalweapons.data.ModelLoader;
import net.medievalweapons.data.RecipeLoader;

public class MedievalDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModelLoader::new);
        pack.addProvider(RecipeLoader::new);
    }

}
