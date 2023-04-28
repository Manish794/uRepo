package com.manish.jpa.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.manish.jpa.app.entity.Student;
import com.manish.jpa.app.util.JPAUtil;


public class ReadWithQBCApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Student> query = builder.createQuery(Student.class);
			Root<Student> root = query.from(Student.class);
			query.select(root);
			Predicate pr1 = builder.equal(root.get("cty"), "Blore");
			Predicate pr2 = builder.equal(root.get("email"), "manish@gmail.com");
			query.where(builder.and(pr1, pr2));
			
			Query q = entityManager.createQuery(query);
			List list = q.getResultList();

			if (list == null || list.size() == 0) {
				System.out.println("Not Found");
			} else {
				List<Student> studList = (List<Student>) list;
				for (Student st : studList) {
					System.out.println(st.getSid() + "\t" + st.getSname() + "\t" + st.getEmail() + "\t" + st.getCty());
				}
			}
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
