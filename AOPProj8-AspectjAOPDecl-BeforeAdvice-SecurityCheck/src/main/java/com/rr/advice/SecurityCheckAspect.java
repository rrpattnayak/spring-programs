package com.rr.advice;

import org.aspectj.lang.JoinPoint;

import com.rr.manager.AuthenticationManager;

public class SecurityCheckAspect {
	private AuthenticationManager manager;

	public SecurityCheckAspect(AuthenticationManager manager) {
		this.manager = manager;
	}
	
	public void check(JoinPoint jp)throws Throwable{
		if(!manager.isAuthenticated()) {
			throw new IllegalArgumentException("Authentication Failed");
		}
	}
	
}
