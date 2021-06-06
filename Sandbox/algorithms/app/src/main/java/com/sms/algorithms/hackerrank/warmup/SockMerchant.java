package com.sms.algorithms.hackerrank.warmup;

import static com.sms.algorithms.hackerrank.warmup.Result.sockMerchant;
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

class Result {

	/*
	 * Complete the 'sockMerchant' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER n 2. INTEGER_ARRAY ar
	 */

	public static int sockMerchant(int n, List<Integer> ar) {

		int pairs = 0;
		Map<Integer, Integer> sockColors = new HashMap<>();
		ar.stream().forEach(s -> {
			sockColors.put(s, sockColors.containsKey(s) ? sockColors.get(s) + 1 : 1);
		});
        /*
         * Imperative
         */
//		for (Integer value : sockColors.values()) {
//			System.out.println(value);
//			pairs += (value % 2 == 0 ? value : value - 1) / 2;
//		}

		/*
		 * Declarative
		 */
		 BinaryOperator<Integer> countPairs = (Integer accumulator, Integer sockcountforcolor) ->
				accumulator += sockcountforcolor % 2 == 0 ? sockcountforcolor
						: sockcountforcolor - 1;
			
		
		pairs = sockColors.values().stream().reduce(0,countPairs) / 2;
		
		
		System.out.println(String.format("Number of Pairs : %s", pairs));

		return pairs;
	}

}

public class SockMerchant {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sockMerchant.txt"));

		// Not sure when they'd ask this
		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int numberOfPairs = sockMerchant(n, ar);

		bufferedWriter.write(String.valueOf(numberOfPairs));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
