package com.rr.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rr.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/register")
	public String showForm(@ModelAttribute Student st) {
		st.setSadd("berhampur");
		return "student_form";
	}
	
	@PostMapping("/register")
	public String processForm(Map<String,Object> map,@ModelAttribute Student st) {
		return "result";
	}
}
