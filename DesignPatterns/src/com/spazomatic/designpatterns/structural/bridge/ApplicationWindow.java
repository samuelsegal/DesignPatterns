package com.spazomatic.designpatterns.structural.bridge;
/*
 * This is the bridge
 */
public class ApplicationWindow extends Window {	

	public ApplicationWindow(WindowImpl windowImpl) {
		super(windowImpl);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Draws normal window plus adds icon to toolbar of window
	 * @see com.spazomatic.designpatterns.structural.bridge.Window#drawWindow()
	 */
	public void drawApplicationWindow(){
		drawWindow();
		System.out.println("Draw Application Icon");
	}

}
