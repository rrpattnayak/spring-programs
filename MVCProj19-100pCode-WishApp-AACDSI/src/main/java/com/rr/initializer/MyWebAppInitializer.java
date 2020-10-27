package com.rr.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.rr.config.RootAppConfig;
import com.rr.config.WebMVCConfig;

public class MyWebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	public Class<?>[] getRootConfigClasses() {
		return new Class[] { RootAppConfig.class };
	}
	
	@Override
	public Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMVCConfig.class };
	}
	
	@Override
	public String[] getServletMappings() {
		return new String[] { "/" };
	}
}
