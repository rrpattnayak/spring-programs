package com.rr.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rr.bo.UserDetailsBO;

public class AuthenticationDAOImpl implements AuthenticationDAO {
	private static final  String AUTH_QUERY="SELECT COUNT(*) FROM USERLIST WHERE UNAME=? AND PWD=?";
	private JdbcTemplate jt;
	
	public AuthenticationDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int validate(UserDetailsBO bo) {
		int count=0;
		count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUsername(),bo.getPwd());
		return count;
	}

}
