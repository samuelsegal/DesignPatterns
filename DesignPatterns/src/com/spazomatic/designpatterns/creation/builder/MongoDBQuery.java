package com.spazomatic.designpatterns.creation.builder;

public class MongoDBQuery implements Query{


	private String from;
	private String where;
	
	@Override
	public void execute() {
		System.out.println(String.format("Executing Mongo DB Query from %s where %s",from,where));
		
	}
	public void setFrom(String from) {
		this.from = from;
	}

	public void setWhere(String where) {
		this.where = where;
	}
}
