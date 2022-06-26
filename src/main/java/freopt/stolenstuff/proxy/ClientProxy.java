package freopt.stolenstuff.proxy;

import freopt.stolenstuff.client.render.RenderTimeAccelerator;
import freopt.stolenstuff.entitys.EntityTimeAccelerator;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{

	public static void postInit()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityTimeAccelerator.class, new RenderTimeAccelerator(Minecraft.getMinecraft().getRenderManager()));
	}
}
