package net.medievalweapons.data;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.init.ItemInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ItemTagLoader extends FabricTagsProvider.ItemTagsProvider {

    private final Collection<String> materials;

    public ItemTagLoader(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
        Set<String> compatMaterials = CompatItems.MATERIALS_BY_MOD.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
        this.materials = ItemInit.MATERIAL_STRINGS.stream().filter(m -> !compatMaterials.contains(m)).toList();
    }

    public ItemTagLoader(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, Collection<String> materials) {
        super(output, registriesFuture);
        this.materials = materials;
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        TagAppender<Item> vanillaSwords = builder(ItemTags.SWORDS);

        for (String material : materials) {
            for (String itemType : ItemInit.ITEM_STRINGS) {
                Identifier id = MedievalMain.identifierOf(material + "_" + itemType);
                vanillaSwords.addOptional(ResourceKey.create(Registries.ITEM, id));
            }
        }

        for (CompatItems.CompatMaterial compatMaterial : CompatItems.MATERIALS) {
            if (materials.contains(compatMaterial.name())) {
                builder(CompatItems.repairTag(compatMaterial.name())).addOptional(ResourceKey.create(Registries.ITEM, compatMaterial.repairItem()));
            }
        }
    }
}
