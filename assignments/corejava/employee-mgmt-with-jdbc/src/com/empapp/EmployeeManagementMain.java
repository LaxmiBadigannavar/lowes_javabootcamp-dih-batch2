package com.empapp.collectionMain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.empapp.Exception.EmpNotFoundException;
import com.empapp.model.*;
import com.empapp.service.EmployeeServiceImpl;

public class EmployeeJbdcMain {

	public static void main(String[] args) {
		Employee emp;
		int select;
		EmployeeServiceImpl empservice = new EmployeeServiceImpl();
		Scanner sc = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("Select operation: ");
				System.out.println("Select 1: Add Employee");
				System.out.println("Select 2: Delete Employee");
				System.out.println("Select 3: View Employee");
				System.out.println("Select 4: Update Employee");
				System.out.println("Select 5: View All Employee");
				System.out.println("Select 6: Exit");
				System.out.println("Enter your selection:");
				select = sc.nextInt();
				switch (select) {
				case 1:
					System.out.println("Enter Employee Details: ");

					System.out.println("Enter Employee Name: ");
					String name = sc.next();

					System.out.println("Enter Employee age: ");
					int age = sc.nextInt();

					System.out.println("Enter Employee gender: ");
					String gender = sc.next();

					System.out.println("Enter Employee designation: ");
					String desgn = sc.next();

					System.out.println("Enter Employee department: ");
					String dept = sc.next();

					System.out.println("Enter Employee salary: ");
					double salary = sc.nextDouble();

					LocalDate currentDate = LocalDate.now();
					System.out.println("Current DateTime: " + currentDate);

					emp = new Employee(name, gender, age, dept, desgn, salary, currentDate);
					boolean valStatus = empservice.validate(emp,
							empVal -> empVal.getAge() >= 20 && empVal.getAge() <= 60 && empVal.getSalary() > 1000
									&& (empVal.getGender().equalsIgnoreCase("male"))
											| (empVal.getGender().equalsIgnoreCase("female")));
					System.out.println("valiidation status" + valStatus);
					if (valStatus) {

						empservice.addEmployee(emp);
						System.out.println("Employee added successfully");
					} else {
						empservice.handleError("Invalid Age or Salary or Gender", msg -> {
							System.err.println("Validation Error:");
							System.err.println(msg);
						});
					}

					System.out.println("Employee added successfully");
					break;

				case 2:
					System.out.println("Enter Employee id to delete:");
					int eid = sc.nextInt();
					empservice.delete(eid);
					System.out.println("Employee deleted sucessfully");
					break;

				case 3:
					System.out.println("Provide Employee Id to Display");
					System.out.println("Enter Employee Id");
					eid = sc.nextInt();
					try {
							empservice.display(eid);

					} catch (EmpNotFoundException e) {
						System.out.println("Employee not found: " + e.getMessage());
					}
					break;
				case 4:
					emp = new Employee();
					System.out.println("Enter the Emp ID to update:");
					eid = sc.nextInt();
					emp.setEmpId(eid);

					System.out.println("Enter the Name to update:");
					name = sc.next();
					emp.setName(name);

					System.out.println("Enter the age:");
					age = sc.nextInt();
					emp.setAge(age);

					System.out.println("Enter the gender:");
					gender = sc.next();
					emp.setGender(gender);

					System.out.println("Enter the designation:");
					String designation = sc.next();
					emp.setDesignation(designation);

					System.out.println("Enter the department:");
					String department = sc.next();
					emp.setDepartment(department);

					System.out.println("Enter the salary:");
					salary = sc.nextDouble();
					emp.setSalary(salary);

					try {
						empservice.update(emp);
					} catch (EmpNotFoundException e) {
						System.out.println("Employee not found");
					}
					break;

				case 5:
					empservice.displayAll();
					break;

				default:
					System.out.println("Wrong Entry....");
				}
			}
		} catch (InputMismatchException e) {
			System.err.println("Wrong Input");

		}
	}
}
