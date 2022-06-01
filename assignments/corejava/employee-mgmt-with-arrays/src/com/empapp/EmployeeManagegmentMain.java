package com.empapp;

import java.util.Scanner;

import com.empapp.exception.EmpNotFoundException;
import com.empapp.model.Employee;
import com.empapp.service.EmployeeServiceArray;

public class EmployeeManagegmentMain {
		public static void main(String[] args) {
			EmployeeServiceArray empSevice=new EmployeeServiceArray();
			Employee[] empArray = new Employee[10];	
			 int count=0;
			 boolean loop=true;
			 int select;
			Scanner sc = new Scanner(System.in);
			while(true){
			System.out.println("Select operation: ");
			System.out.println("Select 1: Add Employee");
			System.out.println("Select 2: Delete Employee");
			System.out.println("Select 3: Display Employee");
			System.out.println("Select 4: Update Employee");
			System.out.println("Select 5: Exit");
			System.out.println("Enter your selection:");
			select=sc.nextInt();
			switch(select) {
			case 1: 
					if(count<empArray.length) {
					Employee emp =new Employee();
					System.out.println("Enter Employee Details: ");					
					System.out.println("Enter Employee Id: ");		
					int id=sc.nextInt();
					emp.setEmpId(id);
					
					System.out.println("Enter Employee Name: ");
					String name=sc.next();
					emp.setName(name);
					
					System.out.println("Enter Employee age: ");
					int age=sc.nextInt();
					emp.setAge(age);
					
					System.out.println("Enter Employee gender: ");
					String gender=sc.next();
					emp.setGender(gender);
					
					System.out.println("Enter Employee designation: ");
					String desgn=sc.next();
					emp.setDesignation(desgn);
					
					System.out.println("Enter Employee department: ");
					String dept=sc.next();
					emp.setDepartment(dept);
					
					System.out.println("Enter Employee salary: ");
					double salary=sc.nextDouble();
					emp.setSalary(salary);
					
					
					empSevice.addEmployee(emp);
					empArray[count]=emp;
					System.out.println("Employee added sucessfully");
					count++;
					}
					break;
			
			case 2:
					System.out.println("Enter Employee ID: ");
					int empId=sc.nextInt();
					System.out.println("Emp id for deleting: "+empId);
					empSevice.deleteEmployee(empId);
					System.out.println("Deleted Employee Sucessfully");
					break;
					
			case 3: try {
						empSevice.displayAll();
					}
					catch(EmpNotFoundException e) {
						System.out.println("No Employees found: "+e.getMessage());
					}
					break;
				
			case 4:System.out.println("Please enter emp id for updating:");
					int id= sc.nextInt();
					empSevice.update(id);	
					break;
					
			case 5:loop=false;	
					System.out.println("Exit....");
					break;
					
			default: System.out.println("Wrong Entry....");
			}
		}
			
	}

}
