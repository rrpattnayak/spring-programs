package com.rr.service;

public interface BankMgmtService {
	public String withdrawMoney(int acno,float amount);
	public String depositeMoney(int acno,float amount);
}
