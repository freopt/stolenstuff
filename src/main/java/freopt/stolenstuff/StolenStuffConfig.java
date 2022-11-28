package freopt.stolenstuff;

import net.minecraftforge.common.config.Config;

@Config(modid = StolenStuff.MODID)
public class StolenStuffConfig {

    @Config.Comment("How many ticks have to pass for a Time in a Bottle to gain 1 second (20 = 1 Second)")
    @Config.Name("TimeInABottlePerSecond")
    public static int TIME_IN_A_BOTTLE_SECOND = 20;

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
        public int maximumMobs = 20;

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
        public int spawnChance = 1030;

        @Config.Comment("Set to true to enable configuration to happen on a regular basis with potential randomisation")
        @Config.Name("Spawn on tick")
        public boolean spawnOnTick = true;

        @Config.Comment("How often spawns should happen in ticks (multiply by 20 to convert to seconds)")
        @Config.Name("Spawn every tick")
        public int spawnTickRate = 220; // 34 seconds

        @Config.Comment("Set to true to enable variance by a random number of the tick rate")
        @Config.Name("Enable tick variance")
        public boolean tickVariance = true;

        @Config.Comment("Set to the number of ticks to randomly add (or subtract) from the next spawn")
        @Config.Name("Tick variance")
        public int tickVarianceAmount = 100;
    }

    @Config.Name("Feral Flare Lantern")
    public static FeralFlareLantern FeralFlareLantern = new FeralFlareLantern();

    public static class FeralFlareLantern {
        @Config.RangeInt(min = 0)
        @Config.Comment("The radius in which the feral flare should try to place lights")
        public int feralFlareRadius = 16;

        @Config.RangeInt(min = 1)
        @Config.Comment("Controls how often the flare should try to place lights. 1 means every tick, 10 every 10th tick, etc")
        public int feralFlareTickRate = 5;

        @Config.RangeInt(min = 1, max = 15)
        @Config.Comment("The target minimum light level to place lights for")
        public int feralFlareMinLightLevel = 10;

        @Config.RangeInt(min = 0)
        @Config.Comment({
                "The maximum amount of invisble lights a feral flare lantern can place. Set to 0 to disable light placement.",
                "Warning: Setting this value too high in conjunction with the feralFlareMinLightLevel and Radius can lead to world corruption!",
                "(Badly compressed packet error)"
        })
        public int FeralFlareLanternLightCountHardcap = 255;

        @Config.Comment("If false, lights decay slowly after the lantern has been removed. If true, the lights will be removed instantly")
        public boolean feralFlareLightDecayInstantly = false;
    }
}

