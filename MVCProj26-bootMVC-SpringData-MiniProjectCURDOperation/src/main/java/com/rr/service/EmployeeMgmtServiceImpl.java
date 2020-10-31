package com.rr.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rr.bo.EmployeeBO;
import com.rr.dto.EmployeeDTO;
import com.rr.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<EmployeeDTO> fetchAllEmployees() {
		List<EmployeeBO> listbo=null;
		List<EmployeeDTO> listDTO=new ArrayList<>();
		//use dao
		listbo=(List<EmployeeBO>) empRepo.findAll();
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
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		bo=empRepo.save(bo);
		return bo!=null?" employee inserted successfully with id "+bo.getEmpNo():" employee not inserted";
	}
	
	public List<Integer> fetchAllDeptNos() {
		return empRepo.getAllDeptNos();
	}
	
	public void removeEmpByNo(int id) {
		empRepo.deleteById(id);
	}
	
	public EmployeeDTO fetchEmpByNo(int id) {
		EmployeeDTO dto=null;
		EmployeeBO bo=null;
		//use dao
		bo=empRepo.findById(id).get();
		//conver bo to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	
	public String modifyEmployeeByNo(EmployeeDTO dto) {
		EmployeeBO bo=null;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		bo=empRepo.save(bo);
		return bo!=null?"employee no "+dto.getEmpNo()+" found and updated":"Employee not found to update";
	}
}
