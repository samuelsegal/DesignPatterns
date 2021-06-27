package com.sms.sandbox.functional.parallelStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionTester {
   public static void main(String[] args) {

      Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
      List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

      System.out.println("List using Serial Stream:");
      listOfIntegers
         .stream()
         .forEach(e -> System.out.print(e + " "));
      System.out.println("");

      System.out.println("List using Parallel Stream:");
      listOfIntegers
         .parallelStream()
         .forEach(e -> System.out.print(e + " "));
      System.out.println("");

      System.out.println("List using Another Parallel Stream:");
      listOfIntegers
         .stream()
         .parallel()
         .forEach(e -> System.out.print(e + " "));
      System.out.println("");

      System.out.println("List using Parallel Stream but Ordered:");
      listOfIntegers
         .parallelStream()
         .forEachOrdered(e -> System.out.print(e + " "));
         System.out.println(""); 
   } 
}