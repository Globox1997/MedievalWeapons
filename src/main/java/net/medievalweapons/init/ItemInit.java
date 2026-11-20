package net.medievalweapons.init;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.EnchantmentEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.util.TriState;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.compat.CompatRecipes;
import net.medievalweapons.entity.FranciscaEntity;
import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.item.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.Nullable;

import java.util.*;


public class ItemInit {

    // Item Group
    public static final ResourceKey<CreativeModeTab> MEDIEVALWEAPONS_ITEM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath("medievalweapons", "item_group"));

    // Lists
    public static final ArrayList<String> MATERIAL_STRINGS = new ArrayList<>(Arrays.asList("wooden", "stone", "iron", "golden", "diamond", "netherite"));
    public static final ArrayList<String> ITEM_STRINGS = new ArrayList<>(
            Arrays.asList("small_axe", "long_sword", "dagger", "francisca", "big_axe", "javelin", "lance", "healing_staff", "mace", "ninjato", "sickle", "rapier"));
    public static final Set<Item> CUSTOM_MODEL_ITEMS = new HashSet<>();
    // Map
    public static final Map<ResourceLocation, Item> ITEMS = new LinkedHashMap<>();
    private static final List<Item> GROUP_ITEMS = new ArrayList<>();

    public record WeaponType(
            String suffix,
            WeaponFactory constructor,
            int damage,
            float speed,
            boolean hasEntity,
            @Nullable Holder<Attribute> attribute,
            @Nullable AttributeModifier modifier,
            @Nullable EquipmentSlotGroup slot,
            String[] pattern
    ) {
    }

    @FunctionalInterface
    interface WeaponFactory {
        Item create(Tier material, Item.Properties settings, String fullId);
    }

    // TODO: USE PATTERN TO GENERATE RECIPES
    public static final List<WeaponType> TYPES = List.of(
            new WeaponType("small_axe", (material, settings, id) -> new SmallAxeItem(material, settings), ConfigInit.CONFIG.battle_axe_attack_damage, ConfigInit.CONFIG.battle_axe_attack_speed, false, null, null, null, new String[]{"iii", "ipi", " s "}),
            new WeaponType("long_sword", (material, settings, id) -> new LongSwordItem(material, settings), ConfigInit.CONFIG.long_sword_attack_damage, ConfigInit.CONFIG.long_sword_attack_speed, false, Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.long_sword_range, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND, new String[]{"i", "s"}),
            new WeaponType("dagger", (material, settings, id) -> new DaggerItem(material, settings), ConfigInit.CONFIG.dagger_attack_damage, ConfigInit.CONFIG.dagger_attack_speed, false, Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(DaggerItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.dagger_range, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND, new String[]{"i", "i", "p"}),
            new WeaponType("big_axe", (material, settings, id) -> new BigAxeItem(material, settings), ConfigInit.CONFIG.war_axe_attack_damage, ConfigInit.CONFIG.war_axe_attack_speed, false, Attributes.SWEEPING_DAMAGE_RATIO, new AttributeModifier(BigAxeItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.war_axe_sweeping_ratio, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND, new String[]{" i ", " i ", "isi"}),
            new WeaponType("lance", (material, settings, id) -> new LanceItem(material, settings), ConfigInit.CONFIG.lance_attack_damage, ConfigInit.CONFIG.lance_attack_speed, false, Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(LanceItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.lance_range, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND, new String[]{" i", "ii", "is"}),
            new WeaponType("healing_staff", (material, settings, id) -> new HealingStaffItem(material, -1, settings), ConfigInit.CONFIG.healing_staff_attack_damage, ConfigInit.CONFIG.healing_staff_attack_speed, false, Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(HealingStaffItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.healing_staff_range, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND, new String[]{" i", "ii", "s "}),
            new WeaponType("mace", (material, settings, id) -> new MaceItem(material, -1, settings), ConfigInit.CONFIG.mace_attack_damage, ConfigInit.CONFIG.mace_attack_speed, false, Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(MaceItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.mace_range, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND, new String[]{"b", "i", "s"}),
            new WeaponType("ninjato", (material, settings, id) -> new NinjatoItem(material, settings), ConfigInit.CONFIG.ninjato_attack_damage, ConfigInit.CONFIG.ninjato_attack_speed, false, null, null, null, new String[]{"  i", " i ", "s  "}),
            new WeaponType("sickle", (material, settings, id) -> new SickleItem(material, settings), ConfigInit.CONFIG.sickle_attack_damage, ConfigInit.CONFIG.sickle_attack_speed, false, null, null, null, new String[]{" ii", "iip", "i s"}),
            new WeaponType("rapier", (material, settings, id) -> new RapierItem(material, -1, settings), ConfigInit.CONFIG.rapier_attack_damage, ConfigInit.CONFIG.rapier_attack_speed, false, null, null, null, new String[]{"i", "p"}),
            new WeaponType("francisca", (material, settings, id) ->
                    new FranciscaItem(material, () -> (EntityType<FranciscaEntity>) EntityInit.ENTITY_TYPES.get(MedievalMain.identifierOf(id)), settings), ConfigInit.CONFIG.francisca_attack_damage, ConfigInit.CONFIG.francisca_attack_speed, true, null, null, null, new String[]{"xi", "s "}),
            new WeaponType("javelin", (material, settings, id) ->
                    new JavelinItem(material, () -> (EntityType<JavelinEntity>) EntityInit.ENTITY_TYPES.get(MedievalMain.identifierOf(id)), settings), ConfigInit.CONFIG.javelin_attack_damage, ConfigInit.CONFIG.javelin_attack_speed, true, Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(JavelinItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.javelin_range, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND, new String[]{"i", "x", "p"})
    );


    // Thalleous Sword
    public static final Item THALLEOUS_SWORD = register("thalleous_sword",
            new HeroSwordItem(Tiers.DIAMOND, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.WOOD, ConfigInit.CONFIG.thalleous_sword_attack_damage, ConfigInit.CONFIG.thalleous_sword_attack_speed)
                    .withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.thalleous_sword_range, AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND)
                    .withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO, new AttributeModifier(HeroSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.thalleous_sword_sweeping_ratio, AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND))));
    // Deathsinger Sword
    public static final Item DEATHSINGER_SWORD = register("deathsinger_sword",
            new HeroSwordItem(Tiers.DIAMOND, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.WOOD, ConfigInit.CONFIG.deathsinger_sword_attack_damage, ConfigInit.CONFIG.deathsinger_sword_attack_speed)
                    .withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.deathsinger_sword_range, AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND)
                    .withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO, new AttributeModifier(HeroSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.deathsinger_sword_sweeping_ratio, AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND))));

    // Tidesinger Sword
    public static final Item TIDESINGER_STAFF = register("tidesinger_staff",
            new HeroStaffItem(Tiers.DIAMOND, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.WOOD, ConfigInit.CONFIG.tidesinger_staff_attack_damage, ConfigInit.CONFIG.tidesinger_staff_attack_speed)
                    .withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(LongSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.tidesinger_staff_range, AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND)
                    .withModifierAdded(Attributes.SWEEPING_DAMAGE_RATIO, new AttributeModifier(HeroSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.tidesinger_staff_sweeping_ratio, AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND))));

    // Long Bow
    public static final Item LONG_BOW_ITEM = register("long_bow", new LongBowItem(new Item.Properties().durability(443)));
    // Recurve Bow
    public static final Item RECURVE_BOW_ITEM = register("recurve_bow", new RecurveBowItem(new Item.Properties().durability(361)));

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MEDIEVALWEAPONS_ITEM_GROUP,
                FabricItemGroup.builder().icon(() -> new ItemStack(THALLEOUS_SWORD)).title(Component.translatable("item.medievalweapons.item_group")).build());
        ItemGroupEvents.modifyEntriesEvent(MEDIEVALWEAPONS_ITEM_GROUP).register(entries -> GROUP_ITEMS.forEach(entries::accept));

        for (Tiers toolMaterial : Tiers.values()) {
            for (WeaponType type : TYPES) {

                String fullName = getFormattedName(toolMaterial, type.suffix());

                Item.Properties settings = createWeaponSettings(toolMaterial, type);
                if (toolMaterial == Tiers.NETHERITE) settings = settings.fireResistant();

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

        for (Map.Entry<ResourceLocation, Item> entry : ITEMS.entrySet()) {
            Registry.register(BuiltInRegistries.ITEM, entry.getKey(), entry.getValue());
            addCustomModelItem(entry.getValue());
            GROUP_ITEMS.add(entry.getValue());
        }

        EnchantmentEvents.ALLOW_ENCHANTING.register((enchantment, target, enchantingContext) -> {
            if (target.getItem() instanceof JavelinItem && (enchantment.is(Enchantments.IMPALING) || enchantment.is(Enchantments.PIERCING) || enchantment.is(Enchantments.LOYALTY))) {
                return TriState.TRUE;
            }
            return TriState.DEFAULT;
        });

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                DaggerItem.updateAttackBonus(player);
                LanceItem.updateAttackBonus(player);
            }
        });
    }


    public static Item register(String id, Item item) {
        addCustomModelItem(item);
        return register(MedievalMain.identifierOf(id), item);
    }

    private static Item register(ResourceLocation id, Item item) {
        GROUP_ITEMS.add(item);
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static String getFormattedName(Tiers mat, String suffix) {
        String matName = mat.name().toLowerCase();
        if (matName.equals("gold")){
            matName = "golden";
        }
        if (matName.equals("wood")){
            matName = "wooden";
        }
        return matName + "_" + suffix;
    }

    private static Item.Properties createWeaponSettings(Tier mat, WeaponType type) {
        ItemAttributeModifiers modifiers = SwordItem.createAttributes(mat, type.damage(), type.speed());

        if (type.attribute() != null && type.modifier() != null) {
            modifiers = modifiers.withModifierAdded(type.attribute(), type.modifier(), type.slot());
        }

        return new Item.Properties().attributes(modifiers);
    }

    private static void registerWeaponEntity(String id, Item item) {
        EntityType type = null;
        if (item instanceof FranciscaItem) {
            type = EntityType.Builder.<FranciscaEntity>of((entity, world) -> new FranciscaEntity(entity, world, (FranciscaItem) item), MobCategory.MISC).sized(0.5F, 0.5F).build();
        } else if (item instanceof JavelinItem) {
            type = EntityType.Builder.<JavelinEntity>of((entity, world) -> new JavelinEntity(entity, world, (JavelinItem) item), MobCategory.MISC).sized(0.5F, 0.5F).build();
        }
        EntityInit.register(id, type);
    }

    private static void addCustomModelItem(Item item) {
        if (item instanceof LongSwordItem || item instanceof SmallAxeItem || item instanceof BigAxeItem || item instanceof LanceItem
                || item instanceof HealingStaffItem || item instanceof JavelinItem || item instanceof MaceItem || item instanceof SickleItem
                || item instanceof RapierItem || item instanceof HeroSwordItem || item instanceof HeroStaffItem) {
            CUSTOM_MODEL_ITEMS.add(item);
        }
    }

}
