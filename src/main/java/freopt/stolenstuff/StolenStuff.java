package freopt.stolenstuff;

import freopt.stolenstuff.proxy.CommonProxy;
import freopt.stolenstuff.util.Antipain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StolenStuff.MODID, name = StolenStuff.NAME, version = StolenStuff.VERSION, acceptedMinecraftVersions = "[1.12,1.13)")
@Mod.EventBusSubscriber
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
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit();
	}

	@EventHandler
	public void init(FMLPostInitializationEvent event) {
		proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit();
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(StolenStuff.MODID)) {
			ConfigManager.sync(StolenStuff.MODID, Config.Type.INSTANCE);
		}
	}

	public static final CreativeTabs creativeTab = new CreativeTabs("stolenstuff") {
		@Override
		public ItemStack getTabIconItem() {
			return Antipain.getItemStack(MODID,"timeInABottle",0);
		}
	};
}
