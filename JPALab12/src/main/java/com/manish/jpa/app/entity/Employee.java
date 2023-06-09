package com.manish.jpa.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lab12_employee")
@Data
@NoArgsConstructor
public class Employee {
	@Id
	@Column(name = "eid")
	@GenericGenerator(
			name = "eidGenerator", 
			strategy = "com.manish.jpa.app.id.EmployeeIdGenerator")
	@GeneratedValue(generator = "eidGenerator")
	private String id;

	@Column(name = "ename")
	private String name;
	private String email;
	private long phone;

	@Temporal(TemporalType.DATE)
	@Column(name = "joining_date")
	private Date doj;

	public Employee(String name, String email, long phone, Date doj) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.doj = doj;
	}
}
