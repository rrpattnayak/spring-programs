package com.rr.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements BankDAO {
	private static final String WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
	private static final String DEPOSITE_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
	private JdbcTemplate jt;
	
	public BankDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int withdraw(int acno, float amount) {
		int count=0;
		count=jt.update(WITHDRAW_QUERY,amount,acno);
		return count;
	}

	public int deposite(int acno, float amount) {
		int count;
		count=jt.update(DEPOSITE_QUERY,amount,acno);
		return count;
	}

}
