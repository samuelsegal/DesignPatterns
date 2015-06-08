package com.spazomatic.designpatterns.creation.builder;

public class SqlQueryBuilder implements QueryBuilder{

	SqlQuery sqlQuery;
	public SqlQueryBuilder() {
		sqlQuery = new SqlQuery();
	}

	@Override
	public void from(String from) {
		sqlQuery.setFrom(from);		
	}

	@Override
	public void where(String where) {
		sqlQuery.setWhere(where);		
	}

	@Override
	public Query getQuery() {
		return sqlQuery;
	}

}
