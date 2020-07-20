package com.rr.dao;

import com.rr.bo.UserDetailsBO;

public interface AuthenticationDAO {
	public int validate(UserDetailsBO bo);
}
