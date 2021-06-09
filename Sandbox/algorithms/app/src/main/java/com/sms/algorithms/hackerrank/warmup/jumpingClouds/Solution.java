package com.sms.algorithms.hackerrank.warmup.jumpingClouds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

class Result {

	/*
	 * Complete the 'jumpingOnClouds' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY c as parameter.
	 */

	public static int jumpingOnClouds(List<Integer> c) {

		return imperativeSolution(c);

	}

	private static Integer imperativeSolution(List<Integer> c) {
		c.add(0);
		c.add(0);
		c.add(0);
		c.add(1);
		c.add(0);
		c.add(0);
		int jumpCount = 0;
		// boolean skipped = false;

		for (int position = 0; position < c.size() - 1; position++) {
			int cloud = c.get(position);
			int nextCloud;
			try {
				nextCloud = c.get(position + 1);
			} catch (IndexOutOfBoundsException e) {
				nextCloud = 0;
			}

			int nextnextCloud;
			try {
				nextnextCloud = c.get(position + 2);
			} catch (IndexOutOfBoundsException e) {
				nextnextCloud = 1;
			}
			if (cloud == 0 && nextnextCloud != 1) {
				position++;
				jumpCount++;
			} else if (nextCloud == 1) {
				position++;
			} else {
				jumpCount++;
			}

		}
		System.out.println(jumpCount);
		return jumpCount;
	}

	private static Integer declarativeSolution(List<Integer> c) {
		BinaryOperator<Integer> jump = (Integer agg, Integer cloud) -> {
			return cloud == 0 ? 1 : 0;
		};
		return c.stream().reduce(0, jump);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("jumpingClouds.txt"));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//           .collect(toList());

		int result = Result.jumpingOnClouds(new ArrayList<Integer>());

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
	}
}
