package freopt.stolenstuff.item;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class ToolMaterials {

    public static ToolMaterial OSMIUM;

    public static void registerMaterials() {
        OSMIUM = EnumHelper.addToolMaterial("osmium",2,650,5F,2.5F,1);
    }

    public static void setRepairItem() {
        OSMIUM.setRepairItem(OreDictionary.getOres("ingotOsmium").get(0));
    }
}
