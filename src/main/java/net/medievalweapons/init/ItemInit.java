package net.medievalweapons.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.compat.CompatRecipes;
import net.medievalweapons.entity.FranciscaEntity;
import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.item.MaceItem;
import net.medievalweapons.item.*;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.*;


public class ItemInit {

    // Item Group
    public static final RegistryKey<ItemGroup> MEDIEVALWEAPONS_ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of("medievalweapons", "item_group"));

    // Lists
    public static final ArrayList<String> MATERIAL_STRINGS = new ArrayList<>(Arrays.asList("wooden", "stone", "iron", "golden", "diamond", "netherite"));
    public static final ArrayList<String> ITEM_STRINGS = new ArrayList<>(
            Arrays.asList("small_axe", "long_sword", "dagger", "francisca", "big_axe", "javelin", "lance", "healing_staff", "mace", "ninjato", "sickle", "rapier"));
    public static final Set<Item> CUSTOM_MODEL_ITEMS = new HashSet<>();
    // Map
    public static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public record WeaponType(
            String suffix,
            WeaponFactory constructor,
            int damage,
            float speed,
            boolean hasEntity,
            @Nullable RegistryEntry<EntityAttribute> attribute,
            @Nullable EntityAttributeModifier modifier,
            @Nullable AttributeModifierSlot slot,
            String[] pattern
    ) {
    }

    @FunctionalInterface
    interface WeaponFactory {
        Item create(ToolMaterial material, Item.Settings settings, String fullId);
    }

    // TODO: USE PATTERN TO GENERATE RECIPES
    public static final List<WeaponType> TYPES = List.of(
            new WeaponType("small_axe", (material, settings, id) -> new SmallAxeItem(material, settings), ConfigInit.CONFIG.battle_axe_attack_damage, ConfigInit.CONFIG.battle_axe_attack_speed, false, null, null, null, new String[]{"iii", "ipi", " s "}),
            new WeaponType("long_sword", (material, settings, id) -> new LongSwordItem(material, settings), ConfigInit.CONFIG.long_sword_attack_damage, ConfigInit.CONFIG.long_sword_attack_speed, false, EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.long_sword_range, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND, new String[]{"i", "s"}),
            new WeaponType("dagger", (material, settings, id) -> new DaggerItem(material, settings), ConfigInit.CONFIG.dagger_attack_damage, ConfigInit.CONFIG.dagger_attack_speed, false, EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.dagger_range, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND, new String[]{"i", "i", "p"}),
            new WeaponType("big_axe", (material, settings, id) -> new BigAxeItem(material, settings), ConfigInit.CONFIG.war_axe_attack_damage, ConfigInit.CONFIG.war_axe_attack_speed, false, EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.war_axe_sweeping_ratio, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND, new String[]{" i ", " i ", "isi"}),
            new WeaponType("lance", (material, settings, id) -> new LanceItem(material, settings), ConfigInit.CONFIG.lance_attack_damage, ConfigInit.CONFIG.lance_attack_speed, false, EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.lance_range, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND, new String[]{" i", "ii", "is"}),
            new WeaponType("healing_staff", (material, settings, id) -> new HealingStaffItem(material, -1, settings), ConfigInit.CONFIG.healing_staff_attack_damage, ConfigInit.CONFIG.healing_staff_attack_speed, false, EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(HealingStaffItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.healing_staff_range, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND, new String[]{" i", "ii", "s "}),
            new WeaponType("mace", (material, settings, id) -> new MaceItem(material, -1, settings), ConfigInit.CONFIG.mace_attack_damage, ConfigInit.CONFIG.mace_attack_speed, false, EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(MaceItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.mace_range, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND, new String[]{"b", "i", "s"}),
            new WeaponType("ninjato", (material, settings, id) -> new NinjatoItem(material, settings), ConfigInit.CONFIG.ninjato_attack_damage, ConfigInit.CONFIG.ninjato_attack_speed, false, null, null, null, new String[]{"  i", " i ", "s  "}),
            new WeaponType("sickle", (material, settings, id) -> new SickleItem(material, settings), ConfigInit.CONFIG.sickle_attack_damage, ConfigInit.CONFIG.sickle_attack_speed, false, null, null, null, new String[]{" ii", "iip", "i s"}),
            new WeaponType("rapier", (material, settings, id) -> new RapierItem(material, -1, settings), ConfigInit.CONFIG.rapier_attack_damage, ConfigInit.CONFIG.rapier_attack_speed, false, null, null, null, new String[]{"i", "p"}),
            new WeaponType("francisca", (material, settings, id) ->
                    new FranciscaItem(material, () -> (EntityType<FranciscaEntity>) EntityInit.ENTITY_TYPES.get(MedievalMain.identifierOf(id)), settings), ConfigInit.CONFIG.francisca_attack_damage, ConfigInit.CONFIG.francisca_attack_speed, true, null, null, null, new String[]{"xi", "s "}),
            new WeaponType("javelin", (material, settings, id) ->
                    new JavelinItem(material, () -> (EntityType<JavelinEntity>) EntityInit.ENTITY_TYPES.get(MedievalMain.identifierOf(id)), settings), ConfigInit.CONFIG.javelin_attack_damage, ConfigInit.CONFIG.javelin_attack_speed, true, EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(JavelinItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.javelin_range, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND, new String[]{"i", "x", "p"})
    );


    // Thalleous Sword
    public static final Item THALLEOUS_SWORD = register("thalleous_sword",
            new HeroSwordItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, ConfigInit.CONFIG.thalleous_sword_attack_damage, ConfigInit.CONFIG.thalleous_sword_attack_speed)
                    .with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.thalleous_sword_range, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.MAINHAND)
                    .with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(HeroSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.thalleous_sword_sweeping_ratio, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.MAINHAND))));
    // Deathsinger Sword
    public static final Item DEATHSINGER_SWORD = register("deathsinger_sword",
            new HeroSwordItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, ConfigInit.CONFIG.deathsinger_sword_attack_damage, ConfigInit.CONFIG.deathsinger_sword_attack_speed)
                    .with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.deathsinger_sword_range, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.MAINHAND)
                    .with(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO, new EntityAttributeModifier(HeroSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.deathsinger_sword_sweeping_ratio, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.MAINHAND))));

    // Long Bow
    public static final Item LONG_BOW_ITEM = register("long_bow", new LongBowItem(new Item.Settings().maxDamage(443)));
    // Recurve Bow
    public static final Item RECURVE_BOW_ITEM = register("recurve_bow", new RecurveBowItem(new Item.Settings().maxDamage(361)));

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, MEDIEVALWEAPONS_ITEM_GROUP,
                FabricItemGroup.builder().icon(() -> new ItemStack(THALLEOUS_SWORD)).displayName(Text.translatable("item.medievalweapons.item_group")).build());

        for (ToolMaterials toolMaterial : ToolMaterials.values()) {
            for (WeaponType type : TYPES) {

                String fullName = getFormattedName(toolMaterial, type.suffix());

                Item.Settings settings = createWeaponSettings(toolMaterial, type);
                if (toolMaterial == ToolMaterials.NETHERITE) settings = settings.fireproof();

                Item weapon = type.constructor().create(toolMaterial, settings, fullName);
                register(fullName, weapon);

                if (type.hasEntity()) {
                    registerWeaponEntity(fullName, weapon);
                }
            }
        }

        CompatItems.loadItems();
        CompatRecipes.createRecipes();
        CompatRecipes.loadRecipes();

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registries.ITEM, id, ITEMS.get(id));
            addCustomModelItem(ITEMS.get(id));
            ItemGroupEvents.modifyEntriesEvent(MEDIEVALWEAPONS_ITEM_GROUP).register(entries -> entries.add(ITEMS.get(id)));
        }
    }


    public static Item register(String id, Item item) {
        addCustomModelItem(item);
        return register(MedievalMain.identifierOf(id), item);
    }

    private static Item register(Identifier id, Item item) {
        ItemGroupEvents.modifyEntriesEvent(MEDIEVALWEAPONS_ITEM_GROUP).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, id, item);
    }

    public static String getFormattedName(ToolMaterials mat, String suffix) {
        String matName = mat.name().toLowerCase();
        if (matName.equals("gold")) matName = "golden";
        if (matName.equals("wood")) matName = "wooden";
        return matName + "_" + suffix;
    }

    private static Item.Settings createWeaponSettings(ToolMaterial mat, WeaponType type) {
        AttributeModifiersComponent modifiers = SwordItem.createAttributeModifiers(mat, type.damage(), type.speed());

        if (type.attribute() != null && type.modifier() != null) {
            modifiers = modifiers.with(type.attribute(), type.modifier(), type.slot());
        }

        return new Item.Settings().attributeModifiers(modifiers);
    }

    private static void registerWeaponEntity(String id, Item item) {
        EntityType type = null;
        if (item instanceof FranciscaItem) {
            type = EntityType.Builder.<FranciscaEntity>create(
                    (entity, world) -> new FranciscaEntity(entity, world, (FranciscaItem) item),
                    SpawnGroup.MISC).dimensions(0.5F, 0.5F).build();
        } else if (item instanceof JavelinItem) {
            type = EntityType.Builder.<JavelinEntity>create(
                    (entity, world) -> new JavelinEntity(entity, world, (JavelinItem) item),
                    SpawnGroup.MISC).dimensions(0.5F, 0.5F).build();
        }
        EntityInit.register(id, type);
    }

    private static void addCustomModelItem(Item item) {
        if (item instanceof LongSwordItem || item instanceof SmallAxeItem || item instanceof BigAxeItem || item instanceof LanceItem
                || item instanceof HealingStaffItem || item instanceof JavelinItem || item instanceof MaceItem || item instanceof SickleItem
                || item instanceof RapierItem || item instanceof HeroSwordItem) {
            CUSTOM_MODEL_ITEMS.add(item);
        }
    }

}
