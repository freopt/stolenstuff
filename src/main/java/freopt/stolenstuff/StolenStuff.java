package freopt.stolenstuff;

import freopt.stolenstuff.proxy.CommonProxy;
import freopt.stolenstuff.util.Antipain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StolenStuff.MODID, name = StolenStuff.NAME, version = StolenStuff.VERSION, acceptedMinecraftVersions = "[1.12,1.13)")
public class StolenStuff
{
	public static final String MODID = "stolenstuff";
	public static final String NAME = "StolenStuff";
	public static final String VERSION = "@VERSION@";

	@Mod.Instance public static StolenStuff INSTANCE;

	@SidedProxy(clientSide = "freopt.stolenstuff.proxy.ClientProxy", serverSide = "freopt.stolenstuff.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static final Logger LOGGER = LogManager.getLogger("stolenstuff");

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}

	public static final CreativeTabs creativeTab = new CreativeTabs("stolenstuff") {
		@Override
		public ItemStack getTabIconItem() {
			return Antipain.getItemStack(MODID,"timeInABottle",0);
		}
	};
}
