package com.rr.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rr.bo.UserBO;
import com.rr.dao.ILoginDAO;
import com.rr.dto.UserDTO;

@Service("loginService")
public class LoginMgmtServiceImpl implements ILoginMgmtService {

	@Autowired
	private ILoginDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public String login(UserDTO dto) {
		UserBO bo=null;
		String result=null;
	    //convert  dto to bo
		bo=new UserBO();
		BeanUtils.copyProperties(dto,bo);
		//use dAO
		result=dao.authenticate(bo);
		return result;
	}
}
