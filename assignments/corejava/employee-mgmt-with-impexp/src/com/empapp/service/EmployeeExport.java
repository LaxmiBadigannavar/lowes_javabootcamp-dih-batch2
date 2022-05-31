package com.empapp.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.io.PrintWriter;
import java.io.FileWriter;
import com.empapp.model.Employee;
import com.empapp.service.EmployeeImport;

public class EmployeeExport extends EmployeeServiceImpl implements Runnable {
	
	BlockingQueue<HashMap<Integer,Employee>> bufferEmployees;
	 public EmployeeExport() {
		 
	 }
	public EmployeeExport(BlockingQueue<HashMap<Integer, Employee>> q) {
		bufferEmployees = q;
	}
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		BlockingQueue<HashMap<Integer,Employee>> bufferEmployeesGet;
		Map<Integer,Employee> empMap=new HashMap<>();
		
		Employee emp = new Employee() ;
		EmployeeServiceImpl empservice=new EmployeeServiceImpl();
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
		try {
				Thread.sleep(4000);
				empMap = bufferEmployees.take();
			List<Employee> empList = new ArrayList<Employee>(empMap.values());
			System.out.println("Employee List:"+empList);
			List<Integer> listKeys = new ArrayList<Integer>(empMap.keySet());
			int index=0;
			String line = null;   
			System.out.println(empList);
			for (Employee emp1 : empList) {
				line= listKeys.get(index)+" "+emp.getName()+" "+
						emp.getAge()+" "+emp.getGender()+" "+
						emp.getDesignation()+" "+emp.getDepartment()+" "+
						emp.getSalary();
				
				index++;
			}
			try {
				out = new PrintWriter(new FileWriter("D:\\training\\lowes_javabootcamp-dih-batch2\\employee-mgmt-with-impexp\\exportfile.txt"));
				while (line != null) {
		        	System.out.println(line);
		            out.write(line);
		            out.write("\n");
		         }
			}catch(IOException e) {
				e.getMessage();
			}
		         
				
		         
			  
		         out.flush();
		         System.out.println("\n" + "File copied successfully.");	

		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		finally {
	         if (out != null) {
	            out.close();
	         }
		}
		//System.out.println(Thread.currentThread().getName() + " -->Stop thread");
		}
}


