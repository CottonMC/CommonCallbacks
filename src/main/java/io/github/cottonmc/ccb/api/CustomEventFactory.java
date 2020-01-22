package io.github.cottonmc.ccb.api;

import io.github.cottonmc.ccb.impl.CustomEventFactoryImpl;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.impl.base.event.EventFactoryImpl;

import java.util.List;
import java.util.function.Function;

public final class CustomEventFactory {
	public static void invalidate() {
		EventFactoryImpl.invalidate();
	}

	public static <T> Event<T> createListBacked(Function<List<T>, T> invokerFactory) {
		return CustomEventFactoryImpl.createListBacked(invokerFactory);
	}

	public static <T> Event<T> createListBacked(T emptyInvoker, Function<List<T>, T> invokerFactory) {
		return CustomEventFactoryImpl.createListBacked(emptyInvoker, invokerFactory);
	}
}
