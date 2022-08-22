package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.item.ItemHoe;

public class SSHoe extends ItemHoe{
    public SSHoe(ToolMaterial material) {
        super(material);
        String name = material.name() + "_hoe";
        this.setRegistryName(StolenStuff.MODID,name);
        this.setTranslationKey(name);
    }
}

