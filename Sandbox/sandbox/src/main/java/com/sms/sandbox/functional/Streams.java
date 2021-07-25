package com.sms.sandbox.functional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Human> humans = Human.createHumans();
		humans.stream()
			.map(Human::getOrgans)
			.flatMap(List::stream)
			.collect(Collectors.toSet())
			.forEach(System.out::println);
		
		System.err.println("--------------------------");
		
		humans.stream()
			.map(Human::getOrgans)
			.flatMap(List::stream)
			.distinct()
			.sorted()
			.collect(Collectors.toList())		
			.forEach(System.out::println);
		
		System.err.println("--------------------------");
		
		humans.stream()
			.sorted(Comparator.comparing(Human::getName))
			.forEach(System.out::println);
		
		System.err.println("--------------------------");
		
		humans.stream()
			.sorted(
					Comparator.comparing(
							Human::getName)
					.reversed())			
			.forEach(System.out::println);
	}

}
@AllArgsConstructor
@Data
class Human {
	List<String> organs;
	String name;
	
	
	static List<Human> createHumans() {
		
		List<String> organs = List.of("heart", "kidney", "lung");
		List<String> moreorgans = List.of("brain", "kidney", "lung");
		List<String> moreorgans2= List.of("liver", "kidney", "lung");
		return List.of(
				new Human(organs, "Samo"), 
				new Human(moreorgans, "Breal"), 
				new Human(moreorgans2, "EasyE"));
	}
}
