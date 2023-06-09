package com.manish.jpa.app;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Employee;
import com.manish.jpa.app.entity.EmployeeId;
import com.manish.jpa.app.util.JPAUtil;

public class InsertApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			Employee emp = new Employee("Raj", "manish@gmail.com", 74856985, new Date());
			emp.setEmployeeId(new EmployeeId("BLR"));
			System.out.println("Before save " + emp.getEmployeeId());
			entityManager.persist(emp);
			System.out.println("After save " + emp.getEmployeeId());

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (null != tx)
				tx.rollback();
		} finally {
			if (null != entityManager)
				entityManager.close();
		}
	}
}
