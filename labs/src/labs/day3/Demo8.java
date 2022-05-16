package com.theLaxmi.day3;
class ConstructorDemo{
	public ConstructorDemo() {
		System.out.println("First Costructor");
	}
	public ConstructorDemo(int a) {
		System.out.println("Second Costructor");
	}
	public ConstructorDemo(String s) {
		System.out.println("Third Costructor");
	}
	public ConstructorDemo(int a,String s) {
		System.out.println("Fourth Costructor");
	}
	public ConstructorDemo(String s,int a) {
		System.out.println("Fifth Costructor");
	}
	
}
public class Demo8 {

	public static void main(String[] args) {
		ConstructorDemo test1= new ConstructorDemo();
		ConstructorDemo test2= new ConstructorDemo(3);
		ConstructorDemo test3 = new ConstructorDemo("Hello");
		ConstructorDemo test4 = new ConstructorDemo(4,"hi");
		ConstructorDemo test5= new ConstructorDemo("abc",6);

	}

}
