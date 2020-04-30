package com.rr.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.rr.controller.StudentController;
import com.rr.vo.StudentVO;

public class ClientApp {

	public static void main(String[] args) {
		StudentVO vo=null;
		Scanner sc=null;
		String sno,sname,m1,m2,m3;
		StudentController controller=null;
		BeanFactory factory=null;
		factory=new XmlBeanFactory(new FileSystemResource("src/com/rr/cfgs/applicationContexts.xml"));
		controller=factory.getBean("stController",StudentController.class);
		//read inputs from the end user
		sc=new Scanner(System.in);
		System.out.println("enter student no : ");
		sno=sc.next();
		System.out.println("enter student name : ");
		sname=sc.next();
		System.out.println("enter mark1 : ");
		m1=sc.next();
		System.out.println("enter mark2 : ");
		m2=sc.next();
		System.out.println("enter mark3 : ");
		m3=sc.next();
		vo=new StudentVO();
		vo.setSno(sno);
		vo.setSname(sname);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		try {
			String result =controller.process(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//create IOC container
		//get bean
		//call method
		//System.out.println(controller.process("103", "radhe", "76", "55", "66"));
	}
}
