package com.empapp.model;

import java.util.List;

public class Employee {

	private String id;
	private String name;
	private Integer age = null;
	private String gender;
	private boolean contractor;
	public Employee() {
		super();
	}

	private List<String> skills;	
	private String designation;
	private String department;
	private String address;
	private String country;	
	
	public Employee(String id, String name, Integer age, String gender, boolean contractor, List<String> skills,
			String designation, String department, String address, String country) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.contractor = contractor;
		this.skills = skills;
		this.designation = designation;
		this.department = department;
		this.address = address;
		this.country = country;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean isContractor() {
		return contractor;
	}

	public void setContractor(boolean contractor) {
		this.contractor = contractor;
	}
	
	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}	

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}