package com.spazomatic.designpatterns.structural.facade;

public class InvoiceCustomerSystem {

	public void createInvoiceForBill(Bill bill){
		System.out.println(String.format("Creating invoice for bill with amount %d",bill.getAmount()));
	}
}
