package com.manish.spring;

import com.manish.spring.to.Employee;
import com.manish.spring.to.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SApp3 {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("manish-spring-config.xml");
		System.out.println("-- Spring Container is Ready --\n");
		/*
		 * // Work fine for Single Bean of Student type 
		 * Student st = context.getBean(Student.class); st.show();
		 * 
		 * // Work fine for Single Bean of Employee type
		 * Employee em = context.getBean(Employee.class); em.display();
		 */

		 Student stud1 = context.getBean("st1",Student.class);
		 stud1.show();
		
		 Student stud2 = context.getBean("st2",Student.class); 
		 stud2.show();
		 
		 Employee em1 = context.getBean("emp1",Employee.class);
		 em1.display();

		 Employee em2 = context.getBean("emp2",Employee.class); 
		 em2.display();

	}

}
