package com.empapp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import com.empapp.model.Employee;

public class EmployeeImportExport{

	public static void main(String[] args) {
		Map<Integer,Employee> empMap=new HashMap<>();
		BlockingQueue<Map<Integer, Employee>> q=null;
		EmployeeImport impEmp = new EmployeeImport();
		impEmp.run();
		
		EmployeeExport export = new EmployeeExport();
		export.run();
	}

}
