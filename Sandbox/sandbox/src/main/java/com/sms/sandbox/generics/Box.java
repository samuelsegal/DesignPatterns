package com.sms.sandbox.generics;

import java.util.List;

public class Box<T> {
	
	private List<T> list;

	public Box(List<T> list) {
		super();
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}

 class BoxGenericMethodsAndConstructor {
	
	private List<?> list;

	public <T> BoxGenericMethodsAndConstructor(List<T> list) {
		super();
		this.list = list;
	}

	public <T> List<?> getList() {
		return list;
	}

	public <T>  void setList(List<T> list) {
		this.list = list;
	}
	
	
}

