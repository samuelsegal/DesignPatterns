package com.spazomatic.designpatterns.creation.prototype;

public class GraphicTool {

	private Graphic prototype;
	/*
	 * Initialize with a prototype instance
	 * @param prototype
	 */
	public GraphicTool(Graphic prototype){
		this.prototype = prototype;
	}
	
	/*
	 * method internal to framework
	 * 
	 */
	protected Graphic createGraphic(){
		return prototype.clone();
	}
	public void setPrototype(Graphic prototype) {
		this.prototype = prototype;
	}
}

