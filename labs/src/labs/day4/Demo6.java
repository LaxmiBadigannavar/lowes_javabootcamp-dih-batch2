package com.theLaxmi.day4;
class Calculator{
	public void addNumber() {
		System.out.println("in non static method");
	}
	public static void subNumber() {
		System.out.println("in static method");
	}	
	
}
public class Demo6 {

	public static void main(String[] args) {
		Calculator calcObj = new Calculator();
		calcObj.addNumber();
		Calculator.subNumber();

	}

}
