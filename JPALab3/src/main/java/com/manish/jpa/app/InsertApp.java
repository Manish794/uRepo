package com.manish.jpa.app;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

			Student stud = new Student();
			stud.setName("Kumar");
			stud.setEmails(List.of("kmar@gmail.com", "kumar@yahoo.com"));
			stud.setPhones(Set.of(8888888822L, 9999999922L));
			stud.setMarks(Map.of("Java", 90, "Spring", 87,"Hibernate",98));

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
