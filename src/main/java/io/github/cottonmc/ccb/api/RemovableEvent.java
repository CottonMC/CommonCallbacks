package io.github.cottonmc.ccb.api;

import net.fabricmc.fabric.api.event.Event;

public abstract class RemovableEvent<T> extends Event<T> {

	/**
	 * Remove a listener.
	 * @param listener The listener to remove.
	 */
	public abstract void remove(T listener);
}
