package com.manish.spring;

import com.manish.spring.to.Student;
import com.manish.spring.to.Employee;

public class SApp1 {
	public static void main(String[] args) {
		Student st1 = new Student();
		st1.setSid(101);
		st1.setSname("Manish");
		
		Employee emp1 = new Employee();
		emp1.setEid(9001);
		emp1.setEname("Ranjan");

		Student st2 = new Student(102,"Aadi");
		Employee emp2 = new Employee(9002, "Rahul");
		
		st1.show();
		st2.show();
		emp1.display();
		emp2.display();
		

	}
}
