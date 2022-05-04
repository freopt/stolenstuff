package freopt.stolenstuff.tileentities;

import freopt.stolenstuff.StolenStuffConfig;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraftforge.event.ForgeEventFactory;

public class TileEntityDefiledGround extends TileEntity implements ITickable {
    private int nextSpawn = 0;

    private int getCurrentTick() {
        if (world.isRemote) return -1;
        MinecraftServer server = world.getMinecraftServer();
        if (server == null) return -1;
        return server.getTickCounter();
    }

    @Override
    public void update() {
        if (world.isRemote) return;

        if (world.getDifficulty() == EnumDifficulty.PEACEFUL) return;

        BlockPos spawnPoint = getPos().up();

        if (!StolenStuffConfig.DefiledGround.defiledGroundEnabled) return;

        if (StolenStuffConfig.DefiledGround.spawnOnTick) {
            if (nextSpawn <= getCurrentTick()) {
                int increment = StolenStuffConfig.DefiledGround.spawnTickRate + getCurrentTick();
                int variance = 1;
                if (StolenStuffConfig.DefiledGround.tickVariance) {
                    variance = world.rand.nextInt(Math.max(1, StolenStuffConfig.DefiledGround.tickVarianceAmount));
                    increment += (world.rand.nextBoolean() ? variance : -variance);
                }
                if (nextSpawn == 0) {
                    nextSpawn = (world.rand.nextInt(Math.max(1, variance)) + increment) / 2;
                    return;
                } else {
                    nextSpawn = increment;
                }
            } else {
                return;
            }
        } else {
            if (world.rand.nextInt(StolenStuffConfig.DefiledGround.spawnChance) != 0) {
                return;
            }
        }

        if (StolenStuffConfig.DefiledGround.minimumLight != -1) {
            if (world.getLightFor(EnumSkyBlock.BLOCK, spawnPoint) > StolenStuffConfig.DefiledGround.minimumLight) return;
        }

        if (StolenStuffConfig.DefiledGround.mobCheck) {
            int limit = StolenStuffConfig.DefiledGround.maximumMobs;
            AxisAlignedBB boundingBox = new AxisAlignedBB(getPos()).grow(-StolenStuffConfig.DefiledGround.horizontalRadius, StolenStuffConfig.DefiledGround.verticalRadius, StolenStuffConfig.DefiledGround.horizontalRadius);
            if (world.getEntitiesWithinAABB(EntityLivingBase.class, boundingBox, (entity) -> entity != null && entity.isCreatureType(EnumCreatureType.MONSTER, false)).size() > limit)
                return;
        }

        EntityLiving mob = getMobForSpawn(world, spawnPoint);
        if (mob == null) return;

        float x = spawnPoint.getX() + 0.5f;
        float y = spawnPoint.getY();
        float z = spawnPoint.getZ() + 0.5f;

        mob.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360.0f, 0.0f);

        if (!ForgeEventFactory.doSpecialSpawn(mob, world, x, y, z, null)) {
            mob.onInitialSpawn(world.getDifficultyForLocation(spawnPoint), null);
        }

        AnvilChunkLoader.spawnEntity(mob, world);
        world.playEvent(2004, spawnPoint, 0);
    }

    private EntityLiving getMobForSpawn(World world, BlockPos pos) {
        Biome.SpawnListEntry entry = ((WorldServer) world).getSpawnListEntryForTypeAt(EnumCreatureType.MONSTER, pos);

        if (entry == null || entry.entityClass == null || !((WorldServer) world).canCreatureTypeSpawnHere(EnumCreatureType.MONSTER, entry, pos)) {
            return null;
        }

        try {
            return entry.newInstance(world);
        } catch (Exception e) {
            return null;
        }
    }
}
