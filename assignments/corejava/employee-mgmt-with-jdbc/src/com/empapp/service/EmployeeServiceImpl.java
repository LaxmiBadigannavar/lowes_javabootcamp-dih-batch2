package com.empapp.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
	
	public synchronized void importEmployees() {
		System.out.format("%n%s - Import started %n", Thread.currentThread().getName());
		int counter = 0;
		try (Scanner in = new Scanner(new FileReader("D:\\training\\lowes_javabootcamp-dih-batch2\\assignments\\corejava\\employee-mgmt-with-jdbc\\importfile.txt"))) {
			System.out.println("Implorting file...");
			while (in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println("Importing employee - " + emp);
				Employee emp = new Employee();
				StringTokenizer tokenizer = new StringTokenizer(line, ",");

			
				emp.setEmpId(Integer.parseInt(tokenizer.nextToken()));
			
				emp.setName(tokenizer.nextToken());
				
				emp.setAge(Integer.parseInt(tokenizer.nextToken()));
				
				emp.setGender(tokenizer.nextToken());
		
				emp.setDesignation(tokenizer.nextToken());
				
				emp.setDepartment(tokenizer.nextToken());
				
				emp.setSalary(Double.parseDouble(tokenizer.nextToken()));
				
				empimpl.ImpFileToTable(emp);
				
				counter++;
			}
			System.out.format("%s - %d Employees are imported successfully.", Thread.currentThread().getName(),
					counter);
		} catch (Exception e) {
			System.out.println("Error occured while importing employee data. " + e.getMessage());
		}
	}

	
	public void exportEmployees() {
		//System.out.format("   Export started %n", Thread.currentThread().getName());
		empimpl.ExpFromTableToFile();
	}
	
	public void printEmpStatistics() {
		List<Employee> listemps  = empimpl.getAllEmployees();
			List<Integer> empIds = listemps
									.stream()
									.map(Employee::getEmpId)
									.collect(Collectors.toList());
			System.out.println("Total No of Employees:  "+empIds.size());
		
			System.out.println("Employees :"+empIds);
			
			
			
			
			List<Integer> list = listemps
				.stream()
				//.map(Employee::getEmpId)
				.filter(emp -> (emp.getAge())>30)
				.map(Employee::getEmpId)
				.collect(Collectors.toList());
				//.forEach(System.out::println);
			System.out.println("Employees whose age is greater than 30:"+list);
			System.out.println("No of Employees whose age is greater than 30 years:"+list.size());
			System.out.println("Employees total and avarage salary:");
			DoubleSummaryStatistics stats =listemps
												.stream()
												.map(Employee::getSalary)
												.collect(Collectors.toList())
												.stream()
												.mapToDouble((sal) -> sal)
												.summaryStatistics();
			
			System.out.println("Total Salary: " + stats.getSum());
			System.out.println("Avg Salary: " + stats.getAverage());
			System.out.print("Group by Dept: ");
			Map<String, Long> groupByDept = 
					listemps
						.stream()
						.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
			System.out.println(groupByDept);
			
			 Map<String, Double> empCountBydept = empCountBydept= listemps.stream()
			.sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors
			.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.averagingInt(Employee::getAge)));
			
			 System.out.println("Average Employee Age by Department: "+ empCountBydept );
			
			System.out.println("Department wise employee count:");
			
			Map<String, Long> groupSortByDept = 
					listemps
						.stream()
						.sorted(Comparator.comparing(Employee::getDepartment))
						.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
			System.out.println(groupSortByDept);
			
			
			 List<String> namesWithS = new ArrayList<>();
			 namesWithS  = listemps
						.stream().filter(emp -> emp.getName().startsWith("S")).map(emp -> emp.getName())
						.collect(Collectors.toList());
			System.out.println("List Employees starts with 'S':"+namesWithS );
			System.out.println();
			System.out.println();
}
	
	
}
