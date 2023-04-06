package com.SB_CRUD_Program1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="name" , nullable =false)
	private String name;

	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="age", nullable=false)
	private int age;
	
	@Column(name="salary", nullable=false)
	private long salary;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Employee(long id, String name, String email, int age, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	
	
	
}
