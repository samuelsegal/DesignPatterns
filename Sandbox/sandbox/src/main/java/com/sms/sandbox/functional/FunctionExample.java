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
 * @author samuelsegal
 *
 */
@Slf4j
public class FunctionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Function< String, Integer> getLength = s -> s.length();
		List<String> strList = Lists.newArrayList("One", "Two", "THeree");
		List<Integer> strLengths= getSizeOfStringsInList(strList, getLength);
		log.info("Strings {} are of lengths {}", strList, strLengths);
		
	}

	private static <T,R> List<R> getSizeOfStringsInList(List<T> list,
			Function<T,R> function) {
		
		List<R> strLengths = new ArrayList<>();
		for(T e : list) {
			strLengths.add(function.apply(e));
		}
		return strLengths;
	}

}
