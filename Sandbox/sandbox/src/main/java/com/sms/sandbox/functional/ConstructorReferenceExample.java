/**
 * 
 */
package com.sms.sandbox.functional;

import java.util.function.Function;

/**
 * Demonstration of using a class constructor as constructor reference lambda
 * @author samuelsegal
 *
 */
public class ConstructorReferenceExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Function<Runnable, Thread> threadGenerator = r -> new Thread(r);
		Function<Runnable, Thread> threadGenerator = Thread :: new;
		
		Runnable t1 = () -> System.out.println("Thread 1");
		Runnable t2 = () -> System.out.println("Thread 2");
		
		threadGenerator.apply(t1);
		Thread thread2 = threadGenerator.apply(t2);
		
		t1.run();
		thread2.start();
		
		threadGenerator
		.apply(() -> System.out.println("Thread 3"))
		.start();
		
		
	}

}
