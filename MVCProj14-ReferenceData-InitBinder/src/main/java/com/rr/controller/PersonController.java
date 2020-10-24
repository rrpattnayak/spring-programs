package com.rr.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rr.model.Person;

@Controller
public class PersonController {
	
	@GetMapping("/person")
	public String showFormPage(@ModelAttribute("perFrm") Person person) {
		//return lvn
		return "show_form";
	}
	
	@PostMapping("/person")
	public String handleForm(Map<String,Object> map,@ModelAttribute("perFrm") Person person) {
		System.out.println("model class object "+person);
		return "register_success";
	}
	
	//reference data for radio button
	@ModelAttribute("genderList")
	public List<String> populateGenders(){
		List<String> genderList=List.of("female","male");
		return genderList;
	}
	
	@ModelAttribute("hobbiesList")
	public List<String> populateHobbies(){
		List<String> hobbiesList=List.of("reading","travelling","eating","playing");
		return hobbiesList;
	}
	
	@ModelAttribute("qlfyList")
	public List<String> populatequalifications(){
		List<String> qlfyList=List.of("MCA","BCA","BTECH","MTECH");
		return qlfyList;
	}
	
	@ModelAttribute("colorsList")
	public List<String> populateColors(){
		List<String> colorsList=List.of("white","red","yellow","green");
		return colorsList;
	}
	
	@InitBinder
	public void myInitBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
