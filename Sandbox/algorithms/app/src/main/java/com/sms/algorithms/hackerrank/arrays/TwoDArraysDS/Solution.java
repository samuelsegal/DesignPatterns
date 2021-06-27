package com.sms.algorithms.hackerrank.arrays.TwoDArraysDS;
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
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {

    	//Imperative Solution
    	int matrix [][] = new int[6][6];
    	int rowNum = 0;
    	
    	//Convert to 2D array
    	for(List<Integer> row : arr) {
    		int colNum = 0;
    	   for(Integer i :  row) {
    		   matrix[rowNum][colNum++] = i;
    	   }
    	   rowNum++;
    	}
    	
    	int maxSum = Integer.MIN_VALUE;
    	//Brute force
    	for(int row = 0; row < 4; row++) {
    		//could use sliding window here
    		for(int col1 = 0; col1 < 4; col1++) {
    			int top = matrix[row][col1] + matrix[row][col1 + 1] + matrix [row][col1 + 2];
    			int middle = matrix [row + 1][col1 + 1];
    			int bottom = matrix[row+2][col1] + matrix[row + 2][col1 + 1] + matrix [row + 2][col1 + 2];
    			int hourglass = top + middle + bottom;
    			maxSum = Math.max(hourglass, maxSum);
    			
    		}
    	}
    	 //Or why convert to an arr
    	for(int row = 0; row < 4; row++) {
    		//could use sliding window here
    		for(int col1 = 0; col1 < 4; col1++) {
    			int top = arr.get(row).get(col1) + arr.get(row).get(col1 + 1) + arr.get(row).get(col1 + 2);
    			int middle = arr.get(row + 1).get(col1 + 1);
    			int bottom = arr.get(row + 2).get(col1) + arr.get(row + 2).get(col1 + 1) + arr.get(row + 2).get(col1 + 2);
    			int hourglass = top + middle + bottom;
    			maxSum = Math.max(hourglass, maxSum);
    			
    		}
    	}
    	return maxSum;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("hourglasses.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hourglassesSolution.txt"));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);
        System.out.println("Max Sum: " + result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
