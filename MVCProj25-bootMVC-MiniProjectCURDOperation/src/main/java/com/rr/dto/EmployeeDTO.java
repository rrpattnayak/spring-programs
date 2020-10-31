package com.rr.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
	private Integer empNo;
	private String ename;
	private String job;
	private float sal;
	private int deptNo;
	private float grossSalary;
	private float netSalary;

}
