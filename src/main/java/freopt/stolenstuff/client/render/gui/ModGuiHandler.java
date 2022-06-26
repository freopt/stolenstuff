package freopt.stolenstuff.client.render.gui;

import freopt.stolenstuff.tileentities.TileEntityFeralFlareLantern;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler
{
	public enum GuiType
	{
		INVALID, TERRAIN_LIGHTER, FERAL_LANTERN;

		public static GuiType fromId(int id)
		{
			if(id < 0 || id > GuiType.values().length)
				return INVALID;
			return GuiType.values()[id];
		}
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (GuiType.fromId(id))
		{
			case FERAL_LANTERN:
				// feral lanterns have no server side element
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{

		switch (GuiType.fromId(id))
		{
			case FERAL_LANTERN:
				return new GuiFeralLantern((TileEntityFeralFlareLantern) world.getTileEntity(new BlockPos(x, y, z)));
			default:
				return null;
		}
	}
}
