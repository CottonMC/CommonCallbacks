package io.github.cottonmc.ccb.impl;

import io.github.cottonmc.ccb.api.RemovableEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ListBackedEvent<T> extends RemovableEvent<T> {
	private final Function<List<T>, T> invokerFactory;
	private final T dummyInvoker;
	private List<T> handlers = new ArrayList<>();

	ListBackedEvent(T dummyInvoker, Function<List<T>, T> invokerFactory) {
		this.dummyInvoker = dummyInvoker;
		this.invokerFactory = invokerFactory;
	}

	void update() {
		if (this.handlers.isEmpty()) {
			if (this.dummyInvoker != null) {
				this.invoker = this.dummyInvoker;
			} else {
				this.invoker = this.invokerFactory.apply(handlers);
			}
		} else if (this.handlers.size() == 1) {
			this.invoker = this.handlers.get(0);
		} else {
			this.invoker = this.invokerFactory.apply(this.handlers);
		}
	}

	@Override
	public void register(T listener) {
		if (listener == null) {
			throw new NullPointerException("Tried to register a null listener!");
		} else {
			this.handlers.add(listener);
			this.update();
		}
	}

	@Override
	public void remove(T listener) {
		if (listener == null) {
			throw new NullPointerException("Tried to remove a null listener!");
		} else {
			this.handlers.remove(listener);
			this.update();
		}
	}
}
