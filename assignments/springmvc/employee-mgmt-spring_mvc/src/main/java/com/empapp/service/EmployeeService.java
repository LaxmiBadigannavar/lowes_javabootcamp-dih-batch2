package com.empapp.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.empapp.dao.EmployeeDaoJdbcImpl;
import com.empapp.model.Employee;

public class EmployeeService {
	
	private static Map<String, Employee> employees = new LinkedHashMap<String, Employee>();
	EmployeeDaoJdbcImpl empdaoimpl = new EmployeeDaoJdbcImpl();

	public void add(Employee employee)
	{

		employee.setId(UUID.randomUUID().toString());		
		
		empdaoimpl.insertTable(employee);
	}
	
	public void update(Employee employee)
	{
		
		//employees.put(employee.getId(), employee);
		empdaoimpl.updateEmployee(employee);
	}
	
	public Employee get(String empId)
	{
		//return employees.get(empId);
		return empdaoimpl.getEmployee(Integer.parseInt(empId));
	}
	
	public void delete(String empId)
	{
		//employees.remove(empId);
		empdaoimpl.deleteEmployee(Integer.parseInt(empId));
	}	
	
	public List<Employee> list()
	{
		return new ArrayList<Employee>(empdaoimpl.getAllEmployees());
	}	
	
}
