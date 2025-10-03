package tfar.xlpackets.mixin;

import net.minecraft.network.CompressionDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mixin(CompressionDecoder.class)
public class CompressionDecoderMixin {
	private static final Logger LOGGER = LogManager.getLogger();

	@ModifyConstant(method = "decode", constant = @Constant(intValue = 2097152))
	private int xlPackets(int old) {
		LOGGER.info("XXLPackets: Increasing compression decoder size limit from {} to {}", old, 2147483647);
		return 2147483647;
	}
}
