package com.rr.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MyController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return new ModelAndView("home","sysDate",new Date());
		
	}

}
