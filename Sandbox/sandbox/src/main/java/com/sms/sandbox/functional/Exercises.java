package com.sms.sandbox.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Exercises {

	public static void main(String[] args) {
		List<Integer> listOfInts = Arrays.asList( new Integer[]{1,2,3,4,5,6,7});
		List<Double> sqrRoots = listOfInts.stream().map(sqrRoot).collect(Collectors.toList());
		List<Double> sqrRoots2 = listOfInts.stream().map(Math::sqrt).collect(Collectors.toList());
		
		log.info("Square Roots: {}", sqrRoots);
		
		List<String> stringList = Arrays.asList(new String[] {"Samo"," Blamo", "makemeupper"});
		List<String> upperCaseList = stringList.stream()
												.map(String::toUpperCase)
												.collect(Collectors.toCollection(ArrayList::new));
		log.info("Uper case Strings {}", upperCaseList);
		
		List<Color> colorsToSort = Arrays.asList(new Color[] {new Color("red"), new Color("blue"), new Color("green")});
		List<String> sortColorNames = colorsToSort.stream()
													.map(Color::getName)
													.sorted((color1, color2)->color1.compareTo(color2))
													.collect(Collectors.toList());
		
		log.info("Sorted Colors :: {}",sortColorNames);
	}
	static Function<Integer, Double> sqrRoot = Math::sqrt;
}

@Data
@RequiredArgsConstructor
class Color{
	final private String name;
	private String htmlCode;
}
