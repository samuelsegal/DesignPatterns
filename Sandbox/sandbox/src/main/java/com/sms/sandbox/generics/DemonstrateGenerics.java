package com.sms.sandbox.generics;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

import com.google.common.collect.ImmutableList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemonstrateGenerics {

	public static void main(String... args) {
		//Data<String> string = Maker.create(Data::new);
		//string.setData("Howdy");
		Data<String> data = Maker.create(()->new Data<>("Waddup")).create();
		Data<Integer> integer = new Data<>(1);
		
		log.info(data.getData());
		log.info(integer.getData().toString());
		List<String> rr = new ArrayList<>();
		ImmutableList<String> immutable = ImmutableList.of("one", "two", "5");
		try {
			immutable.add("howdy");
		}catch(Exception e) {
			log.info(e.getClass().descriptorString());
		}
		immutable.forEach((imm) -> System.out.println(imm.toString())); 
		Bin<Integer, String> trashBin = new Bin<>(1,"gross");
		log.info(trashBin.getWetTrash() + trashBin.getDryTrash());
		
		List<Number> nums = List.of(1,2);
		
		//NOTE: commented out wont work because List.of() returns an Immutable List 
		//that will not allow sort operation that modifes list in DataSorter.
		//Of course we could change DataSorter.sortAndDisplay to make a new sorted object internally
		//Leaving here for reference because if you dont pay attention to return type
		// you be like whaaaaaaaa?
		//NumberSorter<Number> sortMe = new NumberSorter(List.of(1,3,2,5,90,5,6));
		NumberSorter<Number> sortMe = new NumberSorter(Arrays.asList(new Integer [] {1,3,2,5,90,5,6}));
		sortMe.sortAndDisplay();
	}
	
	public static <T extends Number> void sortAndDisplay(List<T> nums) {
		nums.sort(null);
		for (T t : nums) {
			System.out.println(t);
		}
	}
}
