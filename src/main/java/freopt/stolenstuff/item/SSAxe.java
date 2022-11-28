package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.item.ItemAxe;

public class SSAxe extends ItemAxe {
    public SSAxe(ToolMaterial material) {
        super(material, material.getAttackDamage()*2.5F, -3F);
        String name = material.name() + "_axe";
        this.setRegistryName(StolenStuff.MODID,name);
        this.setTranslationKey(name);
    }
}
