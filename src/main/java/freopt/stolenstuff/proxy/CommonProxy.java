package freopt.stolenstuff.proxy;

import freopt.stolenstuff.block.ModBlocks;
import freopt.stolenstuff.entitys.ModEntitys;
import freopt.stolenstuff.handler.RTEventHandler;
import freopt.stolenstuff.item.ModItems;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy
{
	public void preInit()
	{

		ModBlocks.load();
		ModItems.load();

		ModEntitys.init();

		MinecraftForge.EVENT_BUS.register(new RTEventHandler());
	}

	public void postInit() {

	}
}
