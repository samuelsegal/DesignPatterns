package com.sms.sandbox.functional.function.composition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompositionExample {

		static Function<Square, Integer> area = s -> s.getArea();
		static Function<Integer, Double> squareTheArea = area -> Math.sqrt(area);
		
		public static void main (String [] args) {
			Function<Square, Double> getSide = squareTheArea.compose(area);
			Square s = new Square();
			s.setArea(100);
			Double side = getSide.apply(s);
			
			log.info("Side of sqaure {} is {}", s, side );
		}
}
