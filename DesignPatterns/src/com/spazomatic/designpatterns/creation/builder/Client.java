package com.spazomatic.designpatterns.creation.builder;

public class Client {

	public static void main(String [] args){
		QueryBuilderDirector director = new QueryBuilderDirector();
		String from = "client table";
		String where = "client name = ...";
		
		QueryBuilder builder = new SqlQueryBuilder();
		
		//build query using director passing implementation of query
		Query query = director.buildQuery(from, where, builder);
		query.execute();
		
		builder = new MongoDBQueryBuilder();
		query = director.buildQuery(from, where, builder);
		query.execute();
	}

}
