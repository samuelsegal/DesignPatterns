package com.sms.sandbox.functional.streams;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Band {
	private String name;
	private String genre;

	
}
