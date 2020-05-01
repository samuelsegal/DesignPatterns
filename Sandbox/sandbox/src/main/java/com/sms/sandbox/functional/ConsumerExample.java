/**
 * 
 */
package com.sms.sandbox.functional;

import java.util.ArrayList;
import java.util.function.Consumer;

import com.google.common.collect.Lists;

/**
 * Demonstrate use of FunctionalInterface Consumer. Consumer consumes given 
 * object and returns nothing. Consumer provides the accept method which accepts
 * the function you would like to perform on given argument
 * @author samuelsegal
 *
 */
public class ConsumerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Consumer<Integer> consumer = s -> System.out.println(s);
		Consumer<Object> consumerMethodReference = System.out :: println;
		
		consumer.accept(0);
		
		printListElements(Lists.newArrayList(1, 2,3,4,5,6,7,8,9), consumer);
		printListElements(Lists.newArrayList("a", 1, " b", 44, "Tooty"), consumerMethodReference);
	}

	private static <T> void printListElements(ArrayList<T> list, Consumer<T> consumer) {
		// TODO Auto-generated method stub
		for(T elem : list) {
			consumer.accept(elem);
		}
	}

	
}
