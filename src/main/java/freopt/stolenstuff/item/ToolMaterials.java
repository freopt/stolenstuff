package freopt.stolenstuff.item;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class ToolMaterials {

    public static ToolMaterial OSMIUM;

    public static void registerMaterials() {
        OSMIUM = EnumHelper.addToolMaterial("osmium",2,650,5F,3F,1);
        if (OreDictionary.doesOreNameExist("ingotOsmium")) {
            OSMIUM.setRepairItem(OreDictionary.getOres("ingotOsmium").get(0));
        }

    }
}
