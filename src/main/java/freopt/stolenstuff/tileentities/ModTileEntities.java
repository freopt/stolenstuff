package freopt.stolenstuff.tileentities;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
    public static void load() {
        GameRegistry.registerTileEntity(TileEntityFeralFlareLantern.class,new ResourceLocation(StolenStuff.MODID,"feral_flare_lantern"));
        GameRegistry.registerTileEntity(TileEntityDefiledGround.class,new ResourceLocation(StolenStuff.MODID,"defiled_ground"));
    }
}
