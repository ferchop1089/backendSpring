package com.tutorial.spring.backend.utilities;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Optional<T> {

	private final java.util.Optional<T> opt;

	private Optional(java.util.Optional<T> opt) {
		this.opt = Objects.requireNonNull(opt);
	}

	public static <T> Optional<T> of(java.util.Optional<T> opt) {
		return new Optional<>(opt);
	}

	public static <T> Optional<T> ofNullable(T value) {
		java.util.Optional<T> ofNullable = java.util.Optional.ofNullable(value);
		return of(ofNullable);
	}

	public static <T> Optional<T> empty() {
		java.util.Optional<T> empty = java.util.Optional.empty();
		return of(empty);
	}

	public T get() {
		return opt.get();
	}

	public boolean isPresent() {
		return opt.isPresent();
	}

	public void ifPresent(Consumer<? super T> ifPresent) {
		opt.ifPresent(ifPresent);
	}

	public Optional<T> filter(Predicate<? super T> predicate) {
		java.util.Optional<T> filter = opt.filter(predicate);
		if (filter == opt) {
			return this;
		} else {
			return Optional.of(filter);
		}
	}

	public <U> Optional<U> map(Function<? super T, ? extends U> mapper) {
		java.util.Optional<U> map = opt.map(mapper);
		return Optional.of(map);
	}

	public <U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {
		Objects.requireNonNull(mapper);
		if (!isPresent()) {
			return empty();
		} else {
			return Objects.requireNonNull(mapper.apply(get()));
		}
	}

	public T orElse(T other) {
		return opt.orElse(other);
	}

	public T orElseGet(Supplier<? extends T> other) {
		return opt.orElseGet(other);
	}

	public <X extends Throwable> T orElseThrow(Supplier<? extends X> orElseException) throws X {
		return opt.orElseThrow(orElseException);
	}

	// Métodos adicionales

	public java.util.Optional<T> unWrap() {
		return opt;
	}

	public boolean isNull() {
		return !isPresent();
	}

	/*
	 * public boolean isEquals() { return isPresent(); }
	 */

	/*
	 * public boolean isDifferent() { return !isPresent(); }
	 */

	public Optional<T> ifPresent(ReturnConsumer<T> ifPresent) {

		if (isPresent()) {
			return ofNullable(ifPresent.accept(get()));
		} else {
			return empty();
		}
	}

	public void ifPresentOrElse(Consumer<? super T> ifPresent, Runnable orElse) {
		if (isPresent()) {
			ifPresent.accept(get());
		} else {
			orElse.run();
		}
	}

	/*
	 * public Optional<T> ifPresentOrElse(Supplier<T> ifPresent, Supplier<T> orElse)
	 * {
	 * 
	 * if (isPresent()) { return ofNullable(ifPresent.get()); } else { return
	 * ofNullable(orElse.get()); } }
	 */

	public <R> Optional<R> ifPresentOrElse(Function<? super T, R> ifPresent, Supplier<R> orElse) {
		if (isPresent()) {
			return ofNullable(ifPresent.apply(get()));
		} else {
			return ofNullable(orElse.get());
		}
	}

	public <X extends Throwable> void ifPresentOrElseThrow(Consumer<T> ifPresent, Supplier<X> orElseException)
			throws X {
		if (isPresent()) {
			ifPresent.accept(get());
		} else {
			throw orElseException.get();
		}
	}

	/*
	 * public <R, X extends Throwable> R ifPresentOrElseThrow(Function<? super T, R>
	 * action, Supplier<X> exceptionSupplier) throws X { if (isPresent()) { //return
	 * action.apply(get()); return mapValue(action); } else { throw
	 * exceptionSupplier.get(); } }
	 */

	public <R, X extends Throwable> Optional<R> ifPresentOrElseThrow(Function<? super T, R> ifPresent,
			Supplier<X> orElseException) throws X {
		if (isPresent()) {
			return ofNullable(ifPresent.apply(get()));
		} else {
			throw orElseException.get();
		}
	}

	/*
	 * public <R> Optional<R> ifPresent(Function<? super T, Optional<R>> action) {
	 * if (isPresent()) { return action.apply(get()); } return empty(); }
	 */

	public <X extends Throwable> void ifPresentThrow(Supplier<X> ifPresentException) throws X {
		if (isPresent()) {
			throw ifPresentException.get();
		}
	}

	/*public void ifDifferent(Runnable run) {
		if (isDifferent()) {
			run.run();
		}
	}*/

	/*
	 * public void ifEquals(Runnable run) { if (isEquals()) { run.run(); } }
	 */

	public void ifNull(Runnable run) {
		if (isNull()) {
			run.run();
		}
	}

	public <U> U mapValue(Function<? super T, ? extends U> mapper) {
		java.util.Optional<U> map = opt.map(mapper);
		return map.isPresent() ? map.get() : null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Optional)) {
			return false;
		}

		Optional<?> other = (Optional<?>) obj;
		return opt.equals(other.opt);
	}

	@Override
	public int hashCode() {
		return opt.hashCode();
	}

	@Override
	public String toString() {
		return opt.toString();
	}

}