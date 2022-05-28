package com.empapp.collectionMain;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.empapp.Exception.EmpNotFoundException;
import com.empapp.model.*;
import com.empapp.service.EmployeeServiceImpl;
public class EmployeeCollectionMain {

	public static void main(String[] args) {
		Employee emp;
		int select;
		EmployeeServiceImpl empservice=new EmployeeServiceImpl();
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("Select operation: ");
		System.out.println("Select 1: Add Employee");
		System.out.println("Select 2: Delete Employee");
		System.out.println("Select 3: View Employee");
		System.out.println("Select 4: Update Employee");
		System.out.println("Select 5: View All Employee");
		System.out.println("Select 6: Exit");
		System.out.println("Enter your selection:");
		select=sc.nextInt();
		switch(select) {
		case 1: 
				System.out.println("Enter Employee Details: ");					
				System.out.println("Enter Employee Id: ");		
				int eid=sc.nextInt();
				
				
				System.out.println("Enter Employee Name: ");
				String name=sc.next();
				
				
				System.out.println("Enter Employee age: ");
				int age=sc.nextInt();
				
				
				System.out.println("Enter Employee gender: ");
				String gender=sc.next();
				
				
				System.out.println("Enter Employee designation: ");
				String desgn=sc.next();
				
				
				System.out.println("Enter Employee department: ");
				String dept=sc.next();
				
				
				System.out.println("Enter Employee salary: ");
				double salary=sc.nextDouble();
				emp= new Employee(name, gender,age,dept, desgn,salary );
				empservice.addEmployee(emp, eid);
				System.out.println("Employee added successfully");
				break;
				
		case 2:	System.out.println("Enter Employee id to delete:");
				eid=sc.nextInt();
				empservice.delete(eid);
				System.out.println("Employee deleted sucessfully");
				break;
		
		case 3:System.out.println("Provide Employee Id to Display");
				System.out.println("Enter Employee Id");
				eid = sc.nextInt();
				
				try{
					emp=empservice.display(eid);
					System.out.println(eid+"  "+emp.getName()+"  "+emp.getGender()+
						"  "+emp.getAge()+" "+emp.getDesignation()+" "+emp.getDepartment());
				}catch(EmpNotFoundException e) {
					System.out.println("Employee Not found");
					System.out.println();
				}
				
					break;
					
		case 4: System.out.println("Provide Employee Id to Update");
				System.out.println("Enter Employee Id");
				int empId = sc.nextInt();
				try {
					empservice.update(empId);
				}catch(EmpNotFoundException e) {
					System.out.println("Employee not found");
				}
				break;
				
		case 5: empservice.displayAll();
				break;
		default: System.out.println("Wrong Entry....");
		
		}
		}
	}
}
