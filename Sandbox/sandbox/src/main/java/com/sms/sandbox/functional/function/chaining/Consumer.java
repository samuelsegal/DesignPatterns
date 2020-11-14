package com.sms.sandbox.functional.function.chaining;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {

		void accept(T t);

		/**
		 * chaining method. Notice the requireNonNull. 
		 * This is because the return function does not execute until the chained method calls accept.
		 * @param next
		 * @return
		 */
		default Consumer<T> thenAccept(Consumer<T> next){
			
			Objects.requireNonNull(next);
			
			return (T t) -> {
				this.accept(t);
				next.accept(t);
			};
		}
}
