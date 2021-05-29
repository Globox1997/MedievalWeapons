package net.medievalweapons.compat;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.entity.*;
import net.medievalweapons.init.EntityInit;
import net.minecraft.entity.EntityType;

public class CompatEntities {
        // DragonLoot
        public static EntityType<Javelin_Entity> DRAGON_JAVELIN;
        public static EntityType<Francisca_HT_Entity> DRAGON_FRANCISCA_HT;

        // Better Nether
        public static EntityType<Francisca_HT_Entity> NETHER_RUBY_FRANCISCA_HT;
        public static EntityType<Javelin_Entity> NETHER_RUBY_JAVELIN;
        public static EntityType<Francisca_HT_Entity> CINCINNASITE_FRANCISCA_HT;
        public static EntityType<Javelin_Entity> CINCINNASITE_JAVELIN;
        public static EntityType<Francisca_HT_Entity> CINCINNASITE_DIAMOND_FRANCISCA_HT;
        public static EntityType<Javelin_Entity> CINCINNASITE_DIAMOND_JAVELIN;

        // Better End
        public static EntityType<Francisca_HT_Entity> TERMINITE_FRANCISCA_HT;
        public static EntityType<Javelin_Entity> TERMINITE_JAVELIN;
        public static EntityType<Francisca_HT_Entity> AETERNIUM_FRANCISCA_HT;
        public static EntityType<Javelin_Entity> AETERNIUM_JAVELIN;
        public static EntityType<Francisca_HT_Entity> THALLASIUM_FRANCISCA_HT;
        public static EntityType<Javelin_Entity> THALLASIUM_JAVELIN;

        public static void loadEntities() {
                if (CompatItems.isBetterEndLoaded) {
                        TERMINITE_FRANCISCA_HT = EntityInit.register("terminite_francisca",
                                        EntityInit.create_HT_Francisca(CompatItems.TERMINITE_FRANCISCA_HT_ITEM));
                        TERMINITE_JAVELIN = EntityInit.register("terminite_javelin",
                                        EntityInit.create_Javelin(CompatItems.TERMINITE_JAVELIN_ITEM));
                        AETERNIUM_FRANCISCA_HT = EntityInit.register("aeternium_francisca",
                                        EntityInit.create_HT_Francisca(CompatItems.AETERNIUM_FRANCISCA_HT_ITEM));
                        AETERNIUM_JAVELIN = EntityInit.register("aeternium_javelin",
                                        EntityInit.create_Javelin(CompatItems.AETERNIUM_JAVELIN_ITEM));
                        THALLASIUM_FRANCISCA_HT = EntityInit.register("thallasium_francisca",
                                        EntityInit.create_HT_Francisca(CompatItems.THALLASIUM_FRANCISCA_HT_ITEM));
                        THALLASIUM_JAVELIN = EntityInit.register("thallasium_javelin",
                                        EntityInit.create_Javelin(CompatItems.THALLASIUM_JAVELIN_ITEM));

                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("terminite_francisca"), TERMINITE_FRANCISCA_HT);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("terminite_javelin"), TERMINITE_JAVELIN);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("aeternium_francisca"), AETERNIUM_FRANCISCA_HT);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("aeternium_javelin"), AETERNIUM_JAVELIN);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("thallasium_francisca"), THALLASIUM_FRANCISCA_HT);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("thallasium_javelin"), THALLASIUM_JAVELIN);
                }
                if (CompatItems.isBetterNetherLoaded) {
                        NETHER_RUBY_FRANCISCA_HT = EntityInit.register("nether_ruby_francisca",
                                        EntityInit.create_HT_Francisca(CompatItems.NETHER_RUBY_FRANCISCA_HT_ITEM));
                        NETHER_RUBY_JAVELIN = EntityInit.register("nether_ruby_javelin",
                                        EntityInit.create_Javelin(CompatItems.NETHER_RUBY_JAVELIN_ITEM));
                        CINCINNASITE_FRANCISCA_HT = EntityInit.register("cincinnasite_francisca",
                                        EntityInit.create_HT_Francisca(CompatItems.CINCINNASITE_FRANCISCA_HT_ITEM));
                        CINCINNASITE_JAVELIN = EntityInit.register("cincinnasite_javelin",
                                        EntityInit.create_Javelin(CompatItems.CINCINNASITE_JAVELIN_ITEM));
                        CINCINNASITE_DIAMOND_FRANCISCA_HT = EntityInit.register("cincinnasite_diamond_francisca",
                                        EntityInit.create_HT_Francisca(
                                                        CompatItems.CINCINNASITE_DIAMOND_FRANCISCA_HT_ITEM));
                        CINCINNASITE_DIAMOND_JAVELIN = EntityInit.register("cincinnasite_diamond_javelin",
                                        EntityInit.create_Javelin(CompatItems.CINCINNASITE_DIAMOND_JAVELIN_ITEM));

                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("nether_ruby_francisca"), NETHER_RUBY_FRANCISCA_HT);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("nether_ruby_javelin"), NETHER_RUBY_JAVELIN);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("cincinnasite_francisca"),
                                        CINCINNASITE_FRANCISCA_HT);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("cincinnasite_javelin"), CINCINNASITE_JAVELIN);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("cincinnasite_diamond_francisca"),
                                        CINCINNASITE_DIAMOND_JAVELIN);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("cincinnasite_diamond_javelin"),
                                        CINCINNASITE_DIAMOND_FRANCISCA_HT);
                }
                if (CompatItems.isDragonLootLoaded) {
                        DRAGON_JAVELIN = EntityInit.register("dragon_javelin",
                                        EntityInit.create_Javelin(CompatItems.DRAGON_JAVELIN_ITEM));
                        DRAGON_FRANCISCA_HT = EntityInit.register("dragon_francisca",
                                        EntityInit.create_HT_Francisca(CompatItems.DRAGON_FRANCISCA_HT_ITEM));

                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("dragon_francisca"), DRAGON_FRANCISCA_HT);
                        EntityInit.ENTITY_TYPES.put(MedievalMain.ID("dragon_javelin"), DRAGON_JAVELIN);
                }
        }
}