package com.spazomatic.designpatterns.structural.bridge;

public class Client {

	public static void main(String[] args) {
		WindowImpl windowsImpl = new WindowsWindowImpl();
		ApplicationWindow applicationWindow = new ApplicationWindow(windowsImpl);
		applicationWindow.drawApplicationWindow();
		
		WindowImpl macImpl = new MacWindowImpl();
		applicationWindow.setWindowImpl(macImpl);
		applicationWindow.drawApplicationWindow();
	}

}
