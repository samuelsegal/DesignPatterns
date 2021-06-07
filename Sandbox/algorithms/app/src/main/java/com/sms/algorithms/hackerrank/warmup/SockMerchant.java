package com.sms.algorithms.hackerrank.warmup;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class SockMerchant {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sockMerchant.txt"));

		// Not sure when they'd ask this
		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int numberOfPairs = Result.sockMerchant(n, ar);

		bufferedWriter.write(String.valueOf(numberOfPairs));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	final static class Result {

		/*
		 * Complete the 'sockMerchant' function below.
		 *
		 * The function is expected to return an INTEGER. The function accepts following
		 * parameters: 1. INTEGER n 2. INTEGER_ARRAY ar
		 */

		public static int sockMerchant(int n, List<Integer> ar) {
			//Create map to contain key: sockColor, value: count
			Map<Integer, Integer> sockColors = new HashMap<>();
			ar.stream().forEach(s -> {
				sockColors.put(s, sockColors.containsKey(s) ? sockColors.get(s) + 1 : 1);
			});
			imperativeSolution(sockColors);
			return declarativeSolution(sockColors);

		}

		/**
		 * accumulate count fort all socks imperatively
		 * @param sockColors
		 * @return
		 */
		private static int imperativeSolution(Map<Integer, Integer> sockColors) {

			int pairs = 0;
			for (Integer value : sockColors.values()) {
				System.out.println(value);
				pairs += addSockCount(value);
			}
			pairs = pairs/2;
			System.out.println(String.format("Number of Pairs : %s", pairs ));
			return pairs;
		}

		private static int addSockCount(Integer value) {
			return (value % 2 == 0 ? value : value - 1);
		}
		
		/**
		 * accumulateCount for all socks declaratively
		 * @param sockColors
		 * @return
		 */
		private static int declarativeSolution(Map<Integer, Integer> sockColors) {

			int pairs = 0;

			BinaryOperator<Integer> countPairs = 
					(Integer accumulator,Integer sockcountforcolor) 
						-> accumulator += (sockcountforcolor % 2 == 0 ? sockcountforcolor : sockcountforcolor - 1);

			pairs = sockColors.values().stream().reduce(0, countPairs) / 2;

			System.out.println(String.format("Number of Pairs : %s", pairs));

			return pairs;
		}

	}
}
