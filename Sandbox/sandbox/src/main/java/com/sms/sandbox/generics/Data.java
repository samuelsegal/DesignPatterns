package com.sms.sandbox.generics;

public class Data<T> implements IData<T>{
	private T data;

	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Data(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Data [data=" + data + "]";
	}
	
	
}
