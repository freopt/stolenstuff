package freopt.stolenstuff.block;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block {
    public BlockBase(String name, Material material) {
        super(material);
        this.setRegistryName(new ResourceLocation(StolenStuff.MODID,name));
        this.setCreativeTab(StolenStuff.creativeTab);
    }
}
