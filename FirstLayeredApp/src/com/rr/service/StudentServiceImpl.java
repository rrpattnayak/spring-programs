package com.rr.service;

import com.rr.bo.StudentBO;
import com.rr.dao.StudentDAO;
import com.rr.dto.StudentDTO;

public class StudentServiceImpl implements StudentService{
	private StudentDAO dao;
	public StudentServiceImpl(StudentDAO dao) {
		this.dao=dao;
	}
	@Override
	public String generateResult(StudentDTO dto)throws Exception {
		//write b.logic
		int total=dto.getM1()+dto.getM2()+dto.getM3();
		float avg=total/3.0f;
		String result=null;
		if(avg<35)
			result="fail";
		else
			result="pass";
		//create BO class obj
		StudentBO bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use DAO
		int count=dao.insert(bo);
		if(count==0)
			return "result:: "+bo.getResult()+  " "+bo.getSno()+ " Registration failed";
		else
			return "result:: "+bo.getResult()+  " "+bo.getSname()+" "+" having id "+bo.getSno()+ " passed with first division with distinction";
	}
}
