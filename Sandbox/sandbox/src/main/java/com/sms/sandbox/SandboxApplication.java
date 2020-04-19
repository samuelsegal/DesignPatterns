package com.sms.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sms.sandbox.functional.PredicateExample;

@SpringBootApplication
public class SandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
		RunProcessor.main(args);
		RunMathOperation.main(args);
		RunReturnStringLength.main(args);
		
		PredicateExample.main(args);
	}

}
