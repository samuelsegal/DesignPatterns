package com.spazomatic.designpatterns.creation.prototype;

public class Video extends Graphic{
	
	public void setUrl(String url) {
		this.url = url;
	}

	private String url;
	@Override
	public Graphic clone() {
		Video clone = new Video();
		clone.setUrl(this.url);
		return clone;
	}
	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}

}
