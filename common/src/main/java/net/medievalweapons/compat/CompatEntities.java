package net.medievalweapons.compat;

import net.medievalweapons.MedievalMain;
import net.medievalweapons.platform.Services;
import net.minecraft.resources.Identifier;

import java.util.ArrayList;
import java.util.List;

public class CompatEntities {

    public static List<Identifier> throwableIds() {
        List<Identifier> ids = new ArrayList<>();
        for (CompatItems.CompatMaterial material : CompatItems.MATERIALS) {
            if (Services.PLATFORM.isModLoaded(material.modId())) {
                ids.add(MedievalMain.identifierOf(material.name() + "_francisca"));
                ids.add(MedievalMain.identifierOf(material.name() + "_javelin"));
            }
        }
        return ids;
    }

}
