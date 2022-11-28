package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class ArmorMaterials {

    public static ArmorMaterial OSMIUM;

    public static void registerMaterials() {
        OSMIUM = EnumHelper.addArmorMaterial("osmium","stolenstuff:osmium",35,new int[]{3,5,8,2},1, SoundEvents.ITEM_ARMOR_EQUIP_IRON,2.5F);
    }

    public static void setRepairItem() {
        OSMIUM.setRepairItem(OreDictionary.getOres("ingotOsmium").get(0));
    }
}
