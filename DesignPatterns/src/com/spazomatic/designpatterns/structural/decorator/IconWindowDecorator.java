/**
 * 
 */
package com.spazomatic.designpatterns.structural.decorator;

/**
 * 
 *
 */
public class IconWindowDecorator extends WindowDecorator {

	/**
	 * @param window
	 */
	public IconWindowDecorator(Window window) {
		super(window);		
	}

	@Override
	public void draw() {
		System.out.println("Drawing Icon Window");
		window.draw();
	}
	
}
