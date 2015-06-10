/**
 * 
 */
package com.spazomatic.designpatterns.structural.bridge;

import sun.awt.WindowClosingListener;
import sun.awt.WindowClosingSupport;

/**
 * @author samuelsegal
 *
 */
public class MacWindowImpl implements WindowImpl {

	/* (non-Javadoc)
	 * @see com.spazomatic.designpatterns.structural.bridge.WindowImpl#drawWindow()
	 */
	@Override
	public void drawWindow() {
		System.out.println("Draw application window for mac");

	}

}
