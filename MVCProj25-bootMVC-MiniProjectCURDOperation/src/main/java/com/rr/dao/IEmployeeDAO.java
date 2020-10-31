package com.rr.dao;

import java.util.List;

import com.rr.bo.EmployeeBO;

public interface IEmployeeDAO {
	public List<EmployeeBO> getAllEmployees();
	public int insertEmployee(EmployeeBO bo);
	public List<Integer> getAllDeptnos();
	public int deleteEmpById(int id);
	public EmployeeBO getEmpById(int id);
	public int updateEmployee(EmployeeBO bo); 
}
