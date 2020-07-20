package com.rr.service;

import com.rr.dao.BankDAO;

public class BankMgmtServiceImpl implements BankMgmtService {
	private BankDAO dao;
	
	
	public BankMgmtServiceImpl(BankDAO dao) {
		this.dao = dao;
	}

	public String withdrawMoney(int acno, float amount) {
		//use dao
		int count=0;
		count=dao.withdraw(acno, amount);
		if(count==0) 
			return "money not withdrawn";
		else
			return amount+" withdrawn from acno "+acno;
	}

	public String depositeMoney(int acno, float amount) {
		//use dao
		int count=0;
		count=dao.deposite(acno, amount);
		return (count==0)?"Money not deposited ":" Money deposited to acno "+acno;
	}

}
	