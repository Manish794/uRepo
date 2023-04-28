package com.manish.spring.to;

public class Service {
	private Employee emp = null;
	private Student stud = null;

	public Service() {
		System.out.println("\n  -- Service Def Cons");
	}

	public Service(Employee emp) {
		System.out.println("\n  -- Service(Employee) Cons");
		this.emp = emp;
	}

	public Service(Student stu) {
		System.out.println("\n  -- Service(Student) Cons");
		this.stud = stu;
	}

	public Service(Employee emp, Student stu) {
		System.out.println("\n  -- Service(Employee, Student) Cons");
		this.emp = emp;
		this.stud = stu;
	}
	
	public void setEmp(Employee emp) {
		System.out.println("-- setEmp method");
		this.emp = emp;
	}

	public void setStud(Student stud) {
		System.out.println("-- setStud method");
		this.stud = stud;
	}

	public void execute() {
		System.out.println("\n-- execute() of Service");
		System.out.println("-- emp " + emp);
		System.out.println("-- stud " + stud);
		if (null != emp)
			emp.display();
		if (null != stud)
			stud.show();
	}

}
