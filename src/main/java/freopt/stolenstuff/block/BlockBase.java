package freopt.stolenstuff.block;

import freopt.stolenstuff.StolenStuff;
import freopt.stolenstuff.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block {
    public BlockBase(String name, Material material) {
        super(material);
        this.setRegistryName(new ResourceLocation(StolenStuff.MODID,name));
        this.setCreativeTab(StolenStuff.creativeTab);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockBase(String name, Material material, Boolean createItemBlock) {
        super(material);
        this.setRegistryName(new ResourceLocation(StolenStuff.MODID,name));
        if (createItemBlock) {
            ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
            this.setCreativeTab(StolenStuff.creativeTab);
        }
    }
}
