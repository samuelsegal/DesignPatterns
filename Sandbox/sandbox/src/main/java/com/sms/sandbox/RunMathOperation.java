package com.sms.sandbox;

import com.sms.sandbox.functional.MathOperation;

public class RunMathOperation {
	public static void main(String [] args) {
		MathOperation add = (a,b)->System.out.println(a + b);
		add.operation(3,4);
		
		MathOperation multiply = (a,b)->System.out.println(a * b);
		multiply.operation(10,20);
	}
}
