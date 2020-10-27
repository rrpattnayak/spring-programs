package com.rr.dto;

public class EmployeeDTO {
	private Integer empNo;
	private String ename;
	private String job;
	private float sal;
	private int deptNo;
	private float grossSalary;
	private float netSalary;
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", deptNo="
				+ deptNo + ", grossSalary=" + grossSalary + ", netSalary=" + netSalary + "]";
	}
}
