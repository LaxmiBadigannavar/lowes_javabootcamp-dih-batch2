package com.labs.java.java8;

public class DefaultDemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultDemo.statiPprint();
		DefaultDemoImpl.statiPprint();
		
		DefaultDemo obj1= new DefaultDemoImpl();
		obj1.defaultPrint();
		DefaultDemo obj2= new DefaultDemoImpl();
		obj2.print();
		
		String msg = DefaultDemo.message;
		System.out.println(msg);
		
		
		
	}

}
