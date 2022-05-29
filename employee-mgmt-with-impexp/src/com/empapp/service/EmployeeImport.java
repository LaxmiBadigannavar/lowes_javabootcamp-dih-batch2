package com.empapp.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import com.empapp.model.Employee;

public class EmployeeImport implements Runnable {
	
	BufferedReader in = null;
	Map<Integer,Employee> empMap=new HashMap<>();
	Employee emp = new Employee() ;
	EmployeeServiceImpl empservice=new EmployeeServiceImpl();
	 BlockingQueue<Map<Integer,Employee>> bufferEmployees;
	 public EmployeeImport() {
		 
	 }
	public EmployeeImport(BlockingQueue<Map<Integer, Employee>> q) {
		bufferEmployees = q;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
		try {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 in = new BufferedReader(new FileReader("D:\\training\\lowes_javabootcamp-dih-batch2\\employee-mgmt-with-impexp\\importfile.txt"));
				 String line = null;         
		         while ((line = in.readLine()) != null) {
		        	String[] field = line.split(",");
		        	emp.setName(field[1]);
				    emp.setAge(Integer.parseInt(field[2]));
		        	emp.setGender(field[3]);
		        	emp.setDesignation(field[4]);
		        	emp.setDepartment(field[5]);
		        	emp.setSalary(Double.parseDouble(field[6]));
		        	System.out.println("Data imported from file"+emp);
		        	empMap.put(Integer.parseInt(field[0]),emp);
		        	//System.out.println("Data from Map::"+empMap);
		        	try {
		        		if(empMap!=null) {
		        			System.out.println("Data from Map::"+empMap);
		        			bufferEmployees.put(empMap);
		        		}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
		         }		
		}

		catch (IOException e){
			e.printStackTrace();
		}
		finally {
	         if (in != null) {
	        	 try {
	        		 in.close();
	        	 }
	        	 catch(IOException e) {
	         }
		}
		
	}
	}
}
 
