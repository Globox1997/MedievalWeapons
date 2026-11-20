package net.medievalweapons.init;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.EnchantmentEvents;
import net.fabricmc.fabric.api.util.TriState;
import net.medievalweapons.MedievalMain;
import net.medievalweapons.compat.CompatItems;
import net.medievalweapons.compat.CompatRecipes;
import net.medievalweapons.entity.FranciscaEntity;
import net.medievalweapons.entity.JavelinEntity;
import net.medievalweapons.item.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ItemInit {

    public static final ResourceKey<CreativeModeTab> MEDIEVALWEAPONS_ITEM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath("medievalweapons", "item_group"));

    public static final ArrayList<String> MATERIAL_STRINGS = new ArrayList<>(Arrays.asList("wooden", "stone", "iron", "golden", "diamond", "netherite"));
    public static final ArrayList<String> ITEM_STRINGS = new ArrayList<>(
            Arrays.asList("small_axe", "long_sword", "dagger", "francisca", "big_axe", "javelin", "lance", "healing_staff", "mace", "ninjato", "sickle", "rapier"));
    public static final Set<Item> CUSTOM_MODEL_ITEMS = new HashSet<>();
    public static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();
    private static final List<Item> GROUP_ITEMS = new ArrayList<>();

    private static final Map<String, ToolMaterial> MATERIALS = new LinkedHashMap<>();

    static {
        MATERIALS.put("wooden", ToolMaterial.WOOD);
        MATERIALS.put("stone", ToolMaterial.STONE);
        MATERIALS.put("iron", ToolMaterial.IRON);
        MATERIALS.put("diamond", ToolMaterial.DIAMOND);
        MATERIALS.put("golden", ToolMaterial.GOLD);
        MATERIALS.put("netherite", ToolMaterial.NETHERITE);
    }

    public record WeaponType(String suffix, WeaponFactory constructor, int damage, float speed, @Nullable WeaponProperties.Bonus bonus, @Nullable Holder<SoundEvent> blockSound,
            boolean staffBlocking) {
    }

    @FunctionalInterface
    public interface WeaponFactory {
        Item create(ToolMaterial material, Item.Properties settings, Identifier id);
    }

    public static final List<WeaponType> TYPES = List.of(
            new WeaponType("small_axe", (material, settings, id) -> new SmallAxeItem(settings), ConfigInit.CONFIG.battle_axe_attack_damage, ConfigInit.CONFIG.battle_axe_attack_speed, null, null,
                    false),
            new WeaponType("long_sword", (material, settings, id) -> new LongSwordItem(settings), ConfigInit.CONFIG.long_sword_attack_damage, ConfigInit.CONFIG.long_sword_attack_speed,
                    WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, LongSwordItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.long_sword_range), SoundInit.SWORD_PARRYING_EVENT, false),
            new WeaponType("dagger", (material, settings, id) -> new DaggerItem(settings), ConfigInit.CONFIG.dagger_attack_damage, ConfigInit.CONFIG.dagger_attack_speed,
                    WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, DaggerItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.dagger_range), null, false),
            new WeaponType("big_axe", (material, settings, id) -> new BigAxeItem(settings), ConfigInit.CONFIG.war_axe_attack_damage, ConfigInit.CONFIG.war_axe_attack_speed,
                    WeaponProperties.bonus(Attributes.SWEEPING_DAMAGE_RATIO, BigAxeItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.war_axe_sweeping_ratio), SoundInit.PARRYING_EVENT, false),
            new WeaponType("lance", (material, settings, id) -> new LanceItem(settings), ConfigInit.CONFIG.lance_attack_damage, ConfigInit.CONFIG.lance_attack_speed,
                    WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, LanceItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.lance_range), null, false),
            new WeaponType("healing_staff", (material, settings, id) -> new HealingStaffItem(material, -1, settings), ConfigInit.CONFIG.healing_staff_attack_damage,
                    ConfigInit.CONFIG.healing_staff_attack_speed,
                    WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, HealingStaffItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.healing_staff_range), null, true),
            new WeaponType("mace", (material, settings, id) -> new MaceItem(material, -1, settings), ConfigInit.CONFIG.mace_attack_damage, ConfigInit.CONFIG.mace_attack_speed,
                    WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, MaceItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.mace_range), null, false),
            new WeaponType("ninjato", (material, settings, id) -> new NinjatoItem(settings), ConfigInit.CONFIG.ninjato_attack_damage, ConfigInit.CONFIG.ninjato_attack_speed, null, null, false),
            new WeaponType("sickle", (material, settings, id) -> new SickleItem(settings), ConfigInit.CONFIG.sickle_attack_damage, ConfigInit.CONFIG.sickle_attack_speed, null, null, false),
            new WeaponType("rapier", (material, settings, id) -> new RapierItem(material, -1, settings), ConfigInit.CONFIG.rapier_attack_damage, ConfigInit.CONFIG.rapier_attack_speed, null, null,
                    false),
            new WeaponType("francisca", (material, settings, id) -> new FranciscaItem(material, () -> franciscaType(id), settings), ConfigInit.CONFIG.francisca_attack_damage,
                    ConfigInit.CONFIG.francisca_attack_speed, null, null, false),
            new WeaponType("javelin", (material, settings, id) -> new JavelinItem(material, () -> javelinType(id), settings), ConfigInit.CONFIG.javelin_attack_damage,
                    ConfigInit.CONFIG.javelin_attack_speed, WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, JavelinItem.ATTACK_BONUS_MODIFIER_ID, ConfigInit.CONFIG.javelin_range), null,
                    false)
    );

    public static final Item THALLEOUS_SWORD = register("thalleous_sword",
            new HeroSwordItem(heroProperties("thalleous_sword", ConfigInit.CONFIG.thalleous_sword_attack_damage, ConfigInit.CONFIG.thalleous_sword_attack_speed,
                    ConfigInit.CONFIG.thalleous_sword_range, ConfigInit.CONFIG.thalleous_sword_sweeping_ratio, SoundInit.SWORD_PARRYING_EVENT)));
    public static final Item DEATHSINGER_SWORD = register("deathsinger_sword",
            new HeroSwordItem(heroProperties("deathsinger_sword", ConfigInit.CONFIG.deathsinger_sword_attack_damage, ConfigInit.CONFIG.deathsinger_sword_attack_speed,
                    ConfigInit.CONFIG.deathsinger_sword_range, ConfigInit.CONFIG.deathsinger_sword_sweeping_ratio, SoundInit.SWORD_PARRYING_EVENT)));
    public static final Item TIDESINGER_STAFF = register("tidesinger_staff",
            new HeroStaffItem(heroProperties("tidesinger_staff", ConfigInit.CONFIG.tidesinger_staff_attack_damage, ConfigInit.CONFIG.tidesinger_staff_attack_speed,
                    ConfigInit.CONFIG.tidesinger_staff_range, ConfigInit.CONFIG.tidesinger_staff_sweeping_ratio, SoundInit.PARRYING_EVENT)));

    public static final Item LONG_BOW_ITEM = register("long_bow", new LongBowItem(WeaponProperties.of(MedievalMain.identifierOf("long_bow")).durability(443).enchantable(1)));
    public static final Item RECURVE_BOW_ITEM = register("recurve_bow", new RecurveBowItem(WeaponProperties.of(MedievalMain.identifierOf("recurve_bow")).durability(361).enchantable(1)));

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MEDIEVALWEAPONS_ITEM_GROUP,
                FabricCreativeModeTab.builder().icon(() -> new ItemStack(THALLEOUS_SWORD)).title(Component.translatable("item.medievalweapons.item_group")).build());
        CreativeModeTabEvents.modifyOutputEvent(MEDIEVALWEAPONS_ITEM_GROUP).register(output -> GROUP_ITEMS.forEach(output::accept));

        for (Map.Entry<String, ToolMaterial> material : MATERIALS.entrySet()) {
            for (WeaponType type : TYPES) {
                Identifier id = MedievalMain.identifierOf(material.getKey() + "_" + type.suffix());
                Item.Properties settings = createWeaponSettings(material.getValue(), type, id);
                if (material.getValue() == ToolMaterial.NETHERITE) {
                    settings = settings.fireResistant();
                }
                Item weapon = type.constructor().create(material.getValue(), settings, id);
                register(id, weapon);
                addCustomModelItem(weapon);
                registerWeaponEntity(id, weapon);
            }
        }

        CompatItems.loadItems();
        CompatRecipes.createRecipes();
        CompatRecipes.loadRecipes();

        for (Map.Entry<Identifier, Item> entry : ITEMS.entrySet()) {
            register(entry.getKey(), entry.getValue());
            addCustomModelItem(entry.getValue());
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

    public static Item.Properties createWeaponSettings(ToolMaterial material, WeaponType type, Identifier id) {
        Item.Properties settings = type.bonus() != null ? WeaponProperties.sword(WeaponProperties.of(id), material, type.damage(), type.speed(), type.bonus())
                : WeaponProperties.sword(WeaponProperties.of(id), material, type.damage(), type.speed());
        if (type.blockSound() != null) {
            settings = WeaponProperties.weaponBlocking(settings, type.blockSound());
        } else if (type.staffBlocking()) {
            settings = WeaponProperties.staffBlocking(settings);
        }
        return settings;
    }

    public static void registerWeaponEntity(Identifier id, Item item) {
        if (item instanceof FranciscaItem franciscaItem) {
            EntityInit.register(id, EntityInit.createFrancisca(id, franciscaItem));
        } else if (item instanceof JavelinItem javelinItem) {
            EntityInit.register(id, EntityInit.createJavelin(id, javelinItem));
        }
    }

    @SuppressWarnings("unchecked")
    public static EntityType<FranciscaEntity> franciscaType(Identifier id) {
        return (EntityType<FranciscaEntity>) EntityInit.ENTITY_TYPES.get(id);
    }

    @SuppressWarnings("unchecked")
    public static EntityType<JavelinEntity> javelinType(Identifier id) {
        return (EntityType<JavelinEntity>) EntityInit.ENTITY_TYPES.get(id);
    }

    private static Item.Properties heroProperties(String name, int damage, float speed, float range, float sweepingRatio, Holder<SoundEvent> blockSound) {
        Item.Properties settings = WeaponProperties.sword(WeaponProperties.of(MedievalMain.identifierOf(name)), ToolMaterial.DIAMOND, ToolMaterial.WOOD, damage, speed,
                WeaponProperties.bonus(Attributes.ENTITY_INTERACTION_RANGE, LongSwordItem.ATTACK_BONUS_MODIFIER_ID, range),
                WeaponProperties.bonus(Attributes.SWEEPING_DAMAGE_RATIO, HeroSwordItem.ATTACK_BONUS_MODIFIER_ID, sweepingRatio));
        return WeaponProperties.weaponBlocking(settings, blockSound).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true);
    }

    public static Item register(String id, Item item) {
        addCustomModelItem(item);
        return register(MedievalMain.identifierOf(id), item);
    }

    private static Item register(Identifier id, Item item) {
        GROUP_ITEMS.add(item);
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    private static void addCustomModelItem(Item item) {
        if (item instanceof LongSwordItem || item instanceof SmallAxeItem || item instanceof BigAxeItem || item instanceof LanceItem
                || item instanceof HealingStaffItem || item instanceof JavelinItem || item instanceof MaceItem || item instanceof SickleItem
                || item instanceof RapierItem || item instanceof HeroSwordItem || item instanceof HeroStaffItem) {
            CUSTOM_MODEL_ITEMS.add(item);
        }
    }

}
