/**
 * 
 */
package com.spazomatic.designpatterns.structural.adapter;

/**
 * 
 *
 */
public class Client {
	
	
	public static void main(String [] args){
		Client client = new Client();
		LegacyRectangle legacyRectangle = new LegacyRectangle();
		LegacyRectangleAdapter legacyRectangleAdapter = new LegacyRectangleAdapter(legacyRectangle);
		client.calulateRectangleSize(legacyRectangleAdapter);
				
	}
	
	public void calulateRectangleSize(Rectangle rectangle){
		System.out.println(String.format("Rectangle size %d", rectangle.determineSize()));
	}
}
