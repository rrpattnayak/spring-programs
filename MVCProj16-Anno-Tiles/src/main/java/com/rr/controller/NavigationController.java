package com.rr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	
	@GetMapping("/home")
	public String showHomePage() {
		return "home";  //tile definition as lvn
	}
	
	@GetMapping("/faculty")
	public String showFacultyPage() {
		return "faculty";  //tile definition as lvn
	}
	
	@GetMapping("/student")
	public String showStudentPage() {
		return "student";  //tile definition as lvn
	}
	
	@GetMapping("/courses")
	public String showCoursePage() {
		return "courses";  //tile definition as lvn
	}



}
