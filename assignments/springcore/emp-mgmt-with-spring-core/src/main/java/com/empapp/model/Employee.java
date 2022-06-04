package com.empapp.model;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class Employee extends Person{
	private int empId;
	private String designation;
	private String department;
	private double salary;
	private LocalDate doj;
	private LocalDateTime updatedTime;
	
	
	public Employee() {
		
	}
	public Employee(int empId,String name,String gender,int age,String department,String designation,double salary ) {
		super(name,age,gender);
		this.empId=empId;
		this.designation=designation;
		this.department=department;
		this.salary =salary;
	}
	public Employee(String name,String gender,int age,String department,String designation,double salary ) {
		super(name,age,gender);
		this.designation=designation;
		this.department=department;
		this.salary =salary;
	}
	public Employee(String name,String gender,int age,String department,String designation,double salary,LocalDate doj) {
		super(name,age,gender);
		this.designation=designation;
		this.department=department;
		this.salary =salary;
		this.doj = doj;
		
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
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
	
	public void printDetails() {
		System.out.println("Prininting the details");
		System.out.println("Employee Id: "+getEmpId());
		System.out.println("Employee Name: "+getName());
		System.out.println("Employee Gender: "+getGender());
		System.out.println("Employee Age: "+getAge());
		System.out.println("Employee Designation: "+getDesignation());
		System.out.println("Employee Department: "+getDepartment()); 
		System.out.println("Employee Salary: "+getSalary());
	}

}
