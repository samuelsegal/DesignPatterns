/**
 * 
 */
package com.sms.sandbox.functional;

import java.util.function.Supplier;

/**
 * Supplier Accepts no argument. However it returns an object. I would imagine
 * this could be used for creating things maybe? Like supplying things on
 * demand I suppose.
 * @author samuelsegal
 *
 */
public class SupplierExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Supplier<String> newStringWithColonPrefix = () -> new String(": ");
		System.out.println(newStringWithColonPrefix.get().concat("Howdy"));
		
		Supplier<Double> randomNumbre = () -> Math.random();
		System.out.println(randomNumbre.get());
		System.out.println(randomNumbre.get());
		System.out.println(randomNumbre.get());
		System.out.println(randomNumbre.get());
	}

}
