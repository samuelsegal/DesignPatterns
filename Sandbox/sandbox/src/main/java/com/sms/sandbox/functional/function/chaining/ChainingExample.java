package com.sms.sandbox.functional.function.chaining;

import java.util.function.Function;

public class ChainingExample {

	public static void main(String[] args) {
		Consumer<String> c1 = s -> System.out.println(s);
		Consumer<String> c2 = s -> System.out.println(s);
		
		c1.accept("Howdy");
		c2.accept("Howdy");
		
		Consumer<String> c3 = s -> {
			c1.accept(s);
			c2.accept(s);;
		};
		
		c3.accept("Hey");
		
		Consumer<String> c4 = c1.thenAccept(c2);
		c4.accept("Chaining Functions is kind of crazy");
		
		Function<Integer, Integer> f1 = s -> s + s;
		Function<Integer, Integer> f2 = s -> s * s;
		Function<Integer, Integer> f3 = f1.andThen(f2);
		System.out.println(f3.apply(2));
	}

}
