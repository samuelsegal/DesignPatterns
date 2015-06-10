/**
 * 
 */
package com.spazomatic.designpatterns.structural.bridge;

/**
 * @author samuelsegal
 *
 */
public abstract class Window {
	//bridge pattern, windowImpl contains drawWindow functionality
	private WindowImpl windowImpl;
	
	public Window(WindowImpl windowImpl) {
		this.windowImpl = windowImpl;
	}

	/**
	 * Draw window on the screen
	 */
	public void drawWindow(){
		windowImpl.drawWindow();
	}

	public void setWindowImpl(WindowImpl windowImpl) {
		this.windowImpl = windowImpl;
	}
}
