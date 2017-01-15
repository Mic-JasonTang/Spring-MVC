package com.springmvc.entities;

/**
 * Spring-MVC
 * <p>
 * Created by JasonTang on 1/12/2017 10:45 PM.
 */
public class Department {

	private int id;

	private String departmentName;

	public Department(int id, String departmentName) {
		this.id = id;
		this.departmentName = departmentName;
	}

	public Department () {

	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", departmentName='" + departmentName + '\'' +
				'}';
	}
}
