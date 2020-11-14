package com.sms.sandbox.functional.HOF;

@FunctionalInterface
public interface IProducer<T> {
	T produce();
}
