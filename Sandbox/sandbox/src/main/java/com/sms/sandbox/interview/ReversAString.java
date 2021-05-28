package com.sms.sandbox.interview;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReversAString {

	public static void main(String[] args) {
		String forward = "reverse";
		char[] reversed = new char[forward.length() + 1];
		for(int i = forward.length() - 1, z = 0; i >= 0; i--) {
			reversed[z++] = forward.charAt(i);
		}
		System.out.println(String.valueOf(reversed));
		
		
		Stream<IntStream> reverseViaStreams = Stream.of(forward.chars());
		
		String r = Stream.of("SamIam".split(""))
				 		.peek(System.out::print)
				 		.reduce("", (reverse, character) -> {
					log.info("Reverse : {}, Char :: {}",reverse, character);
					return character + reverse;});
		System.out.println(r);

	}

}
