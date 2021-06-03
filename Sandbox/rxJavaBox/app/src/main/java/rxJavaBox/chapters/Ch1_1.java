package rxJavaBox.chapters;

import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.rxjava3.core.Observable;

public class Ch1_1 {
	public static void main(String[] args) {

		
		Observable<String> stream$ = Observable.create(emitter -> {
			emitter.onNext("Heres something");

			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generate. method stub
				 emitter.onNext("And something in 3 seconds, good bye");
				 emitter.onComplete();
				 timer.cancel();;
				}
			}, 1000);
			
		});
		
		stream$.map(String::length).subscribe(System.out::println);
		stream$.map(String::length).subscribe((v) -> System.out.println("Herres the length " + v));
		stream$.subscribe(System.out::println);
		

	}
}