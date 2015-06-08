package com.spazomatic.designpatterns.creation.builder;

public class SqlQuery implements Query{

	private String from;
	private String where;
	
	@Override
	public void execute() {
		System.out.println(String.format("Executing SQL Query from %s where %s",from,where));
		
	}
	public void setFrom(String from) {
		this.from = from;
	}

	public void setWhere(String where) {
		this.where = where;
	}

}
