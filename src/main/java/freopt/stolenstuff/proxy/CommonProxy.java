package freopt.stolenstuff.proxy;

import freopt.stolenstuff.block.ModBlocks;
import freopt.stolenstuff.entitys.ModEntitys;
import freopt.stolenstuff.handler.RTEventHandler;
import freopt.stolenstuff.item.ArmorMaterials;
import freopt.stolenstuff.item.ModItems;
import freopt.stolenstuff.item.ToolMaterials;
import freopt.stolenstuff.tileentities.ModTileEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{
		ToolMaterials.registerMaterials();
		ArmorMaterials.registerMaterials();
		ModBlocks.load();
		ModItems.load();
		ModTileEntities.load();
		ModEntitys.load();
	}

	public void init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new RTEventHandler());
		ToolMaterials.setRepairItem();
		ArmorMaterials.setRepairItem();
	}
}
