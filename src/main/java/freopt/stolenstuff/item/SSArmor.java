package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class SSArmor extends ItemArmor {
    public SSArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot slot) {
        super(material,renderIndex,slot);
        String name = material.name() + "_" + slot.getName();
        this.setRegistryName(StolenStuff.MODID,name);
        this.setUnlocalizedName(name);
    }
}
