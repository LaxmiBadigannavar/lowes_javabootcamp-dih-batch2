package com.empapp.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.function.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.empapp.Exception.EmpNotFoundException;

import com.empapp.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	protected Map<Integer,Employee> empMap = new HashMap<>();
	Employee emp = new Employee();
	Scanner sc = new Scanner(System.in);
	public void addEmployee(Employee emp,int empId) {
		empMap.put(empId, emp);
	}

	public void delete(int empId) {
		
		if(empMap.get(empId)!=null) {
			empMap.remove(empId);
			System.out.println("goint here"+empMap.get(empId));
		}
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
	
	public void printEmpStatistics() {
			//System.out.println("Employee map: "+empMap);
				List<Integer> empIds = empMap.values()
										.stream()
										.map(Employee::getEmpId)
										.collect(Collectors.toList());
				System.out.println("Total No of Employees:  "+empIds.size());
			
				System.out.println("Employees :"+empIds);
				
				
				
				
				List<Integer> list = empMap.values()
					.stream()
					//.map(Employee::getEmpId)
					.filter(emp -> (emp.getAge())>30)
					.map(Employee::getEmpId)
					.collect(Collectors.toList());
					//.forEach(System.out::println);
				System.out.println("Employees whose age is greater than 30:"+list);
				
				System.out.println("Employees total and avarage salary:");
				DoubleSummaryStatistics stats = empMap.values()
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
						empMap.values()
							.stream()
							.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
				System.out.println(groupByDept);
				
				System.out.println("Department wise employee count:");
				Map<String, Long> groupSortByDept = 
						empMap.values()
							.stream()
							.sorted(Comparator.comparing(Employee::getDepartment))
							.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
				System.out.println(groupSortByDept);
				System.out.println();
				System.out.println();
	}
	
	public synchronized void importEmployees() {
		System.out.format("%n%s - Import started %n", Thread.currentThread().getName());
		int counter = 0;
		try (Scanner in = new Scanner(new FileReader("D:\\training\\lowes_javabootcamp-dih-batch2\\assignments\\corejava\\employee-mgmt-with-impexp\\importfile.txt"))) {
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

				empMap.put(emp.getEmpId(), emp);
				
				counter++;
			}
			System.out.format("%s - %d Employees are imported successfully.", Thread.currentThread().getName(),
					counter);
		} catch (Exception e) {
			System.out.println("Error occured while importing employee data. " + e.getMessage());
		}
	}

	
	public void exportEmployees() {
		System.out.format("   Export started %n", Thread.currentThread().getName());
		try (FileWriter out = new FileWriter("D:\\\\training\\\\lowes_javabootcamp-dih-batch2\\\\assignments\\\\corejava\\\\employee-mgmt-with-impexp\\\\exportfile.txt")) {
		
			for (Employee emp : empMap.values()){
				String line = emp.getEmpId() + "," + emp.getName() + "," + emp.getAge() + ","+emp.getGender() + ","
						+ emp.getDesignation() + "," + emp.getDepartment() + "," + emp.getSalary() + "\n";
				System.out.println(line);
				try {
					out.write(line);
				} catch (IOException e) {
					System.out
							.println("Error occured while writing employee data into file. " + e.getMessage());
					e.printStackTrace();
				}
			}
						
					
			System.out.format("%d Employees are exported successfully.", empMap.values().size());
		} catch (IOException e) {
			System.out.println("Error occured while exporting employee data. " + e.getMessage());
		}
	}
	
}
