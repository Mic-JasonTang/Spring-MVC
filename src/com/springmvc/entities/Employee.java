package com.springmvc.entities;

/**
 * Spring-MVC
 * <p>
 * Created by JasonTang on 1/12/2017 10:44 PM.
 */
public class Employee {

	private Integer id;

	private String userName;

	private String gender;

	private Department department;

	public Employee(int id, String userName, String gender, Department department) {
		this.id = id;
		this.userName = userName;
		this.gender = gender;
		this.department = department;
	}

	public Employee() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", gender='" + gender + '\'' +
				", department=" + department +
				'}';
	}
}
