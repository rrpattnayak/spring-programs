package com.rr.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rr.dto.UserDTO;
import com.rr.model.User;
import com.rr.service.ILoginMgmtService;

@Controller
public class LoginController {
	
	@Autowired
	private ILoginMgmtService service;
	
	@GetMapping("/login")
	public  String  showLoginForm(@ModelAttribute User userDetails) {
		userDetails.setUname("Ghost");
		return "login_form";
	}
	@PostMapping("/login")
	public    String  performLogin(Map<String,Object> map,@ModelAttribute User user) {
		UserDTO dto=new UserDTO();
		String result=null;
		//convert model to dTO
		BeanUtils.copyProperties(user,dto);
		//use service
		System.out.println("hiiii bapi");
		result=service.login(dto);
		//add reuslt map object
		map.put("resultMsg",result);
		//return lvn;
		return "login_form";
	}//method
}
