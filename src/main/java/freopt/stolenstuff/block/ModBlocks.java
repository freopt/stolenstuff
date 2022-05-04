package freopt.stolenstuff.block;

import freopt.stolenstuff.StolenStuff;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBlocks {
    public static BlockDefiledGround defiledGround;
    public static ItemBlock itemDefiled;

    public static void load(FMLPreInitializationEvent event) {
        defiledGround = new BlockDefiledGround();
        ForgeRegistries.BLOCKS.register(defiledGround);
        itemDefiled = new ItemBlock(defiledGround);
        itemDefiled.setRegistryName(defiledGround.getRegistryName());
        ForgeRegistries.ITEMS.register(itemDefiled);
    }
}
