package rxJavaBox.puzzles;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class HalfASquare {

	/**
	 * Write a program that uses only two output statements, cout << "#" and cout <<
	 * "\n", to produce a pattern of hash symbols shaped like half of a perfect 5 x
	 * 5 square (or a right triangle): ##### #### ### ## #
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		printPoundsAllInOne(7);
		
        List<String> sentences = new ArrayList<>();
        sentences.add("Ladybug!  Ladybug!");
        sentences.add("Fly away home.");
        sentences.add("Your house is on fire.");
        sentences.add("And your children all gone.");
 
        Observable.fromIterable(sentences)
                .flatMap(s -> Observable.fromArray(s.split(" ")))
                .blockingSubscribe(System.out::println);
	}

	static void printPoundsAllInOne(int num) {

		Observable<String> poundStream$ = Observable.create(emitter -> {
			for (int i = num; i > 0; i--) {

				for (int j = 0; j < i; j++) {
					emitter.onNext("#");
				}
				emitter.onNext("\n");
			}
		});

		poundStream$.subscribe(System.out::print);
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");
		source.map((s -> s)).filter(i -> i.length() >= 5).subscribe(s -> System.out.println("RECEIVED: " + s));
	}

}
