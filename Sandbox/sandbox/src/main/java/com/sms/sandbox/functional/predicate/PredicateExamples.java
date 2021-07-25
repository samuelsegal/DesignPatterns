package com.sms.sandbox.functional.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class PredicateExamples {


	
	
	public static void main(String [] args) {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> nums2 = Arrays.asList(1,2);
		Predicate<Integer> lessThen5 = n -> n < 5;		
		
		System.out.println("*** functional test lambda ***");
		System.out.println(lessThen5.test(10) ? "10 is less then 5" : "10 is not less then 5");
		
		nums.stream().filter(lessThen5.negate()).forEach(System.out::print);
		System.out.println("*** not operator ***");
		System.out.println(Predicate.not(lessThen5).test(10));
		
		System.out.println("*** and operator ***");
		Predicate<Integer> grtThen2 = n -> n > 2;
		nums.stream().filter(lessThen5.and(grtThen2)).forEach(System.out::print);
		
		System.out.println("\n*** isEquals operator ***");
		
		Predicate<Object> isEqualToNums = Predicate.isEqual(nums);
		System.out.println(isEqualToNums.test(nums2));
		
		System.out.println("*** or operator ***");
		nums.stream().filter(lessThen5.or(grtThen2)).forEach(System.out::println);;
		
	}
	
}
