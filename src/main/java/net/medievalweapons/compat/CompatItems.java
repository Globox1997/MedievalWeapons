package net.medievalweapons.compat;

import com.kyanite.deeperdarker.util.DDTiers;
import com.mythicmetals.item.tools.MythicToolMaterials;
import dqu.additionaladditions.material.GildedNetheriteToolMaterial;
import dqu.additionaladditions.material.RoseGoldToolMaterial;
import net.dragonloot.item.DragonToolMaterials;
import net.earlystage.item.material.EarlyStageToolMaterials;
import net.fabricmc.loader.api.FabricLoader;
import net.id.paradiselost.items.tools.ParadiseLostToolMaterials;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.ItemInit;
import net.medievalweapons.item.*;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.oblivion.item.OblivionToolMaterials;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import org.betterx.betterend.item.material.EndToolMaterial;
import org.betterx.betternether.items.materials.BNToolMaterial;
import potionstudios.byg.common.item.BYGTier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CompatItems {

    private static final FabricLoader fabricLoader = FabricLoader.getInstance();

    public static Boolean isDragonLootLoaded = fabricLoader.isModLoaded("dragonloot");
    public static Boolean isBetterEndLoaded = fabricLoader.isModLoaded("betterend");
    public static Boolean isBetterNetherLoaded = fabricLoader.isModLoaded("betternether");
    public static Boolean isMythicMetalsLoaded = fabricLoader.isModLoaded("mythicmetals");
    public static Boolean isParadiseLostLoaded = fabricLoader.isModLoaded("paradise_lost");
    public static Boolean isBYGLoaded = fabricLoader.isModLoaded("byg");
    public static Boolean isAdditionalAdditionsLoaded = fabricLoader.isModLoaded("additionaladditions");
    public static Boolean isMythicUpgradesLoaded = fabricLoader.isModLoaded("mythicupgrades");
    public static Boolean isDeeperDarkerLoaded = fabricLoader.isModLoaded("deeperdarker");
    public static Boolean isEarlyStageLoaded = fabricLoader.isModLoaded("earlystage");
    public static Boolean isOblivionLoaded = fabricLoader.isModLoaded("oblivion");

    public static final Map<String, Set<String>> MATERIALS_BY_MOD = new LinkedHashMap<>();

    static {
        MATERIALS_BY_MOD.put("betterend", Set.of("terminite", "aeternium", "thallasium"));
        MATERIALS_BY_MOD.put("betternether", Set.of("nether_ruby", "cincinnasite", "cincinnasite_diamond"));
        MATERIALS_BY_MOD.put("dragonloot", Set.of("dragon"));
        MATERIALS_BY_MOD.put("mythicmetals", Set.of("adamantite"));
        MATERIALS_BY_MOD.put("paradise_lost", Set.of("olvite"));
        MATERIALS_BY_MOD.put("byg", Set.of("pendorite"));
        MATERIALS_BY_MOD.put("additionaladditions", Set.of("gilded_netherite", "rose_gold"));
        MATERIALS_BY_MOD.put("mythicupgrades", Set.of("ruby_netherite", "sapphire_netherite"));
        MATERIALS_BY_MOD.put("deeperdarker", Set.of("warden"));
        MATERIALS_BY_MOD.put("earlystage", Set.of("steel", "damascus_steel"));
        MATERIALS_BY_MOD.put("oblivion", Set.of("solarite", "fiery_netherite", "scarlet"));
    }

    // DragonLoot
    public static Item DRAGON_FRANCISCA_ITEM;
    public static Item DRAGON_JAVELIN_ITEM;

    // Better Nether
    public static Item NETHER_RUBY_FRANCISCA_ITEM;
    public static Item NETHER_RUBY_JAVELIN_ITEM;
    public static Item CINCINNASITE_FRANCISCA_ITEM;
    public static Item CINCINNASITE_JAVELIN_ITEM;
    public static Item CINCINNASITE_DIAMOND_FRANCISCA_ITEM;
    public static Item CINCINNASITE_DIAMOND_JAVELIN_ITEM;

    // Better End
    public static Item TERMINITE_FRANCISCA_ITEM;
    public static Item TERMINITE_JAVELIN_ITEM;
    public static Item AETERNIUM_FRANCISCA_ITEM;
    public static Item AETERNIUM_JAVELIN_ITEM;
    public static Item THALLASIUM_FRANCISCA_ITEM;
    public static Item THALLASIUM_JAVELIN_ITEM;

    // Mythic Metals
    public static Item ADAMANTITE_FRANCISCA_ITEM;
    public static Item ADAMANTITE_JAVELIN_ITEM;

    // BYG
    public static Item PENDORITE_FRANCISCA_ITEM;
    public static Item PENDORITE_JAVELIN_ITEM;

    // Additional Additions
    public static Item ROSE_GOLD_FRANCISCA_ITEM;
    public static Item ROSE_GOLD_JAVELIN_ITEM;
    public static Item GILDED_NETHERITE_FRANCISCA_ITEM;
    public static Item GILDED_NETHERITE_JAVELIN_ITEM;

    // Paradise Lost
    public static Item OLVITE_FRANCISCA_ITEM;
    public static Item OLVITE_JAVELIN_ITEM;

    // Mythic Upgrades
    public static Item RUBY_NETHERITE_FRANCISCA_ITEM;
    public static Item RUBY_NETHERITE_JAVELIN_ITEM;
    public static Item SAPPHIRE_NETHERITE_FRANCISCA_ITEM;
    public static Item SAPPHIRE_NETHERITE_JAVELIN_ITEM;

    // Deeper and Darker
    public static Item WARDEN_FRANCISCA_ITEM;
    public static Item WARDEN_JAVELIN_ITEM;

    // EarlyStage
    public static Item STEEL_FRANCISCA_ITEM;
    public static Item STEEL_JAVELIN_ITEM;
    public static Item DAMASCUS_STEEL_FRANCISCA_ITEM;
    public static Item DAMASCUS_STEEL_JAVELIN_ITEM;

    // Oblivion
    public static Item FIERY_NETHERITE_FRANCISCA_ITEM;
    public static Item FIERY_NETHERITE_JAVELIN_ITEM;
    public static Item SCARLET_FRANCISCA_ITEM;
    public static Item SCARLET_JAVELIN_ITEM;
    public static Item SOLARITE_FRANCISCA_ITEM;
    public static Item SOLARITE_JAVELIN_ITEM;

    public static void loadItems() {
        if (isBetterEndLoaded) {
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_small_axe"),
                    new SmallAxeItem(EndToolMaterial.TERMINITE,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_long_sword"),
                    new LongSwordItem(EndToolMaterial.TERMINITE,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_dagger"),
                    new DaggerItem(EndToolMaterial.TERMINITE,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_big_axe"),
                    new BigAxeItem(EndToolMaterial.TERMINITE,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                    new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_lance"),
                    new LanceItem(EndToolMaterial.TERMINITE,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_healing_staff"),
                    new HealingStaffItem(EndToolMaterial.TERMINITE, 4, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 1, -3.3f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_mace"),
                    new MaceItem(EndToolMaterial.TERMINITE, 2,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            TERMINITE_FRANCISCA_ITEM = new FranciscaItem(EndToolMaterial.TERMINITE, () -> CompatEntities.TERMINITE_FRANCISCA, new Item.Properties());
            TERMINITE_JAVELIN_ITEM = new JavelinItem(EndToolMaterial.TERMINITE, () -> CompatEntities.TERMINITE_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 1, -2.6f)));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_francisca"), TERMINITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_javelin"), TERMINITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_ninjato"),
                    new NinjatoItem(EndToolMaterial.TERMINITE, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 2, -2.1f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_sickle"),
                    new SickleItem(EndToolMaterial.TERMINITE, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 2, -2.2f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("terminite_rapier"),
                    new RapierItem(EndToolMaterial.TERMINITE, 2, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.TERMINITE, 2, -2.0f))));

            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_small_axe"),
                    new SmallAxeItem(EndToolMaterial.AETERNIUM,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_long_sword"),
                    new LongSwordItem(EndToolMaterial.AETERNIUM,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_dagger"),
                    new DaggerItem(EndToolMaterial.AETERNIUM,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_big_axe"),
                    new BigAxeItem(EndToolMaterial.AETERNIUM,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                    new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_lance"),
                    new LanceItem(EndToolMaterial.AETERNIUM,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_healing_staff"),
                    new HealingStaffItem(EndToolMaterial.AETERNIUM, 4, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 1, -3.3f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_mace"),
                    new MaceItem(EndToolMaterial.AETERNIUM, 2,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            AETERNIUM_FRANCISCA_ITEM = new FranciscaItem(EndToolMaterial.AETERNIUM, () -> CompatEntities.AETERNIUM_FRANCISCA, new Item.Properties());
            AETERNIUM_JAVELIN_ITEM = new JavelinItem(EndToolMaterial.AETERNIUM, () -> CompatEntities.AETERNIUM_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 1, -2.6f)));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_francisca"), AETERNIUM_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_javelin"), AETERNIUM_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_ninjato"),
                    new NinjatoItem(EndToolMaterial.AETERNIUM, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 2, -2.1f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_sickle"),
                    new SickleItem(EndToolMaterial.AETERNIUM, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 2, -2.2f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("aeternium_rapier"),
                    new RapierItem(EndToolMaterial.AETERNIUM, 2, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.AETERNIUM, 2, -2.0f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_small_axe"),
                    new SmallAxeItem(EndToolMaterial.THALLASIUM,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_long_sword"),
                    new LongSwordItem(EndToolMaterial.THALLASIUM,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_dagger"),
                    new DaggerItem(EndToolMaterial.THALLASIUM,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_big_axe"),
                    new BigAxeItem(EndToolMaterial.THALLASIUM,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                    new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_lance"),
                    new LanceItem(EndToolMaterial.THALLASIUM,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_healing_staff"),
                    new HealingStaffItem(EndToolMaterial.THALLASIUM, 3, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 1, -3.3f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_mace"),
                    new MaceItem(EndToolMaterial.THALLASIUM, 1,
                            new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))));
            THALLASIUM_FRANCISCA_ITEM = new FranciscaItem(EndToolMaterial.THALLASIUM, () -> CompatEntities.THALLASIUM_FRANCISCA, new Item.Properties());
            THALLASIUM_JAVELIN_ITEM = new JavelinItem(EndToolMaterial.THALLASIUM, () -> CompatEntities.THALLASIUM_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 1, -2.6f)));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_francisca"), THALLASIUM_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_javelin"), THALLASIUM_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_ninjato"),
                    new NinjatoItem(EndToolMaterial.THALLASIUM, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 2, -2.1f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_sickle"),
                    new SickleItem(EndToolMaterial.THALLASIUM, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 2, -2.2f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("thallasium_rapier"),
                    new RapierItem(EndToolMaterial.THALLASIUM, 1, new Item.Properties().attributes(SwordItem.createAttributes(EndToolMaterial.THALLASIUM, 2, -2.0f))));

            ItemInit.MATERIAL_STRINGS.add("terminite");
            ItemInit.MATERIAL_STRINGS.add("aeternium");
            ItemInit.MATERIAL_STRINGS.add("thallasium");
        }
        if (isBetterNetherLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("nether_ruby_small_axe"),
                            new SmallAxeItem(BNToolMaterial.NETHER_RUBY,
                                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("nether_ruby_long_sword"),
                    new LongSwordItem(BNToolMaterial.NETHER_RUBY,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("nether_ruby_dagger"),
                    new DaggerItem(BNToolMaterial.NETHER_RUBY,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("nether_ruby_big_axe"),
                            new BigAxeItem(BNToolMaterial.NETHER_RUBY,
                                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                                    new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("nether_ruby_lance"),
                    new LanceItem(BNToolMaterial.NETHER_RUBY,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("nether_ruby_healing_staff"),
                    new HealingStaffItem(BNToolMaterial.NETHER_RUBY, 2, new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("nether_ruby_mace"),
                    new MaceItem(BNToolMaterial.NETHER_RUBY, 1,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            NETHER_RUBY_FRANCISCA_ITEM = new FranciscaItem(BNToolMaterial.NETHER_RUBY, () -> CompatEntities.NETHER_RUBY_FRANCISCA,
                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 1, -2.6f)));
            NETHER_RUBY_JAVELIN_ITEM = new JavelinItem(BNToolMaterial.NETHER_RUBY, () -> CompatEntities.NETHER_RUBY_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("nether_ruby_francisca"), NETHER_RUBY_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("nether_ruby_javelin"), NETHER_RUBY_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("nether_ruby_ninjato"),
                    new NinjatoItem(BNToolMaterial.NETHER_RUBY, new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("nether_ruby_sickle"),
                    new SickleItem(BNToolMaterial.NETHER_RUBY, new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("nether_ruby_rapier"),
                    new RapierItem(BNToolMaterial.NETHER_RUBY, 1, new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.NETHER_RUBY, 2, -2.0f)).fireResistant()));

            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("cincinnasite_small_axe"),
                            new SmallAxeItem(BNToolMaterial.CINCINNASITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_long_sword"),
                    new LongSwordItem(BNToolMaterial.CINCINNASITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_dagger"),
                    new DaggerItem(BNToolMaterial.CINCINNASITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_big_axe"),
                    new BigAxeItem(BNToolMaterial.CINCINNASITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_lance"),
                    new LanceItem(BNToolMaterial.CINCINNASITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_healing_staff"), new HealingStaffItem(BNToolMaterial.CINCINNASITE, 3,
                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_mace"),
                    new MaceItem(BNToolMaterial.CINCINNASITE, 1,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            CINCINNASITE_FRANCISCA_ITEM = new FranciscaItem(BNToolMaterial.CINCINNASITE, () -> CompatEntities.CINCINNASITE_FRANCISCA,
                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 1, -2.6f)));
            CINCINNASITE_JAVELIN_ITEM = new JavelinItem(BNToolMaterial.CINCINNASITE, () -> CompatEntities.CINCINNASITE_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_francisca"), CINCINNASITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_javelin"), CINCINNASITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_ninjato"),
                    new NinjatoItem(BNToolMaterial.CINCINNASITE, new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_sickle"),
                    new SickleItem(BNToolMaterial.CINCINNASITE, new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_rapier"),
                    new RapierItem(BNToolMaterial.CINCINNASITE, 1, new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE, 2, -2.0f)).fireResistant()));

            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_small_axe"),
                    new SmallAxeItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                            new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_long_sword"),
                    new LongSwordItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_dagger"),
                    new DaggerItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_big_axe"),
                    new BigAxeItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_lance"),
                    new LanceItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_healing_staff"), new HealingStaffItem(BNToolMaterial.CINCINNASITE_DIAMOND, 5,
                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_mace"),
                    new MaceItem(BNToolMaterial.CINCINNASITE_DIAMOND, 3,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            CINCINNASITE_DIAMOND_FRANCISCA_ITEM = new FranciscaItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                    () -> CompatEntities.CINCINNASITE_DIAMOND_FRANCISCA, new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 1, -2.6f)));
            CINCINNASITE_DIAMOND_JAVELIN_ITEM =
                    new JavelinItem(BNToolMaterial.CINCINNASITE_DIAMOND, () -> CompatEntities.CINCINNASITE_DIAMOND_JAVELIN,
                            new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_francisca"), CINCINNASITE_DIAMOND_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_javelin"), CINCINNASITE_DIAMOND_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_ninjato"), new NinjatoItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_sickle"), new SickleItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("cincinnasite_diamond_rapier"), new RapierItem(BNToolMaterial.CINCINNASITE_DIAMOND, 3,
                    new Item.Properties().attributes(SwordItem.createAttributes(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("nether_ruby");
            ItemInit.MATERIAL_STRINGS.add("cincinnasite");
            ItemInit.MATERIAL_STRINGS.add("cincinnasite_diamond");
        }
        if (isDragonLootLoaded) {
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_small_axe"),
                    new SmallAxeItem(DragonToolMaterials.DRAGON,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                            new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_long_sword"),
                    new LongSwordItem(DragonToolMaterials.DRAGON,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_dagger"),
                    new DaggerItem(DragonToolMaterials.DRAGON,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_big_axe"),
                    new BigAxeItem(DragonToolMaterials.DRAGON,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_lance"),
                    new LanceItem(DragonToolMaterials.DRAGON,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_healing_staff"), new HealingStaffItem(DragonToolMaterials.DRAGON, 5,
                    new Item.Properties().attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_mace"),
                    new MaceItem(DragonToolMaterials.DRAGON, 3,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            DRAGON_FRANCISCA_ITEM = new FranciscaItem(DragonToolMaterials.DRAGON, () -> CompatEntities.DRAGON_FRANCISCA,
                    new Item.Properties().attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 1, -2.6f)));
            DRAGON_JAVELIN_ITEM = new JavelinItem(DragonToolMaterials.DRAGON, () -> CompatEntities.DRAGON_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_francisca"), DRAGON_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_javelin"), DRAGON_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_ninjato"), new NinjatoItem(DragonToolMaterials.DRAGON,
                    new Item.Properties().attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_sickle"), new SickleItem(DragonToolMaterials.DRAGON,
                    new Item.Properties().attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("dragon_rapier"), new RapierItem(DragonToolMaterials.DRAGON, 3,
                    new Item.Properties().attributes(SwordItem.createAttributes(DragonToolMaterials.DRAGON, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("dragon");
        }
        if (isMythicMetalsLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("adamantite_small_axe"),
                            new SmallAxeItem(MythicToolMaterials.ADAMANTITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_long_sword"),
                    new LongSwordItem(MythicToolMaterials.ADAMANTITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_dagger"),
                    new DaggerItem(MythicToolMaterials.ADAMANTITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_big_axe"),
                    new BigAxeItem(MythicToolMaterials.ADAMANTITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_lance"),
                    new LanceItem(MythicToolMaterials.ADAMANTITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_healing_staff"), new HealingStaffItem(MythicToolMaterials.ADAMANTITE, 4,
                    new Item.Properties().attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_mace"),
                    new MaceItem(MythicToolMaterials.ADAMANTITE, 2,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ADAMANTITE_FRANCISCA_ITEM = new FranciscaItem(MythicToolMaterials.ADAMANTITE, () -> CompatEntities.ADAMANTITE_FRANCISCA,
                    new Item.Properties().attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 1, -2.6f)));
            ADAMANTITE_JAVELIN_ITEM = new JavelinItem(MythicToolMaterials.ADAMANTITE, () -> CompatEntities.ADAMANTITE_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_francisca"), ADAMANTITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_javelin"), ADAMANTITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_ninjato"),
                    new NinjatoItem(MythicToolMaterials.ADAMANTITE, new Item.Properties().attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_sickle"),
                    new SickleItem(MythicToolMaterials.ADAMANTITE, new Item.Properties().attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("adamantite_rapier"), new RapierItem(MythicToolMaterials.ADAMANTITE, 3,
                    new Item.Properties().attributes(SwordItem.createAttributes(MythicToolMaterials.ADAMANTITE, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("adamantite");
        }
        if (isParadiseLostLoaded) {
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_small_axe"),
                    new SmallAxeItem(ParadiseLostToolMaterials.OLVITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                            new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_long_sword"),
                    new LongSwordItem(ParadiseLostToolMaterials.OLVITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_dagger"),
                    new DaggerItem(ParadiseLostToolMaterials.OLVITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_big_axe"),
                    new BigAxeItem(ParadiseLostToolMaterials.OLVITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_lance"),
                    new LanceItem(ParadiseLostToolMaterials.OLVITE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_healing_staff"), new HealingStaffItem(ParadiseLostToolMaterials.OLVITE, 4,
                    new Item.Properties().attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_mace"),
                    new MaceItem(ParadiseLostToolMaterials.OLVITE, 1,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            OLVITE_FRANCISCA_ITEM = new FranciscaItem(ParadiseLostToolMaterials.OLVITE, () -> CompatEntities.OLVITE_FRANCISCA,
                    new Item.Properties().attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 1, -2.6f)));
            OLVITE_JAVELIN_ITEM = new JavelinItem(ParadiseLostToolMaterials.OLVITE, () -> CompatEntities.OLVITE_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_francisca"), OLVITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_javelin"), OLVITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_ninjato"), new NinjatoItem(ParadiseLostToolMaterials.OLVITE,
                    new Item.Properties().attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_sickle"), new SickleItem(ParadiseLostToolMaterials.OLVITE,
                    new Item.Properties().attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("olvite_rapier"), new RapierItem(ParadiseLostToolMaterials.OLVITE, 2,
                    new Item.Properties().attributes(SwordItem.createAttributes(ParadiseLostToolMaterials.OLVITE, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("olvite");
        }
        if (isBYGLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("pendorite_small_axe"),
                            new SmallAxeItem(BYGTier.PENDORITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("pendorite_long_sword"),
                            new LongSwordItem(BYGTier.PENDORITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("pendorite_dagger"),
                            new DaggerItem(BYGTier.PENDORITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("pendorite_big_axe"),
                            new BigAxeItem(BYGTier.PENDORITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                                    new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("pendorite_lance"),
                            new LanceItem(BYGTier.PENDORITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("pendorite_healing_staff"),
                    new HealingStaffItem(BYGTier.PENDORITE, 4, new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("pendorite_mace"),
                            new MaceItem(BYGTier.PENDORITE, 2,
                                    new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            PENDORITE_FRANCISCA_ITEM = new FranciscaItem(BYGTier.PENDORITE, () -> CompatEntities.PENDORITE_FRANCISCA,
                    new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 1, -2.6f)));
            PENDORITE_JAVELIN_ITEM = new JavelinItem(BYGTier.PENDORITE, () -> CompatEntities.PENDORITE_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("pendorite_francisca"), PENDORITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("pendorite_javelin"), PENDORITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("pendorite_ninjato"),
                    new NinjatoItem(BYGTier.PENDORITE, new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("pendorite_sickle"),
                    new SickleItem(BYGTier.PENDORITE, new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("pendorite_rapier"),
                    new RapierItem(BYGTier.PENDORITE, 2, new Item.Properties().attributes(SwordItem.createAttributes(BYGTier.PENDORITE, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("pendorite");
        }
        if (isAdditionalAdditionsLoaded) {
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_small_axe"),
                    new SmallAxeItem(GildedNetheriteToolMaterial.MATERIAL,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                            new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_long_sword"),
                    new LongSwordItem(GildedNetheriteToolMaterial.MATERIAL,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_dagger"),
                    new DaggerItem(GildedNetheriteToolMaterial.MATERIAL,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_big_axe"),
                    new BigAxeItem(GildedNetheriteToolMaterial.MATERIAL,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_lance"),
                    new LanceItem(GildedNetheriteToolMaterial.MATERIAL,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_healing_staff"), new HealingStaffItem(GildedNetheriteToolMaterial.MATERIAL, 5,
                    new Item.Properties().attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_mace"),
                    new MaceItem(GildedNetheriteToolMaterial.MATERIAL, 3,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            GILDED_NETHERITE_FRANCISCA_ITEM = new FranciscaItem(GildedNetheriteToolMaterial.MATERIAL, () -> CompatEntities.GILDED_NETHERITE_FRANCISCA,
                    new Item.Properties().attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 1, -2.6f)));
            GILDED_NETHERITE_JAVELIN_ITEM = new JavelinItem(GildedNetheriteToolMaterial.MATERIAL, () -> CompatEntities.GILDED_NETHERITE_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_francisca"), GILDED_NETHERITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_javelin"), GILDED_NETHERITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_ninjato"), new NinjatoItem(GildedNetheriteToolMaterial.MATERIAL,
                    new Item.Properties().attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_sickle"), new SickleItem(GildedNetheriteToolMaterial.MATERIAL,
                    new Item.Properties().attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("gilded_netherite_rapier"), new RapierItem(GildedNetheriteToolMaterial.MATERIAL, 3,
                    new Item.Properties().attributes(SwordItem.createAttributes(GildedNetheriteToolMaterial.MATERIAL, 2, -2.0f)).fireResistant()));

            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("rose_gold_small_axe"),
                            new SmallAxeItem(RoseGoldToolMaterial.MATERIAL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_long_sword"),
                    new LongSwordItem(RoseGoldToolMaterial.MATERIAL,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_dagger"),
                    new DaggerItem(RoseGoldToolMaterial.MATERIAL,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_big_axe"),
                    new BigAxeItem(RoseGoldToolMaterial.MATERIAL,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_lance"),
                    new LanceItem(RoseGoldToolMaterial.MATERIAL,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_healing_staff"), new HealingStaffItem(RoseGoldToolMaterial.MATERIAL, 3,
                    new Item.Properties().attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_mace"),
                    new MaceItem(RoseGoldToolMaterial.MATERIAL, 1,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ROSE_GOLD_FRANCISCA_ITEM = new FranciscaItem(RoseGoldToolMaterial.MATERIAL, () -> CompatEntities.ROSE_GOLD_FRANCISCA,
                    new Item.Properties().attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 1, -2.6f)));
            ROSE_GOLD_JAVELIN_ITEM = new JavelinItem(RoseGoldToolMaterial.MATERIAL, () -> CompatEntities.ROSE_GOLD_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_francisca"), ROSE_GOLD_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_javelin"), ROSE_GOLD_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_ninjato"),
                    new NinjatoItem(RoseGoldToolMaterial.MATERIAL, new Item.Properties().attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_sickle"),
                    new SickleItem(RoseGoldToolMaterial.MATERIAL, new Item.Properties().attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("rose_gold_rapier"),
                    new RapierItem(RoseGoldToolMaterial.MATERIAL, 1, new Item.Properties().attributes(SwordItem.createAttributes(RoseGoldToolMaterial.MATERIAL, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("gilded_netherite");
            ItemInit.MATERIAL_STRINGS.add("rose_gold");
        }
        if (isMythicUpgradesLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("ruby_netherite_small_axe"),
                            new SmallAxeItem(MUToolMaterials.RUBY,
                                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("ruby_netherite_long_sword"),
                            new LongSwordItem(MUToolMaterials.RUBY,
                                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("ruby_netherite_dagger"),
                            new DaggerItem(MUToolMaterials.RUBY,
                                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("ruby_netherite_big_axe"),
                            new BigAxeItem(MUToolMaterials.RUBY,
                                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                                    new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("ruby_netherite_lance"),
                            new LanceItem(MUToolMaterials.RUBY,
                                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("ruby_netherite_healing_staff"),
                    new HealingStaffItem(MUToolMaterials.RUBY, 5, new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("ruby_netherite_mace"),
                            new MaceItem(MUToolMaterials.RUBY, 3,
                                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            RUBY_NETHERITE_FRANCISCA_ITEM = new FranciscaItem(MUToolMaterials.RUBY, () -> CompatEntities.RUBY_NETHERITE_FRANCISCA,
                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 1, -2.6f)));
            RUBY_NETHERITE_JAVELIN_ITEM = new JavelinItem(MUToolMaterials.RUBY, () -> CompatEntities.RUBY_NETHERITE_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("ruby_netherite_francisca"), RUBY_NETHERITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("ruby_netherite_javelin"), RUBY_NETHERITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("ruby_netherite_ninjato"),
                    new NinjatoItem(MUToolMaterials.RUBY, new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("ruby_netherite_sickle"),
                    new SickleItem(MUToolMaterials.RUBY, new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("ruby_netherite_rapier"),
                    new RapierItem(MUToolMaterials.RUBY, 3, new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.RUBY, 2, -2.0f)).fireResistant()));

            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("sapphire_netherite_small_axe"),
                            new SmallAxeItem(MUToolMaterials.SAPPHIRE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("sapphire_netherite_long_sword"),
                    new LongSwordItem(MUToolMaterials.SAPPHIRE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("sapphire_netherite_dagger"),
                    new DaggerItem(MUToolMaterials.SAPPHIRE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("sapphire_netherite_big_axe"),
                            new BigAxeItem(MUToolMaterials.SAPPHIRE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                                    new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("sapphire_netherite_lance"),
                    new LanceItem(MUToolMaterials.SAPPHIRE,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("sapphire_netherite_healing_staff"),
                    new HealingStaffItem(MUToolMaterials.SAPPHIRE, 5, new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("sapphire_netherite_mace"),
                    new MaceItem(MUToolMaterials.SAPPHIRE, 3,
                            new Item.Properties()
                                    .attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                    .fireResistant()));
            SAPPHIRE_NETHERITE_FRANCISCA_ITEM = new FranciscaItem(MUToolMaterials.SAPPHIRE, () -> CompatEntities.SAPPHIRE_NETHERITE_FRANCISCA,
                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 1, -2.6f)));
            SAPPHIRE_NETHERITE_JAVELIN_ITEM = new JavelinItem(MUToolMaterials.SAPPHIRE, () -> CompatEntities.SAPPHIRE_NETHERITE_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("sapphire_netherite_francisca"), SAPPHIRE_NETHERITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("sapphire_netherite_javelin"), SAPPHIRE_NETHERITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("sapphire_netherite_ninjato"),
                    new NinjatoItem(MUToolMaterials.SAPPHIRE, new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("sapphire_netherite_sickle"),
                    new SickleItem(MUToolMaterials.SAPPHIRE, new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("sapphire_netherite_rapier"),
                    new RapierItem(MUToolMaterials.SAPPHIRE, 3, new Item.Properties().attributes(SwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("ruby_netherite");
            ItemInit.MATERIAL_STRINGS.add("sapphire_netherite");
        }
        if (isDeeperDarkerLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("warden_small_axe"),
                            new SmallAxeItem(DDTiers.WARDEN,
                                    new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                                    new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("warden_long_sword"),
                            new LongSwordItem(DDTiers.WARDEN,
                                    new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("warden_dagger"),
                            new DaggerItem(DDTiers.WARDEN,
                                    new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("warden_big_axe"),
                            new BigAxeItem(DDTiers.WARDEN,
                                    new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                                    new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("warden_lance"),
                            new LanceItem(DDTiers.WARDEN,
                                    new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("warden_healing_staff"),
                    new HealingStaffItem(DDTiers.WARDEN, 5, new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("warden_mace"),
                            new MaceItem(DDTiers.WARDEN, 3,
                                    new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                                    new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                                            .fireResistant()));
            WARDEN_FRANCISCA_ITEM =
                    new FranciscaItem(DDTiers.WARDEN, () -> CompatEntities.WARDEN_FRANCISCA, new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 1, -2.6f)));
            WARDEN_JAVELIN_ITEM = new JavelinItem(DDTiers.WARDEN, () -> CompatEntities.WARDEN_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("warden_francisca"), WARDEN_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("warden_javelin"), WARDEN_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("warden_ninjato"),
                    new NinjatoItem(DDTiers.WARDEN, new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("warden_sickle"),
                    new SickleItem(DDTiers.WARDEN, new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("warden_rapier"),
                    new RapierItem(DDTiers.WARDEN, 3, new Item.Properties().attributes(SwordItem.createAttributes(DDTiers.WARDEN, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("warden");
        }

        if (isEarlyStageLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("steel_small_axe"),
                            new SmallAxeItem(EarlyStageToolMaterials.STEEL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                            new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("steel_long_sword"),
                            new LongSwordItem(EarlyStageToolMaterials.STEEL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("steel_dagger"),
                            new DaggerItem(EarlyStageToolMaterials.STEEL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("steel_big_axe"),
                            new BigAxeItem(EarlyStageToolMaterials.STEEL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("steel_lance"),
                            new LanceItem(EarlyStageToolMaterials.STEEL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("steel_healing_staff"),
                    new HealingStaffItem(EarlyStageToolMaterials.STEEL, 5, new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 1, -3.3f))));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("steel_mace"),
                            new MaceItem(EarlyStageToolMaterials.STEEL, 3,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            STEEL_FRANCISCA_ITEM =
                    new FranciscaItem(EarlyStageToolMaterials.STEEL, () -> CompatEntities.STEEL_FRANCISCA, new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 1, -2.6f)));
            STEEL_JAVELIN_ITEM = new JavelinItem(EarlyStageToolMaterials.STEEL, () -> CompatEntities.STEEL_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 1, -2.6f)));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("steel_francisca"), STEEL_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("steel_javelin"), STEEL_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("steel_ninjato"),
                    new NinjatoItem(EarlyStageToolMaterials.STEEL, new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 2, -2.1f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("steel_sickle"),
                    new SickleItem(EarlyStageToolMaterials.STEEL, new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 2, -2.2f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("steel_rapier"),
                    new RapierItem(EarlyStageToolMaterials.STEEL, 3, new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.STEEL, 2, -2.0f))));

            ItemInit.MATERIAL_STRINGS.add("steel");

            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("damascus_steel_small_axe"),
                            new SmallAxeItem(EarlyStageToolMaterials.DAMASCUS_STEEL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                            new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("damascus_steel_long_sword"),
                            new LongSwordItem(EarlyStageToolMaterials.DAMASCUS_STEEL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("damascus_steel_dagger"),
                            new DaggerItem(EarlyStageToolMaterials.DAMASCUS_STEEL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("damascus_steel_big_axe"),
                            new BigAxeItem(EarlyStageToolMaterials.DAMASCUS_STEEL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("damascus_steel_lance"),
                            new LanceItem(EarlyStageToolMaterials.DAMASCUS_STEEL,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("damascus_steel_healing_staff"),
                    new HealingStaffItem(EarlyStageToolMaterials.DAMASCUS_STEEL, 5, new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 1, -3.3f))));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("damascus_steel_mace"),
                            new MaceItem(EarlyStageToolMaterials.DAMASCUS_STEEL, 3,
                                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND))
                            ));
            DAMASCUS_STEEL_FRANCISCA_ITEM =
                    new FranciscaItem(EarlyStageToolMaterials.DAMASCUS_STEEL, () -> CompatEntities.DAMASCUS_STEEL_FRANCISCA, new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 1, -2.6f)));
            DAMASCUS_STEEL_JAVELIN_ITEM = new JavelinItem(EarlyStageToolMaterials.DAMASCUS_STEEL, () -> CompatEntities.DAMASCUS_STEEL_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 1, -2.6f)));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("damascus_steel_francisca"), DAMASCUS_STEEL_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("damascus_steel_javelin"), DAMASCUS_STEEL_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("damascus_steel_ninjato"),
                    new NinjatoItem(EarlyStageToolMaterials.DAMASCUS_STEEL, new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 2, -2.1f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("damascus_steel_sickle"),
                    new SickleItem(EarlyStageToolMaterials.DAMASCUS_STEEL, new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 2, -2.2f))));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("damascus_steel_rapier"),
                    new RapierItem(EarlyStageToolMaterials.DAMASCUS_STEEL, 3, new Item.Properties().attributes(SwordItem.createAttributes(EarlyStageToolMaterials.DAMASCUS_STEEL, 2, -2.0f))));

            ItemInit.MATERIAL_STRINGS.add("damascus_steel");
        }

        if (isOblivionLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("fiery_netherite_small_axe"),
                            new SmallAxeItem(OblivionToolMaterials.FIERY_NETHERITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                            new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("fiery_netherite_long_sword"),
                            new LongSwordItem(OblivionToolMaterials.FIERY_NETHERITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("fiery_netherite_dagger"),
                            new DaggerItem(OblivionToolMaterials.FIERY_NETHERITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("fiery_netherite_big_axe"),
                            new BigAxeItem(OblivionToolMaterials.FIERY_NETHERITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("fiery_netherite_lance"),
                            new LanceItem(OblivionToolMaterials.FIERY_NETHERITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("fiery_netherite_healing_staff"),
                    new HealingStaffItem(OblivionToolMaterials.FIERY_NETHERITE, 5, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("fiery_netherite_mace"),
                            new MaceItem(OblivionToolMaterials.FIERY_NETHERITE, 3,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            FIERY_NETHERITE_FRANCISCA_ITEM =
                    new FranciscaItem(OblivionToolMaterials.FIERY_NETHERITE, () -> CompatEntities.FIERY_NETHERITE_FRANCISCA, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 1, -2.6f)).fireResistant());
            FIERY_NETHERITE_JAVELIN_ITEM = new JavelinItem(OblivionToolMaterials.FIERY_NETHERITE, () -> CompatEntities.FIERY_NETHERITE_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("fiery_netherite_francisca"), FIERY_NETHERITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("fiery_netherite_javelin"), FIERY_NETHERITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("fiery_netherite_ninjato"),
                    new NinjatoItem(OblivionToolMaterials.FIERY_NETHERITE, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("fiery_netherite_sickle"),
                    new SickleItem(OblivionToolMaterials.FIERY_NETHERITE, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("fiery_netherite_rapier"),
                    new RapierItem(OblivionToolMaterials.FIERY_NETHERITE, 3, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.FIERY_NETHERITE, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("fiery_netherite");

            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("scarlet_small_axe"),
                            new SmallAxeItem(OblivionToolMaterials.SCARLET,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                            new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("scarlet_long_sword"),
                            new LongSwordItem(OblivionToolMaterials.SCARLET,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("scarlet_dagger"),
                            new DaggerItem(OblivionToolMaterials.SCARLET,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("scarlet_big_axe"),
                            new BigAxeItem(OblivionToolMaterials.SCARLET,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("scarlet_lance"),
                            new LanceItem(OblivionToolMaterials.SCARLET,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("scarlet_healing_staff"),
                    new HealingStaffItem(OblivionToolMaterials.SCARLET, 5, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("scarlet_mace"),
                            new MaceItem(OblivionToolMaterials.SCARLET, 3,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            SCARLET_FRANCISCA_ITEM =
                    new FranciscaItem(OblivionToolMaterials.SCARLET, () -> CompatEntities.SCARLET_FRANCISCA, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 1, -2.6f)).fireResistant());
            SCARLET_JAVELIN_ITEM = new JavelinItem(OblivionToolMaterials.SCARLET, () -> CompatEntities.SCARLET_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("scarlet_francisca"), SCARLET_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("scarlet_javelin"), SCARLET_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("scarlet_ninjato"),
                    new NinjatoItem(OblivionToolMaterials.SCARLET, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("scarlet_sickle"),
                    new SickleItem(OblivionToolMaterials.SCARLET, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("scarlet_rapier"),
                    new RapierItem(OblivionToolMaterials.SCARLET, 3, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SCARLET, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("scarlet");

            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("solarite_small_axe"),
                            new SmallAxeItem(OblivionToolMaterials.SOLARITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 5, -2.9f).withModifierAdded(Attributes.ATTACK_KNOCKBACK,
                                            new AttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("solarite_long_sword"),
                            new LongSwordItem(OblivionToolMaterials.SOLARITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 6, -3.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("solarite_dagger"),
                            new DaggerItem(OblivionToolMaterials.SOLARITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 2, -2.0f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("solarite_big_axe"),
                            new BigAxeItem(OblivionToolMaterials.SOLARITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 6, -3.4f).withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO,
                                            new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("solarite_lance"),
                            new LanceItem(OblivionToolMaterials.SOLARITE,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 3, -3.2f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("solarite_healing_staff"),
                    new HealingStaffItem(OblivionToolMaterials.SOLARITE, 5, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 1, -3.3f)).fireResistant()));
            ItemInit.ITEMS
                    .put(MedievalMain.identifierOf("solarite_mace"),
                            new MaceItem(OblivionToolMaterials.SOLARITE, 3,
                                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 4, -2.8f).withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                                            new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)).fireResistant()
                            ));
            SOLARITE_FRANCISCA_ITEM =
                    new FranciscaItem(OblivionToolMaterials.SOLARITE, () -> CompatEntities.SOLARITE_FRANCISCA, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 1, -2.6f)).fireResistant());
            SOLARITE_JAVELIN_ITEM = new JavelinItem(OblivionToolMaterials.SOLARITE, () -> CompatEntities.SOLARITE_JAVELIN,
                    new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 1, -2.6f)).fireResistant());
            ItemInit.ITEMS.put(MedievalMain.identifierOf("solarite_francisca"), SOLARITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("solarite_javelin"), SOLARITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.identifierOf("solarite_ninjato"),
                    new NinjatoItem(OblivionToolMaterials.SOLARITE, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 2, -2.1f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("solarite_sickle"),
                    new SickleItem(OblivionToolMaterials.SOLARITE, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 2, -2.2f)).fireResistant()));
            ItemInit.ITEMS.put(MedievalMain.identifierOf("solarite_rapier"),
                    new RapierItem(OblivionToolMaterials.SOLARITE, 3, new Item.Properties().attributes(SwordItem.createAttributes(OblivionToolMaterials.SOLARITE, 2, -2.0f)).fireResistant()));

            ItemInit.MATERIAL_STRINGS.add("solarite");
        }

    }
}