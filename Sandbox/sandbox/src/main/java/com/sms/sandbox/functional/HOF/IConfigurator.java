package com.sms.sandbox.functional.HOF;

@FunctionalInterface
public interface IConfigurator<T, R> {

	R configure(T t);
}
