/**
 * 
 */
package com.spazomatic.designpatterns.structural.adapter;

/**
 * Adapter will adapt one interface to another
 *
 */
public class LegacyRectangleAdapter extends Rectangle{


	private LegacyRectangle legacyRectangle;

	public LegacyRectangleAdapter(LegacyRectangle legacyRectangle) {
		super();
		this.legacyRectangle = legacyRectangle;
	}
	@Override
	public Integer determineSize() {
		
		return legacyRectangle.calulateSize();
	}
	
	
}
