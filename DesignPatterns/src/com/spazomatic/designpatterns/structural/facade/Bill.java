package com.spazomatic.designpatterns.structural.facade;

public class Bill {
	public Integer getAmount() {
		return amount;
	}
	private Integer amount;
	public Bill(Integer amount){
		this.amount = amount;
	}
	
}
