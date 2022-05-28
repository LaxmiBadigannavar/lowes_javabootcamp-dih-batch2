package com.labs.java.java8;

public interface DefaultDemo {
	//public final static
	String message="message from Interface";
	public void print();
	
	static void statiPprint() {
		System.out.println("static print");
	}
	
	default void defaultPrint() {
		System.out.println("Default print");
		privatePrint();
	}
	private void privatePrint() {
		System.out.println("Private priint");
	}
	
}
