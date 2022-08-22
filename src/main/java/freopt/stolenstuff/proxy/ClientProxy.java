package freopt.stolenstuff.proxy;

import freopt.stolenstuff.client.render.RenderTimeAccelerator;
import freopt.stolenstuff.entitys.EntityTimeAccelerator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityTimeAccelerator.class, new IRenderFactory<EntityTimeAccelerator>() {
			@Override
			public Render<? super EntityTimeAccelerator> createRenderFor(RenderManager manager) {
				return new RenderTimeAccelerator(manager);
			}
		});
	}
}
