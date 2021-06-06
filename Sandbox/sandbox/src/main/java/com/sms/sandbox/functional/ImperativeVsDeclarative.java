package com.sms.sandbox.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ImperativeVsDeclarative {

	public static void main(String [] args) {
		List<String> data = new ArrayList<String>(Arrays.asList("Java", "Functional", "syntax", "Is", "quite different", "then javascript syntax")); 
		System.out.println("############## Imperative  ##############");
		imperative(data);
		System.out.println("############## Declarative ##############");
		declarative(data);
	}
	static <T> void imperative(List<T> data) {
		
		for(T element : data) {
			System.out.println(element);
		}
	}
	@SuppressWarnings("unchecked")
	static <T> void declarative(List<T> data) {
		
		data.forEach(s -> System.out.println(s));	
		data.stream().forEach(System.out::println);
		data.stream().map(s -> s + " WOOOOOOOOW").forEach(System.out::println);
		List<String>streamdData = (List<String>) data.stream().collect(Collectors.toList());
		streamdData.stream().filter(s -> !s.contains(" ")).forEach(System.out::println);
		streamdData.stream().map(s -> s.length()).forEach(System.out::println);
		
	}
}
