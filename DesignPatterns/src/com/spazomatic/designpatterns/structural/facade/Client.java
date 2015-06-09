package com.spazomatic.designpatterns.structural.facade;

public class Client {
	public static void main(String[] args){
		BillingSystem billingSystem = new BillingSystem();
		InvoiceCustomerSystem invoiceCustomerSystem = new InvoiceCustomerSystem();
		
		//Without facade we would directly create Bill and invoice system
		//Bill bill = billingSystem.createBill(1000);
		//invoiceCustomerSystem.createInvoiceForBill(bill);

		//Facade abstracts above would be code
		FinancialSystemFacade facade = new FinancialSystemFacade(billingSystem, invoiceCustomerSystem);
		facade.createInvoice(1000);
	}
}
