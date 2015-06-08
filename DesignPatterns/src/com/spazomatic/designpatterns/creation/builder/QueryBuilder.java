package com.spazomatic.designpatterns.creation.builder;

public interface QueryBuilder {

	void from(String from);
	void where(String where);
	Query getQuery();

}
