package com.rr.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Configuration
@ComponentScan(basePackages = "com.rr.dao")
public class PersistenceConfig {
	
	@Autowired
	private DataSource ds;
	
	@Bean
	public SimpleJdbcCall sjc() {
		return new SimpleJdbcCall (ds);
	}
}
