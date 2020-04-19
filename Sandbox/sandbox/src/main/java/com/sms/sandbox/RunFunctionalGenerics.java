package com.sms.sandbox;

import com.sms.sandbox.functional.FunctionalGenerics;

public class RunFunctionalGenerics {

	public static void main(String[] args) {
		
		FunctionalGenerics<String, Integer> functionalGenerics = s -> Integer.valueOf(s);
		Integer i = functionalGenerics.execute("22");
		System.out.println("i is an instance of Integer: " + (i instanceof Integer));
	}

}
