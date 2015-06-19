package com.scholastic.intl.primedigital.cammon.utill;

import java.sql.Types;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class PDAuthorizeMySqlDialect extends MySQL5InnoDBDialect {
	public PDAuthorizeMySqlDialect() {
		super();
		registerColumnType(Types.BOOLEAN, "bit");
		registerColumnType( Types.LONGVARCHAR, "longtext" ); 
	}
}
