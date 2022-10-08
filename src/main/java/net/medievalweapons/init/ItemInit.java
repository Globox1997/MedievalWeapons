package net.medievalweapons.init;

import java.util.ArrayList;
import java.util.Arrays;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.compat.CompatRecipes;
import net.medievalweapons.item.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.signature.qual.Identifier;

import javax.crypto.Mac;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MedievalMain.MOD_ID);

    // Lists
    public static final ArrayList<String> MATERIAL_STRINGS = new ArrayList<String>(Arrays.asList("wooden", "stone", "iron", "golden", "diamond", "netherite"));
    public static final ArrayList<String> ITEM_STRINGS = new ArrayList<String>(
            Arrays.asList("small_axe", "long_sword", "dagger", "francisca", "big_axe", "javelin", "lance", "healing_staff", "mace", "ninjato", "sickle", "rapier"));
    // Map

    // Small Axe
    public static final RegistryObject<Small_Axe_Item> WOODEN_SMALL_AXE_ITEM = ITEMS.register("wooden_small_axe", () ->new Small_Axe_Item(Tiers.WOOD, 5, -2.9F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Small_Axe_Item> STONE_SMALL_AXE_ITEM = ITEMS.register("stone_small_axe", () ->new Small_Axe_Item(Tiers.STONE, 5, -2.9F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Small_Axe_Item> IRON_SMALL_AXE_ITEM = ITEMS.register("iron_small_axe", () ->new Small_Axe_Item(Tiers.IRON, 5, -2.9F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Small_Axe_Item> GOLDEN_SMALL_AXE_ITEM = ITEMS.register("golden_small_axe", () ->new Small_Axe_Item(Tiers.GOLD, 5, -2.9F, new Item.Properties().tab(MedievalMain.GROUP)));
public static final RegistryObject<Small_Axe_Item> DIAMOND_SMALL_AXE_ITEM = ITEMS.register("diamond_small_axe", () ->new Small_Axe_Item(Tiers.DIAMOND, 5, -2.9F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Small_Axe_Item> NETHERITE_SMALL_AXE_ITEM = ITEMS.register("netherite_small_axe",() ->
            new Small_Axe_Item(Tiers.NETHERITE, 5, -2.9F, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Long Sword
    public static final RegistryObject<Long_Sword_Item> WOOD_LONG_SWORD_ITEM = ITEMS.register("wooden_long_sword", () ->new Long_Sword_Item(Tiers.WOOD, 6, -3.0F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Long_Sword_Item> STONE_LONG_SWORD_ITEM = ITEMS.register("stone_long_sword", () ->new Long_Sword_Item(Tiers.STONE, 6, -3.0F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Long_Sword_Item> IRON_LONG_SWORD_ITEM = ITEMS.register("iron_long_sword", () ->new Long_Sword_Item(Tiers.IRON, 6, -3.0F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Long_Sword_Item> GOLDEN_LONG_SWORD_ITEM = ITEMS.register("golden_long_sword", () ->new Long_Sword_Item(Tiers.GOLD, 6, -3.0F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Long_Sword_Item> DIAMOND_LONG_SWORD_ITEM = ITEMS.register("diamond_long_sword", () ->new Long_Sword_Item(Tiers.DIAMOND, 6, -3.0F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Long_Sword_Item> NETHERITE_LONG_SWORD_ITEM = ITEMS.register("netherite_long_sword",() ->
            new Long_Sword_Item(Tiers.NETHERITE, 6, -3.0F, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Dagger
    public static final RegistryObject<Dagger_Item> WOOD_DAGGER_ITEM = ITEMS.register("wooden_dagger", () ->new Dagger_Item(Tiers.WOOD, 2, -2.0F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Dagger_Item> STONE_DAGGER_ITEM = ITEMS.register("stone_dagger", () ->new Dagger_Item(Tiers.STONE, 2, -2.0F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Dagger_Item> IRON_DAGGER_ITEM = ITEMS.register("iron_dagger", () ->new Dagger_Item(Tiers.IRON, 2, -2.0F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Dagger_Item> GOLDEN_DAGGER_ITEM = ITEMS.register("golden_dagger", () ->new Dagger_Item(Tiers.GOLD, 2, -2.0F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Dagger_Item> DIAMOND_DAGGER_ITEM = ITEMS.register("diamond_dagger", () ->new Dagger_Item(Tiers.DIAMOND, 2, -2.0F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Dagger_Item> NETHERITE_DAGGER_ITEM = ITEMS.register("netherite_dagger",() ->
            new Dagger_Item(Tiers.NETHERITE, 2, -2.0F, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Francisca
    public static final RegistryObject<Francisca_Item> WOODEN_FRANCISCA_ITEM = ITEMS.register("wooden_francisca",() ->
            new Francisca_Item(Tiers.WOOD, 1.0F, -2.6F,  EntityInit.WOODEN_FRANCISCA, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Francisca_Item> STONE_FRANCISCA_ITEM = ITEMS.register("stone_francisca",() ->
            new Francisca_Item(Tiers.STONE, 1.0F, -2.6F,  EntityInit.STONE_FRANCISCA, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Francisca_Item> IRON_FRANCISCA_ITEM = ITEMS.register("iron_francisca",() ->
            new Francisca_Item(Tiers.IRON, 1.0F, -2.6F,  EntityInit.IRON_FRANCISCA, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Francisca_Item> GOLDEN_FRANCISCA_ITEM = ITEMS.register("golden_francisca",() ->
            new Francisca_Item(Tiers.GOLD, 1.0F, -2.6F,  EntityInit.GOLDEN_FRANCISCA, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Francisca_Item> DIAMOND_FRANCISCA_ITEM = ITEMS.register("diamond_francisca",() ->
            new Francisca_Item(Tiers.DIAMOND, 1.0F, -2.6F,  EntityInit.DIAMOND_FRANCISCA, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Francisca_Item> NETHERITE_FRANCISCA_ITEM = ITEMS.register("netherite_francisca",() ->
            new Francisca_Item(Tiers.NETHERITE, 1.0F, -2.6F,  EntityInit.NETHERITE_FRANCISCA, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Big Axe
    public static final RegistryObject<Big_Axe_Item> WOODEN_BIG_AXE_ITEM = ITEMS.register("wooden_big_axe", () ->new Big_Axe_Item(Tiers.WOOD, 6, -3.4F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Big_Axe_Item> STONE_BIG_AXE_ITEM = ITEMS.register("stone_big_axe", () ->new Big_Axe_Item(Tiers.STONE, 6, -3.4F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Big_Axe_Item> IRON_BIG_AXE_ITEM = ITEMS.register("iron_big_axe", () ->new Big_Axe_Item(Tiers.IRON, 6, -3.4F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Big_Axe_Item> GOLDEN_BIG_AXE_ITEM = ITEMS.register("golden_big_axe",() -> new Big_Axe_Item(Tiers.GOLD, 6, -3.4F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Big_Axe_Item> DIAMOND_BIG_AXE_ITEM = ITEMS.register("diamond_big_axe", () ->new Big_Axe_Item(Tiers.DIAMOND, 6, -3.4F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Big_Axe_Item> NETHERITE_BIG_AXE_ITEM = ITEMS.register("netherite_big_axe",() ->
            new Big_Axe_Item(Tiers.NETHERITE, 6, -3.4F, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Javelin
    public static final RegistryObject<Javelin_Item> WOODEN_JAVELIN_ITEM = ITEMS.register("wooden_javelin",() ->
            new Javelin_Item(Tiers.WOOD, 2.2F, -2.7F,  EntityInit.WOODEN_JAVELIN, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Javelin_Item> STONE_JAVELIN_ITEM = ITEMS.register("stone_javelin",() ->
            new Javelin_Item(Tiers.STONE, 2.2F, -2.7F,  EntityInit.STONE_JAVELIN, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Javelin_Item> IRON_JAVELIN_ITEM = ITEMS.register("iron_javelin",() ->
            new Javelin_Item(Tiers.IRON, 2.2F, -2.7F,  EntityInit.IRON_JAVELIN, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Javelin_Item> GOLDEN_JAVELIN_ITEM = ITEMS.register("golden_javelin",() ->
            new Javelin_Item(Tiers.GOLD, 2.2F, -2.7F,  EntityInit.GOLDEN_JAVELIN, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Javelin_Item> DIAMOND_JAVELIN_ITEM = ITEMS.register("diamond_javelin",() ->
            new Javelin_Item(Tiers.DIAMOND, 2.2F, -2.7F,  EntityInit.DIAMOND_JAVELIN, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Javelin_Item> NETHERITE_JAVELIN_ITEM = ITEMS.register("netherite_javelin", ()->
            new Javelin_Item(Tiers.NETHERITE, 2.2F, -2.7F,  EntityInit.NETHERITE_JAVELIN, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Lance
    public static final RegistryObject<Lance_Item> WOODEN_LANCE_ITEM = ITEMS.register("wooden_lance", ()->new Lance_Item(Tiers.WOOD, 3, -3.2F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Lance_Item> STONE_LANCE_ITEM = ITEMS.register("stone_lance", ()->new Lance_Item(Tiers.STONE, 3, -3.2F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Lance_Item> IRON_LANCE_ITEM = ITEMS.register("iron_lance",()-> new Lance_Item(Tiers.IRON, 3, -3.2F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Lance_Item> GOLDEN_LANCE_ITEM = ITEMS.register("golden_lance",()-> new Lance_Item(Tiers.GOLD, 3, -3.2F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Lance_Item> DIAMOND_LANCE_ITEM = ITEMS.register("diamond_lance", ()->new Lance_Item(Tiers.DIAMOND, 3, -3.2F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Lance_Item> NETHERITE_LANCE_ITEM = ITEMS.register("netherite_lance", ()->new Lance_Item(Tiers.NETHERITE, 3, -3.2F, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Healing Staff
    public static final RegistryObject<Healing_Staff_Item> WOODEN_HEALING_STAFF_ITEM = ITEMS.register("wooden_healing_staff",()->
            new Healing_Staff_Item(Tiers.WOOD, 1, -3.3F, 1, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Healing_Staff_Item> STONE_HEALING_STAFF_ITEM = ITEMS.register("stone_healing_staff",()->
            new Healing_Staff_Item(Tiers.STONE, 1, -3.3F, 2, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Healing_Staff_Item> IRON_HEALING_STAFF_ITEM = ITEMS.register("iron_healing_staff",()->
            new Healing_Staff_Item(Tiers.IRON, 1, -3.3F, 3, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Healing_Staff_Item> GOLDEN_HEALING_STAFF_ITEM = ITEMS.register("golden_healing_staff",()->
            new Healing_Staff_Item(Tiers.GOLD, 1, -3.3F, 3, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Healing_Staff_Item> DIAMOND_HEALING_STAFF_ITEM = ITEMS.register("diamond_healing_staff",()->
            new Healing_Staff_Item(Tiers.DIAMOND, 1, -3.3F, 4, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Healing_Staff_Item> NETHERITE_HEALING_STAFF_ITEM = ITEMS.register("netherite_healing_staff",()->
            new Healing_Staff_Item(Tiers.NETHERITE, 1, -3.3F, 5, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Mace
    public static final RegistryObject<Mace_Item> WOODEN_MACE_ITEM = ITEMS.register("wooden_mace", ()->new Mace_Item(Tiers.WOOD, 4, -2.8F, 0, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Mace_Item> STONE_MACE_ITEM = ITEMS.register("stone_mace", ()->new Mace_Item(Tiers.STONE, 4, -2.8F, 0, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Mace_Item> IRON_MACE_ITEM = ITEMS.register("iron_mace", ()->new Mace_Item(Tiers.IRON, 4, -2.8F, 1, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Mace_Item> GOLDEN_MACE_ITEM = ITEMS.register("golden_mace", ()->new Mace_Item(Tiers.GOLD, 4, -2.8F, 2, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Mace_Item> DIAMOND_MACE_ITEM = ITEMS.register("diamond_mace", ()->new Mace_Item(Tiers.DIAMOND, 4, -2.8F, 2, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Mace_Item> NETHERITE_MACE_ITEM = ITEMS.register("netherite_mace", ()->new Mace_Item(Tiers.NETHERITE, 4, -2.8F, 3, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Ninjato
    public static final RegistryObject<Ninjato_Item> WOODEN_NINJATO_ITEM = ITEMS.register("wooden_ninjato", ()->new Ninjato_Item(Tiers.WOOD, 2, -2.1F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Ninjato_Item> STONE_NINJATO_ITEM = ITEMS.register("stone_ninjato", ()->new Ninjato_Item(Tiers.STONE, 2, -2.1F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Ninjato_Item> IRON_NINJATO_ITEM = ITEMS.register("iron_ninjato", ()->new Ninjato_Item(Tiers.IRON, 2, -2.1F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Ninjato_Item> GOLDEN_NINJATO_ITEM = ITEMS.register("golden_ninjato", ()->new Ninjato_Item(Tiers.GOLD, 2, -2.1F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Ninjato_Item> DIAMOND_NINJATO_ITEM = ITEMS.register("diamond_ninjato", ()->new Ninjato_Item(Tiers.DIAMOND, 2, -2.1F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Ninjato_Item> NETHERITE_NINJATO_ITEM = ITEMS.register("netherite_ninjato",()->
            new Ninjato_Item(Tiers.NETHERITE, 2, -2.1F, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Sickle
    public static final RegistryObject<Sickle_Item> WOODEN_SICKLE_ITEM = ITEMS.register("wooden_sickle", ()->new Sickle_Item(Tiers.WOOD, 2, -2.3F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Sickle_Item> STONE_SICKLE_ITEM = ITEMS.register("stone_sickle", ()->new Sickle_Item(Tiers.STONE, 2, -2.3F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Sickle_Item> IRON_SICKLE_ITEM = ITEMS.register("iron_sickle", ()->new Sickle_Item(Tiers.IRON, 2, -2.3F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Sickle_Item> GOLDEN_SICKLE_ITEM = ITEMS.register("golden_sickle", ()->new Sickle_Item(Tiers.GOLD, 2, -2.3F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Sickle_Item> DIAMOND_SICKLE_ITEM = ITEMS.register("diamond_sickle", ()->new Sickle_Item(Tiers.DIAMOND, 2, -2.3F, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Sickle_Item> NETHERITE_SICKLE_ITEM = ITEMS.register("netherite_sickle",()->
            new Sickle_Item(Tiers.NETHERITE, 2, -2.3F, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Rapier
    public static final RegistryObject<Rapier_Item> WOODEN_RAPIER_ITEM = ITEMS.register("wooden_rapier", ()-> new Rapier_Item(Tiers.WOOD, 3, -2.0F, 0, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Rapier_Item> STONE_RAPIER_ITEM = ITEMS.register("stone_rapier", ()-> new Rapier_Item(Tiers.STONE, 3, -2.0F, 0, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Rapier_Item> IRON_RAPIER_ITEM = ITEMS.register("iron_rapier",  () ->new Rapier_Item(Tiers.IRON, 3, -2.0F, 1, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Rapier_Item> GOLDEN_RAPIER_ITEM = ITEMS.register("golden_rapier", () ->new Rapier_Item(Tiers.GOLD, 3, -2.0F, 2, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Rapier_Item> DIAMOND_RAPIER_ITEM = ITEMS.register("diamond_rapier", () ->new Rapier_Item(Tiers.DIAMOND, 3, -2.0F, 2, new Item.Properties().tab(MedievalMain.GROUP)));
    public static final RegistryObject<Rapier_Item> NETHERITE_RAPIER_ITEM = ITEMS.register("netherite_rapier",()->
            new Rapier_Item(Tiers.NETHERITE, 3, -2.0F, 3, new Item.Properties().tab(MedievalMain.GROUP).fireResistant()));
    // Long Bow
    public static final RegistryObject<Long_Bow_Item> LONG_BOW_ITEM = ITEMS.register("long_bow", ()-> new Long_Bow_Item(new Item.Properties().durability(443).tab(MedievalMain.GROUP)));
    // Recurve Bow
    public static final RegistryObject<Recurve_Bow_Item> RECURVE_BOW_ITEM = ITEMS.register("recurve_bow",  () ->(new Recurve_Bow_Item(new Item.Properties().durability(361).tab(MedievalMain.GROUP))));
    // Thalleous Sword
    public static final RegistryObject<Thalleous_Sword_Item> THALLEOUS_SWORD = ITEMS.register("thalleous_sword", () -> (new Thalleous_Sword_Item(Tiers.DIAMOND, 10, -3.0F, new Item.Properties().tab(MedievalMain.GROUP))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


    public static void init() {
        CompatItems.loadItems();
        CompatRecipes.createRecipes();
        CompatRecipes.loadRecipes();
    }

}