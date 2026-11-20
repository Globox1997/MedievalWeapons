package net.medievalweapons.compat;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.init.ItemInit;
import net.medievalweapons.platform.Services;
import net.medievalweapons.platform.services.IPlatformHelper;
import net.medievalweapons.init.SoundInit;
import net.medievalweapons.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class CompatItems {

    private static final IPlatformHelper platform = Services.PLATFORM;

    public static Boolean isDragonLootLoaded = platform.isModLoaded("dragonloot");
    public static Boolean isBetterEndLoaded = platform.isModLoaded("betterend");
    public static Boolean isBetterNetherLoaded = platform.isModLoaded("betternether");
    public static Boolean isMythicMetalsLoaded = platform.isModLoaded("mythicmetals");
    public static Boolean isParadiseLostLoaded = platform.isModLoaded("paradise_lost");
    public static Boolean isBYGLoaded = platform.isModLoaded("byg");
    public static Boolean isAdditionalAdditionsLoaded = platform.isModLoaded("additionaladditions");
    public static Boolean isMythicUpgradesLoaded = platform.isModLoaded("mythicupgrades");
    public static Boolean isDeeperDarkerLoaded = platform.isModLoaded("deeperdarker");
    public static Boolean isEarlyStageLoaded = platform.isModLoaded("earlystage");
    public static Boolean isOblivionLoaded = platform.isModLoaded("oblivion");

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

    public record CompatMaterial(String name, String modId, ToolMaterial material, Identifier repairItem, boolean fireResistant, boolean franciscaFireResistant, boolean franciscaAttributes,
            int healingAddition, int maceAddition, int rapierAddition) {
    }

    public static final List<CompatMaterial> MATERIALS = List.of(
            material("terminite", "betterend", BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1230, 8.5F, 3.0F, 14, "betterend:terminite_ingot", false, false, 4, 2, 2),
            material("aeternium", "betterend", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2196, 10.0F, 4.5F, 18, "betterend:aeternium_ingot", false, false, 4, 2, 2),
            material("thallasium", "betterend", BlockTags.INCORRECT_FOR_IRON_TOOL, 320, 7.0F, 1.5F, 12, "betterend:thallasium_ingot", false, false, 3, 1, 1),
            material("nether_ruby", "betternether", BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2561, 7.1F, 3.1F, 18, "betternether:nether_ruby", true, true, 2, 1, 1),
            material("cincinnasite", "betternether", BlockTags.INCORRECT_FOR_IRON_TOOL, 512, 6.2F, 2.5F, 16, "betternether:cincinnasite_ingot", true, true, 3, 1, 1),
            material("cincinnasite_diamond", "betternether", BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2061, 8.2F, 3.7F, 14, "minecraft:diamond", true, true, 5, 3, 3),
            material("dragon", "dragonloot", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1961, 12.0F, 5.0F, 20, "dragonloot:dragon_scale", true, true, 5, 3, 3),
            material("adamantite", "mythicmetals", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1024, 7.0F, 5.0F, 16, "mythicmetals:adamantite_ingot", true, true, 4, 2, 3),
            material("olvite", "paradise_lost", BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 4.5F, 2.0F, 14, "paradise_lost:olvite", true, true, 4, 1, 2),
            material("pendorite", "byg", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2500, 10.0F, 4.0F, 15, "byg:pendorite_ingot", true, true, 4, 2, 2),
            material("gilded_netherite", "additionaladditions", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 10.0F, 2.0F, 20, "minecraft:netherite_ingot", true, true, 5, 3, 3),
            material("rose_gold", "additionaladditions", BlockTags.INCORRECT_FOR_IRON_TOOL, 900, 9.0F, 2.0F, 17, "minecraft:copper_ingot", true, true, 3, 1, 1),
            material("ruby_netherite", "mythicupgrades", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2923, 13.0F, 5.0F, 18, "mythicupgrades:ruby", true, true, 5, 3, 3),
            material("sapphire_netherite", "mythicupgrades", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2923, 10.0F, 5.0F, 18, "mythicupgrades:sapphire", true, true, 5, 3, 3),
            material("warden", "deeperdarker", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2519, 10.0F, 5.0F, 18, "deeperdarker:reinforced_echo_shard", true, true, 5, 3, 3),
            material("steel", "earlystage", BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 7.0F, 2.0F, 14, "earlystage:steel_ingot", false, true, 5, 3, 3),
            material("damascus_steel", "earlystage", BlockTags.INCORRECT_FOR_IRON_TOOL, 720, 7.0F, 2.5F, 16, "earlystage:damascus_steel_ingot", false, true, 5, 3, 3),
            material("fiery_netherite", "oblivion", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2331, 9.5F, 4.5F, 16, "oblivion:fiery_netherite_ingot", true, true, 5, 3, 3),
            material("scarlet", "oblivion", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2631, 10.0F, 5.0F, 20, "oblivion:scarlet_ingot", true, true, 5, 3, 3),
            material("solarite", "oblivion", BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2931, 11.0F, 5.5F, 25, "oblivion:solarite_ingot", true, true, 5, 3, 3)
    );

    public static TagKey<Item> repairTag(String materialName) {
        return TagKey.create(Registries.ITEM, MedievalMain.identifierOf("repair/" + materialName));
    }

    private static CompatMaterial material(String name, String modId, TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue,
            String repairItem, boolean fireResistant, boolean franciscaAttributes, int healingAddition, int maceAddition, int rapierAddition) {
        boolean franciscaFireResistant = modId.equals("oblivion");
        ToolMaterial toolMaterial = new ToolMaterial(incorrectBlocksForDrops, durability, speed, attackDamageBonus, enchantmentValue, repairTag(name));
        return new CompatMaterial(name, modId, toolMaterial, Identifier.parse(repairItem), fireResistant, franciscaFireResistant, franciscaAttributes, healingAddition, maceAddition,
                rapierAddition);
    }

    public static void loadItems(BiConsumer<Identifier, Item> registrar) {
        for (CompatMaterial material : MATERIALS) {
            if (platform.isModLoaded(material.modId())) {
                registerMaterial(material, registrar);
            }
        }
    }

    private static void registerMaterial(CompatMaterial compat, BiConsumer<Identifier, Item> registrar) {
        ToolMaterial material = compat.material();

        put(registrar, compat, "small_axe", (id, p) -> new SmallAxeItem(WeaponProperties.sword(p, material, 5, -2.9f,
                WeaponProperties.bonus(Attributes.ATTACK_KNOCKBACK, SmallAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D))));
        put(registrar, compat, "long_sword", (id, p) -> new LongSwordItem(WeaponProperties.weaponBlocking(WeaponProperties.sword(p, material, 6, -3.0f,
                WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, LongSwordItem.ATTACK_BONUS_MODIFIER_ID, 0.8f)), SoundInit.SWORD_PARRYING_KEY)));
        put(registrar, compat, "dagger", (id, p) -> new DaggerItem(WeaponProperties.sword(p, material, 2, -2.0f,
                WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, DaggerItem.ATTACK_BONUS_MODIFIER_ID, -1.0f))));
        put(registrar, compat, "big_axe", (id, p) -> new BigAxeItem(WeaponProperties.weaponBlocking(WeaponProperties.sword(p, material, 6, -3.4f,
                WeaponProperties.bonus(Attributes.SWEEPING_DAMAGE_RATIO, BigAxeItem.ATTACK_BONUS_MODIFIER_ID, 1.0D)), SoundInit.PARRYING_KEY)));
        put(registrar, compat, "lance", (id, p) -> new LanceItem(WeaponProperties.sword(p, material, 3, -3.2f,
                WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, LanceItem.ATTACK_BONUS_MODIFIER_ID, 1.5f))));
        put(registrar, compat, "healing_staff", (id, p) -> new HealingStaffItem(material, compat.healingAddition(),
                WeaponProperties.staffBlocking(WeaponProperties.sword(p, material, 1, -3.3f))));
        put(registrar, compat, "mace", (id, p) -> new MaceItem(material, compat.maceAddition(), WeaponProperties.sword(p, material, 4, -2.8f,
                WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, LongSwordItem.ATTACK_BONUS_MODIFIER_ID, -0.5f))));
        put(registrar, compat, "francisca", (id, p) -> new FranciscaItem(material, () -> ItemInit.franciscaType(id), compat.franciscaAttributes()
                ? WeaponProperties.sword(p, material, 1, -2.6f) : WeaponProperties.swordWithoutAttributes(p, material)));
        put(registrar, compat, "javelin", (id, p) -> Services.items().createJavelin(material, () -> ItemInit.javelinType(id), WeaponProperties.sword(p, material, 1, -2.6f)));
        put(registrar, compat, "ninjato", (id, p) -> new NinjatoItem(WeaponProperties.sword(p, material, 2, -2.1f)));
        put(registrar, compat, "sickle", (id, p) -> new SickleItem(WeaponProperties.sword(p, material, 2, -2.2f)));
        put(registrar, compat, "rapier", (id, p) -> new RapierItem(material, compat.rapierAddition(), WeaponProperties.sword(p, material, 2, -2.0f)));
    }

    private static void put(BiConsumer<Identifier, Item> registrar, CompatMaterial compat, String weapon, BiFunction<Identifier, Item.Properties, Item> factory) {
        Identifier id = MedievalMain.identifierOf(compat.name() + "_" + weapon);
        Item.Properties properties = WeaponProperties.of(id);
        if (weapon.equals("francisca") ? compat.franciscaFireResistant() : compat.fireResistant()) {
            properties = properties.fireResistant();
        }
        registrar.accept(id, factory.apply(id, properties));
    }

}
