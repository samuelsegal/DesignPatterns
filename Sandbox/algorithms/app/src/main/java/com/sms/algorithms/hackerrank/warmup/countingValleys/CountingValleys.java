package com.sms.algorithms.hackerrank.warmup.countingValleys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("countingValleys.txt"));

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
        	
        	declarativeSolution(steps, path);
        	return  imperativeSolution(steps, path);
        }
        private static int imperativeSolution(int steps, String path) {
            int valleyNum = 0;
            int tracker =  0;
           
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

            }
            return valleyNum;
        }
        
        /**
         * declarative doesn't seem to help here or I am not doing
         * what would need to be done to make declarative. It does
         * allow to separate work into a consumer. hmmm...
         * @param steps
         * @param path
         * @return
         */
        private static int declarativeSolution(int steps, String path) {
        	AtomicInteger tracker = new AtomicInteger(0);
        	AtomicInteger valleyCount = new AtomicInteger(0);
        	Consumer<Character> valleyCounter = c -> {
				boolean upMove = false;
				if(c == 'U') {
					upMove = true;
					tracker.getAndIncrement();
				}
				if(c == 'D') {
					tracker.getAndDecrement();
				}
				if(tracker.get() == 0) {
					if(upMove) {
						valleyCount.getAndIncrement();
					}
				}
			};
	
        	path.chars()
        		.mapToObj(item -> (char) item)
        		.forEach(valleyCounter);
        	
        	return valleyCount.get();
        }
    }

}
