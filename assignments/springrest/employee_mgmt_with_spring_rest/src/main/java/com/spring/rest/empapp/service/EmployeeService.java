package com.spring.rest.empapp.service;

import java.util.List;

import com.spring.rest.empapp.model.Employee;

public interface EmployeeService {
	 public Employee createEmployee(Employee emp);
	 public List<Employee> getAll();
	 public Employee get(int empId); 
	 public Employee update(int empId,Employee emp);
	 public void delete(int empId);
	

}
