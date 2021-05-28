/**
 * 
 */
package com.sms.sandbox.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/**
 * Demonstration of FunctionalInterface Function. A Function accepts one
 * argument and produces a result.
 * 
 * @author samuelsegal
 *
 */
@Slf4j
public class FunctionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Lambda example
		Function<String, Integer> getLength1 = s -> s.length();
		// Method reference example from static method
		Function<String, Integer> getLength2 = FunctionExample::getLengthStaticFunction;
		List<String> strList = Lists.newArrayList("One", "Two", "THeree");
		List<Integer> strLengths = getSizeOfStringsInList(strList, getLength1);
		log.info("Strings {} are of lengths {}", strList, strLengths);
		List<Integer> strLengths2 = getSizeOfStringsInList(strList, getLength2);
		log.info("Strings {} are of lengths {}", strList, strLengths2);

	}

	private static <T, R> List<R> getSizeOfStringsInList(List<T> list, Function<T, R> function) {

		List<R> strLengths = new ArrayList<>();
		for (T e : list) {
			strLengths.add(function.apply(e));
		}
		return strLengths;
	}

	static Integer getLengthStaticFunction(String s) {
		return s.length();
	}

}
