package com.manish.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.manish.jpa.app.entity.Address;
import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;

public class InsertApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Address add = new Address();
			add.setCity("Del");
			add.setStreet("Chandani Chauk");
			add.setPin(457854);
			entityManager.persist(add);

			Student stud = new Student();
			stud.setName("Kumar");
			stud.setEmail("kumar@oits.com");
			stud.setPhone(9696969692L);
			stud.setAddress(add);
			entityManager.persist(stud);

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
