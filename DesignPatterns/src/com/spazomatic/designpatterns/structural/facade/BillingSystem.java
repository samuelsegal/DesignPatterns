package com.spazomatic.designpatterns.structural.facade;

public class BillingSystem {

	public Bill createBill(Integer amount){
		return new Bill(amount);
	}
}
