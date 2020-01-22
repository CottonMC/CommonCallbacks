package io.github.cottonmc.ccb.api.event.lifecycle;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourcePackProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ClientResoucePackAppendCallback {
	Event<ClientResoucePackAppendCallback> EVENT = EventFactory.createArrayBacked(ClientResoucePackAppendCallback.class, listeners -> () -> {
		List<ResourcePackProvider> providers = new ArrayList<>();
		for (ClientResoucePackAppendCallback listener : listeners) {
			providers.add(listener.getClientPackProviders());
		}
		return new ResourcePackProvider() {
			@Override
			public <T extends ResourcePackProfile> void register(Map<String, T> registry, ResourcePackProfile.Factory<T> factory) {
				for (ResourcePackProvider provider : providers) {
					provider.register(registry, factory);
				}
			}
		};
	});

	/**
	 * @return A resource pack provider you want registered.
	 */
	ResourcePackProvider getClientPackProviders();
}
