package com.sms.algorithms.arrays.minimumSwaps;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	int count = 0;
    	for(int i = 0; i < arr.length ; i++) {
    		//check if equal to index seeing as this allows brute force
    		if(arr[i] == i + 1) {
    			continue;
    		}
    		int tmp = arr[i];
    		arr[i] = arr[tmp - 1];
    		arr[tmp - 1] = tmp;
    		//increment swap
    		count++;
    		//now that we swapped we need to check new value so keep index for next loop
    		i--;
    	}
    	//System.out.println(Arrays.toString(arr));
    	return count;
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("minimumSwaps.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
