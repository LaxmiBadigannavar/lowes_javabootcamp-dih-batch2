 package com.spring.boot.empapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.NumberFormat;

@XmlRootElement
@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	
	@NotEmpty
	@Size(min = 2,message = "Name should be of atleast of 2 characters")
	private String name;
	
	@Min(value=18, message="Minimum age is 18")
	@Max(value= 70, message = "Maximum age is 70")
	private int age;
	
	@NotEmpty(message="Gender is required")
	private String gender;
	
	@NotBlank (message = "Designation should be mentioned")
	private String designation;
	
	private String department;
	
	@Min(value=10000, message="Minimum salary should be Rs 10000/-")
	@Max(value = 100000, message = "Max Salary should be RS 1000000/-")
	private double salary;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
