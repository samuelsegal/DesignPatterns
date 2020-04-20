/**
 * 
 */
package com.sms.sandbox.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;


/**
 * Use UnaryOperator when you need to have a function that must accept and 
 * return the same type.
 * 
 * @author samuelsegal
 *
 */
@Slf4j
public class UnaryOperatorExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UnaryOperator<Integer> timesAllByAGrand = (i) -> i * 1000;
		
		List<Integer> list = Lists.newArrayList(1,2,3,4,5);
		
		List<Integer> newList = mapFunctionToList(list, timesAllByAGrand);
		log.info("OG list {} operated on to times a thousand for all to be {}", list, newList);
		
	}

	private static <T> List<T> mapFunctionToList(List<T> list, UnaryOperator<T> operator) {
		List<T> newList = new ArrayList<>();
		
		for (T t : list) {
			newList.add(operator.apply(t));
		}
		return newList;
	}

}
