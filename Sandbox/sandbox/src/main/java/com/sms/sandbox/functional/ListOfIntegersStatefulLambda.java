package com.sms.sandbox.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOfIntegersStatefulLambda {
 
	public static void main(String[] args) {
		
		List<Integer> listOfIntegers = Arrays.asList(new Integer[] {40,34,21,100,37,20});
		List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
		listOfIntegers.parallelStream()
 
				// You shou! It uses a stateful lambda expression.
				.map(e -> {
					syncList.add(e);
					return e;
				})
		.forEachOrdered(e -> System.out.print(e + " "));
		
		System.out.println("");
 
		syncList.stream().forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
	}
}