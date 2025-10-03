package tfar.xlpackets.mixin;

import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mixin(FriendlyByteBuf.class)
public class PacketByteBufMixin {
	private static final Logger LOGGER = LogManager.getLogger();

	@ModifyConstant(method = "readNbt()Lnet/minecraft/nbt/CompoundTag;", constant = @Constant(longValue = 2097152L))
	private long xlPackets(long old) {
		LOGGER.info("XXLPackets: Increasing NBT size limit from {} to {}", old, 2_147_483_647L);
		return 2_147_483_647L;
	}
}
