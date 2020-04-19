package com.sms.sandbox;

import com.sms.sandbox.functional.ReturnStringLength;

public class RunReturnStringLength {
	public static void main(String [] args) {
		ReturnStringLength len = str -> str.length();
		int l = len.length("sixsixsix");
		System.out.println(l);
		ReturnStringLength multiLine = str -> {
			int l2 = str.length();
			System.out.println(str + " is " + l2 + " characters");
			return l2;		
		};
		multiLine.length("fiver");
		
	}
}
