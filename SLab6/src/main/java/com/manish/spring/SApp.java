package com.manish.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.manish.spring.to.Service;

public class SApp {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("manish-spring-config.xml");
		System.out.println("-- Spring Container is Ready --\n");

		Service s1 = context.getBean("serv2", Service.class);
		s1.execute();
		
	}

}
