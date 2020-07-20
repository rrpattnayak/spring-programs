package com.rr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rr.service.ShoppingStore;

public class AfterAdvice {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore store=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/rr/cfgs/applicationContext.xml");
		//get proxy object bean
		store=ctx.getBean("shopping",ShoppingStore.class);
		//invoke method
		try {
			System.out.println(store.shopping(new String[]{"mobile","jeans","tshirts"},new double[]{8000,2400,2300}));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();
	}
}
