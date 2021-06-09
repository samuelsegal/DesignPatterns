package com.sms.algorithms.hackerrank.warmup.repeatedString;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {

    		if(n == 0) {
    			return 0;
    		}
			long intervals = n / s.length() ;
			long numberOfOccurrences = s.chars().filter(ch -> ch ==  'a').count();

			long occurrences = intervals == 0 ? 0 : numberOfOccurrences * intervals;
			long substringlength = n % (s.length() * (intervals == 0 ? 1 : intervals));
			occurrences += s.substring(0, (int) substringlength).chars().filter(ch -> ch == 'a').count();
    		System.out.println(occurrences);
			return occurrences;

    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("repeatedString.txt"));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString("ababa", 3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}