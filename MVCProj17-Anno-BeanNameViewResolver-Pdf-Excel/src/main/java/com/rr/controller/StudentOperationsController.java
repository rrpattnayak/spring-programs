package com.rr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rr.dto.StudentDTO;
import com.rr.service.StudentMgmtService;

@Controller
public class StudentOperationsController {

	@Autowired
	private StudentMgmtService service;

	@GetMapping("/home")
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/pdf_report")
	public String showPdfReport(Map<String,Object> map) {
		List<StudentDTO> listDTO=null;
		//use service
		listDTO=service.getAllStudents();
		map.put("studentsInfo",listDTO);
		return "pdfview";
	}
	
	@GetMapping("/excel_report")
	public String showExcelReport(Map<String,Object> map) {
		List<StudentDTO> listDTO=null;
		//use service
		listDTO=service.getAllStudents();
		map.put("studentsInfo", listDTO);
		return "excelview";
	}
}
