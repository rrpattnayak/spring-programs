package com.rr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rr.service.IWishMessageService;

@Controller
public class WishMessageController {
	
	@Autowired
	private IWishMessageService service;
	
	@GetMapping("/welcome")
	public String showHome() {
		//return lvn
		return "home";
	}
	
	@GetMapping("/wish")
	public String showWishMessage(Map<String,Object> map) {
		//use service
		String result=service.getWishMessage();
		//keep results in model attribute
		map.put("resultMsg",result);
		//return lvn
		return "show_message";
	}
}
