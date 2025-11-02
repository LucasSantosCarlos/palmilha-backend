package com.example.palmilha_backend.config;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQLDialect;

public class PostgreSQLDialectPalmilha extends PostgreSQLDialect {

	public PostgreSQLDialectPalmilha() {
		
	}
	
	@Override
	public String columnType(int sqlTypeCode) {
		
		if(sqlTypeCode == Types.DOUBLE) {
			return "NUMERIC";
		} else if(sqlTypeCode == Types.FLOAT) {
			return "NUMERIC";
		}
		
		return super.columnType(sqlTypeCode);
	}

}
