package com.sms.sandbox.functional.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BandTest {

	private Band[] bandArr = {new Band("Motley Crue", "hairband"), new Band("Fugazi", "punk"),
			new Band("Bad Brains", "punk"), new Band("Nirvana", "grunge")};
	private List<Band> bandList = Arrays.asList();

	public static void main(String[] args) {
		BandTest bt = new BandTest();
		bt.streamExample();
		bt.integerStreams();

	}

	private void streamExample() {
		System.out.println("Punk bands: ");
		bandList.stream().filter(b -> b.getGenre().equals("punk")).map(Band::getName).distinct()
				.forEach(System.out::println);

		System.out.println("Hair bands: ");
		Arrays.stream(bandArr).filter(b -> b.getGenre().equals("hairband")).map(Band::getName)
				.forEach(s -> System.out.println(s));
		
		System.out.println("Grunge Bands:");
		Stream.of(bandArr)
		.filter(b->b.getGenre().equals("grunge")).map(b->b.getName()).forEach(System.out::println);;
	}

	private void integerStreams() {
		IntStream.range(1, 10).skip(3).forEach(System.out::print);
	}
}
