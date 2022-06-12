package com.spring.boot.empapp.service;

import java.util.List;

import com.spring.boot.empapp.exceptions.EmployeeException;
import com.spring.boot.empapp.model.Employee;

public interface EmployeeService {
	 public Employee createEmployee(Employee emp) throws EmployeeException;
	 public List<Employee> getAll() throws EmployeeException;
	 public Employee get(int empId); 
	 public Employee update(int empId,Employee emp);
	 public void delete(int empId);
	

}
