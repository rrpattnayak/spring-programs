package com.rr.manager;

import org.springframework.beans.BeanUtils;

import com.rr.bo.UserDetailsBO;
import com.rr.dao.AuthenticationDAO;
import com.rr.dto.UserDetailsDTO;

public class AuthenticationManager {
	
	private AuthenticationDAO dao;
	private ThreadLocal<UserDetailsDTO> threadLocal=new ThreadLocal();
	public AuthenticationManager(AuthenticationDAO dao) {
		this.dao = dao;
	}
	
	public void signIn(String username,String password) {
		UserDetailsDTO dto=null;
		//convert username,password into  userdetailsDTO class object
		dto=new UserDetailsDTO();
		dto.setUsername(username);
		dto.setPwd(password);
		threadLocal.set(dto);
	}
	
	public void signOut() {
		threadLocal.remove();
	}
	
	public boolean isAuthenticated() {
		UserDetailsDTO dto=null;
		UserDetailsBO bo=null;
		int count=0;
		//get current thread's UserDetailsDTO class object
		dto=threadLocal.get();
		//convert dto to bo
		bo=new UserDetailsBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.validate(bo);
		return count==0?false:true;
	}
}
