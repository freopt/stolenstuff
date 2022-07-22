package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.item.ItemAxe;

public class SSAxe extends ItemAxe {
    public SSAxe(ToolMaterial material) {
        super(material);
        String name = material.name() + "_axe";
        this.setRegistryName(StolenStuff.MODID,name);
        this.setUnlocalizedName(name);
    }
}
