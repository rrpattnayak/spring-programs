package com.rr.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class DiscountCouponAdvice {
	
	public void couponGenerator(JoinPoint jp,double billAmt)throws Throwable{
		String couponmessage=null;
		Writer write=null;
		System.out.println(jp.getSignature()+" with args "+Arrays.toString(jp.getArgs()));
		if(billAmt<5000)
			couponmessage="Avail 5% off on next purchase";
		else if(billAmt<10000)
			couponmessage="Avail 10% off on next purchase";
		else if(billAmt<20000)
			couponmessage="Avail 20% off on next purchase";
		else
			couponmessage="Avail 30% off on next purchase";
		write=new FileWriter("E:/coupon.txt");
		write.write(couponmessage);
		write.flush();
		write.close();
		
	}
}