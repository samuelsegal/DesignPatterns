package com.sms.algorithms.hackerrank.arrays.newYearChaos;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'minimumBribes' function below.
	 *
	 * The function accepts INTEGER_ARRAY q as parameter.
	 */

	public static void minimumBribes(List<Integer> list) {
		int[] q = list.stream().mapToInt(i -> i).toArray();
		int bribes = 0;
		for (int i = 0; i < list.size(); i++) {
			if (q[i] - (i + 1) > 2){
				//if(the current value of index - index + 1 > 2) then we moved up too far
				//for instance we can't have a 5 at index 1 as 5 - (1 + 1) is 3 meaning 5 moved bribes forward
				System.out.println("Too chaotic");
				return;
			}

			for (int offSet = Math.max(0, q[i] - 2); offSet < i; offSet++) {
				//because we checked to if to chaotic already then we know
				//that anything before 2 moves ahead, would have resulted in too chaotic
				//so we just need to check all from the value set at 2 below current value
				if (q[offSet] > q[i]) {
					//System.out.println(String.format("q[offset] = %s, q[i] = %s", q[offSet], q[i]));
					bribes++;
				}
			}
		}
		System.out.println(bribes);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList());

				Result.minimumBribes(q);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}
}
