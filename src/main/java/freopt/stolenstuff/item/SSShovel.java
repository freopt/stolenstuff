package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.item.ItemSpade;

public class SSShovel extends ItemSpade {
    public SSShovel(ToolMaterial material) {
        super(material);
        String name = material.name() + "_shovel";
        this.setRegistryName(StolenStuff.MODID,name);
        this.setTranslationKey(name);
    }
}

