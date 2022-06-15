package com.spring.boot.empapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.empapp.exceptions.EmployeeException;
import com.spring.boot.empapp.model.Employee;
import com.spring.boot.empapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository repo;
	
	//Map<Integer,Employee> employees = new HashMap<Integer, Employee>();
	
	@Override
	 public Employee createEmployee(Employee emp){
		 //employees.put(emp.getEmpId(), emp);
		 //return emp;
		return repo.save(emp);

	 }
	 
	@Override
	 public List<Employee> getAll() throws EmployeeException {
		List<Employee> employees = new ArrayList<>(); 
		//return new ArrayList<Employee>(employees.values());
		employees = repo.findAll();
		System.out.println("Employees List:"+employees.size());
		if(!employees.isEmpty()) {
			return repo.findAll();
		}else {
			throw new EmployeeException("No Employees present");
		}
		
	 }
	
	@Override
	 public Employee get(int empId) throws NoSuchElementException{
		// return employees.get(empId);
		return repo.findById(empId).get();
	 }
	
	@Override
	 public Employee update(int empId,Employee emp) {
		 //employees.put(empId, emp);
		//return emp;
		return repo.save(emp);
	}
	
	@Override
	 public void delete(int empId) {
		 //employees.remove(empId);
		repo.deleteById(empId);
	 }
	 
}
