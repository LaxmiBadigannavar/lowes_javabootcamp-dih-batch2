package com.theLaxmi.day3;
class Test{
	public int a;
	public Test() {
		System.out.println("Default Constructor");
	}
	
	public Test(int a) {
		this.a=a;
		System.out.println("parameterized Constructor");
	}
	public void display() {
		System.out.println("Display method");
	}
	
}

public class Demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test test= new Test(10);
		
	}

}
