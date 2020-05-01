package com.sms.sandbox.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/*
 * Demonstration of use of function interface Predicate. Predicate allows
 * us to define a test that can be used for any given object and to pass it 
 * as a parameter the fly
 *
 * @author samuelsegal
 *
 */
@Slf4j
public class PredicateExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Tooty");
		list.add("Too");
		list.add("Rudy");
		log.info("OG list with words containg Too {}", list);
		Predicate<String> predicate = s -> !s.contains("Too");
		List<String> filteredList = filterList(list, predicate);
		log.debug("Filtered List without words containing Too {}", filteredList);
		
		
		List<Integer> intList = Lists.newArrayList(1,2,3,4);
		Predicate<Integer> greaterThan2 = i -> i > 2;
		List<Integer> numsAbove2 = filterGenericList(intList, greaterThan2);
		log.info("OG list {} cvs list only including nums above 2 {}", intList, numsAbove2 );

	}

	private static List<String> filterList(List<String> list, Predicate<String> predicate) {
		List<String> filteredList = new ArrayList<>();

		for (String str : list) {
			if (predicate.test(str)) {
				filteredList.add(str);
			}

		}
		return filteredList;
	}
	/**
	 * Same as filtered but handles any type
	 * @param list
	 * @param predicate
	 * @return
	 */
	private static <T> List<T> filterGenericList(List<T> list, Predicate<T> predicate) {
		List<T> filteredList = new ArrayList<>();

		for (T str : list) {
			if (predicate.test(str)) {
				filteredList.add(str);
			}

		}
		return filteredList;
	}
}
