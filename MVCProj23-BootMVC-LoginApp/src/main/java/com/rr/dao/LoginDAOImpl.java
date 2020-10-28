package com.rr.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.rr.bo.UserBO;

@Repository("loginDAO")
public class LoginDAOImpl implements ILoginDAO {

	@Autowired
	private SimpleJdbcCall sjc;
	
	public String authenticate(UserBO bo) {
		//set procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//Prepare Map object haivng IN paran names and values
		Map<String,Object> inParams=Map.of("USERNAME",bo.getUname(), "PASSWORD",bo.getPwd());
		//call Pl/SQL procedure
		Map<String,Object> outParams=sjc.execute(inParams);
		//get result from OUT param
		return (String) outParams.get("RESULT");
	}
}
