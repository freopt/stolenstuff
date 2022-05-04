package freopt.stolenstuff.client.models;

import freopt.stolenstuff.item.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

import static freopt.stolenstuff.block.ModBlocks.itemDefiled;

public class ItemModels
{
	public static void register()
	{
		registerItem(ModItems.timeInABottle);
		registerItem(itemDefiled);
	}
	
	private static void registerItem(Item i)
	{
		ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName(), "inventory"));
	}
}
