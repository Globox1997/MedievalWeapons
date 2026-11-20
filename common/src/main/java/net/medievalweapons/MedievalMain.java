package net.medievalweapons;

import net.medievalweapons.init.ConfigInit;
import net.minecraft.resources.Identifier;

public class MedievalMain {

    // All credits go to Plasma Studios: https://youtu.be/Uc7YMW3AKpg?t=1152
    // Thanks for the awesome series
    // Check it out here: https://youtu.be/yCNUP2NAt-A

    public static final String MOD_ID = "medievalweapons";

    public static void init() {
        ConfigInit.init();
    }

    public static Identifier identifierOf(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

}

// You are LOVED!!!
// Jesus loves you unconditionally!
