package io.github.cottonmc.ccb.mixin;

import io.github.cottonmc.ccb.api.event.lifecycle.ClientResoucePackAppendCallback;
import net.minecraft.client.resource.ClientBuiltinResourcePackProvider;
import net.minecraft.resource.ResourcePackProfile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ClientBuiltinResourcePackProvider.class)
public class MixinClientBuiltinResourcePackProvider {
	@Inject(method = "register", at = @At("RETURN"))
	private <T extends ResourcePackProfile> void addEventPacks(Map<String, T> registry, ResourcePackProfile.Factory<T> factory, CallbackInfo info) {
		ClientResoucePackAppendCallback.EVENT.invoker().getClientPackProviders().register(registry, factory);
	}
}
