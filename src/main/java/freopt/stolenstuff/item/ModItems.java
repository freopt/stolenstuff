package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<>();

	public static void load()
	{
		ITEMS.add(new ItemTimeInABottle());

		for (Item item: ITEMS) {
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
