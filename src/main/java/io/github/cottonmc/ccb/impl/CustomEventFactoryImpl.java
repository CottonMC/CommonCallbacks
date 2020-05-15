package io.github.cottonmc.ccb.impl;

import net.fabricmc.fabric.api.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class CustomEventFactoryImpl {
	private static final List<ListBackedEvent<?>> LIST_BACKED_EVENTS = new ArrayList<>();

	private CustomEventFactoryImpl() {
	}

	public static void invalidate() {
		LIST_BACKED_EVENTS.forEach(ListBackedEvent::update);
	}

	public static <T> Event<T> createListBacked(Function<List<T>, T> invokerFactory) {
		return createListBacked(null, invokerFactory);
	}

	public static <T> Event<T> createListBacked(T emptyInvoker, Function<List<T>, T> invokerFactory) {
		ListBackedEvent<T> event = new ListBackedEvent<>(emptyInvoker, invokerFactory);
		LIST_BACKED_EVENTS.add(event);
		return event;
	}
}
