package com.sms.sandbox;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.sms.sandbox.functional.Processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
		
        String prefix = "Prefix: ";

        System.out.println(functional("Hello World!", prefix::concat));
        System.out.println(staticLambda(10, String::valueOf));
        System.out.println(functional("upper", str -> str.toUpperCase()));
        System.out.println(internalJavaFunctionalInterface("LOWER", str -> str.toLowerCase()));
        System.out.println((functional("MethodByReference toLowerCase", String::toLowerCase)));
        System.out.println((bifunctional("MethodByReference substring", 6, (str, i) -> str.substring(i))));

        String[] names = {"Mr. sam", "Mr. Rob", "Dr. Rob", "Dr. James", "Dr. Sam", "Mr. James"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.split(" ")[1].compareTo(o2.split(" ")[1]);
            }
        });

        String[] namesLambda = {"Mr. Bo", "Dr. Pop", "Mr. Jackson"};
        Arrays.sort(namesLambda, (name1, name2) -> {
             return name1.split(" ")[1].compareTo(name2.split(" ")[1]);
        });


        String[] namesComparator = {"Mr. Foo", "Dr. Abe", "Mr. Wowzer"};
        Arrays.sort(namesComparator, Comparator.comparing(name -> name.split(" ")[1]));

        String[] staticFunctionRef = {"Mr. oh", "Dr. nice", "Mr. cow"};
        String[] instanceFunctionRef = {"Mr. instance", "Dr. v", "Mr. coo"};
        SandboxApplication m = new SandboxApplication();
        Arrays.sort(staticFunctionRef, Comparator.comparing(m::firstNameNonStatic));
        Arrays.sort(instanceFunctionRef, Comparator.comparing(SandboxApplication::firstName));


        System.out.println("Names anonymous function: " + (Arrays.toString(names)));
        System.out.println("Names lambda: " + (Arrays.toString(namesLambda)));
        System.out.println("Names Comparator: " + (Arrays.toString(namesComparator)));
        System.out.println("Instance function reference: " + (Arrays.toString(instanceFunctionRef)));
        System.out.println("Static function reference: " + (Arrays.toString(staticFunctionRef)));

        Arrays.sort(staticFunctionRef, Comparator.comparing(SandboxApplication::firstName).reversed());
        System.out.println("Reversed Static function reference: " + (Arrays.toString(staticFunctionRef)));

        Arrays.sort(names, Comparator.comparing(SandboxApplication::firstName).thenComparing(SandboxApplication::title));
        System.out.println(("Sorted by name then title: " + Arrays.toString(names)));		
	}
    public static String title(String name){
        return name.split(" ")[0];
    }
    public String firstNameNonStatic(String name){
        return name.split(" ")[1];
    }
    public static String firstName(String name){
        return name.split(" ")[1];
    }
    private static String functional(String str, Processor processor) {
        return processor.process(str);
    }

    private static String bifunctional(String str, int i, BiFunction<String, Integer, String> processor) {
        return processor.apply(str, i);
    }

    private static String internalJavaFunctionalInterface(String str, Function<String, String> processor){
        return processor.apply(str);
    }
    private static String staticLambda(Integer str, Function<Integer, String> processor){
        return processor.apply(str);
    }
}
