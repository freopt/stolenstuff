package freopt.stolenstuff.entitys;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntitys
{
	public static void init()
	{
		registerEntity(EntityTimeAccelerator.class, "timeAccelerator", 11, StolenStuff.instance, 64, 10, false);
	}

	private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation("stolenstuff", entityName), entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}
