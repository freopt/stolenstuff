package freopt.stolenstuff.block;

import freopt.stolenstuff.tileentities.TileEntityDefiledGround;
import freopt.stolenstuff.StolenStuff;
import freopt.stolenstuff.StolenStuffConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockDefiledGround extends BlockBase {
    public BlockDefiledGround() {
        super("defiled_ground",Material.GROUND);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return StolenStuffConfig.DefiledGround.defiledGroundEnabled;

    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        if (StolenStuffConfig.DefiledGround.defiledGroundEnabled) {
            return new TileEntityDefiledGround();
        }

        return null;
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(this);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (StolenStuffConfig.DefiledGround.requireSilkTouch) {
            return Item.getItemFromBlock(Blocks.DIRT);
        } else {
            return Item.getItemFromBlock(this);
        }
    }
}

