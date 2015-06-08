package com.spazomatic.designpatterns.creation.prototype;

public class Image extends Graphic {

	public void setUrl(String url) {
		this.url = url;
	}

	private String url;
	
	@Override
	public Graphic clone() {
		Image clone = new Image();
		clone.setUrl(this.url);
		return clone;
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}

	
}
