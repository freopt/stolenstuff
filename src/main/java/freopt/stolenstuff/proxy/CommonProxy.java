package freopt.stolenstuff.proxy;

import freopt.stolenstuff.block.ModBlocks;
import freopt.stolenstuff.entitys.ModEntitys;
import freopt.stolenstuff.handler.RTEventHandler;
import freopt.stolenstuff.item.ModItems;
import freopt.stolenstuff.tileentities.ModTileEntities;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy
{
	public void preInit()
	{
		ModBlocks.load();
		ModItems.load();
		ModTileEntities.load();
		ModEntitys.load();
	}

	public void postInit() {
		MinecraftForge.EVENT_BUS.register(new RTEventHandler());
	}
}
