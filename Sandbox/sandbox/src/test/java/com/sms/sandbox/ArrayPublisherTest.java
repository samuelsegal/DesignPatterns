package com.sms.sandbox;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.reactivestreams.tck.PublisherVerification;
import org.reactivestreams.tck.TestEnvironment;

import com.sms.sandbox.reactive.publisher.ArrayPublisher;

public class ArrayPublisherTest extends PublisherVerification<Long>{

	public ArrayPublisherTest() {
		super(new TestEnvironment());
	}

	@Test
	public void executeSubsriberMethodInParticularOrder() {
		CountDownLatch latch = new CountDownLatch(1);
		ArrayList<String> observedSignals = new ArrayList<>();
		ArrayPublisher<Long> arrayPublisher = new ArrayPublisher<>(generate(5));
		
		arrayPublisher.subscribe(new Subscriber<Long>() {

			@Override
			public void onSubscribe(Subscription subscription) {
				observedSignals.add("onSubscribe");
				subscription.request(100);
			}

			@Override
			public void onNext(Long item) {
				// TODO Auto-generated method stub
				observedSignals.add("onNext(" + item + ")");

			}

			@Override
			public void onError(Throwable throwable) {
				
				observedSignals.add("onError"); 
			}

			@Override
			public void onComplete() {
				observedSignals.add("onComplete");
				latch.countDown();
			}
			
		});
		
		try {
			Assertions
				.assertThat(latch.await(1000, TimeUnit.MILLISECONDS)).isTrue();
			Assertions
				.assertThat(observedSignals)
				.containsExactly(
						"onSubscribe",
						"onNext(0)",
						"onNext(1)",
						"onNext(2)",
						"onNext(3)",
						"onNext(4)",
						"onComplete"
						);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Long[] generate(long num) {
		return LongStream
				.range(0, num >= Integer.MAX_VALUE ? 1_000_000 : num)
				.boxed()
				.toArray(Long[]::new);
	}

	@Override
	public Publisher<Long> createPublisher(long elements) {
		ArrayPublisher<Long> arrayPublisher = new ArrayPublisher<>(generate(5));
		return arrayPublisher;
	}

	@Override
	public Publisher<Long> createFailedPublisher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override @Test
	public void required_createPublisher1MustProduceAStreamOfExactly1Element() throws Throwable {
		// TODO Auto-generated method stub
		super.required_createPublisher1MustProduceAStreamOfExactly1Element();
	}
	
	
}
