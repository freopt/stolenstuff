package freopt.stolenstuff.network;

import freopt.stolenstuff.StolenStuff;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class StolenStuffNetwork
{
    private static SimpleNetworkWrapper network;

    public static void initNetwork()
    {
        network = NetworkRegistry.INSTANCE.newSimpleChannel(StolenStuff.MODID);
        network.registerMessage(PacketSetFeralLanternLoS.Handler, PacketSetFeralLanternLoS.class, 0, Side.SERVER);
    }

    public static SimpleNetworkWrapper getNetwork() { return network; }
}
