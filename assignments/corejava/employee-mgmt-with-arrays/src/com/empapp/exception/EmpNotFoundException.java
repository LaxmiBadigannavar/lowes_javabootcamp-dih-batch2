package com.empapp.exception;

public class EmpNotFoundException extends Exception{
	public EmpNotFoundException() {
		
	}
	public EmpNotFoundException(String message) {
		System.out.println("Employee not found");
	}
	
}
