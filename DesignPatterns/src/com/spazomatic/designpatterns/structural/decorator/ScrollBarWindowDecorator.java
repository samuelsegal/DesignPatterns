/**
 * 
 */
package com.spazomatic.designpatterns.structural.decorator;

/**
 * 
 *
 */
public class ScrollBarWindowDecorator extends WindowDecorator {


	/**
	 * @param window
	 */
	public ScrollBarWindowDecorator(Window window) {
		super(window);
	}

	@Override
	public void draw() {
		System.out.println("Drawing ScrollBar Window");
		window.draw();
	}	
}
