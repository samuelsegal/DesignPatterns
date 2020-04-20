/**
 * 
 */
package com.sms.sandbox.functional;

import java.util.function.BiFunction;

import lombok.extern.slf4j.Slf4j;

/**
 * BiFunction ( java.util.function.BiFunction ) is a functional interface that 
 * has one abstract method and one default method declared in it. It 
 * represents an algorithm where two input parameter of same or different type 
 * is used to produce return value of same or another type.
 * @author samuelsegal
 *
 */
@Slf4j
public class BiFunctionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BiFunction<String, Integer, Integer> getSalary = (position, years) -> {
			if(position.equalsIgnoreCase("Manager")) {
				return years < 10 ? 50_000 : 60_000;
			}else if(position.equalsIgnoreCase("developer")) {
				return years < 10 ? 40_000 : 220_000;
			}
			return 0;
		};
		
		Integer oldManager = getSalary.apply("manager",22);
		int youngDeveloper = getSalary.apply("developer", 7);
		
		log.info("Old manager makes {}, young developer makes {}", oldManager, youngDeveloper);
	}

}
