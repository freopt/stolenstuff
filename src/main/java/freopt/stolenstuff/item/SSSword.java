package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.item.ItemSword;

public class SSSword extends ItemSword {
    public SSSword(ToolMaterial material) {
        super(material);
        String name = material.name() + "_sword";
        this.setRegistryName(StolenStuff.MODID,name);
        this.setUnlocalizedName(name);
    }
}
