package com.sms.sandbox.generics;

import java.util.List;

public class NumberSorter<T extends Number> {

	private List<T> nums;

	public NumberSorter(List<T> nums) {
		super();
		this.nums = nums;
	}

	public NumberSorter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<T> getNums() {
		return nums;
	}

	public void setNums(List<T> nums) {
		this.nums = nums;
	}
	
	public void sortAndDisplay() {
		nums.sort(null);
		for (T t : nums) {
			System.out.println(t);
		}
	}
}
