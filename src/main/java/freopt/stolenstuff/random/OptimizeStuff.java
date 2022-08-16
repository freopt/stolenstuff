package freopt.stolenstuff.random;

import net.minecraftforge.fml.common.Loader;

public class OptimizeStuff {
    public static boolean witcheryLoaded = false;

    public static void doOptimizeStuff() {
        if (Loader.isModLoaded("witchery")) {
            witcheryLoaded = true;
        }
    }
}
