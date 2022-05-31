package com.empapp.dao;

import com.empapp.model.Employee;

public interface EmployeeDao {
	public void insertTable(Employee emp);
	public void getEmployee(int empId) ;
	public void deleteEmployee(int empid);
	public void getAllEmployees() ;
	public void updateEmployee(Employee emp);
}
