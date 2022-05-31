package com.empapp.service;

import java.util.Arrays;
import java.util.Scanner;

import com.empapp.exception.EmpNotFoundException;
import com.empapp.model.Employee;

public class EmployeeServiceArray {
	Employee empArray[]=new Employee[10];
	int count=0;
	public void addEmployee(Employee emp) {
		empArray[count]=emp;
		count++;
		System.out.println("Employee added sucessfully");
	}
	
	public void deleteEmployee(int empId) {
		Employee[] tmpArray=new Employee[empArray.length];
		int index=0;
		for(int i=0;i<count;i++) {
		
			System.out.println("Emp id from arrat:"+empArray[i].getEmpId());
			if(empId!=empArray[i].getEmpId()) {
				tmpArray[index]=empArray[i];
				index++;
				
			}
			else {
					continue;
			}
		
		}
		empArray=Arrays.copyOf(tmpArray, count);
	}
	
	
	public void displayAll() throws EmpNotFoundException{
		for(int i=0;i<count;i++) {
			Employee emp=empArray[i];
			if(emp!=null) {
				System.out.println(" " +emp.getEmpId()+ " "+emp.getName()+" "+
									emp.getAge()+" "+emp.getGender()+" "+
									emp.getDesignation()+" "+
									emp.getDepartment()+" "+emp.getSalary());
			}
			else {
				throw new EmpNotFoundException();
			}
		}
	}
	
	public void update(int id)  {
		Scanner sc1=new Scanner(System.in);
		for(int i=0;i<count;i++) {
		if(id==empArray[i].getEmpId()) {
			System.out.println("What u want to update:");
			System.out.println("Enter 1: updating designation");
			System.out.println("Enter 2: updating department");
			System.out.println("Enter 3: updating salary");
			int field=sc1.nextInt();
			System.out.println("Field is: "+field);
			switch(field) {
				
				case 1 :		System.out.println("Enter the Designation:");
								String dsgn = sc1.next();
								empArray[i].setDesignation(dsgn);
								System.out.println("Updated sucessfully");
								break;
				case 2 :		System.out.println("Enter the Department:");
								String dept = sc1.next();
								empArray[i].setDepartment(dept);
								System.out.println("Updated sucessfully");
								break;
				case 3 :		System.out.println("Enter the Salary to update:");
								Double sal = sc1.nextDouble();
								System.out.println("salary for updating: "+sal);
								empArray[i].setSalary(sal);
								System.out.println("Updated sucessfully");
								break;
								
				default: 		System.out.println("Can not update it");					
				}
			}
			else {
				continue;
			}
	}
				 
	}
	
}
