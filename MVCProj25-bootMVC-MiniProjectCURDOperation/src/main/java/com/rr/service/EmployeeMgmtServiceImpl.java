package com.rr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rr.bo.EmployeeBO;
import com.rr.dao.IEmployeeDAO;
import com.rr.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<EmployeeDTO> fetchAllEmployees() {
		List<EmployeeBO> listbo=null;
		List<EmployeeDTO> listDTO=new ArrayList<>();
		//use dao
		listbo=dao.getAllEmployees();
		//convert bo to dto
		listbo.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setGrossSalary(dto.getSal()+dto.getSal()*0.3f);
			dto.setNetSalary(dto.getGrossSalary()-dto.getGrossSalary()*0.1f);
			dto.setSal(Math.round(dto.getSal()));
			listDTO.add(dto);
		});
		return listDTO;
	}
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		count=dao.insertEmployee(bo);
		return count!=0?" employee inserted successfully":" employee not inserted";
	}
	
	public List<Integer> fetchAllDeptNos() {
		return dao.getAllDeptnos();
	}
	
	public String removeEmpByNo(int id) {
		int count=0;
		count=dao.deleteEmpById(id);
		return count!=0?id+" Employee found and deleted":"Employee not found for deletion";
	}
	
	public EmployeeDTO fetchEmpByNo(int id) {
		EmployeeDTO dto=null;
		EmployeeBO bo=null;
		//use dao
		bo=dao.getEmpById(id);
		//conver bo to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	
	public String modifyEmployeeByNo(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.updateEmployee(bo);
		return count!=0?"employee no "+dto.getEmpNo()+" found and updated":"Employee not found to update";
	}
}
