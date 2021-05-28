package rxJavaBox.chapters;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Ch1_1 {
	public static void main(String[] args) {
		//Observable<String> myStrings = Observable.just("Alpha", "Beta", "Gamma");
		Observable<String> strs = Observable.just("samo", "albert", "friend");
		strs.subscribe(System.out::println);
		strs.map(s->s.length()).subscribe(System.out::println);
		
		
		//Intervals
		Observable<Long> seconds$ = Observable.interval(1, TimeUnit.SECONDS);
		seconds$.subscribe(System.out::println);
		try {
			//current thread goes to sleep in 5 seconds
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}