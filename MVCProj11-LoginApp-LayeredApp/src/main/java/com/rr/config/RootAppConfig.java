package com.rr.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfig.class,PersistenceConfig.class})
public class RootAppConfig {
	
}
