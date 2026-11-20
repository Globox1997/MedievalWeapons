package net.medievalweapons.data;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.init.ItemInit;
import net.minecraft.core.HolderLookup;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class LangLoader extends FabricLanguageProvider {

    private final FabricPackOutput packOutput;
    private final Collection<String> materials;
    private final boolean loadExisting;

    private static final Map<String, String> MATERIAL_NAMES = Map.ofEntries(
            Map.entry("terminite", "Terminite"),
            Map.entry("aeternium", "Aeternium"),
            Map.entry("thallasium", "Thallasium"),
            Map.entry("nether_ruby", "Nether Ruby"),
            Map.entry("cincinnasite", "Cincinnasite"),
            Map.entry("cincinnasite_diamond", "Diamond Cincinnasite"),
            Map.entry("dragon", "Dragon"),
            Map.entry("adamantite", "Adamantite"),
            Map.entry("olvite", "Olvite"),
            Map.entry("pendorite", "Pendorite"),
            Map.entry("gilded_netherite", "Gilded Netherite"),
            Map.entry("rose_gold", "Rose Gold"),
            Map.entry("ruby_netherite", "Ruby Netherite"),
            Map.entry("sapphire_netherite", "Sapphire Netherite"),
            Map.entry("warden", "Warden"),
            Map.entry("steel", "Steel"),
            Map.entry("damascus_steel", "Damascus Steel"),
            Map.entry("scarlet", "Scarlet"),
            Map.entry("fiery_netherite", "Fiery Netherite"),
            Map.entry("solarite", "Solarite")
    );

    private static final Map<String, String> ITEM_NAMES = Map.ofEntries(
            Map.entry("small_axe", "Battle Axe"),
            Map.entry("long_sword", "Longsword"),
            Map.entry("dagger", "Dagger"),
            Map.entry("big_axe", "War Axe"),
            Map.entry("lance", "Lance"),
            Map.entry("healing_staff", "Staff of Healing"),
            Map.entry("mace", "Mace"),
            Map.entry("francisca", "Francisca"),
            Map.entry("javelin", "Javelin"),
            Map.entry("ninjato", "Ninjato"),
            Map.entry("sickle", "Sickle"),
            Map.entry("rapier", "Rapier")
    );

    public LangLoader(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
        this.packOutput = dataOutput;
        Set<String> compatMaterials = CompatItems.MATERIALS_BY_MOD.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
        this.materials = ItemInit.MATERIAL_STRINGS.stream().filter(m -> !compatMaterials.contains(m)).toList();
        this.loadExisting = true;
    }

    public LangLoader(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup, Collection<String> materials) {
        super(dataOutput, registryLookup);
        this.packOutput = dataOutput;
        this.materials = materials;
        this.loadExisting = false;
    }

    @Override
    public void generateTranslations(HolderLookup.Provider wrapperLookup, TranslationBuilder translationBuilder) {
        for (String material : materials) {
            for (String item : ItemInit.ITEM_STRINGS) {
                String materialName = MATERIAL_NAMES.getOrDefault(material, prettifyMaterial(material));
                String itemName = ITEM_NAMES.getOrDefault(item, item);
                String translationKey = "item.medievalweapons." + material + "_" + item;
                translationBuilder.add(translationKey, materialName + " " + itemName);
                if (item.equals("javelin") || item.equals("francisca")) {
                    String entityTranslationKey = "entity.medievalweapons." + material + "_" + item;
                    translationBuilder.add(entityTranslationKey, materialName + " " + itemName);
                }
            }
        }
        if (loadExisting) {
            try {
                Optional<Path> existing = this.packOutput.getModContainer().findPath("assets/medievalweapons/lang/en_us.existing.json");
                if (existing.isEmpty()) {
                    throw new IllegalStateException("Missing existing lang file");
                }
                translationBuilder.add(existing.get());
            } catch (Exception e) {
                throw new RuntimeException("Failed to add existing language file!", e);
            }
        }
    }

    private static String prettifyMaterial(String raw) {
        String[] parts = raw.split("_");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            if (!sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }
        return sb.toString();
    }
}
