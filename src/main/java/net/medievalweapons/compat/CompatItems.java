package net.medievalweapons.compat;

import com.kyanite.deeperdarker.util.DDTiers;

import net.dragonloot.item.DragonToolMaterials;
import net.minecraft.item.ToolMaterials;
import org.betterx.betterend.item.material.EndToolMaterial;
import org.betterx.betternether.items.materials.BNToolMaterial;

import dqu.additionaladditions.material.GildedNetheriteToolMaterial;
import dqu.additionaladditions.material.RoseGoldToolMaterial;
import net.fabricmc.loader.api.FabricLoader;
import net.id.paradiselost.items.tools.ParadiseLostToolMaterials;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.ItemInit;
import net.medievalweapons.item.*;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.trique.mythicupgrades.item.MUToolMaterials;
import nourl.mythicmetals.item.tools.MythicToolMaterials;
import potionstudios.byg.common.item.BYGTier;

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

    public static void loadItems() {
        if (isBetterEndLoaded) {
            ItemInit.ITEMS.put(MedievalMain.id("terminite_small_axe"),
                    new SmallAxeItem(EndToolMaterial.TERMINITE,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                    new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("terminite_long_sword"),
                    new LongSwordItem(EndToolMaterial.TERMINITE,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("terminite_dagger"),
                    new DaggerItem(EndToolMaterial.TERMINITE,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("terminite_big_axe"),
                    new BigAxeItem(EndToolMaterial.TERMINITE,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                    new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("terminite_lance"),
                    new LanceItem(EndToolMaterial.TERMINITE,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("terminite_healing_staff"),
                    new HealingStaffItem(EndToolMaterial.TERMINITE, 4, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 1, -3.3f))));
            ItemInit.ITEMS.put(MedievalMain.id("terminite_mace"),
                    new MaceItem(EndToolMaterial.TERMINITE, 2,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            TERMINITE_FRANCISCA_ITEM = new FranciscaItem(EndToolMaterial.TERMINITE, () -> CompatEntities.TERMINITE_FRANCISCA, new Item.Settings());
            TERMINITE_JAVELIN_ITEM =  new JavelinItem(EndToolMaterial.TERMINITE, () -> CompatEntities.TERMINITE_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 1, -2.6f)));
            ItemInit.ITEMS.put(MedievalMain.id("terminite_francisca"), TERMINITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("terminite_javelin"), TERMINITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("terminite_ninjato"),
                    new NinjatoItem(EndToolMaterial.TERMINITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 2, -2.1f))));
            ItemInit.ITEMS.put(MedievalMain.id("terminite_sickle"),
                    new SickleItem(EndToolMaterial.TERMINITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 2, -2.2f))));
            ItemInit.ITEMS.put(MedievalMain.id("terminite_rapier"),
                    new RapierItem(EndToolMaterial.TERMINITE, 2, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.TERMINITE, 2, -2.0f))));

            ItemInit.ITEMS.put(MedievalMain.id("aeternium_small_axe"),
                    new SmallAxeItem(EndToolMaterial.AETERNIUM,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                    new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_long_sword"),
                    new LongSwordItem(EndToolMaterial.AETERNIUM,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_dagger"),
                    new DaggerItem(EndToolMaterial.AETERNIUM,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_big_axe"),
                    new BigAxeItem(EndToolMaterial.AETERNIUM,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                    new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_lance"),
                    new LanceItem(EndToolMaterial.AETERNIUM,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_healing_staff"),
                    new HealingStaffItem(EndToolMaterial.AETERNIUM, 4, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 1, -3.3f))));
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_mace"),
                    new MaceItem(EndToolMaterial.AETERNIUM, 2,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            AETERNIUM_FRANCISCA_ITEM =  new FranciscaItem(EndToolMaterial.AETERNIUM, () -> CompatEntities.AETERNIUM_FRANCISCA, new Item.Settings());
            AETERNIUM_JAVELIN_ITEM = new JavelinItem(EndToolMaterial.AETERNIUM, () -> CompatEntities.AETERNIUM_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 1, -2.6f)));
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_francisca"), AETERNIUM_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_javelin"), AETERNIUM_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_ninjato"),
                    new NinjatoItem(EndToolMaterial.AETERNIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 2, -2.1f))));
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_sickle"),
                    new SickleItem(EndToolMaterial.AETERNIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 2, -2.2f))));
            ItemInit.ITEMS.put(MedievalMain.id("aeternium_rapier"),
                    new RapierItem(EndToolMaterial.AETERNIUM, 2, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.AETERNIUM, 2, -2.0f))));
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_small_axe"),
                    new SmallAxeItem(EndToolMaterial.THALLASIUM,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                    new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_long_sword"),
                    new LongSwordItem(EndToolMaterial.THALLASIUM,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_dagger"),
                    new DaggerItem(EndToolMaterial.THALLASIUM,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_big_axe"),
                    new BigAxeItem(EndToolMaterial.THALLASIUM,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                    new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_lance"),
                    new LanceItem(EndToolMaterial.THALLASIUM,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_healing_staff"),
                    new HealingStaffItem(EndToolMaterial.THALLASIUM, 3, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 1, -3.3f))));
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_mace"),
                    new MaceItem(EndToolMaterial.THALLASIUM, 1,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));
            THALLASIUM_FRANCISCA_ITEM =  new FranciscaItem(EndToolMaterial.THALLASIUM, () -> CompatEntities.THALLASIUM_FRANCISCA, new Item.Settings());
            THALLASIUM_JAVELIN_ITEM = new JavelinItem(EndToolMaterial.THALLASIUM, () -> CompatEntities.THALLASIUM_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 1, -2.6f)));
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_francisca"), THALLASIUM_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_javelin"), THALLASIUM_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_ninjato"),
                    new NinjatoItem(EndToolMaterial.THALLASIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 2, -2.1f))));
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_sickle"),
                    new SickleItem(EndToolMaterial.THALLASIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 2, -2.2f))));
            ItemInit.ITEMS.put(MedievalMain.id("thallasium_rapier"),
                    new RapierItem(EndToolMaterial.THALLASIUM, 1, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EndToolMaterial.THALLASIUM, 2, -2.0f))));

            ItemInit.MATERIAL_STRINGS.add("terminite");
            ItemInit.MATERIAL_STRINGS.add("aeternium");
            ItemInit.MATERIAL_STRINGS.add("thallasium");
        }
        if (isBetterNetherLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.id("nether_ruby_small_axe"),
                            new SmallAxeItem(BNToolMaterial.NETHER_RUBY,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("nether_ruby_long_sword"),
                    new LongSwordItem(BNToolMaterial.NETHER_RUBY,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("nether_ruby_dagger"),
                    new DaggerItem(BNToolMaterial.NETHER_RUBY,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("nether_ruby_big_axe"),
                            new BigAxeItem(BNToolMaterial.NETHER_RUBY,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("nether_ruby_lance"),
                    new LanceItem(BNToolMaterial.NETHER_RUBY,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("nether_ruby_healing_staff"),
                    new HealingStaffItem(BNToolMaterial.NETHER_RUBY, 2, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("nether_ruby_mace"),
                    new MaceItem(BNToolMaterial.NETHER_RUBY, 1,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            NETHER_RUBY_FRANCISCA_ITEM = new FranciscaItem(BNToolMaterial.NETHER_RUBY, () -> CompatEntities.NETHER_RUBY_FRANCISCA,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 1, -2.6f)));
            NETHER_RUBY_JAVELIN_ITEM = new JavelinItem(BNToolMaterial.NETHER_RUBY, () -> CompatEntities.NETHER_RUBY_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("nether_ruby_francisca"), NETHER_RUBY_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("nether_ruby_javelin"), NETHER_RUBY_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("nether_ruby_ninjato"),
                    new NinjatoItem(BNToolMaterial.NETHER_RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("nether_ruby_sickle"),
                    new SickleItem(BNToolMaterial.NETHER_RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("nether_ruby_rapier"),
                    new RapierItem(BNToolMaterial.NETHER_RUBY, 1, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.NETHER_RUBY, 2, -2.0f)).fireproof()));

            ItemInit.ITEMS
                    .put(MedievalMain.id("cincinnasite_small_axe"),
                            new SmallAxeItem(BNToolMaterial.CINCINNASITE,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_long_sword"),
                    new LongSwordItem(BNToolMaterial.CINCINNASITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_dagger"),
                    new DaggerItem(BNToolMaterial.CINCINNASITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_big_axe"),
                    new BigAxeItem(BNToolMaterial.CINCINNASITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_lance"),
                    new LanceItem(BNToolMaterial.CINCINNASITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_healing_staff"), new HealingStaffItem(BNToolMaterial.CINCINNASITE, 3,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_mace"),
                    new MaceItem(BNToolMaterial.CINCINNASITE, 1,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            CINCINNASITE_FRANCISCA_ITEM = new FranciscaItem(BNToolMaterial.CINCINNASITE, () -> CompatEntities.CINCINNASITE_FRANCISCA,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 1, -2.6f)));
            CINCINNASITE_JAVELIN_ITEM =  new JavelinItem(BNToolMaterial.CINCINNASITE, () -> CompatEntities.CINCINNASITE_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_francisca"), CINCINNASITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_javelin"), CINCINNASITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_ninjato"),
                    new NinjatoItem(BNToolMaterial.CINCINNASITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_sickle"),
                    new SickleItem(BNToolMaterial.CINCINNASITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_rapier"),
                    new RapierItem(BNToolMaterial.CINCINNASITE, 1, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE, 2, -2.0f)).fireproof()));

            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_small_axe"),
                    new SmallAxeItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_long_sword"),
                    new LongSwordItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_dagger"),
                    new DaggerItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_big_axe"),
                    new BigAxeItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_lance"),
                    new LanceItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_healing_staff"), new HealingStaffItem(BNToolMaterial.CINCINNASITE_DIAMOND, 5,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_mace"),
                    new MaceItem(BNToolMaterial.CINCINNASITE_DIAMOND, 3,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            CINCINNASITE_DIAMOND_FRANCISCA_ITEM =  new FranciscaItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                    () -> CompatEntities.CINCINNASITE_DIAMOND_FRANCISCA, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 1, -2.6f)));
            CINCINNASITE_DIAMOND_JAVELIN_ITEM =
                    new JavelinItem(BNToolMaterial.CINCINNASITE_DIAMOND, () -> CompatEntities.CINCINNASITE_DIAMOND_JAVELIN,
                            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_francisca"), CINCINNASITE_DIAMOND_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_javelin"), CINCINNASITE_DIAMOND_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_ninjato"), new NinjatoItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_sickle"), new SickleItem(BNToolMaterial.CINCINNASITE_DIAMOND,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("cincinnasite_diamond_rapier"), new RapierItem(BNToolMaterial.CINCINNASITE_DIAMOND, 3,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BNToolMaterial.CINCINNASITE_DIAMOND, 2, -2.0f)).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("nether_ruby");
            ItemInit.MATERIAL_STRINGS.add("cincinnasite");
            ItemInit.MATERIAL_STRINGS.add("cincinnasite_diamond");
        }
        if (isDragonLootLoaded) {
            ItemInit.ITEMS.put(MedievalMain.id("dragon_small_axe"),
                    new SmallAxeItem(DragonToolMaterials.DRAGON,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("dragon_long_sword"),
                    new LongSwordItem(DragonToolMaterials.DRAGON,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("dragon_dagger"),
                    new DaggerItem(DragonToolMaterials.DRAGON,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("dragon_big_axe"),
                    new BigAxeItem(DragonToolMaterials.DRAGON,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("dragon_lance"),
                    new LanceItem(DragonToolMaterials.DRAGON,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("dragon_healing_staff"), new HealingStaffItem(DragonToolMaterials.DRAGON, 5,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("dragon_mace"),
                    new MaceItem(DragonToolMaterials.DRAGON, 3,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            DRAGON_FRANCISCA_ITEM =  new FranciscaItem(DragonToolMaterials.DRAGON, () -> CompatEntities.DRAGON_FRANCISCA,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 1, -2.6f)));
            DRAGON_JAVELIN_ITEM =  new JavelinItem(DragonToolMaterials.DRAGON, () -> CompatEntities.DRAGON_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("dragon_francisca"), DRAGON_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("dragon_javelin"), DRAGON_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("dragon_ninjato"), new NinjatoItem(DragonToolMaterials.DRAGON,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("dragon_sickle"), new SickleItem(DragonToolMaterials.DRAGON,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("dragon_rapier"), new RapierItem(DragonToolMaterials.DRAGON, 3,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DragonToolMaterials.DRAGON, 2, -2.0f)).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("dragon");
        }
        if (isMythicMetalsLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.id("adamantite_small_axe"),
                            new SmallAxeItem(MythicToolMaterials.ADAMANTITE,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_long_sword"),
                    new LongSwordItem(MythicToolMaterials.ADAMANTITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_dagger"),
                    new DaggerItem(MythicToolMaterials.ADAMANTITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_big_axe"),
                    new BigAxeItem(MythicToolMaterials.ADAMANTITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_lance"),
                    new LanceItem(MythicToolMaterials.ADAMANTITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_healing_staff"), new HealingStaffItem(MythicToolMaterials.ADAMANTITE, 4,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_mace"),
                    new MaceItem(MythicToolMaterials.ADAMANTITE, 2,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ADAMANTITE_FRANCISCA_ITEM =  new FranciscaItem(MythicToolMaterials.ADAMANTITE, () -> CompatEntities.ADAMANTITE_FRANCISCA,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 1, -2.6f)));
            ADAMANTITE_JAVELIN_ITEM =  new JavelinItem(MythicToolMaterials.ADAMANTITE, () -> CompatEntities.ADAMANTITE_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_francisca"), ADAMANTITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_javelin"), ADAMANTITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_ninjato"),
                    new NinjatoItem(MythicToolMaterials.ADAMANTITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_sickle"),
                    new SickleItem(MythicToolMaterials.ADAMANTITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("adamantite_rapier"), new RapierItem(MythicToolMaterials.ADAMANTITE, 3,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MythicToolMaterials.ADAMANTITE, 2, -2.0f)).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("adamantite");
        }
        if (isParadiseLostLoaded) {
            ItemInit.ITEMS.put(MedievalMain.id("olvite_small_axe"),
                    new SmallAxeItem(ParadiseLostToolMaterials.OLVITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("olvite_long_sword"),
                    new LongSwordItem(ParadiseLostToolMaterials.OLVITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("olvite_dagger"),
                    new DaggerItem(ParadiseLostToolMaterials.OLVITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("olvite_big_axe"),
                    new BigAxeItem(ParadiseLostToolMaterials.OLVITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("olvite_lance"),
                    new LanceItem(ParadiseLostToolMaterials.OLVITE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("olvite_healing_staff"), new HealingStaffItem(ParadiseLostToolMaterials.OLVITE, 4,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("olvite_mace"),
                    new MaceItem(ParadiseLostToolMaterials.OLVITE, 1,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            OLVITE_FRANCISCA_ITEM =  new FranciscaItem(ParadiseLostToolMaterials.OLVITE, () -> CompatEntities.OLVITE_FRANCISCA,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 1, -2.6f)));
            OLVITE_JAVELIN_ITEM =  new JavelinItem(ParadiseLostToolMaterials.OLVITE, () -> CompatEntities.OLVITE_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("olvite_francisca"), OLVITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("olvite_javelin"), OLVITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("olvite_ninjato"), new NinjatoItem(ParadiseLostToolMaterials.OLVITE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("olvite_sickle"), new SickleItem(ParadiseLostToolMaterials.OLVITE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("olvite_rapier"), new RapierItem(ParadiseLostToolMaterials.OLVITE, 2,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ParadiseLostToolMaterials.OLVITE, 2, -2.0f)).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("olvite");
        }
        if (isBYGLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.id("pendorite_small_axe"),
                            new SmallAxeItem(BYGTier.PENDORITE,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("pendorite_long_sword"),
                            new LongSwordItem(BYGTier.PENDORITE,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("pendorite_dagger"),
                            new DaggerItem(BYGTier.PENDORITE,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("pendorite_big_axe"),
                            new BigAxeItem(BYGTier.PENDORITE,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("pendorite_lance"),
                            new LanceItem(BYGTier.PENDORITE,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("pendorite_healing_staff"),
                    new HealingStaffItem(BYGTier.PENDORITE, 4, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("pendorite_mace"),
                            new MaceItem(BYGTier.PENDORITE, 2,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            PENDORITE_FRANCISCA_ITEM = new FranciscaItem(BYGTier.PENDORITE, () -> CompatEntities.PENDORITE_FRANCISCA,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 1, -2.6f)));
            PENDORITE_JAVELIN_ITEM =  new JavelinItem(BYGTier.PENDORITE, () -> CompatEntities.PENDORITE_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("pendorite_francisca"), PENDORITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("pendorite_javelin"), PENDORITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("pendorite_ninjato"),
                    new NinjatoItem(BYGTier.PENDORITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("pendorite_sickle"),
                    new SickleItem(BYGTier.PENDORITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("pendorite_rapier"),
                    new RapierItem(BYGTier.PENDORITE, 2, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BYGTier.PENDORITE, 2, -2.0f)).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("pendorite");
        }
        if (isAdditionalAdditionsLoaded) {
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_small_axe"),
                    new SmallAxeItem(GildedNetheriteToolMaterial.MATERIAL,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_long_sword"),
                    new LongSwordItem(GildedNetheriteToolMaterial.MATERIAL,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_dagger"),
                    new DaggerItem(GildedNetheriteToolMaterial.MATERIAL,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_big_axe"),
                    new BigAxeItem(GildedNetheriteToolMaterial.MATERIAL,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_lance"),
                    new LanceItem(GildedNetheriteToolMaterial.MATERIAL,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_healing_staff"), new HealingStaffItem(GildedNetheriteToolMaterial.MATERIAL, 5,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_mace"),
                    new MaceItem(GildedNetheriteToolMaterial.MATERIAL, 3,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            GILDED_NETHERITE_FRANCISCA_ITEM = new FranciscaItem(GildedNetheriteToolMaterial.MATERIAL, () -> CompatEntities.GILDED_NETHERITE_FRANCISCA,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 1, -2.6f)));
            GILDED_NETHERITE_JAVELIN_ITEM =  new JavelinItem(GildedNetheriteToolMaterial.MATERIAL, () -> CompatEntities.GILDED_NETHERITE_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_francisca"), GILDED_NETHERITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_javelin"), GILDED_NETHERITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_ninjato"), new NinjatoItem(GildedNetheriteToolMaterial.MATERIAL,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_sickle"), new SickleItem(GildedNetheriteToolMaterial.MATERIAL,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("gilded_netherite_rapier"), new RapierItem(GildedNetheriteToolMaterial.MATERIAL, 3,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(GildedNetheriteToolMaterial.MATERIAL, 2, -2.0f)).fireproof()));

            ItemInit.ITEMS
                    .put(MedievalMain.id("rose_gold_small_axe"),
                            new SmallAxeItem(RoseGoldToolMaterial.MATERIAL,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_long_sword"),
                    new LongSwordItem(RoseGoldToolMaterial.MATERIAL,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_dagger"),
                    new DaggerItem(RoseGoldToolMaterial.MATERIAL,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_big_axe"),
                    new BigAxeItem(RoseGoldToolMaterial.MATERIAL,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_lance"),
                    new LanceItem(RoseGoldToolMaterial.MATERIAL,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_healing_staff"), new HealingStaffItem(RoseGoldToolMaterial.MATERIAL, 3,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_mace"),
                    new MaceItem(RoseGoldToolMaterial.MATERIAL, 1,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ROSE_GOLD_FRANCISCA_ITEM = new FranciscaItem(RoseGoldToolMaterial.MATERIAL, () -> CompatEntities.ROSE_GOLD_FRANCISCA,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 1, -2.6f)));
            ROSE_GOLD_JAVELIN_ITEM = new JavelinItem(RoseGoldToolMaterial.MATERIAL, () -> CompatEntities.ROSE_GOLD_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_francisca"), ROSE_GOLD_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_javelin"), ROSE_GOLD_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_ninjato"),
                    new NinjatoItem(RoseGoldToolMaterial.MATERIAL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_sickle"),
                    new SickleItem(RoseGoldToolMaterial.MATERIAL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("rose_gold_rapier"),
                    new RapierItem(RoseGoldToolMaterial.MATERIAL, 1, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(RoseGoldToolMaterial.MATERIAL, 2, -2.0f)).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("gilded_netherite");
            ItemInit.MATERIAL_STRINGS.add("rose_gold");
        }
        if (isMythicUpgradesLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.id("ruby_netherite_small_axe"),
                            new SmallAxeItem(MUToolMaterials.RUBY,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("ruby_netherite_long_sword"),
                            new LongSwordItem(MUToolMaterials.RUBY,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("ruby_netherite_dagger"),
                            new DaggerItem(MUToolMaterials.RUBY,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("ruby_netherite_big_axe"),
                            new BigAxeItem(MUToolMaterials.RUBY,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("ruby_netherite_lance"),
                            new LanceItem(MUToolMaterials.RUBY,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("ruby_netherite_healing_staff"),
                    new HealingStaffItem(MUToolMaterials.RUBY, 5, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("ruby_netherite_mace"),
                            new MaceItem(MUToolMaterials.RUBY, 3,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            RUBY_NETHERITE_FRANCISCA_ITEM = new FranciscaItem(MUToolMaterials.RUBY, () -> CompatEntities.RUBY_NETHERITE_FRANCISCA,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 1, -2.6f)));
            RUBY_NETHERITE_JAVELIN_ITEM = new JavelinItem(MUToolMaterials.RUBY, () -> CompatEntities.RUBY_NETHERITE_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("ruby_netherite_francisca"), RUBY_NETHERITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("ruby_netherite_javelin"), RUBY_NETHERITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("ruby_netherite_ninjato"),
                    new NinjatoItem(MUToolMaterials.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("ruby_netherite_sickle"),
                    new SickleItem(MUToolMaterials.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("ruby_netherite_rapier"),
                    new RapierItem(MUToolMaterials.RUBY, 3, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.RUBY, 2, -2.0f)).fireproof()));

            ItemInit.ITEMS
                    .put(MedievalMain.id("sapphire_netherite_small_axe"),
                            new SmallAxeItem(MUToolMaterials.SAPPHIRE,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("sapphire_netherite_long_sword"),
                    new LongSwordItem(MUToolMaterials.SAPPHIRE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("sapphire_netherite_dagger"),
                    new DaggerItem(MUToolMaterials.SAPPHIRE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("sapphire_netherite_big_axe"),
                            new BigAxeItem(MUToolMaterials.SAPPHIRE,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("sapphire_netherite_lance"),
                    new LanceItem(MUToolMaterials.SAPPHIRE,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("sapphire_netherite_healing_staff"),
                    new HealingStaffItem(MUToolMaterials.SAPPHIRE, 5, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("sapphire_netherite_mace"),
                    new MaceItem(MUToolMaterials.SAPPHIRE, 3,
                            new Item.Settings()
                                    .attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                    .fireproof()));
            SAPPHIRE_NETHERITE_FRANCISCA_ITEM = new FranciscaItem(MUToolMaterials.SAPPHIRE, () -> CompatEntities.SAPPHIRE_NETHERITE_FRANCISCA,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 1, -2.6f)));
            SAPPHIRE_NETHERITE_JAVELIN_ITEM =  new JavelinItem(MUToolMaterials.SAPPHIRE, () -> CompatEntities.SAPPHIRE_NETHERITE_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("sapphire_netherite_francisca"), SAPPHIRE_NETHERITE_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("sapphire_netherite_javelin"), SAPPHIRE_NETHERITE_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("sapphire_netherite_ninjato"),
                    new NinjatoItem(MUToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("sapphire_netherite_sickle"),
                    new SickleItem(MUToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("sapphire_netherite_rapier"),
                    new RapierItem(MUToolMaterials.SAPPHIRE, 3, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(MUToolMaterials.SAPPHIRE, 2, -2.0f)).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("ruby_netherite");
            ItemInit.MATERIAL_STRINGS.add("sapphire_netherite");
        }
        if (isDeeperDarkerLoaded) {
            ItemInit.ITEMS
                    .put(MedievalMain.id("warden_small_axe"),
                            new SmallAxeItem(DDTiers.WARDEN,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 5, -2.9f).with(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                                            new EntityAttributeModifier(SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("warden_long_sword"),
                            new LongSwordItem(DDTiers.WARDEN,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 6, -3.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("warden_dagger"),
                            new DaggerItem(DDTiers.WARDEN,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 2, -2.0f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("warden_big_axe"),
                            new BigAxeItem(DDTiers.WARDEN,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 6, -3.4f).with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                                            new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("warden_lance"),
                            new LanceItem(DDTiers.WARDEN,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 3, -3.2f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("warden_healing_staff"),
                    new HealingStaffItem(DDTiers.WARDEN, 5, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 1, -3.3f)).fireproof()));
            ItemInit.ITEMS
                    .put(MedievalMain.id("warden_mace"),
                            new MaceItem(DDTiers.WARDEN, 3,
                                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 4, -2.8f).with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))
                                            .fireproof()));
            WARDEN_FRANCISCA_ITEM =
                    new FranciscaItem(DDTiers.WARDEN, () -> CompatEntities.WARDEN_FRANCISCA, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 1, -2.6f)));
            WARDEN_JAVELIN_ITEM =  new JavelinItem(DDTiers.WARDEN, () -> CompatEntities.WARDEN_JAVELIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 1, -2.6f)).fireproof());
            ItemInit.ITEMS.put(MedievalMain.id("warden_francisca"), WARDEN_FRANCISCA_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("warden_javelin"), WARDEN_JAVELIN_ITEM);
            ItemInit.ITEMS.put(MedievalMain.id("warden_ninjato"),
                    new NinjatoItem(DDTiers.WARDEN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 2, -2.1f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("warden_sickle"),
                    new SickleItem(DDTiers.WARDEN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 2, -2.2f)).fireproof()));
            ItemInit.ITEMS.put(MedievalMain.id("warden_rapier"),
                    new RapierItem(DDTiers.WARDEN, 3, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DDTiers.WARDEN, 2, -2.0f)).fireproof()));

            ItemInit.MATERIAL_STRINGS.add("warden");
        }

    }
}