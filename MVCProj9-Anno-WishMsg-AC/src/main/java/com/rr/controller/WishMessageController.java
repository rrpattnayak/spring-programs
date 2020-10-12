package com.rr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rr.service.WishMessageService;

@Controller
public class WishMessageController {
	private WishMessageService service;
	
	public WishMessageController(WishMessageService service) {
		this.service=service;
	}
	
	@RequestMapping(value = "/welcome")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping(value = "/wish")
	public ModelAndView showWishMessage() {
		//use service
		String wmsg=service.generateMessage();
		return new ModelAndView("result","wmsg",wmsg);
	}
}
