package net.medievalweapons.init;

import java.util.Iterator;

import org.jetbrains.annotations.Nullable;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.models.JModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;
import pers.solid.brrp.v1.model.ModelJsonBuilder;
import pers.solid.brrp.v1.model.ModelOverrideBuilder;
import pers.solid.brrp.v1.model.TransformationBuilder;

@Environment(EnvType.CLIENT)
public class ModelProviderInit {

    public static RuntimeResourcePack ARRP_RESOURCE_PACK;
    public static pers.solid.brrp.v1.api.RuntimeResourcePack BRRP_RESOURCE_PACK;

    public static void init() {
        ModelPredicateProviderRegistry.register(ItemInit.LONG_BOW_ITEM, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 50.0F;
            }
        });
        ModelPredicateProviderRegistry.register(ItemInit.LONG_BOW_ITEM, new Identifier("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(ItemInit.RECURVE_BOW_ITEM, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 16.0F;
            }
        });
        ModelPredicateProviderRegistry.register(ItemInit.RECURVE_BOW_ITEM, new Identifier("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(new Identifier("medievalweapons", "offhand"), (stack, world, entity, seed) -> {
            return entity != null && !entity.getOffHandStack().isEmpty() ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(new Identifier("throwing"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f;
        });
        ModelPredicateProviderRegistry.register(new Identifier("medievalweapons", "gui"), (stack, world, entity, seed) -> {
            return seed == 0 ? 1.0f : 0.0f;
        });
        if (CompatInit.isARRPLoaded) {
            ARRP_RESOURCE_PACK = RuntimeResourcePack.create("medievalweapons:weapons");
            // Generate models
            Iterator<String> items = ItemInit.ITEM_STRINGS.iterator();
            while (items.hasNext()) {
                String item = items.next();

                for (int i = 0; i < ItemInit.MATERIAL_STRINGS.size(); i++) {
                    ARRP_RESOURCE_PACK.addModel(getJModel(item, ItemInit.MATERIAL_STRINGS.get(i)), new Identifier("medievalweapons", "item/" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item));
                    // Check for gui item models
                    if (item.equals("big_axe") || item.equals("healing_staff") || item.equals("javelin") || item.equals("lance") || item.equals("long_sword") || item.equals("mace")
                            || item.equals("rapier") || item.equals("sickle") || item.equals("small_axe")) {
                        ARRP_RESOURCE_PACK.addModel(getGuiJModel(item, ItemInit.MATERIAL_STRINGS.get(i)),
                                new Identifier("medievalweapons", "item/" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item + "_gui"));
                    }
                    // Check for bc item models
                    if (item.equals("dagger") || item.equals("big_axe") || item.equals("lance") || item.equals("long_sword")) {
                        ARRP_RESOURCE_PACK.addModel(getOtherJModel(item, ItemInit.MATERIAL_STRINGS.get(i)),
                                new Identifier("medievalweapons", "item/bc_" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item));
                    }
                    // Check ARRP_RESOURCE_PACK throwing item models
                    if (item.equals("javelin")) {
                        ARRP_RESOURCE_PACK.addModel(getOtherJModel(item, ItemInit.MATERIAL_STRINGS.get(i)),
                                new Identifier("medievalweapons", "item/" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item + "_throwing"));
                    }
                }

            }

            RRPCallback.BEFORE_VANILLA.register(a -> a.add(ARRP_RESOURCE_PACK));
        } else if (CompatInit.isBRRPLoaded) {
            BRRP_RESOURCE_PACK = pers.solid.brrp.v1.api.RuntimeResourcePack.create(new Identifier("medievalweapons", "weapons"));
            // Generate models
            Iterator<String> items = ItemInit.ITEM_STRINGS.iterator();
            while (items.hasNext()) {
                String item = items.next();

                for (int i = 0; i < ItemInit.MATERIAL_STRINGS.size(); i++) {
                    BRRP_RESOURCE_PACK.addModel(new Identifier("medievalweapons", "item/" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item),
                            getModelJsonBuilder(item, ItemInit.MATERIAL_STRINGS.get(i)));
                    // Check for gui item models
                    if (item.equals("big_axe") || item.equals("healing_staff") || item.equals("javelin") || item.equals("lance") || item.equals("long_sword") || item.equals("mace")
                            || item.equals("rapier") || item.equals("sickle") || item.equals("small_axe")) {
                        BRRP_RESOURCE_PACK.addModel(new Identifier("medievalweapons", "item/" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item + "_gui"),
                                getGuiModelJsonBuilder(item, ItemInit.MATERIAL_STRINGS.get(i)));
                    }
                    // Check for bc item models
                    if (item.equals("dagger") || item.equals("big_axe") || item.equals("lance") || item.equals("long_sword")) {
                        BRRP_RESOURCE_PACK.addModel(new Identifier("medievalweapons", "item/bc_" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item),
                                getOtherModelJsonBuilder(item, ItemInit.MATERIAL_STRINGS.get(i)));
                    }
                    // Check BRRP_RESOURCE_PACK throwing item models
                    if (item.equals("javelin")) {
                        BRRP_RESOURCE_PACK.addModel(new Identifier("medievalweapons", "item/" + ItemInit.MATERIAL_STRINGS.get(i) + "_" + item + "_throwing"),
                                getOtherModelJsonBuilder(item, ItemInit.MATERIAL_STRINGS.get(i)));
                    }
                }
            }
            pers.solid.brrp.v1.fabric.api.RRPCallback.BEFORE_VANILLA.register(a -> a.add(BRRP_RESOURCE_PACK));
        } else {
            throw new AssertionError("MedievalWeapons requires ARRP or BRRP as a mod dependencys!");
        }
    }

    // ARRP
    @Nullable
    private static JModel getJModel(String item, String material) {
        switch (item) {

        case "big_axe":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .addOverride(JModel.override(JModel.condition().parameter("bettercombat:loaded", 1.0f), new Identifier("medievalweapons:item/bc_" + material + "_" + item)))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:offhand", 1.0f), new Identifier("medievalweapons:item/bc_" + material + "_" + item)))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:gui", 1.0f), new Identifier("medievalweapons:item/" + material + "_" + item + "_gui")))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(123f, 150f, -52f).translation(-14.5f, 6.5f, 2.75f).scale(1.7f, 1.7f, 1f))
                            .setThirdperson_lefthand(JModel.position().rotation(123f, -150f, 52f).translation(2.5f, 6.5f, 2.75f).scale(1.7f, 1.7f, 1f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, 90f, 25f).translation(1.13f, 3.2f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, -90f, -25f).translation(1.13f, 3.2f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                            .setGround(JModel.position().translation(0f, 4.5f, 0f).scale(0.85f, 0.85f, 0.6f))
                            .setHead(JModel.position().rotation(0f, 0f, -180f).translation(-3f, 1.25f, 0f).scale(2f, 2f, 1f))
                            .setFixed(JModel.position().translation(1.25f, 2f, 0f).scale(1.3f, 1.3f, 1f)));

        case "dagger":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .addOverride(JModel.override(JModel.condition().parameter("bettercombat:loaded", 1.0f), new Identifier("medievalweapons:item/bc_" + material + "_" + item)))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, -90f, -135f).translation(0f, -9f, 1.5f).scale(0.85f, 0.85f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, 135f).translation(0f, -9f, 1.5f).scale(0.85f, 0.85f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, -90f, 25f).translation(1.13f, 3.2f, 1.13f).scale(0.68f, 0.68f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, 90f, -25f).translation(1.13f, 3.2f, 1.13f).scale(0.68f, 0.68f, 0.68f)));

        case "francisca":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item));

        case "healing_staff":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:gui", 1.0f), new Identifier("medievalweapons:item/" + material + "_" + item + "_gui")))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, -90f, 40f).translation(0f, 8f, 2.5f).scale(2.55f, 2.55f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, -40f).translation(0f, 8f, 2.5f).scale(2.55f, 2.55f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, -90f, 50f).translation(1f, 5.5f, 1f).scale(2.04f, 2.04f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, 90f, -50f).translation(1f, 5.5f, 1f).scale(2.04f, 2.04f, 0.68f))
                            .setGround(JModel.position().translation(0f, 3f, 0f).scale(0.85f, 0.85f, 0.4f))
                            .setHead(JModel.position().rotation(0f, 0f, -180f).translation(-4f, -0.5f, 0f).scale(2.3f, 2.3f, 1f))
                            .setFixed(JModel.position().translation(2.5f, 2.5f, 0f).scale(1.4f, 1.4f, 1f)));

        case "javelin":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .addOverride(JModel.override(JModel.condition().parameter("throwing", 1.0f), new Identifier("medievalweapons:item/" + material + "_" + item + "_throwing")))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:gui", 1.0f), new Identifier("medievalweapons:item/" + material + "_" + item + "_gui")))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, -90f, 55f).translation(0f, 4f, 0.5f).scale(1.7f, 1.7f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, -55f).translation(0f, 4f, 0.5f).scale(1.7f, 1.7f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(-45f, -90f, 25f).translation(2.5f, 1f, 1f).scale(1.34f, 1.34f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(-45f, 90f, -25f).translation(2.5f, 1f, 1f).scale(1.34f, 1.34f, 0.68f))
                            .setGround(JModel.position().translation(0f, 4.5f, 0f).scale(0.85f, 0.85f, 0.6f))
                            .setHead(JModel.position().rotation(0f, 0f, 180f).translation(-2f, 2f, 0f).scale(2f, 2f, 1f)).setFixed(JModel.position().translation(2f, 2f, 0f).scale(1.3f, 1.3f, 1f)));

        case "lance":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .addOverride(JModel.override(JModel.condition().parameter("bettercombat:loaded", 1.0f), new Identifier("medievalweapons:item/bc_" + material + "_" + item)))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:gui", 1.0f), new Identifier("medievalweapons:item/" + material + "_" + item + "_gui")))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, -90f, 30f).translation(0f, 14.5f, 6f).scale(2.55f, 2.55f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, -30f).translation(0f, 14.5f, 6f).scale(2.55f, 2.55f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, -90f, 25f).translation(1.13f, 9.5f, 1.5f).scale(2.04f, 2.04f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, 90f, -25f).translation(1.13f, 9.5f, 1.5f).scale(2.04f, 2.04f, 0.68f))
                            .setGround(JModel.position().translation(0f, 3f, 0f).scale(0.85f, 0.85f, 0.4f))
                            .setHead(JModel.position().rotation(0f, 0f, 180f).translation(-5.5f, -1f, 0f).scale(2.3f, 2.3f, 1f))
                            .setFixed(JModel.position().translation(2.5f, 3f, 0f).scale(1.4f, 1.4f, 1f)));

        case "long_sword":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .addOverride(JModel.override(JModel.condition().parameter("bettercombat:loaded", 1.0f), new Identifier("medievalweapons:item/bc_" + material + "_" + item)))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:offhand", 1.0f), new Identifier("medievalweapons:item/bc_" + material + "_" + item)))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:gui", 1.0f), new Identifier("medievalweapons:item/" + material + "_" + item + "_gui")))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, 60f, 42f).translation(0f, 12.75f, 1.25f).scale(1.7f, 1.7f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, -42f).translation(0f, 12.75f, 2.5f).scale(1.7f, 1.7f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, -90f, 25f).translation(1.13f, 7.5f, 1.5f).scale(1.34f, 1.34f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, 90f, -25f).translation(1.13f, 7.5f, 1.5f).scale(1.34f, 1.34f, 0.68f))
                            .setGround(JModel.position().translation(0f, 4f, 0f).scale(1f, 1f, 0.68f)).setHead(JModel.position().translation(5.5f, 9f, 0f).scale(2f, 2f, 1f))
                            .setFixed(JModel.position().rotation(0, -180f, 0f).translation(-4.25f, 4.25f, -0.5f).scale(1.5f, 1.5f, 1f)));

        case "mace":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:gui", 1.0f), new Identifier("medievalweapons:item/" + material + "_" + item + "_gui")))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, -90f, 35f).translation(0f, 12f, 4f).scale(1.7f, 1.7f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, -35f).translation(0f, 12f, 4f).scale(1.7f, 1.7f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, -90f, 45f).translation(1.13f, 9.2f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, 90f, -45f).translation(1.13f, 9.2f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                            .setGround(JModel.position().translation(0f, 4f, 0f).scale(1f, 1f, 0.68f)).setHead(JModel.position().translation(5.5f, 9f, 0f).scale(2f, 2f, 1f))
                            .setFixed(JModel.position().translation(4.25f, 4.25f, 0f).scale(1.5f, 1.5f, 1f)));

        case "ninjato":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item));

        case "rapier":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:gui", 1.0f), new Identifier("medievalweapons:item/" + material + "_" + item + "_gui")))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, -90f, 55f).translation(0f, 14.5f, -1f).scale(1.7f, 1.7f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, -55f).translation(0f, 14.5f, -1f).scale(1.7f, 1.7f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, -90f, 25f).translation(1.13f, 8.5f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, 90f, -25f).translation(1.13f, 8.5f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                            .setGround(JModel.position().translation(0f, 4.25f, 0f).scale(1f, 1f, 0.68f)).setHead(JModel.position().translation(6f, 11f, 0f).scale(2f, 2f, 1f))
                            .setFixed(JModel.position().translation(5.25f, 5.25f, 0f).scale(1.6f, 1.6f, 1f)));

        case "sickle":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:gui", 1.0f), new Identifier("medievalweapons:item/" + material + "_" + item + "_gui")))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, -90f, 55f).translation(0f, 12.5f, -1f).scale(1.7f, 1.7f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, -55f).translation(0f, 12.5f, -1f).scale(1.7f, 1.7f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, -90f, 25f).translation(1.13f, 9f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, 90f, -25f).translation(1.13f, 9f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                            .setGround(JModel.position().translation(0f, 4.5f, 0f).scale(1f, 1f, 0.5f)).setHead(JModel.position().translation(7f, 12f, 0f).scale(2f, 2f, 1f))
                            .setFixed(JModel.position().translation(5.5f, 4.25f, 0f).scale(1.5f, 1.5f, 1f)));

        case "small_axe":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .addOverride(JModel.override(JModel.condition().parameter("medievalweapons:gui", 1.0f), new Identifier("medievalweapons:item/" + material + "_" + item + "_gui")))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, 90f, 45f).translation(0f, 12f, 2.5f).scale(1.7f, 1.7f, 1f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, -45f).translation(0f, 12f, 2.5f).scale(1.7f, 1.7f, 1f))
                            .setFirstperson_righthand(JModel.position().rotation(7.5f, 75f, 32f).translation(8.75f, 12.25f, -3.5f).scale(2f, 2f, 1f))
                            .setFirstperson_lefthand(JModel.position().rotation(7.5f, -105f, -32f).translation(8.75f, 12.25f, -3.5f).scale(2f, 2f, 1f))
                            .setGround(JModel.position().translation(0f, 4.25f, 0f).scale(1f, 1f, 0.68f)).setHead(JModel.position().translation(6f, 10f, 0f).scale(2f, 2f, 1f))
                            .setFixed(JModel.position().rotation(0f, -180f, 0f).translation(-4.25f, 4.25f, -0.25f).scale(1.5f, 1.5f, 1f)));

        default:
            throw new IllegalStateException("Could not find JModel!");
        }
    }

    @Nullable
    private static JModel getOtherJModel(String item, String material) {
        switch (item) {
        case "dagger":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item));

        case "big_axe":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, 90f, 55f).translation(0f, 11f, 3.5f).scale(1.7f, 1.7f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, -90f, -55f).translation(0f, 11f, 3.5f).scale(1.7f, 1.7f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, 90f, 25f).translation(1.13f, 5.5f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, -90f, -25f).translation(1.13f, 5.5f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                            .setGround(JModel.position().translation(0f, 4.5f, 0f).scale(0.85f, 0.85f, 0.6f))
                            .setHead(JModel.position().rotation(0f, 0f, -180f).translation(-3f, 1.25f, 0f).scale(2f, 2f, 1f))
                            .setFixed(JModel.position().translation(1.25f, 2f, 0f).scale(1.3f, 1.3f, 1f)));

        case "javelin":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, -90f, -140f).translation(0f, -5.75f, 1.25f).scale(1.7f, 1.7f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, -90f, 130f).translation(0f, -5.75f, 1.25f).scale(1.7f, 1.7f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(-40f, -90f, 25f).translation(8.5f, 6.5f, -5f).scale(1.34f, 1.34f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(-40f, 90f, -25f).translation(8.5f, 6.5f, -5f).scale(1.34f, 1.34f, 0.68f)));

        case "lance":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, -90f, 55f).translation(0f, 16.5f, -1.25f).scale(2.55f, 2.55f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, -55f).translation(0f, 16.5f, -1.25f).scale(2.55f, 2.55f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, -90f, 25f).translation(1.13f, 9.5f, 1.5f).scale(2.04f, 2.04f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, 90f, -25f).translation(1.13f, 9.5f, 1.5f).scale(2.04f, 2.04f, 0.68f))
                            .setGround(JModel.position().translation(0f, 3f, 0f).scale(0.85f, 0.85f, 0.4f))
                            .setHead(JModel.position().rotation(0f, 0f, 180f).translation(-5.5f, -1f, 0f).scale(2.3f, 2.3f, 1f))
                            .setFixed(JModel.position().translation(2.5f, 3f, 0f).scale(1.4f, 1.4f, 1f)));

        case "long_sword":
            return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/" + material + "_" + item))
                    .display(JModel.display().setThirdperson_righthand(JModel.position().rotation(0f, 90f, 35f).translation(0f, 13f, -1f).scale(1.7f, 1.7f, 0.85f))
                            .setThirdperson_lefthand(JModel.position().rotation(0f, 90f, -50f).translation(0f, 13f, 0f).scale(1.7f, 1.7f, 0.85f))
                            .setFirstperson_righthand(JModel.position().rotation(0f, -90f, 25f).translation(1.13f, 7.5f, 1.5f).scale(1.34f, 1.34f, 0.68f))
                            .setFirstperson_lefthand(JModel.position().rotation(0f, 90f, -25f).translation(1.13f, 7.5f, 1.5f).scale(1.34f, 1.34f, 0.68f))
                            .setGround(JModel.position().translation(0f, 4f, 0f).scale(1f, 1f, 0.68f)).setHead(JModel.position().translation(5.5f, 9f, 0f).scale(2f, 2f, 1f))
                            .setFixed(JModel.position().rotation(0, -180f, 0f).translation(-4.25f, 4.25f, -0.5f).scale(1.5f, 1.5f, 1f)));
        default:
            throw new IllegalStateException("Could not find BCJModel!");
        }
    }

    private static JModel getGuiJModel(String item, String material) {
        return JModel.model().parent("item/handheld").textures(JModel.textures().layer0("medievalweapons:item/extra/" + material + "_" + item));
    }

    // BRRP
    @Nullable
    public static ModelJsonBuilder getModelJsonBuilder(String item, String material) {
        switch (item) {

        case "big_axe":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/bc_" + material + "_" + item), new Identifier("bettercombat:loaded"), 1.0f))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/bc_" + material + "_" + item), new Identifier("medievalweapons:offhand"), 1.0f))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/" + material + "_" + item + "_gui"), new Identifier("medievalweapons:gui"), 1.0f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(123f, 150f, -52f).translation(-14.5f, 6.5f, 2.75f).scale(1.7f, 1.7f, 1f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(123f, -150f, 52f).translation(2.5f, 6.5f, 2.75f).scale(1.7f, 1.7f, 1f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, 90f, 25f).translation(1.13f, 3.2f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, -90f, -25f).translation(1.13f, 3.2f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 4.5f, 0f).scale(0.85f, 0.85f, 0.6f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().rotation(0f, 0f, -180f).translation(-3f, 1.25f, 0f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().translation(1.25f, 2f, 0f).scale(1.3f, 1.3f, 1f));

        case "dagger":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/bc_" + material + "_" + item), new Identifier("bettercombat:loaded"), 1.0f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, -135f).translation(0f, -9f, 1.5f).scale(0.85f, 0.85f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, 135f).translation(0f, -9f, 1.5f).scale(0.85f, 0.85f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 25f).translation(1.13f, 3.2f, 1.13f).scale(0.68f, 0.68f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -25f).translation(1.13f, 3.2f, 1.13f).scale(0.68f, 0.68f, 0.68f));

        case "francisca":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item));

        case "healing_staff":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/" + material + "_" + item + "_gui"), new Identifier("medievalweapons:gui"), 1.0f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 40f).translation(0f, 8f, 2.5f).scale(2.55f, 2.55f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -40f).translation(0f, 8f, 2.5f).scale(2.55f, 2.55f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 50f).translation(1f, 5.5f, 1f).scale(2.04f, 2.04f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -50f).translation(1f, 5.5f, 1f).scale(2.04f, 2.04f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 3f, 0f).scale(0.85f, 0.85f, 0.4f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().rotation(0f, 0f, -180f).translation(-4f, -0.5f, 0f).scale(2.3f, 2.3f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().translation(2.5f, 2.5f, 0f).scale(1.4f, 1.4f, 1f));

        case "javelin":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/" + material + "_" + item + "_throwing"), new Identifier("throwing"), 1.0f))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/" + material + "_" + item + "_gui"), new Identifier("medievalweapons:gui"), 1.0f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 55f).translation(0f, 4f, 0.5f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -55f).translation(0f, 4f, 0.5f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(-45f, -90f, 25f).translation(2.5f, 1f, 1f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(-45f, 90f, -25f).translation(2.5f, 1f, 1f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 4.5f, 0f).scale(0.85f, 0.85f, 0.6f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().rotation(0f, 0f, 180f).translation(-2f, 2f, 0f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().translation(2f, 2f, 0f).scale(1.3f, 1.3f, 1f));

        case "lance":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/bc_" + material + "_" + item), new Identifier("bettercombat:loaded"), 1.0f))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/" + material + "_" + item + "_gui"), new Identifier("medievalweapons:gui"), 1.0f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 30f).translation(0f, 14.5f, 6f).scale(2.55f, 2.55f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -30f).translation(0f, 14.5f, 6f).scale(2.55f, 2.55f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 25f).translation(1.13f, 9.5f, 1.5f).scale(2.04f, 2.04f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -25f).translation(1.13f, 9.5f, 1.5f).scale(2.04f, 2.04f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 3f, 0f).scale(0.85f, 0.85f, 0.4f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().rotation(0f, 0f, 180f).translation(-5.5f, -1f, 0f).scale(2.3f, 2.3f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().translation(2.5f, 3f, 0f).scale(1.4f, 1.4f, 1f));

        case "long_sword":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/bc_" + material + "_" + item), new Identifier("bettercombat:loaded"), 1.0f))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/bc_" + material + "_" + item), new Identifier("medievalweapons:offhand"), 1.0f))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/" + material + "_" + item + "_gui"), new Identifier("medievalweapons:gui"), 1.0f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, 60f, 42f).translation(0f, 12.75f, 1.25f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -42f).translation(0f, 12.75f, 2.5f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 25f).translation(1.13f, 7.5f, 1.5f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -25f).translation(1.13f, 7.5f, 1.5f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 4f, 0f).scale(1f, 1f, 0.68f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().translation(5.5f, 9f, 0f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().rotation(0, -180f, 0f).translation(-4.25f, 4.25f, -0.5f).scale(1.5f, 1.5f, 1f));

        case "mace":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/" + material + "_" + item + "_gui"), new Identifier("medievalweapons:gui"), 1.0f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 35f).translation(0f, 12f, 4f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -35f).translation(0f, 12f, 4f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 45f).translation(1.13f, 9.2f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -45f).translation(1.13f, 9.2f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 4f, 0f).scale(1f, 1f, 0.68f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().translation(5.5f, 9f, 0f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().translation(4.25f, 4.25f, 0f).scale(1.5f, 1.5f, 1f));

        case "ninjato":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item));

        case "rapier":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/" + material + "_" + item + "_gui"), new Identifier("medievalweapons:gui"), 1.0f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 55f).translation(0f, 14.5f, -1f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -55f).translation(0f, 14.5f, -1f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 25f).translation(1.13f, 8.5f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -25f).translation(1.13f, 8.5f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 4.25f, 0f).scale(1f, 1f, 0.68f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().translation(6f, 11f, 0f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().translation(5.25f, 5.25f, 0f).scale(1.6f, 1.6f, 1f));

        case "sickle":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/" + material + "_" + item + "_gui"), new Identifier("medievalweapons:gui"), 1.0f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 55f).translation(0f, 12.5f, -1f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -55f).translation(0f, 12.5f, -1f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 25f).translation(1.13f, 9f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -25f).translation(1.13f, 9f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 4.5f, 0f).scale(1f, 1f, 0.5f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().translation(7f, 12f, 0f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().translation(5.5f, 4.25f, 0f).scale(1.5f, 1.5f, 1f));

        case "small_axe":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .addOverride(ModelOverrideBuilder.of(new Identifier("medievalweapons:item/" + material + "_" + item + "_gui"), new Identifier("medievalweapons:gui"), 1.0f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, 90f, 45f).translation(0f, 12f, 2.5f).scale(1.7f, 1.7f, 1f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -45f).translation(0f, 12f, 2.5f).scale(1.7f, 1.7f, 1f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(7.5f, 75f, 32f).translation(8.75f, 12.25f, -3.5f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(7.5f, -105f, -32f).translation(8.75f, 12.25f, -3.5f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 4.25f, 0f).scale(1f, 1f, 0.68f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().translation(6f, 10f, 0f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().rotation(0f, -180f, 0f).translation(-4.25f, 4.25f, -0.25f).scale(1.5f, 1.5f, 1f));

        default:
            throw new IllegalStateException("Could not find ModelJsonBuilder!");
        }
    }

    @Nullable
    private static ModelJsonBuilder getOtherModelJsonBuilder(String item, String material) {
        switch (item) {
        case "dagger":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item));

        case "big_axe":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, 90f, 55f).translation(0f, 11f, 3.5f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, -90f, -55f).translation(0f, 11f, 3.5f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, 90f, 25f).translation(1.13f, 5.5f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, -90f, -25f).translation(1.13f, 5.5f, 1.13f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 4.5f, 0f).scale(0.85f, 0.85f, 0.6f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().rotation(0f, 0f, -180f).translation(-3f, 1.25f, 0f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().translation(1.25f, 2f, 0f).scale(1.3f, 1.3f, 1f));

        case "javelin":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, -140f).translation(0f, -5.75f, 1.25f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, -90f, 130f).translation(0f, -5.75f, 1.25f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(-40f, -90f, 25f).translation(8.5f, 6.5f, -5f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(-40f, 90f, -25f).translation(8.5f, 6.5f, -5f).scale(1.34f, 1.34f, 0.68f));

        case "lance":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 55f).translation(0f, 16.5f, -1.25f).scale(2.55f, 2.55f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -55f).translation(0f, 16.5f, -1.25f).scale(2.55f, 2.55f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 25f).translation(1.13f, 9.5f, 1.5f).scale(2.04f, 2.04f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -25f).translation(1.13f, 9.5f, 1.5f).scale(2.04f, 2.04f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 3f, 0f).scale(0.85f, 0.85f, 0.4f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().rotation(0f, 0f, 180f).translation(-5.5f, -1f, 0f).scale(2.3f, 2.3f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().translation(2.5f, 3f, 0f).scale(1.4f, 1.4f, 1f));

        case "long_sword":
            return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/" + material + "_" + item))
                    .transformation(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, 90f, 35f).translation(0f, 13f, -1f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.THIRD_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -50f).translation(0f, 13f, 0f).scale(1.7f, 1.7f, 0.85f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, new TransformationBuilder().rotation(0f, -90f, 25f).translation(1.13f, 7.5f, 1.5f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.FIRST_PERSON_LEFT_HAND, new TransformationBuilder().rotation(0f, 90f, -25f).translation(1.13f, 7.5f, 1.5f).scale(1.34f, 1.34f, 0.68f))
                    .transformation(ModelTransformationMode.GROUND, new TransformationBuilder().translation(0f, 4f, 0f).scale(1f, 1f, 0.68f))
                    .transformation(ModelTransformationMode.HEAD, new TransformationBuilder().translation(5.5f, 9f, 0f).scale(2f, 2f, 1f))
                    .transformation(ModelTransformationMode.FIXED, new TransformationBuilder().rotation(0, -180f, 0f).translation(-4.25f, 4.25f, -0.5f).scale(1.5f, 1.5f, 1f));
        default:
            throw new IllegalStateException("Could not find BCJModel!");
        }
    }

    public static ModelJsonBuilder getGuiModelJsonBuilder(String item, String material) {
        return ModelJsonBuilder.create("item/handheld").addTexture(TextureKey.LAYER0, new Identifier("medievalweapons:item/extra/" + material + "_" + item));
    }

}