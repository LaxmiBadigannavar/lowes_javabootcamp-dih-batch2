package com.spring.rest.empapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.rest.empapp.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	Map<Integer,Employee> employees = new HashMap<Integer, Employee>();
	
	@Override
	 public Employee createEmployee(Employee emp) {
		 employees.put(emp.getEmpId(), emp);
		 return emp;
	 }
	 
	@Override
	 public List<Employee> getAll(){
		 return new ArrayList<Employee>(employees.values());
	 }
	
	@Override
	 public Employee get(int empId) {
		 return employees.get(empId);
	 }
	
	@Override
	 public Employee update(int empId,Employee emp) {
		 employees.put(empId, emp);
		 return emp;
	}
	
	@Override
	 public void delete(int empId) {
		 employees.remove(empId);
	 }
	 
}
