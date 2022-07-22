package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.item.ItemPickaxe;

public class SSPickaxe extends ItemPickaxe {
    public SSPickaxe(ToolMaterial material) {
        super(material);
        String name = material.name() + "_pickaxe";
        this.setRegistryName(StolenStuff.MODID,name);
        this.setUnlocalizedName(name);
    }
}
