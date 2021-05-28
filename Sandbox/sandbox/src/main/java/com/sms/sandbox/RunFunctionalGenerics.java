package com.sms.sandbox;

import java.util.function.Function;

import com.sms.sandbox.functional.FunctionalGenerics;

public class RunFunctionalGenerics {

	public static void main(String[] args) {
		
		FunctionalGenerics<String, Integer> functionalGenerics = s -> Integer.valueOf(s);
		Integer i = functionalGenerics.execute("22");
		System.out.println("i is an instance of Integer: " + (i instanceof Integer));
		
		FunctionalGenerics<String, Function<String,String>> func = s -> {return Function.identity();};
		Function<String,String> f = func.execute("samo");
		System.out.println(f.apply("samo"));
		System.out.println("f is instance of Function: " + (f instanceof Function));
		
	}

}
