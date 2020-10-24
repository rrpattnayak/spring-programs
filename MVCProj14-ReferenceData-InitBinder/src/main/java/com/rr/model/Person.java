package com.rr.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private String name;
	private String address;
	private int mobileNo;
	private String gender="female";
	private String[] hobbies=new String[] {"reading","travelling"};
	private String qlfy="MCA";
	private String[] colors=new String[] {"white","black"};
	private Date dob;
	private Date doj=new Date();
	private float salary;
}
