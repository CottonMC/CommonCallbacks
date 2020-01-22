package io.github.cottonmc.ccb.mixin;

import io.github.cottonmc.ccb.api.event.lifecycle.MinecraftClientInitCallback;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
	@Inject(method = "<init>", at = @At("RETURN"))
	private void onClientInit(CallbackInfo info) {
		MinecraftClientInitCallback.EVENT.invoker().onClientInit();
	}
}
