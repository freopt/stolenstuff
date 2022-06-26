package freopt.stolenstuff.proxy;

import freopt.stolenstuff.block.ModBlocks;
import freopt.stolenstuff.entitys.ModEntitys;
import freopt.stolenstuff.handler.RTEventHandler;
import freopt.stolenstuff.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	public static void preInit(FMLPreInitializationEvent event)
	{

		ModBlocks.load(event);
		ModItems.load(event);

		ModEntitys.init();

		MinecraftForge.EVENT_BUS.register(new RTEventHandler());
	}

	public static void postInit(FMLPostInitializationEvent event) {

	}
}
