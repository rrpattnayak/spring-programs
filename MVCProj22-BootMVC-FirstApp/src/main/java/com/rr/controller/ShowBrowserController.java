package com.rr.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowBrowserController {
	
	@GetMapping("/welcome")
	public String showHomePage() {
		//return lvn
		return "home";
	}
	
	@GetMapping("/browser")
	public String getBrowser(Map<String,Object> map,HttpServletRequest req) {
		//get browser s/w name
		String bName=req.getHeader("user-agent");
		//keep browser as model attribute
		map.put("resultMsg",bName);
		//return lvn
		return "result";
	}
}
