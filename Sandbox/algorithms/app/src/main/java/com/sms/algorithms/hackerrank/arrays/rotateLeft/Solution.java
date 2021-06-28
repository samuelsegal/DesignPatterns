package com.sms.algorithms.hackerrank.arrays.rotateLeft;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
    	Integer [] ret = new Integer [a.size()];
    	
    	
    	for(int count = 0; count < a.size(); count++) {
    		int countMinusD = count - d;
    		int position = countMinusD < 0 ? a.size() + (countMinusD) : countMinusD;
    		System.out.println(position);
    		System.out.println(a.size());
    		ret[position] =  a.get(count);
    	}
    	return new ArrayList<Integer>(Arrays.asList(ret));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");


        int d = 4;

        List<Integer> a = Arrays.asList(1,2,3,4,5);

        List<Integer> result = Result.rotLeft(a, d);
        System.out.println(result);
//        bufferedWriter.write(
//            result.stream()
//                .map(Object::toString)
//                .collect(joining(" "))
//            + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
