package com.rr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rr.dto.StudentDTO;

@Service("studentService")
public class StudentMgmtServiceImpl implements StudentMgmtService{
	
	public List<StudentDTO> getAllStudents() {
		return List.of(new StudentDTO(21,"rakesh","bbsr",87.5f),
						new StudentDTO(23,"siba","hyd",98.5f),
						new StudentDTO(53,"radhe","nuagaon",93.5f));
	}
}
