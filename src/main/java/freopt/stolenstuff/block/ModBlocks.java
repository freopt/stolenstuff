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

    public static final BlockDefiledGround DEFILED_GROUND = new BlockDefiledGround();
    public static final BlockInvisibleLight INVISIBLE_LIGHT = new BlockInvisibleLight();
    public static final BlockFeralFlareLantern FERAL_FLARE_LANTERN = new BlockFeralFlareLantern();

    public static void load() {
        BLOCKS.add(DEFILED_GROUND);
        BLOCKS.add(INVISIBLE_LIGHT);
        BLOCKS.add(FERAL_FLARE_LANTERN);

        for (Block block: BLOCKS) {
            ForgeRegistries.BLOCKS.register(block);
        }
    }
}
