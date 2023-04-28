package com.manish.jpa.app.id;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeIdGenerator implements IdentifierGenerator {

	/*public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("EmployeeIdGenerator - generate()");
		UUID uuid = UUID.randomUUID();
		String nextId = uuid.toString();
		System.out.println("EmployeeIdGenerator - generate() "+ nextId);
		return nextId;
	}*/

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		List list = session.createQuery("select max(emp.id) from Employee emp").list();
		if (list == null || list.size() == 0 || list.get(0) == null)
			return "E-001";
		String maxId = list.get(0).toString();
		int maxIntId = Integer.parseInt(maxId.substring(2));
		maxIntId++;
		if (maxIntId < 10)
			return "E-00" + maxIntId;
		if (maxIntId < 100)
			return "E-0" + maxIntId;
		return "E-" + maxIntId;
	}
}
