package com.rr.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements Serializable{
	private Integer sno;
	private String sname;
	private String sadd;
	private Float savg;
}
