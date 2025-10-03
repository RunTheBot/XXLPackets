package tfar.xlpackets.mixin;

import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mixin(ClientboundCustomPayloadPacket.class)
public class ClientboundCustomPayloadPacketMixin {
	private static final Logger LOGGER = LogManager.getLogger();

    @ModifyConstant(method = {"<init>"},
            constant = @Constant(intValue = 1048576))
    private int xlPackets(int old) {
        LOGGER.info("XXLPackets: Increasing custom payload packet size limit from {} to {}", old, 2147483647);
        return 2147483647;
    }
}