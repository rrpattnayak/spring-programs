package com.rr.dao;

import com.rr.bo.UserBO;

public interface ILoginDAO {
	public String authenticate(UserBO bo);
}
