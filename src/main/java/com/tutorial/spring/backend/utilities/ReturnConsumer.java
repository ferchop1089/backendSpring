package com.tutorial.spring.backend.utilities;

import java.util.Objects;

@FunctionalInterface
public interface ReturnConsumer<T> {

	T accept(T t);

	default ReturnConsumer<T> andThen(ReturnConsumer<T> after) {
		Objects.requireNonNull(after);
		ReturnConsumer<T> c = (T t) -> {
			t = accept(t);
			t = after.accept(t);
			return t;
		};
		return c;
	}
}
