package com.spazomatic.designpatterns.creation.prototype;

public class Client {

	public static void main(String[] args) {
		Image image = new Image();
		image.setUrl("http://www.google.com");
		
		GraphicTool tool = new GraphicTool(image);
		
		Graphic graphic = tool.createGraphic();
		System.out.println(String.format(
				"Graphic Instance %s url %s", 
				graphic.getClass(), graphic.getUrl()));
		
		//demonstrate state change via clone prototype
		image.setUrl("http://www.spazomatic.com");
		
		System.out.println(String.format("Graphic URL %s",graphic.getUrl()));
		
		Video video = new Video();
		video.setUrl("http:/www.github.com");
		
		tool.setPrototype(video);
		graphic = tool.createGraphic();
		System.out.println(String.format(
				"Graphic Instance %s url %s", 
				graphic.getClass(), graphic.getUrl()));
		
		
	}

}
