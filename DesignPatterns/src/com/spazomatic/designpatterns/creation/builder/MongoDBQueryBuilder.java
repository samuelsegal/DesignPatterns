package com.spazomatic.designpatterns.creation.builder;

public class MongoDBQueryBuilder implements QueryBuilder{

	private MongoDBQuery MongoDBQuery;
	
	
	public MongoDBQueryBuilder() {
		MongoDBQuery = new MongoDBQuery();
	}

	@Override
	public void from(String from) {
		MongoDBQuery.setFrom(from);		
	}

	@Override
	public void where(String where) {
		MongoDBQuery.setWhere(where);
		
	}

	@Override
	public Query getQuery() {
		
		return MongoDBQuery;
	}

}
