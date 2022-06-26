package freopt.stolenstuff;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = StolenStuff.MODID)
@SuppressWarnings("unused")
public class StolenStuffConfig {
    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(StolenStuff.MODID)) {
            ConfigManager.sync(StolenStuff.MODID, Config.Type.INSTANCE);
        }
    }

    @Config.Comment("Settings related to Defiled Ground")
    @Config.Name("Defiled Ground")
    public static DefiledGround DefiledGround = new DefiledGround();

    public static class DefiledGround {
        @Config.Comment("Enabled defiled ground's functionality; if disabled, it is still craftable, but does nothing.")
        @Config.Name("Enable Defiled Ground")
        public boolean defiledGroundEnabled = true;

        @Config.Comment("Radius in which to test for mobs for total number of mobs spawned")
        @Config.Name("Check horizontal radius")
        public int horizontalRadius = 5;

        @Config.Comment("Vertical radius in which to test for mobs for total number of mobs spawned")
        @Config.Name("Check vertical radius")
        public int verticalRadius = 4;

        @Config.Comment("Set to false to disable numerical checks for nearby mobs before spawning")
        @Config.Name("Enable mob check")
        public boolean mobCheck = true;

        @Config.Comment("Maximum number of mobs within range at which point to stop spawning")
        @Config.Name("Maximum mobs")
        public int maximumMobs = 10;

        @Config.Comment("Minimum light level for spawning mobs (set to -1 to disable)")
        @Config.Name("Minimum light")
        @Config.RangeInt(min = -1, max = 15)
        public int minimumLight = 7;

        @Config.Comment("Requires silk-touch in order to harvest")
        @Config.Name("Require silk touch")
        public boolean requireSilkTouch = false;

        @Config.Comment("Set the chance per tick of spawning mobs (higher value = rarer, this value is ignored if Spawn on tick is enabled)")
        @Config.Name("Spawn chance")
        @Config.RangeInt(min = 1)
        public int spawnChance = 3200;

        @Config.Comment("Set to true to enable configuration to happen on a regular basis with potential randomisation")
        @Config.Name("Spawn on tick")
        public boolean spawnOnTick = true;

        @Config.Comment("How often spawns should happen in ticks (multiply by 20 to convert to seconds)")
        @Config.Name("Spawn every tick")
        public int spawnTickRate = 680; // 34 seconds

        @Config.Comment("Set to true to enable variance by a random number of the tick rate")
        @Config.Name("Enable tick variance")
        public boolean tickVariance = true;

        @Config.Comment("Set to the number of ticks to randomly add (or subtract) from the next spawn")
        @Config.Name("Tick variance")
        public int tickVarianceAmount = 100;
    }

    @Config.Comment("How many ticks have to pass for a Time in a Bottle to gain 1 second (20 = 1 Second)")
    @Config.Name("TimeInABottlePerSecond")
    public static int TIME_IN_A_BOTTLE_SECOND = 20;
}

