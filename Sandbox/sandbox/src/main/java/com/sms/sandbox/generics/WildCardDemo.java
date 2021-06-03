package com.sms.sandbox.generics;

import java.util.List;

import org.assertj.core.util.Arrays;

public class WildCardDemo {
	
	static void displayData(List<?> l) {
		for(Object t: l) {
			System.out.println(t);
		}
	}
	
	public static void main(String[]args) {
		Integer[] numList = new Integer[] {1,2,3,4,5,6};
		displayData(Arrays.asList(numList));
	}

}
