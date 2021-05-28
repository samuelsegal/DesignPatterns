package com.sms.sandbox.generics;

import java.util.function.Supplier;


public class GenericsBuilder<T> {
	private final Supplier<T> supplier;

	public GenericsBuilder(Supplier<T> supplier) {
		super();
		this.supplier = supplier;
	}
	
 }
