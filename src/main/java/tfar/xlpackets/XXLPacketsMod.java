package tfar.xlpackets;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.bus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(XXLPacketsMod.MODID)
public class XXLPacketsMod {
    public static final String MODID = "xxlpackets";
    private static final Logger LOGGER = LogManager.getLogger();

    public XXLPacketsMod(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
    }

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("XXLPackets mod loaded successfully! Packet size limits increased to 2GB.");
        LOGGER.info("XXLPackets: If you see this message, the mod is loaded. Check for mixin application messages above.");
    }
}