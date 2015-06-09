package com.spazomatic.designpatterns.structural.facade;
/*
 * Facade is used to abstract complexities of underlying system.
 */
public class FinancialSystemFacade {

	private BillingSystem billingSystem;
	private InvoiceCustomerSystem invoiceCustomerSystem;
	
	public FinancialSystemFacade(BillingSystem billingSystem,
			InvoiceCustomerSystem invoiceCustomerSystem) {
		this.billingSystem = billingSystem;
		this.invoiceCustomerSystem = invoiceCustomerSystem;
	}
	public void createInvoice(Integer amount){
		//abstraction of Billing and Invoice system
		Bill bill = billingSystem.createBill(amount);
		invoiceCustomerSystem.createInvoiceForBill(bill);
	}

}
