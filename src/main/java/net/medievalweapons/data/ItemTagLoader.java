package net.medievalweapons.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.init.ItemInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ItemTagLoader extends FabricTagProvider.ItemTagProvider {

    private final Collection<String> materials;

    public ItemTagLoader(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
        Set<String> compatMaterials = CompatItems.MATERIALS_BY_MOD.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
        this.materials = ItemInit.MATERIAL_STRINGS.stream().filter(m -> !compatMaterials.contains(m)).toList();
    }

    public ItemTagLoader(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, Collection<String> materials) {
        super(output, registriesFuture);
        this.materials = materials;
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        var vanillaSwords = tag(ItemTags.SWORDS);

        for (String material : materials) {
            for (String itemType : ItemInit.ITEM_STRINGS) {
                ResourceLocation id = MedievalMain.identifierOf(material + "_" + itemType);
                vanillaSwords.addOptional(id);
            }
        }
    }
}
