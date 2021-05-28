package com.sms.sandbox.reactive.publisher;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor 
@Slf4j
public class ArrayPublisher<T> implements Publisher<T> {

	private final T[] source;
	@Override
	public void subscribe(Subscriber<? super T> subscriber) {
		subscriber.onSubscribe(new Subscription() {
			
			@Override
			public void request(long n) {
				log.info("Subscription request");
				for(T s : source) {
					log.info(s.toString());
					subscriber.onNext(s);
				}
				
			}

			@Override
			public void cancel() {
				// TODO Auto-generated method stub
				
			}
			
		});

		subscriber.onComplete();
		
	}


}
