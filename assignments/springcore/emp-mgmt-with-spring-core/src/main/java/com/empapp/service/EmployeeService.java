package com.empapp.service;
import com.empapp.model.Employee;
public interface EmployeeService {
	 public void addEmployee(Employee emp);
	 public void update(Employee emp);
	 public void delete(int empId);
	 public void display(int empId); 
	 public void displayAll();
}
			 
