package freopt.stolenstuff.item;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item
{

	public ItemBase(String name)
	{
		this.setRegistryName(new ResourceLocation("stolenstuff",name));
		this.setUnlocalizedName(name);
		this.setCreativeTab(StolenStuff.creativeTab);
	}

}
