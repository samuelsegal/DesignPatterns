/**
 * 
 */
package com.spazomatic.designpatterns.structural.bridge;

/**
 *
 *
 */
public abstract class IconWindow extends Window {


	public IconWindow(WindowImpl windowImpl) {
		super(windowImpl);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Adds Icon to the window after it has been drawn
	 * @see com.spazomatic.designpatterns.structural.bridge.Window#drawWindow()
	 */
	public void drawIconWindow(){
		//First draw normal window
		drawWindow();
		//second add icon
		System.out.println("Draw Icon");
	}

}
