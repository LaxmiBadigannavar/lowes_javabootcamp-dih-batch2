package com.empapp.service;
import com.empapp.model.Employee;
public interface EmployeeService {
	 public void addEmployee(Employee emp,int empId);
	 public void update(int empId);
	 public void delete(int empId);
	 public Employee display(int empId); 
	 public void displayAll();
}
			 
