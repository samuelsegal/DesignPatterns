/**
 * 
 */
package com.sms.sandbox.functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import lombok.extern.slf4j.Slf4j;

/**
 * Similar to @see {@link BiFunction} demonstrated in @see {@link BiFunctionExample}
 * Only Difference being the 2 parameter types must be the same as welll as 
 * the return type.
 * @author samuelsegal
 *
 */
@Slf4j
public class BinaryOperatorExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryOperator<String> getSalary = (position, years) -> {
			if(position.equalsIgnoreCase("Manager")) {
				return Integer.valueOf(years) < 10 ? "$50,000" : "$60,000";
			}else if(position.equalsIgnoreCase("developer")) {
				return Integer.valueOf(years) < 10 ? "$40,000" : "$220,000";
			}
			return "A whole lot of nothing";
		};
		
		String oldManager = getSalary.apply("manager","22");
		String youngDeveloper = getSalary.apply("developer", "7");
		String ceo = getSalary.apply("ceo", "100");
		
		log.info("Old manager makes {}, young developer makes {} and ceo makes {}", 
				oldManager, youngDeveloper, ceo);
	}

}
