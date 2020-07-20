package com.rr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rr.manager.AuthenticationManager;
import com.rr.service.BankMgmtService;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationManager manager=null;
		BankMgmtService service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/rr/cfgs/applicationContext.xml");
		//get manager
		manager=ctx.getBean("authManager",AuthenticationManager.class);
		service=ctx.getBean("bankService",BankMgmtService.class);
		manager.signIn("rakesh","ranjan");
		try {
			System.out.println(service.withdrawMoney(1001, 100));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println(service.depositeMoney(1002, 100));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		manager.signOut();
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
