package freopt.stolenstuff.block;

import freopt.stolenstuff.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    private static final List<Block> BLOCKS = new ArrayList<>();
    public static void load(FMLPreInitializationEvent event) {
        BLOCKS.add(new BlockDefiledGround());

        for (Block block: BLOCKS) {
            ForgeRegistries.BLOCKS.register(block);
            ModItems.ITEMS.add(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }
    }
}
