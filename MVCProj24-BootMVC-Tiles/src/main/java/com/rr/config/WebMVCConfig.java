package com.rr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class WebMVCConfig {
	
	@Bean
	public TilesConfigurer createTilesConfigure() {
		TilesConfigurer configure=new TilesConfigurer();
		configure.setDefinitions("/WEB-INF/tiles.xml");
		return configure;
	}
	
	@Bean
	public TilesViewResolver tv() {
		return new TilesViewResolver();
	}
}
