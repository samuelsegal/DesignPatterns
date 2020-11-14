package com.sms.sandbox.functional.HOF;

import java.nio.charset.Charset;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * Higher Order Function example
 * 
 * @author samuelsegal
 *
 */
@Slf4j
public class HigherOrderFunctionExample {

	public static void main(String[] args) {
		IFactory<Integer> randomIntFactory = createFactory(() -> Math.random() * 100, random -> random.intValue());
		Integer intCreated = randomIntFactory.create();
		log.info("Random integer created = {}", intCreated);

		IFactory<String> randomStringFactory = createFactory(() -> Math.random() * 100,
				random -> generateRandomString(random.intValue()));
		String randomString = randomStringFactory.create();
		log.info("Random String created = {}", randomString);
	}

	public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator) {
		return () -> {
			T product = producer.produce();
			return configurator.configure(product);
		};
	}

	private static String generateRandomString(int arraySize) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		return random
				.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

	}
}
