package io.github.cottonmc.ccb.api;

public class Cancellable<T> {
	private boolean cancelled;
	private T returnValue;
	private boolean hasRet = true;

	public static <T> Cancellable<T> of(T value) {
		return new Cancellable<>(value, false);
	}

	public static Cancellable<Void> cancel() {
		Cancellable<Void> cancelled = new Cancellable<>(null, true);
		cancelled.hasRet = false;
		return cancelled;
	}

	public static <T> Cancellable<T> cancelAndReturn(T value) {
		return new Cancellable<>(value, true);
	}

	private Cancellable(T value, boolean cancelled) {
		this.cancelled = cancelled;
		this.returnValue = value;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public boolean hasReturn() {
		return hasRet;
	}

	public T getReturnValue() {
		return returnValue;
	}
}
