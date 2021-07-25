package com.sms.algorithms.hackerrank.maps.ransomNote;
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
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {

    	Map<String, Integer> wordMapMag  = new HashMap<>();
    	//imperative
    	for(String word : magazine) {
    		int count = wordMapMag.get(word) != null ? wordMapMag.get(word) + 1 : 1;
    		wordMapMag.put(word, count);
    	}
    	Map<String, Integer> wordMapNote = new HashMap<>();
    	for(String word : note) {
    		int count = wordMapNote.get(word) != null ? wordMapNote.get(word) + 1: 1;    
    		wordMapNote.put(word, count);
    	}
    	boolean canUse = true;
    	
    	for(var entry : wordMapNote.entrySet()) {
    		if(wordMapMag.containsKey(entry.getKey())) {
    			if(wordMapMag.get(entry.getKey()) < entry.getValue()) {
    				canUse = !canUse;
    				break;
    			}
    		}else {
    			canUse = !canUse;
    			break;
    		}
    	}
    	System.out.println(canUse ? "Yes" : "No");
    	
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
