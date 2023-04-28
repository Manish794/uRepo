package com.manish.spring;

import com.manish.spring.to.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SApp {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("manish-spring-config.xml");
		System.out.println("-- Spring Container is Ready --\n");
		/*
		 * Student stud1 = context.getBean("st1",Student.class); stud1.show();
		 * 
		 * Student stud2 = context.getBean("st2",Student.class); stud2.show();
		 * 
		 * Employee em1 = context.getBean("emp1",Employee.class); em1.display();
		 * 
		 * Employee em2 = context.getBean("emp2",Employee.class); em2.display();
		 */
		 
		Service s1 = context.getBean("serv1", Service.class);
		s1.execute();
		
		Service s2 = context.getBean("serv2", Service.class);
		s2.execute();
		
		Service s3 = context.getBean("serv3", Service.class);
		s3.execute();
		
		Service s4 = context.getBean("serv4", Service.class);
		s4.execute();
		
		Service s5 = context.getBean("serv5", Service.class);
		s5.execute();
		
		Service s6 = context.getBean("serv6", Service.class);
		s6.execute();
		
		Service s8 = context.getBean("serv8", Service.class);
		s8.execute();
	}

}
