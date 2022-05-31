package com.empapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.empapp.Exception.EmpNotFoundException;
import com.empapp.dao.EmployeeDaoImpl;
import com.empapp.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	protected Map<Integer,Employee> empMap = new HashMap<>();
	EmployeeDaoImpl empimpl = new EmployeeDaoImpl();
	Employee emp = new Employee();
	Scanner sc = new Scanner(System.in);
	public void addEmployee(Employee emp) {
		//EmployeeDaoImpl empimpl = new EmployeeDaoImpl();
		empimpl.insertTable(emp);
	}

	public void delete(int empId) {
		
		empimpl.deleteEmployee(empId);
	}
	public void display(int empId)throws EmpNotFoundException {
		empimpl.getEmployee(empId);
		
	}
	public void update(Employee emp) throws EmpNotFoundException {
		
			empimpl.updateEmployee(emp);
		}
		
	
	
	public void displayAll() {
		empimpl.getAllEmployees();
		
	}
	public static boolean validate(Employee emp, Predicate<Employee> validator) {
		return validator.test(emp); // executes lambda expression body
	}
	public static void handleError(String errorMessage, Consumer<String> consumer)
	{
		consumer.accept(errorMessage);
	}
	
}
