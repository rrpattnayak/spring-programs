package com.rr.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.rr.dao")
public class PersistenceConfig {
	
	@Bean
	public JndiObjectFactoryBean createJOFB() {
		JndiObjectFactoryBean jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/dsjndi");
		return jofb;
	}
	
	@Bean
	public SimpleJdbcCall sjc() {
		return new SimpleJdbcCall ((DataSource) createJOFB().getObject());
	}
}
