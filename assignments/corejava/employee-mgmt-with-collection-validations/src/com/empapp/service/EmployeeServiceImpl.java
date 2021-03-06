package com.empapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.empapp.Exception.EmpNotFoundException;
import com.empapp.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	protected Map<Integer,Employee> empMap = new HashMap<>();
	Employee emp = new Employee();
	Scanner sc = new Scanner(System.in);
	public void addEmployee(Employee emp,int empId) {
		empMap.put(empId, emp);
	}

	public void delete(int empId) throws EmpNotFoundException{
		if(empMap.containsKey(empId))
			empMap.remove(empId);
		else
			throw new EmpNotFoundException();
	}
	public Employee display(int empId)throws EmpNotFoundException {
		if(empMap.containsKey(empId))
			emp = empMap.get(empId);
		else
			throw new EmpNotFoundException();
		return emp;
	}
	public void update(int empId) throws EmpNotFoundException {
		if(empMap.containsKey(empId)) {
			System.out.println("What do you want to update:");
			int field=sc.nextInt();
			emp = empMap.get(empId);
			System.out.println("What u want to update:");
			System.out.println("Enter 1: for updating name");
			System.out.println("Enter 2: for updating age");
			System.out.println("Enter 3: for updatig gender");
			System.out.println("Enter 4: for updating designation");
			System.out.println("Enter 5: for updating department");
			System.out.println("Enter 6: for updating salary");
		
			System.out.println("Field is: "+field);
			switch(field) {
			case 1 :	System.out.println("Enter the Name to update:");
						String nameToUpdate = sc.nextLine();
						emp.setName(nameToUpdate);	
						break;
							
			case 2 :	System.out.println("Enter the age:");
						int age = sc.nextInt();		
						emp.setAge(age);
						break;
		
			case 3 :	System.out.println("Enter the gender:");
						String gender = sc.next();
						emp.setGender(gender);
						break;	
									
			case 4 :	System.out.println("Enter the designation:");
						String designation = sc.next();
						emp.setDesignation(designation);
						break;
						
			case 5	:	System.out.println("Enter the department:");
						String department = sc.next();
						emp.setDesignation(department);
						break;
						
			case 6	:	System.out.println("Enter the salary:");
						int salary = sc.nextInt();
						emp.setSalary(salary);
						break;			
							
			default: 		System.out.println("Can not update it");
			}
		}
		else
			throw new EmpNotFoundException();
		
	}
	
	public void displayAll() {
		List<Employee> empList = new ArrayList<Employee>(empMap.values());
		List<Integer> listKeys = new ArrayList<Integer>(empMap.keySet());
		int index=0;
		for (Employee emp : empList) {
		
		System.out.println(listKeys.get(index)+" "+emp.getName()+" "+
					emp.getAge()+" "+emp.getGender()+" "+
					emp.getDesignation()+" "+emp.getDepartment()+" "+
					emp.getSalary());
		
					index++;

		}
		
	}
	public static boolean validate(Employee emp, Predicate<Employee> validator) {
		return validator.test(emp); // executes lambda expression body
	}
	public static void handleError(String errorMessage, Consumer<String> consumer)
	{
		consumer.accept(errorMessage);
	}
}
