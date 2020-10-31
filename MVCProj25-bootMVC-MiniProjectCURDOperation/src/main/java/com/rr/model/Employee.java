package com.rr.model;

import lombok.Data;

@Data
public class Employee {
	private Integer empNo;
	private String ename;
	private String job;
	private float sal;
	private Integer deptNo=10;
	

}
