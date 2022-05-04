package freopt.stolenstuff.client;

import freopt.stolenstuff.CommonProxy;
import freopt.stolenstuff.client.models.ItemModels;
import freopt.stolenstuff.client.render.RenderTimeAccelerator;
import freopt.stolenstuff.entitys.EntityTimeAccelerator;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerModels()
	{
		ItemModels.register();
	}

	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityTimeAccelerator.class, new RenderTimeAccelerator(Minecraft.getMinecraft().getRenderManager()));
	}
}
