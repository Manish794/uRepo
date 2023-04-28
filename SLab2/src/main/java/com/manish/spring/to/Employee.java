package com.manish.spring.to;

public class Employee {
	private int eid;
	private String ename;

	public Employee() {
		System.out.println("^^ Employee() Cons");
	}

	public Employee(int eid, String ename) {
		System.out.println("^^ Employee(int,String) Cons");
		this.eid = eid;
		this.ename = ename;
	}

	{
		System.out.println("^^ Employee IB ");
	}

	static {
		System.out.println("^^ Employee SB ");
	}

	public void setEid(int eid) {
		this.eid = eid;
		System.out.println("^^ setEid() **");
	}

	public void setEname(String ename) {
		this.ename = ename;
		System.out.println("^^ setEname() **");
	}

	public void display() {
		System.out.println("\n## Employee -> display()");
		System.out.println("Eid " + eid + "\t Ename " + ename);
	}
}
