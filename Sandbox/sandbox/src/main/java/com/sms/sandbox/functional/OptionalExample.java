/**
 * 
 */
package com.sms.sandbox.functional;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

/**
 * Protecting null values with Optional
 * @author samuelsegal
 *
 */
/**
 * @author samuelsegal
 *
 */
@Slf4j
public class OptionalExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//get - will be deprecated use orElse or others below preferably
		Optional<Integer> opt = Optional.of(22);
		log.info("{}", opt.get());

		Optional<Integer> empty = Optional.empty();
		// isPresent
		log.info("", empty.isPresent() ? empty.get() : "none");

		// orElse
		log.info("{} :: {}", empty.orElse(0), opt.orElse(0));

		// orElseTHrow
		try {
			log.info("{}", empty.orElseThrow(() -> new NullPointerException("Was null")));

		} catch (NullPointerException e) {
			log.error(e.getMessage());
			try {
				log.info("{}", empty.orElseThrow(NullPointerException::new));
			} catch (NullPointerException ne) {

				log.error(ne.getMessage());
			}
		}

		// orElseGet
		log.info("{}", empty.orElseGet(() -> 0));
		log.info("{}", opt.orElseGet(() -> 0));
		
		
		Optional<String> optional = Optional.of("Value");
		Optional<String> emp = Optional.empty();
		//map
		String mapped = optional.map(val -> "Replaced").orElse("Empty");
		log.info(mapped);
		String mappedEmpty = emp.map(val -> "Replaced").orElse("Empty");
		log.info(mappedEmpty);
		
		
		//filter
		Optional<String> filter = optional.filter(v -> v.equals("Value"));
		log.info(filter.get());
		
		Optional<String> emptyFilter = emp.filter(v -> v.equals("Value"));
		log.info(emptyFilter.orElse("Empty"));
		
		//flatmap
		Optional<String> flatMap = optional.flatMap(
				v -> Optional.of("Replaced but not Wrapped already is an Option"));
		log.info("{}",flatMap.get());
		
		Optional<String> flatEmptyMap = emp.flatMap(
				v -> Optional.of("Flat map not replacing empty"));
		
		log.info("{}", flatEmptyMap.orElse("EMpty so not replaced"));
	}

}
