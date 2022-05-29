package com.empapp.Exception;

public class EmpNotFoundException extends NullPointerException{
	public EmpNotFoundException() {};
	public EmpNotFoundException(String message) {
		System.out.println("Employee not found");
	}
	
}
