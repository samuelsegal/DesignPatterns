package com.spazomatic.designpatterns.creation.prototype;

public abstract class Graphic {
		/*
		 * use clone method to hold object that can be changed at runtime
		 * @see java.lang.Object#clone()
		 */
		public abstract Graphic clone();
		
		/*
		 * to demonstrate that the prototype object state gets copied as well.
		 */
		public abstract String getUrl();
}
