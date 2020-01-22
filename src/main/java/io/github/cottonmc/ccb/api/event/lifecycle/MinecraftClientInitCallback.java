package io.github.cottonmc.ccb.api.event.lifecycle;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public interface MinecraftClientInitCallback {
	Event<MinecraftClientInitCallback> EVENT = EventFactory.createArrayBacked(MinecraftClientInitCallback.class, listeners -> () -> {
		for (MinecraftClientInitCallback listener : listeners) {
			listener.onClientInit();
		}
	});

	/**
	 * Run code once MinecraftClient has finished initializing, and GL/Blaze3D is ready for use.
	 */
	void onClientInit();
}
