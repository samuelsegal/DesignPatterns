package com.sms.algorithms.hackerrank.arrays.arrayManipulation;
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
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Write your code here
    	int a = 0;
    	int b = 1;
    	int k = 2;
    	List<Integer> zeros = new ArrayList<>(Collections.nCopies(n + 1, 0));

    	//Naive Solution
    	long max = Long.MIN_VALUE;
    	for(int i = 0; i < queries.size(); i++) {
    		int amount = queries.get(i).get(k);
    		int start = queries.get(i).get(a);
    		int end = queries.get(i).get(b);

    		while(start <= end) {   
    			zeros.set(start,zeros.get(start) + amount);
    			max = zeros.get(start) > max ? zeros.get(start) : max;
    			start++;
    		}
    		System.out.println(zeros);
    	}
    	
    	System.out.println("Optimized: ");
    	//Optimized
    	Map<Integer, Integer> boundaries = new TreeMap<>();
    	for(int i = 0; i < queries.size(); i++) {
    		int amount = queries.get(i).get(k);
    		int start = queries.get(i).get(a);
    		int end = queries.get(i).get(b);
    		int sVal = boundaries.get(start) != null ? boundaries.get(start) : 0;
    		int eVal = boundaries.get(end + 1) != null ? boundaries.get(end + 1) : 0;
    		boundaries.put(start, sVal  += amount);
    		boundaries.put(end + 1, eVal -= amount);
    		System.out.println(boundaries);
    	}

    	System.out.println(boundaries);
    	long sum = 0;
    	for(var entry : boundaries.entrySet()) {
    		System.out.println(String.format("%s :: %s", entry.getKey(), entry.getValue()));
    		sum += entry.getValue();
    		max = Math.max(sum, max);
    	}
    	
    	return max;
    }
  
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ArrayManipulation.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

//        int n = 10;
//        queries.add(Arrays.asList(2,6,8));
//        queries.add(Arrays.asList(3,5,7));
//        queries.add(Arrays.asList(1,8,1));
//        queries.add(Arrays.asList(5, 9, 15));
        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
