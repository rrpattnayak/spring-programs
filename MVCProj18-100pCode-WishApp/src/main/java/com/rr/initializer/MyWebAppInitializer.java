package com.rr.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.rr.config.RootAppConfig;
import com.rr.config.WebMVCConfig;

public class MyWebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext sc) throws ServletException {
		//create parent IOC container
		AnnotationConfigWebApplicationContext parentCtx=new AnnotationConfigWebApplicationContext();
		parentCtx.register(RootAppConfig.class);
		//create contextloader listener
		ContextLoaderListener listener=new ContextLoaderListener(parentCtx);
		sc.addListener(listener);
		
		//create child IOC container
		AnnotationConfigWebApplicationContext childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(WebMVCConfig.class);
		//create dispatcher servlet object
		DispatcherServlet servlet=new DispatcherServlet(childCtx);
		//register servlet with servlet container
		ServletRegistration.Dynamic register=sc.addServlet("ds", servlet);
		//provice url pattern
		register.addMapping("/");
		register.setLoadOnStartup(2);
	}
}
