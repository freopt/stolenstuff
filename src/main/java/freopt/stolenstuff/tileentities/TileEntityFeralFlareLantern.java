package freopt.stolenstuff.tileentities;

import freopt.stolenstuff.StolenStuffConfig;
import freopt.stolenstuff.block.ModBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class TileEntityFeralFlareLantern extends TileEntity implements ITickable {
    private int ticks;
    private List<BlockPos> childLights = new ArrayList<>();

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, -1, this.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(super.getUpdateTag());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        List<Integer> childLightsEncoded = new ArrayList<>(this.childLights.size());
        for (BlockPos child : this.childLights)
            childLightsEncoded.add(encodePosition(this.pos, child));

        nbt.setTag("lights", new NBTTagIntArray(childLightsEncoded));
        nbt.setInteger("ticks", this.ticks);
        return super.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        this.childLights.clear();
        if (nbt.getTagId("lights") == Constants.NBT.TAG_INT_ARRAY) {
            BlockPos origin = new BlockPos(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z"));
            int[] lightsEncoded = ((NBTTagIntArray) nbt.getTag("lights")).getIntArray();
            for (int encodedLight : lightsEncoded)
                this.childLights.add(decodePosition(origin, encodedLight));
        }
        this.ticks = nbt.getInteger("ticks");
        super.readFromNBT(nbt);
    }

    @Override
    public void update() {
        if (this.world.isRemote || ++this.ticks % StolenStuffConfig.FeralFlareLantern.feralFlareTickRate != 0) return;
        if (ticks > 1_000_000) ticks = 0;

        if (this.childLights.size() > StolenStuffConfig.FeralFlareLantern.FeralFlareLanternLightCountHardcap) return;

        int radius = StolenStuffConfig.FeralFlareLantern.feralFlareRadius;
        int diameter = radius * 2;

        int x = (radius - this.world.rand.nextInt(diameter)) + this.pos.getX();
        int y = (radius - this.world.rand.nextInt(diameter)) + this.pos.getY();
        int z = (radius - this.world.rand.nextInt(diameter)) + this.pos.getZ();

        // limit height - lower bounds
        if (y < 3) y = 3;

        // limit height - upper bounds
        BlockPos targetPos = new BlockPos(x, y, z);
        if (!this.world.isBlockLoaded(targetPos)) return;

        BlockPos precipitationHeight = this.world.getPrecipitationHeight(targetPos);
        if (targetPos.getY() > precipitationHeight.getY() + 4)
            targetPos = precipitationHeight.up(4);

        // dont try to place blocks outside of the world height
        int worldHeightCap = world.getHeight();
        if (targetPos.getY() > worldHeightCap)
            targetPos = new BlockPos(targetPos.getX(), worldHeightCap - 1, targetPos.getZ());

        if (this.world.isAirBlock(targetPos) && this.world.getLightFor(EnumSkyBlock.BLOCK, targetPos) < StolenStuffConfig.FeralFlareLantern.feralFlareMinLightLevel) {
            if (this.world.setBlockState(targetPos, ModBlocks.INVISIBLE_LIGHT.getDefaultState(), 3)) {
                this.childLights.add(targetPos);
                this.markDirty();
            }
        }
    }

    public void removeChildLights() {
        if (this.world.isRemote) return;
        for (BlockPos pos : this.childLights) {
            if (this.world.getBlockState(pos).getBlock() == ModBlocks.INVISIBLE_LIGHT) {
                if (StolenStuffConfig.FeralFlareLantern.feralFlareLightDecayInstantly)
                    this.world.setBlockToAir(pos);
                else
                    this.world.setBlockState(pos, ModBlocks.INVISIBLE_LIGHT.getDecayState(), 2);
            }
        }
        this.childLights.clear();
    }

    private static int encodePosition(BlockPos origin, BlockPos target) {
        int x = target.getX() - origin.getX();
        int y = target.getY() - origin.getY();
        int z = target.getZ() - origin.getZ();
        return ((x & 0xFF) << 16) + ((y & 0xFF) << 8) + (z & 0xFF);
    }

    private static BlockPos decodePosition(BlockPos origin, int pos) {
        int x = (byte) ((pos >> 16) & 0xFF);
        int y = (byte) ((pos >> 8) & 0xFF);
        int z = (byte) (pos & 0xFF);
        return origin.add(x, y, z);
    }
}
