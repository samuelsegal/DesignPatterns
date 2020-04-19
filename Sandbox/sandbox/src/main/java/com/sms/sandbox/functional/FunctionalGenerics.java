package com.sms.sandbox.functional;

@FunctionalInterface
public interface FunctionalGenerics<T,R> {
	R execute(T t);
}

