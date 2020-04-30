package com.rr.controller;

import com.rr.dto.StudentDTO;
import com.rr.service.StudentService;
import com.rr.vo.StudentVO;

public class StudentController {
	private StudentService  service;
	public StudentController(StudentService service) {
		this.service=service;
	}
	public String process(StudentVO vo)throws Exception {
		//convert from VO obj to dto obj
		StudentDTO dto=new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		//use service class
		String result=service.generateResult(dto);
		return result;
	}//method
}//class
