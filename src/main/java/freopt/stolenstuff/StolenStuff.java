package freopt.stolenstuff;

import freopt.stolenstuff.block.ModBlocks;
import freopt.stolenstuff.entitys.ModEntitys;
import org.apache.logging.log4j.Logger;

import freopt.stolenstuff.handler.RTEventHandler;
import freopt.stolenstuff.item.ModItems;
import freopt.stolenstuff.lib.RTCreativeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = StolenStuff.MOD_ID, name = StolenStuff.MOD_NAME, version = StolenStuff.MOD_VERSION, acceptedMinecraftVersions = "[1.12,1.13)")
public class StolenStuff
{
	public static final String MOD_ID = "stolenstuff";
	public static final String MOD_NAME = "StolenStuff";
	public static final String MOD_VERSION = "@VERSION@";

	@Instance(MOD_ID)
	public static StolenStuff instance;

	@SidedProxy(clientSide = "freopt.stolenstuff.client.ClientProxy", serverSide = "freopt.stolenstuff.CommonProxy")
	public static CommonProxy proxy;

	public RTCreativeTab creativeTab;

	public Logger logger;


	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		creativeTab = new RTCreativeTab();
		logger = event.getModLog();


		ModItems.load(event);
		ModBlocks.load(event);

		ModEntitys.init();
		proxy.registerModels();

		RTEventHandler eventHandler = new RTEventHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.registerRenderers();
	}
}
