package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<>();

	public static Item TIAB = new ItemTimeInABottle();
	public static Item OSMIUM_INGOT = new ItemBase("osmium_ingot");

	public static void load()
	{
		OreDictionary.registerOre("ingotOsmium",OSMIUM_INGOT);
		ITEMS.add(OSMIUM_INGOT);
		ITEMS.add(TIAB);
		ITEMS.add(new SSPickaxe(ToolMaterials.OSMIUM));
		ITEMS.add(new SSAxe(ToolMaterials.OSMIUM));
		ITEMS.add(new SSHoe(ToolMaterials.OSMIUM));
		ITEMS.add(new SSShovel(ToolMaterials.OSMIUM));
		ITEMS.add(new SSSword(ToolMaterials.OSMIUM));
		ITEMS.add(new SSArmor(ArmorMaterials.OSMIUM,1, EntityEquipmentSlot.HEAD));
		ITEMS.add(new SSArmor(ArmorMaterials.OSMIUM,1, EntityEquipmentSlot.CHEST));
		ITEMS.add(new SSArmor(ArmorMaterials.OSMIUM,2, EntityEquipmentSlot.LEGS));
		ITEMS.add(new SSArmor(ArmorMaterials.OSMIUM,1, EntityEquipmentSlot.FEET));


		for (Item item: ITEMS) {
			item.setCreativeTab(StolenStuff.creativeTab);
			ForgeRegistries.ITEMS.register(item);
			if (item.getRegistryName().equals(new ResourceLocation(StolenStuff.MODID,"feral_flare_lantern"))) {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "facing=down"));
			}
			else {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
			}
		}

	}
}
