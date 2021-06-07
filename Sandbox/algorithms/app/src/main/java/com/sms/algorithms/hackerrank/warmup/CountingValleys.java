package com.sms.algorithms.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sockMerchant.txt"));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    final static class Result {

        public static int countingValleys(int steps, String path) {
            int valleyNum = 0;
            int tracker =  0;
            boolean isFirst = true;
            System.out.println(steps);
            System.out.println(path);
            for (char c : path.toCharArray()) {
                if(c == 'U') {
                    tracker++;
                }else if( c == 'D'){
                    tracker --;
                }
                if(tracker == 0 ) {
                    if( c == 'U') {
                        valleyNum++;
                    }
                } 

                System.out.print(tracker);
                System.out.println(c);
            }
            System.out.println(String.format("Valleys walked: %s", valleyNum));
            return valleyNum;

        }

    }

}
