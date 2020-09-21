package com.rr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.rr.service.WishMessageService;

public class WishMessageController extends AbstractController {
	private WishMessageService service;
	
	public WishMessageController(WishMessageService service) {
		this.service=service;
	}
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)throws Exception {
		String msg=null;
		msg=service.generateMessage();
		return new ModelAndView("result","wmg",msg);
	}

}
