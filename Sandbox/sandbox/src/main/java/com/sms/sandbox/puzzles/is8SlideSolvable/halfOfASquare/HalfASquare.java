package com.sms.sandbox.puzzles.is8SlideSolvable.halfOfASquare;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import java.util.function.BinaryOperator;
public class HalfASquare {

	/**
	 * Write a program that uses only two output statements, cout << "#" and cout << "\n", to produce a pattern of hash symbols shaped like half of a perfect 5 x 5 square (or a right triangle):
             #####
             ####
             ###
             ## 
             #

	 * @param args
	 */
	public static void main(String[] args) {
		imperativeSolution(6);
		reductionSolution(6);
	}
	
	static final void imperativeSolution(int num) {
		for(int i = num; i > 0; i-- ) {
			for(int j = 0; j < i;j++) {
				System.out.print("#");
			}
			System.out.print("\n");
		}
	}
	static final void reductionSolution(int num) {
		
		/**
		 * Bad example
		 */
		String [] pounds = new String[num];
		for (int i = 0; i < num; i++) {
			pounds [i] = "#";
		}
		
		BinaryOperator<String> printPounds = (pound, acc) -> {
			System.out.println(pound);
			return acc + pound;
		};
		Stream.of(pounds).reduce("#",printPounds);
	}

}
